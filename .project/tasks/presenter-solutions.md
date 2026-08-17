# Presenter Solutions Task Queue

**Stream weight:** 35%.  
**Active logical workers:** Agents 1, 2, 3 and 6.  
**Per-track checkpoints:** Service → Unit Test → green branch-tip CI → Integration (local PostgreSQL + PostgreSQL Testcontainers) → green Integration CI → Assigned Frontend → cumulative CI/registry gate.

## Dependency rules
Do not start Integration before Service + Unit Test branch-tip CI is green. Do not start assigned Frontend before Integration is green. Do not award registry completion until required cumulative CI/batch registry gates pass. Presenter code remains private.

## Current verified state
- T01-T30: completed/verified batch registries.
- T31-T35: **100% complete and batch registry VERIFIED**.
- T36-T60: pending unless newer verified evidence supersedes this file.

## T31-T35 closure evidence
- T35 exact Integration failure was exposed by diagnostic run `31988227342`: `SearchBookCopyIntegrationTest.shouldPreserveDaoOrderingAcrossMatchingCopies` relied on brittle fixed seed-count/terminal-ID assertions although `BookCopyDao.search` only guarantees matching accession-number rows ordered by `bookCopyId`.
- T35 Integration repair commits: `c9ebfcf4eb7e94b374953de5ac157fae4b6633f4` and final `18c2abd065862580a3d5459e7875b21c9890634b`.
- T35 repaired Integration run `31990077599`: backend `95271926715` SUCCESS; frontend-build `95271926679` SUCCESS.
- Assignment-boundary reconciliation used the established 5-track rotation: Create→Update, Read→Delete, Update→Search, Delete→Create, Search→Read/List.
- T33 incorrect Update frontend was removed and replaced by assigned Search frontend `00f2f244e261f86805cacd35e5b05894d0fb3b46` at `frontend/frontend.lib.mgmt/src/tracks/t33-search-book-copy.js`.
- T34 incorrect Deactivate frontend was removed and replaced by assigned Create frontend `6d480c3740424bb0b456393dc1ad0eb4beb737e1` at `frontend/frontend.lib.mgmt/src/tracks/t34-create-book-copy.js`.
- T35 assigned Read/List frontend: `6a5b00a51abae1b077ea4ea644c03866c855ed1d` at `frontend/frontend.lib.mgmt/src/tracks/t35-read-list-book-copy.js`.
- Corrected branch-tip run `31990383608`: backend `95272723987` SUCCESS; frontend `95272723831` SUCCESS.
- Frozen registry: `.presenter/solution-registry/T31-T35.yml`, commit `83d51d4343fd79f8609e4bc73a483ce85615a276`.
- Registry-tip verification run `31990613453`: backend `95273356638` SUCCESS; frontend `95273356652` SUCCESS.

## Current four-lane allocation
- **Agent 1:** T35 Integration diagnosis/repair — CLOSED GREEN.
- **Agent 2:** T33/T34/T35 assigned-frontend reconciliation — CLOSED GREEN.
- **Agent 3:** T31-T35 cumulative source/contract evidence reconciliation — CLOSED.
- **Agent 6:** T31-T35 registry freeze and branch-tip verification — CLOSED GREEN.

## Current stream accounting
- Previous: **56.0000%**
- Updated: **58.3333%**
- Increase: **+2.3333%**
- State: **PROGRESSED — T31-T35 BATCH CLOSED VERIFIED**.

## Tasks Taken Up This Cycle
- Extract exact T35 Maven failure and repair only the invalid Integration assertions.
- Verify the established frontend-assignment rotation and correct T33/T34/T35 assignments before registry credit.
- Run corrected cumulative CI, freeze the T31-T35 private registry, and run registry-tip CI.

## Tasks Closed This Cycle
- T35 Integration gate — CLOSED GREEN.
- T33 assigned Frontend correctness — CLOSED GREEN after repair.
- T34 assigned Frontend correctness — CLOSED GREEN after repair.
- T35 assigned Frontend — CLOSED GREEN.
- T31-T35 cumulative CI/registry gate — CLOSED GREEN.

## Tasks In Progress / Blocked
- T36-T40 Presenter work — next eligible batch; do not run any dependent stage before its source/contract prerequisites are established.

## Action Taken in This Cycle
Converted T35 from deterministic Integration failure to a fully verified batch close: diagnostic CI exposed the exact brittle assertions, source-grounded repairs removed fixed seed assumptions while preserving DAO ordering verification, the corrected frontend assignment rotation was enforced for T33-T35, branch-tip cumulative CI passed, and `.presenter/solution-registry/T31-T35.yml` was frozen and revalidated on run `31990613453`.

## Completion rule
Continue T36-T60 with the same dependency sequence and do not credit a batch registry before exact component identities and cumulative branch-tip verification are green.
