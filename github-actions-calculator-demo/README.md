# Calculator Spring Boot WAR - Beginner GitHub Actions CI/CD Tutorial

This project is intentionally small so a reader who has never used GitHub Actions can understand the complete path from Java source code to a deployed WAR.

## 1. The application

The main Spring component is `Calculator`. It has four constructor-injected dependencies:

```text
Calculator
  -> AdditionService
  -> SubtractionService
  -> MultiplicationService
  -> DivisionService
```

`Calculator` does not perform the arithmetic itself. It delegates each operation to the correct service. That makes it a clear example for dependency injection and isolated unit testing.

The HTTP controller is included only so that, after deployment to Tomcat, the application can be verified from a browser.

## 2. What are GitHub Actions?

GitHub Actions is GitHub's automation system. Instructions are written in YAML files under:

```text
.github/workflows/
```

When an event such as a `push` happens, GitHub reads the matching workflow and sends its jobs to runners for execution.

### Beginner vocabulary

| Term | Meaning |
|---|---|
| **Workflow** | The complete automation process written in a YAML file. |
| **Event** | What starts the workflow, for example a push. |
| **Job** | A major stage such as test/build or deploy. |
| **Runner** | The computer that executes a job. |
| **Step** | One instruction inside a job. |
| **Action** | A reusable step such as checkout or upload-artifact. |
| **Artifact** | A file created by a job and stored by GitHub, such as `calculator.war`. |
| **CI** | Continuous Integration: automatically test and build changes. |
| **CD** | Continuous Delivery/Deployment: deliver the tested build to a target system. |

For this demo:

```text
Developer
   |
   | git push
   v
GitHub Repository
   |
   v
GitHub Actions workflow
   |
   v
GitHub-hosted Ubuntu runner
   |
   +-- Checkout source
   +-- Install Java 21
   +-- Run unit tests
   +-- Build calculator.war
   +-- Upload calculator.war
              |
              v
       Tested WAR artifact
              |
              v
 Windows self-hosted runner
              |
              v
        Tomcat webapps
              |
              v
      calculator.war
```

## 3. Unit testing the Calculator

`CalculatorTest` uses Mockito mocks for all four dependencies.

Example:

```java
when(additionService.add(10, 5)).thenReturn(15.0);

double result = calculator.add(10, 5);

assertEquals(15.0, result);
verify(additionService).add(10, 5);
```

This proves that the `Calculator` delegates to the expected dependency without starting Spring and without using the real service implementation.

The test also uses `verifyNoInteractions(...)` to prove that unrelated services were not called.

`DivisionServiceTest` separately tests the real division logic, including the divide-by-zero rule.

## 4. Build a WAR locally

The Maven project contains:

```xml
<packaging>war</packaging>
```

and:

```xml
<finalName>calculator</finalName>
```

Run:

```bash
cd github-actions-calculator-demo
mvn clean test
mvn package
```

A successful build creates:

```text
target/calculator.war
```

`CalculatorApplication` extends `SpringBootServletInitializer`, allowing the WAR to be initialized by an external Tomcat server.

## 5. Workflow file

The workflow is:

```text
.github/workflows/calculator-war-ci-cd.yml
```

For the current training branch, a push affecting this demo starts the workflow automatically:

```yaml
on:
  push:
    branches:
      - FrontEnd-Backend-DB-Deployment
```

So the beginner mental model is:

```text
Save code
   |
Commit
   |
Push
   |
GitHub Actions starts automatically
```

The workflow also contains `workflow_dispatch` for future manual execution. GitHub requires a manually dispatched workflow to exist on the repository's default branch. While this workflow exists only on `FrontEnd-Backend-DB-Deployment`, use push-triggered runs. If the workflow is later merged to the default branch, the **Run workflow** button can be used and a branch can be selected.

## 6. CI job: test first, then build

The first job runs on a GitHub-hosted machine:

```yaml
runs-on: ubuntu-latest
```

### Step 1 - Checkout

```yaml
- uses: actions/checkout@v4
```

The runner is a fresh machine. Checkout copies the repository files into that runner.

### Step 2 - Java setup

```yaml
- uses: actions/setup-java@v4
  with:
    distribution: temurin
    java-version: '21'
    cache: maven
```

This selects Java 21 and enables Maven dependency caching.

### Step 3 - Unit tests

```yaml
run: mvn --batch-mode --no-transfer-progress clean test
```

If any unit test fails, the job fails and the later build/deployment path does not proceed successfully.

```text
Unit Test PASS -> continue
Unit Test FAIL -> stop
```

### Step 4 - Build WAR

```yaml
run: mvn --batch-mode --no-transfer-progress package -DskipTests
```

Tests are skipped only in this second command because they were already executed explicitly in the previous step.

The workflow then verifies that this file exists:

```text
github-actions-calculator-demo/target/calculator.war
```

### Step 5 - Upload artifact

The tested WAR is uploaded as a GitHub Actions artifact named:

```text
calculator-war
```

This is important because deployment downloads the exact WAR created after successful tests. The deployment machine does not rebuild the source code.

```text
Source
  |
Unit Tests
  |
WAR Build
  |
calculator-war artifact
  |
Deployment
```

## 7. Why two runners are used

### GitHub-hosted runner

```yaml
runs-on: ubuntu-latest
```

Used for CI. GitHub provides the temporary machine for test/build work.

### Self-hosted runner

```yaml
runs-on: [self-hosted, windows, x64, calculator-deploy]
```

Used for deployment. This is a Windows machine controlled by you, normally the same system where Tomcat is installed.

```text
GitHub Cloud
    |
    | sends deployment job
    v
Windows deployment machine
    |
    v
Tomcat
```

## 8. Prepare the target Windows system

Install:

- Java compatible with the Spring Boot application
- Apache Tomcat 10.1.x
- GitHub Actions self-hosted runner

Example Tomcat installation:

```text
C:\apache-tomcat-10.1
```

The workflow deploys to:

```text
C:\apache-tomcat-10.1\webapps\calculator.war
```

Tomcat uses the WAR filename as the context path:

```text
/calculator
```

## 9. Register the target machine as a self-hosted runner

In the GitHub repository open:

```text
Settings
 -> Actions
 -> Runners
 -> New self-hosted runner
```

Choose:

```text
Windows
x64
```

GitHub displays repository-specific installation and registration commands. Run those commands on the target Windows machine.

Give the runner the custom label:

```text
calculator-deploy
```

For a permanent deployment system, run the GitHub runner as a Windows service so it reconnects automatically after Windows restarts.

Before deployment, GitHub should show the runner as online/idle.

## 10. Configure GitHub repository variables

Open:

```text
Settings
 -> Secrets and variables
 -> Actions
 -> Variables
```

Create:

### `CALCULATOR_TOMCAT_HOME`

```text
C:\apache-tomcat-10.1
```

### `CALCULATOR_HEALTH_URL`

Recommended:

```text
http://localhost:8080/calculator/api/calculator/health
```

This allows the deployment job to verify that Tomcat actually started the application.

### `CALCULATOR_DEPLOY_ENABLED`

Initially use:

```text
false
```

This lets students learn CI without requiring a deployment computer.

When the self-hosted runner and Tomcat are ready, change it to:

```text
true
```

Now a successful push can continue to the deployment job.

## 11. Deployment job

The deployment job contains:

```yaml
needs: test-and-build
```

Therefore it cannot start until the CI job has succeeded.

The deployment sequence is:

```text
Test/build job PASS
       |
       v
Download calculator-war artifact
       |
       v
Remove old calculator deployment
       |
       v
Copy calculator.war to Tomcat webapps
       |
       v
Tomcat deploys WAR
       |
       v
Optional HTTP health check
```

The old `calculator.war` and exploded `calculator` directory are removed before the new WAR is copied.

## 12. First classroom demonstration - CI only

Keep:

```text
CALCULATOR_DEPLOY_ENABLED=false
```

Make a small source change and push it.

Open:

```text
Repository -> Actions
```

Open the run for:

```text
Calculator WAR - Test, Build and Deploy
```

Show the students these steps:

```text
Checkout source code
Install Java 21
Run unit tests
Build WAR
Verify WAR was created
Upload tested WAR as workflow artifact
```

At this stage, explain that GitHub Actions is simply executing the same commands that a developer could run manually.

## 13. Demonstrate a failed quality gate

Temporarily change this correct assertion in `CalculatorTest`:

```java
assertEquals(15.0, result);
```

to an incorrect value:

```java
assertEquals(99.0, result);
```

Commit and push.

Expected result:

```text
Checkout       PASS
Java setup     PASS
Unit tests     FAIL
WAR build      NOT EXECUTED
Artifact       NOT CREATED
Deployment     NOT EXECUTED
```

Restore the correct assertion and push again.

Expected result:

```text
Checkout       PASS
Java setup     PASS
Unit tests     PASS
WAR build      PASS
Artifact       PASS
```

This is the clearest way to demonstrate why CI is valuable.

## 14. Enable deployment

After Tomcat and the self-hosted runner are ready, set:

```text
CALCULATOR_DEPLOY_ENABLED=true
```

Push a change to the demo.

A successful workflow now becomes:

```text
GitHub-hosted Ubuntu runner
       |
       +-- Unit tests
       +-- WAR build
       +-- Upload artifact
                 |
                 v
Windows self-hosted runner
       |
       +-- Download exact tested WAR
       +-- Copy WAR into Tomcat
       +-- Verify health URL
```

If this workflow is later present on the repository default branch, `workflow_dispatch` can also be used to run it manually with the `deploy` input.

## 15. Verify the deployed application

Health:

```text
http://localhost:8080/calculator/api/calculator/health
```

Expected:

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

```text
CI = automatically prove the Calculator code works and create calculator.war.
CD = move that exact tested calculator.war to the Tomcat system.
```

GitHub Actions is not the permanent application server. It automates the work and then finishes. Tomcat is the system that continues hosting the application for users.

```text
GitHub Actions
      |
      | test / build / deploy
      v
Tomcat Server
      |
      | continues running
      v
Application Users
```

## 17. Files in the demonstration

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
        └── service/
            └── DivisionServiceTest.java

.github/workflows/
└── calculator-war-ci-cd.yml
```

## 18. Recommended teaching order

1. Explain `Calculator` and its four dependencies.
2. Run `CalculatorTest` locally.
3. Explain Mockito mocks and why Spring is not started for this unit test.
4. Run `mvn package` locally and show `target/calculator.war`.
5. Explain workflow, event, job, runner, step, action, artifact, CI, and CD.
6. Push the source and watch the GitHub-hosted runner execute CI.
7. Deliberately fail one test and show that the WAR/deployment path is blocked.
8. Correct the test and show the successful artifact.
9. Configure the Windows self-hosted runner.
10. Set `CALCULATOR_DEPLOY_ENABLED=true`.
11. Push again and watch the tested WAR move to Tomcat.
12. Open the calculator URLs in a browser.
