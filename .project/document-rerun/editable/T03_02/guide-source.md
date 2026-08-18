# T03_02 Progressive Guide — Update Department

Status: EDITABLE_SOURCE_MATERIALIZED / EXPANSION_IN_PROGRESS

## Frozen grounding
- Registry verified source: `cdf4f8cb3d379216c5ffaaac7ba2622e246a4e6c`
- Service commit: `df921d3081e00782cfae616ab223b404ea6a738d`
- Unit-test commit: `ee84af6e7f7b7affaa5ab7d877175d90ff7dfb5b`
- Integration commit: `18936b6f75bc53d0ccebfc0f4916bb239ecfcbd1`
- Frontend commit: `c21b3e2c78dce328fbaad93d95b21f11120d6eb5`
- Service path: `backend/backend.lib.mgmt/src/main/java/self/learning/backend/lib/mgmt/service/impl/UpdateDepartmentServiceImpl.java`
- Unit-test path: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/service/impl/UpdateDepartmentServiceImplTest.java`
- Local PostgreSQL integration: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/integration/UpdateDepartmentIntegrationTest.java`
- PostgreSQL Testcontainers integration: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/integration/UpdateDepartmentTestcontainersIntegrationTest.java`
- Assigned frontend path: `frontend/frontend.lib.mgmt/src/tracks/t03-search-department.js`

## Learning outcome
By the end of this guide, the student should be able to explain why Update is more complex than Create or Read, how the identifier in the URL selects the existing Department, how the request DTO supplies the new values, how the service protects the business rules, and how unit tests and integration tests prove that the correct row is changed without damaging unrelated Departments.

The progressive learning sequence is:

`Understand existing state -> validate the update request -> isolate the service -> prove a successful change -> prove invalid/not-found/conflict paths -> integrate with PostgreSQL -> repeat with PostgreSQL 18 Testcontainers -> exercise the frontend contract -> run regression tests`

---

# Stage 1 — Why Update Is Different from Create and Read

Create starts with no existing record. Read returns existing state without changing it. Update begins with an existing Department and must safely replace only the values that are allowed to change.

For a Library Management system this matters because Department data is shared by membership, users, reports and other features. An update must not silently create a second Department, update the wrong row, or accept an invalid duplicate code.

A typical HTTP operation is:

`PUT /rest/departments/{id}`

The URL identifies the Department. The JSON request contains the proposed new Department values. The service combines both pieces of information and decides whether the update is allowed.

## Important student questions before coding
1. Does the Department ID exist and represent the current record?
2. Is the request body present and valid?
3. Are required fields blank after trimming?
4. Does the Department code need normalization?
5. Would the new code conflict with another current Department?
6. Which fields are permitted to change?
7. What controlled error should be returned for each rejected condition?

These questions become the test plan.

---

# Stage 2 — Browser to PostgreSQL Update Flow

The conceptual path is:

`Browser -> PUT Controller -> UpdateDepartmentService -> DepartmentDao -> PostgreSQL -> Mapper -> DepartmentResponseDto -> Browser`

Unlike a simple read, the service normally performs both a lookup and a save. The lookup proves that the target exists and supplies the current persistence object. The service applies validated changes. The DAO/repository persists the updated state. The mapper then creates the response DTO.

### Draw.io asset: `update-request-flow.drawio`
The diagram must show the request ID and request body entering separately at the REST boundary, the service validation decision, the current-record lookup, the save operation, a cylinder-shaped PostgreSQL database, and the mapped response returning to the browser.

---

# Stage 3 — Service Responsibilities

The Update Department service should be taught as a sequence of guards and actions, not as one large code block.

## Responsibility A — Validate the identifier
A null ID cannot select an existing Department. The service should reject it with the application's controlled invalid-input response before calling persistence.

## Responsibility B — Validate the request object
A null request or blank required value is a caller error. Detect it at the service boundary so the failure is meaningful.

## Responsibility C — Load the current Department
The DAO lookup proves that the target exists. If the current record is absent, return the controlled not-found response instead of creating a new object accidentally.

## Responsibility D — Normalize values
If the frozen contract requires trimming or upper-casing a Department code, normalize before duplicate checking and persistence. The unit test should prove the normalized result, not only that a method returned.

## Responsibility E — Protect uniqueness and business rules
A proposed code must not collide with a different current Department. Duplicate checking should distinguish “this same record already owns this value” from “another Department owns this value.”

## Responsibility F — Persist and map
Only after all guards pass should the service update the persistence object, save it, and map the result to the response DTO.

---

# Stage 4 — Why an Empty-Service / Isolated Unit-Test Stage Helps

A complete Spring request includes controller routing, dependency injection, DAO queries, PostgreSQL, Flyway state and mapping. If students implement everything first, a failure can come from too many places.

A focused unit test removes this abstraction. JUnit calls `UpdateDepartmentServiceImpl` directly. Mockito supplies controlled `DepartmentDao` and mapper behavior. This is conceptually similar to writing a small `main` method that invokes only the component under study, except JUnit provides repeatable assertions and lifecycle support.

### Draw.io asset: `unit-test-isolation.drawio`
Show the normal chain and the isolated chain side by side. The unit-test side must clearly replace DAO/mapper dependencies with mocks and must not show a real PostgreSQL connection.

---

# Stage 5 — Positive Unit Test Progression

A good first test should represent a real change, for example changing the Department name while keeping a valid normalized code.

The Arrange phase prepares:
- an existing current Department;
- an update request DTO;
- the DAO lookup result;
- the DAO save result if the service contract uses it;
- the mapped response DTO.

The Act phase calls the real service method.

The Assert phase checks the returned values and verifies the important persistence interaction. It should also confirm that the saved persistence object contains the expected updated state.

The student should run this single positive test first and observe PASS before adding negative cases.

---

# Stage 6 — Invalid Input Tests

Add focused tests one condition at a time:

- null Department ID;
- null update request;
- blank required Department code/name where the frozen contract requires them;
- malformed or otherwise invalid frozen-contract input.

For each test, assert the controlled application response code. Where appropriate, verify that the DAO `save` path is never invoked. This demonstrates that validation prevents persistence side effects.

After every new negative test, rerun the positive test. This is the first simple regression habit students should learn.

---

# Stage 7 — Unknown ID and Duplicate Conflict

## Unknown Department
Mock the current-record lookup as empty. The service should report NOT_FOUND and must not save anything.

## Duplicate proposed Department code
Prepare the existing target Department and a conflicting different Department using the frozen DAO behavior. The service should return the defined conflict/duplicate response and must not overwrite either record.

This scenario explains why update-specific duplicate checks are more subtle than create: the record being updated may already own its current code.

### Draw.io asset: `validation-decision-flow.drawio`
Use a clean decision flow:

`ID valid? -> Request valid? -> Current Department exists? -> Proposed values valid? -> Duplicate belongs to another Department? -> Save -> Map response`

Every rejected branch should terminate at a controlled error box. Avoid crossing arrows.

---

# Stage 8 — JaCoCo as a Feedback Tool

Run the approved Maven test command and inspect coverage for the update service. Meaningful branches include invalid ID, invalid request, missing record, duplicate/conflict, successful mutation, save and mapping.

Coverage should reveal an untested decision, not become a reason to write meaningless assertions. The goal is confidence in business behavior.

---

# Stage 9 — Local PostgreSQL Integration

The local integration test reconnects the real Spring container, DAO/repository, Flyway-managed schema and PostgreSQL.

A strong integration scenario should:
1. read or identify the seeded target Department;
2. invoke the update service through the real application wiring;
3. query the resulting state through the approved persistence path;
4. assert that the intended Department changed;
5. assert that an unrelated Department did not change;
6. exercise at least one controlled rejected condition against real persistence state.

DBeaver can be used as an observation tool after the test to show the student the row before/after, but the automated assertion remains the actual test evidence.

---

# Stage 10 — PostgreSQL 18 Testcontainers

The Testcontainers integration repeats the important behavior against a disposable PostgreSQL 18 container. This proves that the test is not accidentally dependent on one developer's manually configured local database.

### Draw.io asset: `testcontainers-flow.drawio`
Show two linked flows: JUnit/Testcontainers starts PostgreSQL 18 and Flyway initializes it; Spring Boot then executes Service -> DAO -> container database. Use a cylinder for the PostgreSQL container.

If local PostgreSQL passes but Testcontainers fails, investigate version, migration, seed or configuration differences. Do not weaken a correct assertion merely to make the pipeline green.

---

# Stage 11 — Assigned Frontend Integration

The assigned T03 frontend is `t03-search-department.js`. The teaching purpose is to show that an Update-capable application often needs a search/read step before the user selects the record to modify.

Students should inspect the frozen frontend contract, use browser developer tools to identify the request URL/method, and relate the JSON response fields back to the same DTOs used by the backend.

A useful demonstration is:
1. search for an existing Department;
2. identify the record to be updated;
3. perform or simulate the update through the approved UI/API exercise;
4. search again and observe the changed value;
5. verify that the frontend does not change the frozen `/rest/` contract to accommodate the implementation.

---

# Stage 12 — Troubleshooting and Exam-Ready Summary

## Common mistake: updating without loading the target
This can create incorrect semantics or hide a missing-record error. Update should act on a verified existing record.

## Common mistake: duplicate checking before normalization
Values such as ` cse ` and `CSE` may represent the same business key. Apply the frozen normalization rule consistently.

## Common mistake: testing only the returned DTO
Also verify the mutation/save interaction so a mapper stub cannot make a broken persistence path look correct.

## Common mistake: relying only on local PostgreSQL
Use the PostgreSQL 18 Testcontainers test to prove repeatability.

### Two-mark answer
**Update operation:** An Update operation modifies an existing resource identified by its ID. A correct update service validates the ID and request, verifies that the current record exists, enforces business and duplicate rules, persists only permitted changes, and returns the updated resource through the API contract.

### Five-mark answer
In the Library Management Department example, the frontend sends an update request to the REST controller. The controller delegates to the Update Department service. The service validates input, loads the current Department through the DAO, normalizes and checks proposed values, rejects missing or conflicting data with controlled application errors, saves the permitted changes and maps the persisted object to a response DTO. JUnit/Mockito tests isolate these decisions, while PostgreSQL and Testcontainers integration tests prove Spring wiring and persistence behavior.

## Final regression checklist
- Positive update passes.
- Null/invalid input paths are controlled.
- Unknown ID returns NOT_FOUND.
- Duplicate/conflict rule is covered.
- Save occurs only on valid input.
- Local PostgreSQL integration passes.
- PostgreSQL 18 Testcontainers integration passes.
- Assigned frontend uses the frozen REST contract.
- Existing Department regression tests remain green.

## Draw.io assets to create beside this source
- `update-request-flow.drawio`
- `unit-test-isolation.drawio`
- `validation-decision-flow.drawio`
- `testcontainers-flow.drawio`

## Quality gates before promotion
Content QA, Technical QA, Diagram QA, visual QA, accessibility check, DOCX render/hash, repository re-fetch/hash verification. `_03` remains blocked until this guide is approved.
