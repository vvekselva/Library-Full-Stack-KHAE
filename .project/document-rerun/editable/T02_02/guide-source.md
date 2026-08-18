# T02_02 Progressive Guide — Read Department

Status: EDITABLE_SOURCE_MATERIALIZED / EXPANSION_IN_PROGRESS

## Frozen grounding
- Registry verified source: `cdf4f8cb3d379216c5ffaaac7ba2622e246a4e6c`
- Service commit: `47fb4a0ac3d2b60d471dcae3d4e5a2eb6a10fed2`
- Unit-test commit: `86b522b754af31a7de52d2e5dfe7bf56d10823e8`
- Integration commit: `edce78fb39fd1c5c316625c7667f7a9b4aacd81c`
- Frontend commit: `46f6a5fc84f087dd86aea11582ab6eedcc0b397c`
- Service path: `backend/backend.lib.mgmt/src/main/java/self/learning/backend/lib/mgmt/service/impl/ReadDepartmentServiceImpl.java`
- Unit-test path: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/service/impl/ReadDepartmentServiceImplTest.java`
- Local PostgreSQL integration: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/integration/ReadDepartmentIntegrationTest.java`
- PostgreSQL Testcontainers integration: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/integration/ReadDepartmentTestcontainersIntegrationTest.java`
- Assigned frontend path: `frontend/frontend.lib.mgmt/src/tracks/t02-delete-department.js`

## Learning outcome
By the end of this guide, the student should be able to explain and test how one Department record is read from the application. The student should understand the difference between a unit test and an integration test, why the service does not return an inactive Department through the normal read path, how controlled errors are produced, and how the browser uses the same REST contract when it loads a Department before a later action.

The important learning sequence is:

`Understand the request -> isolate the service -> prove the normal result -> observe invalid/not-found conditions -> integrate with PostgreSQL -> repeat with Testcontainers -> call the REST path from the frontend -> rerun regression tests`

---

# Stage 1 — Why a Read Department Service Is Needed

A Library Management application contains Departments such as CSE and ECE. Other features need to know which Department a user selected. A frontend screen may need to load one Department before it allows an update, deactivation, membership operation, or another business action.

The browser should not read a database table directly. The request must travel through application layers. Each layer has one responsibility:

- The **REST controller** receives the HTTP request.
- The **service** applies the use-case rules.
- The **DAO** reads the current record from persistence.
- The **mapper** converts the database-oriented object into the API response DTO.
- The **frontend** displays the response or a controlled error.

The Read Department service is therefore not simply "one SELECT query". It is an application capability with a defined contract and controlled behaviour.

## Why the service layer is useful

If every controller queried the database directly, business rules would be repeated in many places. For example, one controller might hide inactive Departments while another accidentally returns them. The service layer provides one place where the application decides what "read a Department" means.

For T02 the frozen implementation uses `DepartmentDao.findCurrentById(id)`. This is important because the normal read path is for the current visible Department. The integration test proves that the inactive sample Department must not be exposed through this normal read operation.

### Student observation
Before writing tests, identify the expected outcomes:

1. A valid active Department ID returns a response.
2. A null ID is invalid input.
3. An unknown ID returns a controlled not-found error.
4. An inactive Department is not exposed through the normal read path.

These four outcomes become the backbone of the testing progression.

---

# Stage 2 — Request Flow from Browser to PostgreSQL

A typical request is:

`GET /rest/departments/2`

The conceptual flow is:

`Browser -> REST Controller -> ReadDepartmentService -> DepartmentDao -> PostgreSQL -> Mapper -> Response DTO -> Browser`

## Why we draw this flow

Students often see a controller, service, DAO and database as unrelated files. The flow diagram shows that they form one request chain. During a unit test we deliberately break this chain and replace dependencies with mocks. During integration testing we reconnect the real Spring components and PostgreSQL.

### Draw.io asset: `request-flow.drawio`
The diagram must show:

- Browser / Client
- REST Controller
- `ReadDepartmentService`
- `DepartmentDao`
- PostgreSQL
- `DepartmentDtoDoMapper`
- `DepartmentResponseDto`

Arrows must be single-direction request/response arrows with no overlap. The response path should make it clear that the database object is mapped before it reaches the browser.

---

# Stage 3 — Understand the Service Before Testing It

The verified T02 service is:

```java
@Service
public class ReadDepartmentServiceImpl implements ReadDepartmentService {

    @Autowired private DepartmentDao departmentDao;
    @Autowired private DepartmentDtoDoMapper mapper;

    @Override
    public DepartmentResponseDto readDepartment(Long id) {
        if (id == null) {
            throw error(ApplicationCodes.RESPONSE_INVALID_INPUT,
                    "Department ID is required");
        }

        DepartmentDO department = departmentDao.findCurrentById(id)
                .orElseThrow(() -> error(
                        ApplicationCodes.RESPONSE_NOT_FOUND,
                        "Department not found"));

        return mapper.toResponse(department);
    }

    private ApplicationServiceException error(String responseCode,
                                                String message) {
        return new ApplicationServiceException(
                ApplicationCodes.T02_READ_DEPARTMENT,
                responseCode,
                message);
    }
}
```

## Line-by-line explanation

`@Service` tells Spring that this class is a service component. Spring can create and manage an instance of the class.

`@Autowired private DepartmentDao departmentDao;` provides the DAO dependency. The service does not know SQL details; it asks the DAO for the current Department.

`@Autowired private DepartmentDtoDoMapper mapper;` provides the mapper. A persistence object should not be exposed directly as the REST response.

`readDepartment(Long id)` is the use-case method. The input is the Department ID supplied by the caller.

The first `if` is an input guard. A null identifier cannot identify a Department, so the method stops immediately with a controlled `RESPONSE_INVALID_INPUT` exception.

`departmentDao.findCurrentById(id)` asks the DAO for the currently visible record. The DAO returns an `Optional` because the requested current record may not exist.

`orElseThrow(...)` converts the missing record into the application's controlled `RESPONSE_NOT_FOUND` error rather than allowing a `NullPointerException` or returning a meaningless empty object.

`mapper.toResponse(department)` converts the persistence representation into `DepartmentResponseDto`, which is the object intended for the API boundary.

The private `error(...)` helper attaches the T02 application code to every controlled exception. This helps identify which application operation reported the error.

### Important ownership boundary
The student should understand and test this implementation. Do not change the frozen REST contract, DTO shape, DAO meaning, or application-code identity merely to make a test easier.

---

# Stage 4 — Why Start with a Unit Test?

The complete application has many dependencies. If we start the full application and a test fails, the problem could be the Spring context, database, migration, data, controller, service, DAO, mapper, or environment.

A unit test removes most of that uncertainty. It directly creates the service under test and supplies controlled mock dependencies.

### Draw.io asset: `unit-test-isolation.drawio`
Show two views:

1. **Normal application:** Controller -> Service -> DAO -> PostgreSQL, plus Mapper.
2. **Unit test:** JUnit -> `ReadDepartmentServiceImpl`, with mocked `DepartmentDao` and mocked `DepartmentDtoDoMapper`.

The diagram must emphasize that the unit test is similar to calling a small piece of application code directly. External dependencies are replaced so the test can focus on service behaviour.

---

# Stage 5 — Positive Unit Test: Read an Active Department

The verified positive test uses a Department with ID `2` and code `ECE`.

```java
@Test
void shouldReadActiveDepartment() {
    DepartmentDO existing = department(2L, "ECE", true);
    DepartmentResponseDto response = response(2L, "ECE", true);

    when(departmentDao.findCurrentById(2L))
            .thenReturn(Optional.of(existing));
    when(mapper.toResponse(existing)).thenReturn(response);

    DepartmentResponseDto result = service.readDepartment(2L);

    assertEquals("ECE", result.getDepartmentCode());
    verify(departmentDao).findCurrentById(2L);
}
```

## What Mockito is doing

`when(...).thenReturn(...)` defines the behaviour of a mock. No PostgreSQL server is contacted. The test says: "When the service asks for Department 2, behave as if the DAO found this Department."

The mapper is also mocked. When the service asks the mapper to convert the `DepartmentDO`, the mock returns the prepared response DTO.

`service.readDepartment(2L)` is the actual method invocation being tested.

`assertEquals("ECE", ...)` proves that the expected response is returned.

`verify(departmentDao).findCurrentById(2L)` proves that the service called the required DAO path.

### Run and observe
Run only `ReadDepartmentServiceImplTest.shouldReadActiveDepartment` first.

Expected observation: **PASS**.

Do not immediately add every negative test. First prove that the service can perform its normal behaviour.

---

# Stage 6 — Invalid Input: Observe and Control the Null-ID Condition

A caller may invoke the service without a Department ID. A good service should report this as a controlled input error.

```java
@Test
void shouldRejectNullId() {
    ApplicationServiceException ex = assertThrows(
            ApplicationServiceException.class,
            () -> service.readDepartment(null));

    assertEquals(ApplicationCodes.RESPONSE_INVALID_INPUT,
            ex.getResponseCode());
}
```

## Why this test matters

Without an explicit input guard, a later DAO or mapping operation might fail in an unclear way. The test documents the business/API expectation: a missing Department ID is invalid input.

### Progressive learning action
1. Read the null guard in the service.
2. Run `shouldRejectNullId`.
3. Observe that the service throws `ApplicationServiceException`.
4. Inspect the response code.
5. Confirm that it is `RESPONSE_INVALID_INPUT`.
6. Rerun the positive unit test to prove the normal path was not damaged.

---

# Stage 7 — Unknown Department: Controlled NOT_FOUND Behaviour

The DAO returns `Optional.empty()` when the current Department does not exist.

```java
@Test
void shouldReportNotFound() {
    when(departmentDao.findCurrentById(999L))
            .thenReturn(Optional.empty());

    ApplicationServiceException ex = assertThrows(
            ApplicationServiceException.class,
            () -> service.readDepartment(999L));

    assertEquals(ApplicationCodes.RESPONSE_NOT_FOUND,
            ex.getResponseCode());
}
```

## Why `Optional` is useful here

`Optional` makes absence explicit. The service must decide what absence means. T02 converts it into the application's controlled not-found response.

### Run -> observe -> regression
Run the not-found test, then rerun all three focused unit tests:

- active Department
- null ID
- unknown ID

Expected result: all three tests pass.

---

# Stage 8 — JaCoCo Coverage Is a Guide, Not the Goal

After the focused unit tests pass, run the project's JaCoCo-enabled test command used by the Presenter build.

The student should inspect whether the important branches of `ReadDepartmentServiceImpl` were executed:

- null-input branch
- DAO-present branch
- DAO-empty branch
- mapper-return path

A high percentage by itself does not prove correctness. Coverage is useful because it can show that a required branch was never executed. If an important business path is uncovered, add a meaningful test rather than adding a test only to increase the percentage.

---

# Stage 9 — Move from Unit Testing to Local PostgreSQL Integration

A unit test proves service logic with mocks. It does **not** prove that Spring wiring, Flyway data, DAO queries and PostgreSQL work together.

The local integration test uses `@SpringBootTest` and autowires the real `ReadDepartmentService`.

```java
@SpringBootTest
class ReadDepartmentIntegrationTest {

    @Autowired private ReadDepartmentService service;

    @Test
    void shouldReadActiveDepartmentFromPostgreSQL() {
        DepartmentResponseDto result = service.readDepartment(2L);
        assertEquals("ECE", result.getDepartmentCode());
        assertTrue(result.getActive());
    }

    @Test
    void shouldNotExposeInactiveDepartmentThroughNormalRead() {
        ApplicationServiceException ex = assertThrows(
                ApplicationServiceException.class,
                () -> service.readDepartment(3L));
        assertEquals(ApplicationCodes.RESPONSE_NOT_FOUND,
                ex.getResponseCode());
    }
}
```

## What changed from the unit test?

There is no mocked DAO in this test. The real Spring application components are connected. The test therefore checks the actual persistence path.

The second integration test is especially important. It proves a business/persistence rule that a unit test with manually prepared mocks could accidentally hide: the inactive Department with ID `3` is not exposed through the normal read path.

### Local execution checklist
1. Start or connect to the approved local PostgreSQL instance.
2. Ensure Flyway migrations are current.
3. Run `ReadDepartmentIntegrationTest`.
4. Observe Department `2` returning `ECE` and active status.
5. Observe Department `3` producing controlled NOT_FOUND behaviour.
6. Use DBeaver to inspect the seeded Department rows if the exercise requires database verification.
7. Do not change seed data merely to force the test result.

### Draw.io asset: `postgres-integration.drawio`
Show JUnit/Spring Boot -> Service -> DAO -> PostgreSQL -> Mapper -> assertion. Mark PostgreSQL as a real external dependency in this stage.

---

# Stage 10 — Repeat the Integration Path with PostgreSQL 18 Testcontainers

A local database test can accidentally depend on the developer's machine. Testcontainers reduces this dependency by starting a controlled PostgreSQL container for the test environment.

The T02 frozen evidence includes `ReadDepartmentTestcontainersIntegrationTest` using the same application behaviour against PostgreSQL 18.

The student should understand the purpose:

- the database version is controlled;
- the test environment can be recreated;
- Flyway/database setup is exercised in a clean environment;
- the result is less dependent on one developer's manually configured database.

### Draw.io asset: `testcontainers-flow.drawio`
Show:

`JUnit -> Testcontainers -> PostgreSQL 18 container`

and

`Spring Boot -> Service -> DAO -> container database`

The diagram should distinguish the test runner from the application request path.

### Expected observation
The same active/inactive behaviour proven locally must remain true in the container-backed test. If behaviour differs, investigate configuration, migration or seed-data differences instead of weakening the assertions.

---

# Stage 11 — Frontend Integration: Load Before Deactivate

The assigned T02 frontend is `t02-delete-department.js`. Although the student assignment is Deactivate Department, the screen first needs to **read** a Department. This makes T02 a useful example of frontend-to-read-service integration.

The relevant frontend code is:

```javascript
root.querySelector('#loadButton').addEventListener('click', async () => {
  const id = root.querySelector('#departmentId').value.trim();
  await callApi(`/rest/departments/${id}`, { method: 'GET' }, output);
});
```

## What happens when Load Department is clicked?

1. JavaScript reads the Department ID from the input field.
2. `.trim()` removes surrounding spaces.
3. `fetch` calls the fixed REST path using HTTP GET.
4. If the backend returns 404, the UI shows `NOT Found`.
5. If another non-success response occurs, the UI shows a controlled administrator-facing message.
6. If the call succeeds, the JSON response is formatted in the `<pre>` element.

The frontend also contains the later DELETE action, but the read path must work independently before the student reasons about deactivation.

### Frontend progressive test
1. Open the T02 track UI.
2. Keep Department ID `2` and click **Load Department**.
3. Observe the JSON response.
4. Change the ID to an unknown value and click **Load Department**.
5. Observe the not-found message.
6. Confirm from browser developer tools that the method is GET and the URL is `/rest/departments/{id}`.
7. Rerun backend tests after frontend integration work; the fixed REST contract must not be changed.

---

# Stage 12 — Common Mistakes and Troubleshooting

## Mistake: calling the DAO directly from the controller
This removes the service boundary and spreads business behaviour across controllers. Keep the read rule in the service.

## Mistake: returning `DepartmentDO` directly
The persistence object and API contract have different responsibilities. Use the mapper and response DTO.

## Mistake: accepting a null ID and waiting for a lower layer to fail
Validate the input at the service boundary and return the controlled application error.

## Mistake: changing the integration seed because a test fails
First determine why the expected current-record rule is not being satisfied. Seed data is evidence, not something to rewrite casually.

## Mistake: claiming the unit test proves PostgreSQL
A mocked unit test does not contact PostgreSQL. Only the integration stages validate the real persistence chain.

## Mistake: starting frontend work before backend behaviour is stable
The UI depends on the fixed contract. Preserve the dependency sequence and rerun regression tests.

---

# Stage 13 — Exam-Ready Concepts

## Two-mark answer: What is a service-layer read operation?
A service-layer read operation is an application use case that receives an identifier or search input, applies validation and business visibility rules, obtains the required data through the persistence layer, and returns the result through the application's response contract. It also converts missing or invalid conditions into controlled application errors.

## Two-mark answer: Why is Mockito used in a unit test?
Mockito is used to replace dependencies such as DAOs and mappers with controllable mock objects. This allows the service logic to be tested independently without starting the database or the complete application chain.

## Two-mark answer: What is an integration test?
An integration test checks whether multiple real application components work together. In this exercise it verifies that Spring Boot, the service, DAO, mapper, Flyway data and PostgreSQL produce the expected Read Department behaviour.

## Five-mark answer: Unit test versus integration test in T02
The unit test isolates `ReadDepartmentServiceImpl` and mocks `DepartmentDao` and `DepartmentDtoDoMapper`. It proves service decisions such as valid read, invalid input and not-found handling. The integration test starts the Spring context and connects the real persistence components to PostgreSQL. It proves that the DAO query, database data and application configuration implement the same behaviour. Both are required because service logic can be correct while persistence configuration is wrong, and persistence can work while service validation is wrong.

---

# Stage 14 — Completion and Regression Checklist

Before T02_02 may move beyond generation, confirm all of the following in the generated guide and evidence package:

- [ ] The reason for the Read Department service is explained before implementation.
- [ ] The browser-to-PostgreSQL request flow is illustrated.
- [ ] Service code is numbered/commented in the final DOCX and important lines are explained.
- [ ] Positive unit testing is demonstrated.
- [ ] Null-ID controlled validation is demonstrated.
- [ ] Unknown-ID controlled NOT_FOUND behaviour is demonstrated.
- [ ] Earlier successful tests are rerun after each correction.
- [ ] JaCoCo is explained and inspected for required branches.
- [ ] Local PostgreSQL integration is demonstrated.
- [ ] Inactive Department visibility is tested.
- [ ] DBeaver/database verification is included where required by the exercise.
- [ ] PostgreSQL 18 Testcontainers integration is demonstrated.
- [ ] Assigned frontend GET integration is explained and tested.
- [ ] The fixed REST contract is unchanged.
- [ ] Draw.io sources are stored beside the editable guide source.
- [ ] Final DOCX is rendered and inspected page by page.
- [ ] Content QA, technical QA, diagram QA and accessibility checks pass.
- [ ] Rendered DOCX hash and repository re-fetch/hash verification are recorded.
- [ ] `_03` remains blocked until `_02` reaches APPROVED.

## Draw.io assets to create beside this source
- `request-flow.drawio`
- `unit-test-isolation.drawio`
- `postgres-integration.drawio`
- `testcontainers-flow.drawio`

## Quality gates before promotion
Content QA, technical QA, diagram QA, visual QA, accessibility check, DOCX render/hash, and repository re-fetch/hash verification are mandatory. This editable-source expansion is substantive generation work but is **not** itself a percentage-bearing approval gate. `_03` remains blocked until this guide is approved.
