# Presenter Solutions Task Queue

**Stream weight:** 35%.  
**Active logical workers:** Agents 1, 2, 3 and 6.  
**Per-track checkpoints:** Service → Unit Test → green branch-tip CI → Integration (local PostgreSQL + PostgreSQL Testcontainers) → green Integration CI → Assigned Frontend → cumulative CI/registry gate.

## Dependency rules
Do not start Integration before Service + Unit Test branch-tip CI is green. Do not start assigned Frontend before Integration is green. Do not award registry completion until required cumulative CI/batch registry gates pass. Presenter code remains private.

## Current verified state
- T01-T30: completed/verified batch registries.
- T31: 80%; final registry checkpoint pending T31-T35 batch.
- T32: 80%; final registry checkpoint pending T31-T35 batch.
- T33: 80%; final registry checkpoint pending T31-T35 batch.
- T34: **80%**; Service + Unit Test + Integration + assigned Frontend verified green; cumulative run `31982423259` SUCCESS; final batch registry checkpoint pending.
- T35: **40% verified**; route/envelope reconciliation, Service and Unit Test are CLOSED GREEN. The live `SearchBookCopyServiceImpl` is implemented with null/blank validation, trim normalization, DAO search and DTO mapping; it is not a hard-coded STUB. Local PostgreSQL Integration `6881ec4a...` and PostgreSQL 18 Testcontainers Integration `31c51de7...` are committed, but the percentage-bearing Integration gate remains FAILED.
- T36-T60: pending unless newer verified evidence supersedes this file.

## Current four-lane allocation
- **Agent 1:** T34 Frontend/cumulative gate — CLOSED GREEN; T34 registry-ready.
- **Agent 2:** T35 Integration diagnosis — ACTIVE; deterministic failure proven, exact Maven/Surefire cause still not exposed by available job logs/annotations.
- **Agent 3:** T35 source/contract/interface/controller/DAO/seed reconciliation — CLOSED; current source and deterministic seed are internally aligned with the frozen contract.
- **Agent 6:** T35 Unit Test — CLOSED GREEN; future Frontend remains BLOCKED because Integration is not green.

## Exact evidence
### T34
- DELETE `/rest/book-copies/{id}`, code `34`.
- Service `abb23be3...`; Unit Test `bc15079b...`.
- Integration replacement run `31981001820`: SUCCESS.
- Frontend `820ae6cf96a2fee1a688383f12db329994ea8cf7`.
- Cumulative run `31982423259`: frontend `95251485072` SUCCESS; backend `95251485194` SUCCESS.
- T34 is registry-ready pending batch freeze.

### T35
- GET `/rest/book-copies/search?text=...`; `ApiResponse<List<BookCopyResponseDto>>`; code `35`; message `Book Copy Search Completed Successfully`.
- Interface `SearchBookCopyService.searchBookCopy(String text)`.
- DAO searches `accessionNumber` with `%text%` and orders by `bookCopyId`.
- Service `0591d97853970e83be826af8bb9fb1c19ed46b2c`.
- Unit Test `126fe8493f80d99ae1c5b1bcdfcaab06fb5b9823`.
- Service/Unit verification run `31982423259`: SUCCESS.
- Local PostgreSQL Integration `6881ec4a108fd4eb460e78b01d737b4929fc2490`.
- PostgreSQL 18 Testcontainers Integration branch tip `31c51de7f11fc56faa56239430f62284a5c0a597`.
- Commit `31c51de7...` changes only `SearchBookCopyTestcontainersIntegrationTest.java`; its test searches `0004`, expects exactly Book Copy ID 4 / `ACC-0004`, and expects `missing` to return an empty list.
- Deterministic seed V002 contains Book Copy ID 4 = `ACC-0004`, AVAILABLE, and four total seeded copies `ACC-0001` through `ACC-0004`; this directly matches the Testcontainers assertion fixture.
- Existing green Testcontainers tests use the same Spring Boot 4.1 / Testcontainers PostgreSQL 18 pattern and `org.testcontainers.postgresql.PostgreSQLContainer`, so the T35 import/container style is not uniquely divergent.
- Integration run `31982678321`: frontend-build `95252157100` SUCCESS; original backend-test `95252157107` FAILURE.
- Same-source failed-job rerun `95256133626` also FAILURE. Job steps show setup/container initialization succeeded and only `Run Presenter solution tests with PostgreSQL` failed; the connector exposes no Surefire artifact and the raw job-log endpoint returns no usable test text.
- Therefore no source-grounded assertion-level repair can yet be justified. No speculative patch was made.

## Current stream accounting
- Previous: **56.0000%**
- Updated: **56.0000%**
- Increase: **+0.0000%**
- State: **STALE BY PERCENTAGE / T35 INTEGRATION DETERMINISTIC FAILURE UNDER DIAGNOSIS**.

## Tasks Taken Up This Cycle
- Isolate the T35 branch-tip delta and compare its Testcontainers fixture against deterministic V002 seed data.
- Inspect failed workflow job steps, annotations/log surfaces, Testcontainers dependency shape and an existing green PostgreSQL 18 Testcontainers test.
- Keep T35 Frontend blocked until Integration is objectively green.

## Tasks Closed This Cycle
- T35 Testcontainers fixture-vs-seed mismatch hypothesis — CLOSED: test `0004` expectation and V002 ID 4 / `ACC-0004` are aligned.
- T35 unique PostgreSQLContainer import/pattern hypothesis — CLOSED: an existing green track uses the same Spring Boot/Testcontainers PostgreSQL 18 pattern.

## Tasks In Progress / Blocked
- T35 exact Integration failure isolation — IN PROGRESS; precise Maven/Surefire assertion/error is still not exposed by available CI evidence.
- T35 Integration percentage gate — FAILED / not credited.
- T35 Frontend — BLOCKED until Integration is green.
- T31-T35 batch freeze — BLOCKED until T35 becomes registry-ready.

## Action Taken in This Cycle
Narrowed the deterministic T35 failure without guessing: inspected commit `31c51de7...`, proved it adds only the T35 PostgreSQL 18 Testcontainers class, reconciled that test's `ACC-0004` expectation against V002, and compared its container pattern with a previously green Testcontainers integration class. CI step evidence confirms container/setup success and failure only inside the Maven presenter-test step, but the connector still exposes no exact Surefire failure text. No speculative source or test change was committed.

## Completion rule
Credit T35 Integration only after a source-grounded repair and fully green workflow. Only then may the assigned T35 Frontend be implemented.