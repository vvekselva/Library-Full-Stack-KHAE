# T05_02 Progressive Guide — Search Department

Status: EDITABLE_SOURCE_MATERIALIZED / EXPANSION_IN_PROGRESS

## Frozen grounding
- Registry verified source: `cdf4f8cb3d379216c5ffaaac7ba2622e246a4e6c`
- DAO commit: `3e0dcbf5633c1f28f744b02b4ce9db2ac54b3b03`
- Service commit: `a5d8e04b5ac06ae4994d3604ef8d1d6eca81d8bc`
- Unit-test commit: `d75de9d9705ceae6344d15d4cbc449ec5bb5718b`
- Integration commit: `d4ffc2ceab6ffd0d9141c51bd9241f3ff806761e`
- Frontend commit: `cdf4f8cb3d379216c5ffaaac7ba2622e246a4e6c`
- DAO path: `backend/backend.lib.mgmt/src/main/java/self/learning/backend/lib/mgmt/dao/DepartmentDao.java`
- Service path: `backend/backend.lib.mgmt/src/main/java/self/learning/backend/lib/mgmt/service/impl/SearchDepartmentServiceImpl.java`
- Unit-test path: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/service/impl/SearchDepartmentServiceImplTest.java`
- Local PostgreSQL integration: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/integration/SearchDepartmentIntegrationTest.java`
- PostgreSQL Testcontainers integration: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/integration/SearchDepartmentTestcontainersIntegrationTest.java`
- Assigned frontend path: `frontend/frontend.lib.mgmt/src/tracks/t05-read-list-department.js`

## Learning outcome
By the end of this guide, the student should understand why search is a list-returning use case rather than read-by-ID, how search text is normalized, how the service and DAO divide responsibilities, why an empty result is different from an application failure, and how unit/integration tests prove query behavior against both mocked and real PostgreSQL data.

The learning sequence is:

`Understand the search contract -> normalize input -> isolate service behavior -> prove matches and no-result behavior -> prove DAO/query integration -> repeat with PostgreSQL 18 Testcontainers -> connect the assigned frontend -> run regression tests`

---

# Stage 1 — Why Search Is Different from Read by ID

Read-by-ID asks for one known resource, such as Department `2`. Search asks the system to discover zero, one, or many matching Departments from user-supplied text.

A Library user may type `cs`, `CSE`, or part of a Department name. The application must decide how the search text is normalized and which fields can match. The result contract is normally a list, because more than one Department may satisfy the search criteria.

This introduces three important design questions:
1. What should happen for null or blank search text?
2. Should matching be case-sensitive?
3. Is “no matching Departments” a successful empty list or an error?

The frozen application contract determines these answers. The student should test the contract rather than inventing a different one.

---

# Stage 2 — Search Request Flow

A conceptual request is:

`GET /rest/departments/search?text=cs`

The request path is:

`Browser -> REST Controller -> SearchDepartmentService -> DepartmentDao search query -> PostgreSQL -> list of DepartmentDO -> Mapper -> list of DepartmentResponseDto -> Browser`

The database returns a collection, not a single row. The mapper therefore participates once per result or through a list-mapping helper according to the frozen implementation.

### Draw.io asset: `search-query-flow.drawio`
Show the browser search box, REST query parameter, service normalization step, DAO query, cylinder-shaped PostgreSQL database, result list, mapper and JSON list response. Use a separate “0 matches” path returning an empty list/contract result rather than drawing it as a system crash.

---

# Stage 3 — DAO and Service Boundaries

Search makes the DAO/service boundary especially useful for teaching.

## DAO responsibility
The DAO knows how to ask persistence for matching current Department rows. It encapsulates repository/query details such as `LIKE`, case-insensitive matching, current/active filters and ordering where defined by the frozen implementation.

## Service responsibility
The service knows the application meaning of the user's input. It may trim input, decide what blank input means, call the DAO through the approved search method, map results and return the API response contract.

The service should not embed SQL. The DAO should not decide user-facing application response codes.

### Draw.io asset: `dao-service-boundary.drawio`
Place user/application rules on the Service side and persistence/query mechanics on the DAO/PostgreSQL side. This diagram should help students answer: “Which class should change if the business rule changes?” versus “Which class should change if the SQL/query implementation changes?”

---

# Stage 4 — Unit Test Isolation

In a focused unit test, `SearchDepartmentServiceImpl` is the real object under test. `DepartmentDao` and mapper dependencies are mocked.

This allows the student to prove service decisions without needing PostgreSQL. The mock can return a prepared list for one search text and an empty list for another.

### Draw.io asset: `unit-test-isolation.drawio`
Show JUnit -> SearchDepartmentServiceImpl, with mocked DAO and mapper. Explicitly mark that no real PostgreSQL query occurs in the unit-test stage.

---

# Stage 5 — Positive Search Unit Test

Choose a meaningful Library example such as searching `cs` and receiving the CSE Department.

The Arrange step prepares Department persistence objects and their mapped DTOs. The DAO mock is configured for the normalized search input. The Act step calls the service. The Assert step checks the returned list size and important Department fields.

A strong test also verifies that the DAO received the normalized search text expected by the frozen implementation. This is more valuable than checking only that the returned list is not null.

Run this positive test independently first. Expected result: PASS.

---

# Stage 6 — Null, Blank and Normalization Behavior

Search boxes frequently produce `null`, `""`, or whitespace-only input. Students should not assume these all mean the same thing until they inspect the frozen contract.

Add focused tests for the defined behavior:
- null text;
- empty text;
- whitespace around a valid term;
- case variation such as `cse` versus `CSE` where normalization is defined.

Where the service normalizes text, verify the normalized value passed to the DAO. Where blank input is rejected, assert the controlled response code and verify that persistence is not called unnecessarily.

After each negative/edge test, rerun the positive search test.

---

# Stage 7 — No-Result Behavior

A search for a non-existing term should be treated according to the frozen list contract. In many search APIs, zero matches are not a server error: the request succeeded and the result list is empty.

The unit test should mock the DAO to return an empty list and assert the expected API behavior. This helps students distinguish:

- **read-by-ID missing record** -> often NOT_FOUND;
- **search with zero matches** -> often an empty successful result list.

This distinction is a useful exam and design question.

---

# Stage 8 — JaCoCo Coverage and Search Branches

Run the approved Maven test/coverage command. Inspect whether important search decisions executed:
- null/blank handling;
- normalization;
- one/multiple result mapping;
- zero-result path.

Coverage is diagnostic evidence. Do not add meaningless calls merely to increase a number.

---

# Stage 9 — Local PostgreSQL Integration

The integration test reconnects the real Spring container and persistence layer. It should use the approved seed/migration state and prove that the actual query returns the expected Department records.

A useful walkthrough is:
1. inspect known Department rows using DBeaver;
2. run a search term that should match a seeded Department;
3. assert the returned code/name through the real service;
4. run a term that should return no results;
5. prove current/inactive filtering if the frozen DAO contract includes it;
6. rerun the focused unit tests after the database test.

The integration test proves query correctness that Mockito cannot prove. A mock will happily return whatever the test author configured; only a real persistence test proves that the repository/DAO query actually finds the intended rows.

---

# Stage 10 — PostgreSQL 18 Testcontainers

The Testcontainers test starts a controlled PostgreSQL 18 environment, applies the application's database setup and repeats the search behavior.

### Draw.io asset: `testcontainers-flow.drawio`
Show JUnit -> Testcontainers -> PostgreSQL 18 container, and Spring Boot -> Search Service -> DepartmentDao -> container database. Use a cylinder shape for PostgreSQL.

If the local search passes but the container search fails, inspect Flyway, version-sensitive SQL, seed data and configuration before modifying assertions.

---

# Stage 11 — Assigned Frontend Integration

The assigned T05 frontend is `t05-read-list-department.js`. It demonstrates a list-oriented Department screen consuming the same REST contract.

Students should use browser developer tools to connect the UI behavior to the backend:
1. enter a search/list condition supported by the screen;
2. observe the request method and `/rest/` URL;
3. inspect the JSON array returned by the backend;
4. identify how each Department item becomes a row/card/list entry;
5. try a no-result condition and observe the UI behavior;
6. confirm that frontend work does not alter the frozen backend DTO merely to simplify rendering.

This stage joins frontend behavior to the service/DAO concepts already proved by automated tests.

---

# Stage 12 — Troubleshooting and Exam-Ready Material

## Common mistake: implementing search as repeated read-by-ID calls
Search belongs in an appropriate query path. Repeatedly guessing IDs is inefficient and does not represent the user's search intent.

## Common mistake: putting SQL in the service
Keep query mechanics behind the DAO/repository boundary.

## Common mistake: treating zero results as a database failure
A valid query can return no rows. Follow the frozen response contract.

## Common mistake: testing only mocks
Mockito proves service decisions, not the correctness of the actual PostgreSQL query. Integration tests are required for that.

### Two-mark answer
**Search operation:** A Search operation accepts criteria such as text, applies the application's normalization and business rules, queries persistence for matching current records, and returns a list of matching API response objects. A valid search may return zero, one or many results.

### Five-mark answer
In the Library Management Department search, the browser sends search text to the REST endpoint. The Search Department service validates or normalizes the text and delegates persistence matching to `DepartmentDao`. PostgreSQL returns the matching Department rows, which are mapped to response DTOs and returned as a list. Unit tests isolate normalization and result-handling behavior with mocks. Local PostgreSQL and PostgreSQL 18 Testcontainers integration tests prove the real DAO query and database setup. The frontend then renders the same list contract without changing the frozen API.

## Final regression checklist
- Positive search returns expected Department data.
- Null/blank behavior matches the frozen contract.
- Search normalization is covered.
- No-result behavior is covered.
- DAO receives the intended normalized criteria.
- Local PostgreSQL query integration passes.
- PostgreSQL 18 Testcontainers integration passes.
- Assigned frontend uses the frozen `/rest/` contract.
- Existing Department tests remain green.

## Draw.io assets to create beside this source
- `search-query-flow.drawio`
- `dao-service-boundary.drawio`
- `unit-test-isolation.drawio`
- `testcontainers-flow.drawio`

## Quality gates before promotion
Content QA, Technical QA, Diagram QA, visual QA, accessibility check, DOCX render/hash, repository re-fetch/hash verification. `_03` remains blocked until this guide is approved.
