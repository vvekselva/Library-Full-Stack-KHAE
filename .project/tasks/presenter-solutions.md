# Presenter Solutions Task Queue

**Stream weight:** 35%.  
**Active logical workers:** Agents 1, 2, 3 and 6.  
**Per-track checkpoints:** Service → Unit Test → green branch-tip CI → Integration (local PostgreSQL + PostgreSQL Testcontainers) → green Integration CI → Assigned Frontend → cumulative CI/registry gate.

## Dependency rules
Do not start Integration before Service + Unit Test branch-tip CI is green. Do not start assigned Frontend before Integration is green. Do not award registry completion until required cumulative CI/batch registry gates pass. Presenter code remains private.

## Current verified state
- T01-T30: completed/verified batch registries.
- T31: 80%; Service + UT + Integration + Frontend complete; final registry checkpoint pending T31-T35 batch.
- T32: 80%; Service + UT + Integration + Frontend complete; final registry checkpoint pending T31-T35 batch.
- T33: 80%; Service + Unit Test/repair + Integration + Frontend verified green; final registry checkpoint pending T31-T35 batch.
- T34: Service + Unit Test + Integration VERIFIED GREEN = 60%. The prior Integration test/seed mismatch was repaired and replacement branch-tip workflow `31981001820` passed both backend PostgreSQL and frontend-build jobs. Assigned Frontend is now dependency-eligible but not yet credited.
- T35: source/interface/DAO/STUB reconciliation is active; no implementation checkpoint is credited yet.
- T36-T60: pending unless newer verified evidence supersedes this file.

## Current four-lane allocation
- **Agent 1:** T34 Integration failure diagnosis — CLOSED with source-proven root cause and green replacement CI.
- **Agent 2:** T34 Integration test/seed reconciliation and verification — CLOSED; branch-tip CI green.
- **Agent 3:** T35 source/contract/interface/controller/stub reconciliation; current evidence proves service code/interface/DAO/STUB identity, with Presenter-owned route/envelope still to be fully frozen before implementation.
- **Agent 6:** T34 assigned Frontend readiness/implementation is now dependency-eligible; exact assigned frontend identity must be resolved before writing. T31-T34 cumulative registry remains pending Frontend completion.

## T34 exact evidence
Frozen source reconciliation:
- Code `T34_DEACTIVATE_BOOK_COPY = "34"`.
- REST contract `DELETE /rest/book-copies/{id}`.
- Interface `DeleteBookCopyService.deleteBookCopy(Long id)`.
- DAO guards: `findCurrentById(id)` excludes WITHDRAWN; `countDependencies(id)` counts ACTIVE Book Issues.

Verified checkpoints:
- Service implementation `abb23be3f9e10dd53c9bf267a3a02b7acbd3e134`.
- Unit tests `bc15079bf17a219283f3465083b8577e7f9da16f`.
- Service/Unit verification workflow `31979270908`: SUCCESS; frontend job `95243377846` SUCCESS; backend PostgreSQL job `95243377910` SUCCESS.

Integration failure diagnosis and repair:
- Prior local PostgreSQL integration `f5c7804210431152ec40e54ca03d64a093fd9361` and PostgreSQL 18 Testcontainers integration `d61995c62f19152ec5fb7ab9b3c30e6e52e5ab6e` both used seeded Book Copy ID `2` as the successful withdrawal case.
- Deterministic seed data gives Book Copy ID `2` an ACTIVE Book Issue. The verified service correctly rejects that copy through the dependency guard, so the tests were inconsistent with the frozen business rule.
- Seeded Book Copy ID `4` is current and has no ACTIVE Book Issue; it is the correct deterministic success case.
- Local PostgreSQL test repair `325c7102ddc2e9911a4abff6e3ec0e80d7701113`: success/repeat-withdrawal uses ID `4`; explicit ID `2` dependency-exists test added.
- PostgreSQL 18 Testcontainers repair `2f2081c062585e1a59a924eff8487f5454fd9025`: same deterministic alignment and dependency guard coverage.
- Replacement workflow `31981001820` at head `2f2081c062585e1a59a924eff8487f5454fd9025`: SUCCESS.
- Frontend-build job `95247637355`: SUCCESS.
- Backend PostgreSQL job `95247637400`: SUCCESS; `Run Presenter solution tests with PostgreSQL` completed successfully.

## T35 reconciliation evidence
- Service code: `T35_SEARCH_BOOK_COPY = "35"`.
- Interface: `SearchBookCopyService.searchBookCopy(String text)` returning `List<BookCopyResponseDto>`.
- `BookCopyDao.search(String text)` searches `accessionNumber` with a `%text%` pattern and orders by `bookCopyId`.
- Current `SearchBookCopyServiceImpl` is a STUB that ignores `text` and returns hard-coded Book Copy `1 / ACC-0001 / book 1 / AVAILABLE`.
- No T35 Service checkpoint is credited until Presenter-owned controller/route/envelope reconciliation is complete and implementation is dependency-safe.

## Current stream accounting
- Previous: **54.6667%**
- Updated: **55.0000%**
- Increase: **+0.3333%**
- State: **T34 INTEGRATION VERIFIED GREEN; T34 FRONTEND NOW ELIGIBLE; T35 RECONCILIATION ACTIVE**.

## Tasks Taken Up This Cycle
- Diagnose the exact T34 PostgreSQL Integration CI failure.
- Reconcile and repair T34 local/Testcontainers tests against deterministic seed and dependency behavior.
- Validate the repair with branch-tip CI.
- Reconcile T35 service code, interface, DAO search behavior and current STUB boundary.
- Inspect T34 Frontend readiness without guessing an unverified assigned file.

## Tasks Closed This Cycle
- T34 failure diagnosis: CLOSED.
- T34 evidence-supported Integration test repair: CLOSED.
- T34 green Integration CI checkpoint: CLOSED with workflow `31981001820`.

## Tasks In Progress
- Resolve exact assigned T34 Frontend identity and implement only after identity verification.
- Complete T35 Presenter-owned route/envelope reconciliation.
- T31-T34 cumulative-regression / registry readiness remains pending T34 Frontend.

## Completion rule
T34 Integration is now credited. No Frontend or registry credit is awarded until exact assigned Frontend implementation and cumulative verification complete.