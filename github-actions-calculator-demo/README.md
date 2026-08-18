# Calculator Spring Boot WAR - Beginner GitHub Actions CI/CD Tutorial

This project is intentionally small so a first-time reader can understand what GitHub Actions does before looking at a larger application.

## 1. What are GitHub Actions?

GitHub Actions is GitHub's automation system. A repository contains a YAML file under `.github/workflows/`. GitHub reads that file and runs the instructions when a configured event happens, such as a push, pull request, or manual run.

For this demo, the important words are:

| Term | Beginner meaning |
|---|---|
| **Workflow** | The complete automation process written in one YAML file. |
| **Event** | What starts the workflow, for example `push`. |
| **Job** | A major stage of work, for example `test-and-build`. |
| **Runner** | The computer that executes a job. |
| **Step** | One instruction inside a job. |
| **Action** | A reusable step created by GitHub or another provider. |
| **Artifact** | A file produced by a job and saved by GitHub, such as `calculator.war`. |
| **CI** | Continuous Integration: automatically test and build every change. |
| **CD** | Continuous Delivery/Deployment: move a tested build to a target environment. |

The complete flow in this demo is:

```text
Developer changes Java code
          |
          v
      git push
          |
          v
GitHub sees the push event
          |
          v
.github/workflows/calculator-war-ci-cd.yml
          |
          v
GitHub-hosted Ubuntu runner
          |
          +--> Checkout source
          +--> Install Java 21
          +--> Run unit tests
          +--> Build calculator.war
          +--> Upload calculator.war as an artifact
                         |
                         v
              Self-hosted Windows runner
                         |
                         v
                  Tomcat webapps
                         |
                         v
                calculator.war deployed
```

## 2. Application design

The main Spring component is `Calculator`.

It has four dependencies:

```text
                     Calculator
                         |
        +----------------+----------------+
        |                |                |
        v                v                v
AdditionService   SubtractionService   MultiplicationService
                         |
                         +----------------------+
                                                |
                                                v
                                         DivisionService
```

Conceptually the dependency structure is:

```text
Calculator
  -> AdditionService
  -> SubtractionService
  -> MultiplicationService
  -> DivisionService
```

`Calculator` delegates each operation to the correct service. This makes it useful for demonstrating dependency injection and unit testing.

## 3. Why the Calculator unit test uses mocks

A **unit test** should test one unit independently.

If we test `Calculator.add(10, 5)`, we want to know whether `Calculator` called `AdditionService` correctly. We do not need to test the real addition algorithm at the same time.

Mockito replaces the real dependencies with mock objects:

```text
                 Unit Test
                    |
                    v
                Calculator
                    |
       +------------+-------------+
       |            |             |
       v            v             v
 Mock Addition   Mock Subtract   Mock Multiply
                    |
                    v
               Mock Division
```

Example from `CalculatorTest`:

```java
when(additionService.add(10, 5)).thenReturn(15.0);

double result = calculator.add(10, 5);

assertEquals(15.0, result);
verify(additionService).add(10, 5);
```

This proves two things:

1. `Calculator` returns the value supplied by `AdditionService`.
2. `Calculator` actually calls the expected dependency.

The test also verifies that the other three dependencies were not called.

## 4. Building a WAR

The Maven project uses:

```xml
<packaging>war</packaging>
```

and:

```xml
<finalName>calculator</finalName>
```

Therefore Maven creates:

```text
target/calculator.war
```

The application class extends `SpringBootServletInitializer`, which allows the Spring Boot application to be initialized by an external servlet container such as Tomcat.

Local commands:

```bash
cd github-actions-calculator-demo
mvn clean test
mvn package
```

After a successful package operation:

```text
github-actions-calculator-demo/
└── target/
    └── calculator.war
```

## 5. The GitHub Actions workflow file

The workflow is stored here:

```text
.github/workflows/calculator-war-ci-cd.yml
```

GitHub automatically discovers YAML workflow files in `.github/workflows/`.

### Event - when does the workflow run?

The workflow contains:

```yaml
on:
  push:
    branches:
      - FrontEnd-Backend-DB-Deployment
```

Meaning:

```text
Push to FrontEnd-Backend-DB-Deployment
                 |
                 v
         Start the workflow
```

A pull request can also start the CI part, and `workflow_dispatch` allows a person to start it manually from the GitHub Actions screen.

## 6. CI Job - unit test and build the WAR

The first job is:

```yaml
jobs:
  test-and-build:
    runs-on: ubuntu-latest
```

`ubuntu-latest` means GitHub provides a temporary Ubuntu virtual machine for the job.

### Step 1 - Checkout

```yaml
- name: Checkout source code
  uses: actions/checkout@v4
```

The runner starts empty. Checkout places the repository source code on the runner.

### Step 2 - Install Java

```yaml
- name: Install Java 21 and enable Maven cache
  uses: actions/setup-java@v4
  with:
    distribution: temurin
    java-version: '21'
    cache: maven
```

Now the runner has the required JDK and Maven dependency caching is enabled.

### Step 3 - Unit tests

```yaml
- name: Run unit tests
  run: mvn --batch-mode --no-transfer-progress clean test
```

Maven compiles the application and runs the JUnit tests.

If a test fails:

```text
Unit test FAILS
      |
      v
GitHub Action job FAILS
      |
      X
WAR build does not continue successfully to deployment
```

This is the quality gate.

### Step 4 - Build the WAR

Only after the test step passes:

```yaml
- name: Build WAR only after tests pass
  run: mvn --batch-mode --no-transfer-progress package -DskipTests
```

The result is:

```text
target/calculator.war
```

Tests are skipped during this second Maven command only because the tests were already executed in the previous explicit test step.

### Step 5 - Save the WAR as an artifact

```yaml
- name: Upload tested WAR as workflow artifact
  uses: actions/upload-artifact@v4
```

The artifact is named:

```text
calculator-war
```

The important principle is:

```text
SOURCE CODE
    |
    v
UNIT TEST
    |
    v
BUILD
    |
    v
TESTED WAR ARTIFACT
```

Deployment downloads this exact WAR. It does not compile another copy on the deployment machine.

## 7. What is a runner?

A runner is simply a computer that performs the workflow instructions.

This demo deliberately uses two kinds of runner.

### GitHub-hosted runner

Used for CI:

```yaml
runs-on: ubuntu-latest
```

GitHub creates and manages this machine. It is used to test and build the application.

### Self-hosted runner

Used for deployment:

```yaml
runs-on: [self-hosted, windows, x64, calculator-deploy]
```

This is a Windows computer that you control. It can be the actual computer where Tomcat is installed.

This creates a very easy-to-understand deployment architecture:

```text
GitHub Cloud
    |
    | sends deployment job
    v
Your Windows Computer
(Self-hosted runner)
    |
    v
Tomcat
    |
    v
calculator.war
```

## 8. Prepare the Windows deployment system

Install on the destination computer:

- Java compatible with your Tomcat/Spring Boot application
- Apache Tomcat 10.1.x
- GitHub self-hosted runner

Assume Tomcat is installed at:

```text
C:\apache-tomcat-10.1
```

The deployment destination is:

```text
C:\apache-tomcat-10.1\webapps\calculator.war
```

Tomcat deploys the WAR with the application context:

```text
/calculator
```

## 9. Register the Windows computer as a self-hosted GitHub runner

In GitHub:

```text
Repository
 -> Settings
 -> Actions
 -> Runners
 -> New self-hosted runner
```

Choose:

```text
Operating system: Windows
Architecture: x64
```

GitHub displays commands specific to your repository. Run those commands on the destination Windows machine.

When configuring the runner, make sure it has the custom label:

```text
calculator-deploy
```

The runner must appear in GitHub as **Idle** before it can accept a deployment job.

For a long-running deployment machine, configure the runner to run as a Windows service so it starts automatically when Windows starts.

## 10. Configure repository variables

Go to:

```text
Repository
 -> Settings
 -> Secrets and variables
 -> Actions
 -> Variables
```

Create:

### Variable 1

```text
Name: CALCULATOR_TOMCAT_HOME
Value: C:\apache-tomcat-10.1
```

### Variable 2

```text
Name: CALCULATOR_HEALTH_URL
Value: http://localhost:8080/calculator/api/calculator/health
```

The health URL is optional but recommended because the workflow can verify that Tomcat actually deployed the application.

### Variable 3 - enable automatic deployment after a push

```text
Name: CALCULATOR_DEPLOY_ENABLED
Value: true
```

Leave this variable unset or set it to `false` while you are only demonstrating CI.

## 11. Deployment job

The deployment job waits for the CI job:

```yaml
needs: test-and-build
```

Therefore:

```text
Tests/build FAILED -> deployment cannot start
Tests/build PASSED -> deployment becomes eligible
```

The deployment job downloads the tested artifact:

```yaml
uses: actions/download-artifact@v4
```

Then PowerShell copies:

```text
calculator.war
```

into:

```text
<TOMCAT_HOME>\webapps\calculator.war
```

Before copying, the old `calculator.war` and old exploded `calculator` application directory are removed.

## 12. First classroom run - CI only

Start with deployment disabled.

Make a small code change and push it:

```bash
git add .
git commit -m "calculator demo change"
git push
```

Then open:

```text
GitHub Repository -> Actions
```

Select:

```text
Calculator WAR - Test, Build and Deploy
```

Show students the first job:

```text
1 - Unit Test and Build WAR
```

Open each step and show:

```text
Checkout source code
Install Java 21
Run unit tests
Build WAR
Verify WAR
Upload artifact
```

At this stage the student sees that GitHub Actions is simply automating commands that could have been typed manually.

## 13. Deliberately make a test fail

For teaching, temporarily change an expected result in `CalculatorTest`.

For example change:

```java
assertEquals(15.0, result);
```

to:

```java
assertEquals(99.0, result);
```

Commit and push.

Expected pipeline:

```text
Checkout       PASS
Java setup     PASS
Unit tests     FAIL
WAR build      NOT REACHED
Artifact       NOT CREATED
Deployment     NOT EXECUTED
```

This demonstrates the purpose of CI better than only showing a successful workflow.

Restore the correct test and push again.

Expected pipeline:

```text
Checkout       PASS
Java setup     PASS
Unit tests     PASS
WAR build      PASS
Artifact       PASS
```

## 14. Deploy to Tomcat

After the self-hosted runner is installed and the repository variables are configured, either:

### Automatic deployment

Set:

```text
CALCULATOR_DEPLOY_ENABLED=true
```

Then every successful push affecting this demo can proceed to deployment.

### Manual deployment

Open:

```text
GitHub -> Actions -> Calculator WAR - Test, Build and Deploy -> Run workflow
```

Enable:

```text
Deploy the tested WAR to the configured Windows Tomcat system = true
```

Then run the workflow.

The sequence becomes:

```text
GitHub-hosted runner
    |
    +-- unit tests
    +-- WAR build
    +-- upload artifact
            |
            v
Windows self-hosted runner
    |
    +-- download same artifact
    +-- remove previous deployment
    +-- copy calculator.war to Tomcat
    +-- optional HTTP health check
```

## 15. Verify the deployed application

Health endpoint:

```text
http://localhost:8080/calculator/api/calculator/health
```

Expected response:

```json
{"status":"UP"}
```

Addition:

```text
http://localhost:8080/calculator/api/calculator/add?first=10&second=5
```

Expected:

```json
{"result":15.0}
```

Subtraction:

```text
http://localhost:8080/calculator/api/calculator/subtract?first=10&second=5
```

Multiplication:

```text
http://localhost:8080/calculator/api/calculator/multiply?first=10&second=5
```

Division:

```text
http://localhost:8080/calculator/api/calculator/divide?first=10&second=5
```

## 16. CI/CD in one sentence

For this application:

```text
CI = automatically prove the Calculator code works and create calculator.war.
CD = take that already-tested calculator.war and place it on the Tomcat system.
```

## 17. Important teaching distinction

Do not describe GitHub Actions as a server that permanently runs the application.

GitHub Actions is the **automation mechanism**.

```text
GitHub Actions
      |
      | builds and moves software
      v
Target System / Tomcat
      |
      | permanently hosts application
      v
Users access application
```

The target Tomcat server continues running after the GitHub Actions job finishes.

## 18. Demo files

```text
github-actions-calculator-demo/
├── pom.xml
├── README.md
└── src/
    ├── main/java/com/khae/calculator/
    │   ├── CalculatorApplication.java
    │   ├── Calculator.java
    │   ├── CalculatorController.java
    │   └── service/
    │       ├── AdditionService.java
    │       ├── SubtractionService.java
    │       ├── MultiplicationService.java
    │       └── DivisionService.java
    └── test/java/com/khae/calculator/
        ├── CalculatorTest.java
        └── service/DivisionServiceTest.java

.github/workflows/
└── calculator-war-ci-cd.yml
```

## 19. Recommended classroom order

1. Explain the Java classes and dependency graph.
2. Run `CalculatorTest` locally.
3. Explain why mocks replace the dependencies.
4. Run `mvn package` locally and show `calculator.war`.
5. Explain workflow, event, job, runner, step, and artifact.
6. Push the source and watch CI run.
7. Intentionally break one unit test and show the failed pipeline.
8. Fix the test and show the green pipeline.
9. Configure the Windows self-hosted runner.
10. Deploy the tested WAR to Tomcat.
11. Open the calculator URLs in a browser.

This order makes GitHub Actions an extension of commands the reader already understands rather than introducing YAML first.
