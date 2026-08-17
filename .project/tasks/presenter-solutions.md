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
- T35: **40% verified**; route/envelope reconciliation, Service and Unit Test are CLOSED GREEN. The live `SearchBookCopyServiceImpl` is implemented with null/blank validation, trim normalization, DAO search and DTO mapping; it is not a hard-coded STUB. Local PostgreSQL Integration `6881ec4a...` and PostgreSQL 18 Testcontainers Integration `31c51de7...` are committed, but the percentage-bearing Integration gate is FAILED.
- T36-T60: pending unless newer verified evidence supersedes this file.

## Current four-lane allocation
- **Agent 1:** T34 Frontend/cumulative gate — CLOSED GREEN; T34 registry-ready.
- **Agent 2:** T35 Integration diagnosis — ACTIVE; exact deterministic CI failure still requires assertion/surefire isolation before any repair.
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
- Integration run `31982678321`: frontend-build `95252157100` SUCCESS; original backend-test `95252157107` FAILURE.
- The failed backend job was rerun without changing source. Replacement backend job `95256133626` also finished FAILURE. This closes the transient-failure hypothesis: the T35 Integration failure is deterministic on the unchanged branch tip.
- Connector inspection confirmed the live service, DAO, mapper, deterministic `ACC-0001`–`ACC-0004` seed and T35 integration sources are structurally aligned. The connector's exposed annotation/log surface did not reveal the exact Maven/Surefire failing assertion, so no speculative code change was made.

## Current stream accounting
- Previous: **56.0000%**
- Updated: **56.0000%**
- Increase: **+0.0000%**
- State: **STALE BY PERCENTAGE / T35 INTEGRATION DETERMINISTIC FAILURE UNDER DIAGNOSIS**.

## Tasks Taken Up This Cycle
- Reconcile the live T35 implementation, DAO, mapper, deterministic Flyway seed and both Integration tests against the frozen contract.
- Rerun only failed backend job `95252157107` to distinguish transient CI failure from deterministic Integration failure.
- Inspect the future Frontend boundary only; do not implement it while Integration is failed.

## Tasks Closed This Cycle
- T35 transient-vs-deterministic CI diagnosis — CLOSED: deterministic failure proven by replacement backend job `95256133626` FAILURE on unchanged source.
- T35 source/seed mismatch hypothesis — CLOSED: current source and deterministic seed remain aligned; no evidence supports a blind service/seed rewrite.

## Tasks In Progress / Blocked
- T35 exact Integration failure isolation — IN PROGRESS; obtain the precise Maven/Surefire assertion/error before modifying source or tests.
- T35 Integration percentage gate — FAILED / not credited.
- T35 Frontend — BLOCKED until Integration is green.
- T31-T35 batch freeze — BLOCKED until T35 becomes registry-ready.

## Action Taken in This Cycle
Inspected the current T35 service/DAO/mapper/tests/seed, disproved the stale hard-coded-STUB description, and reran only the failed backend CI job. The rerun failed again on the unchanged branch tip, proving a deterministic Integration problem. Because the exposed CI annotation remained generic and the exact failing assertion was not available, no speculative patch was committed and all dependent work remains correctly blocked.

## Completion rule
Credit T35 Integration only after a repaired workflow is fully green. Only then may the assigned T35 Frontend be implemented.