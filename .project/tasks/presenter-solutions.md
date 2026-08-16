# Presenter Solutions Task Queue

**Stream weight:** 35% — SECONDARY while Documentation is primary.  
**Logical worker:** Agent 6.  
**Per-track checkpoints:** Service → Unit Test → Integration (local PostgreSQL + PostgreSQL Testcontainers) → Assigned Frontend → cumulative CI/registry gate.

## Dependency rules

Do not start Integration before Service + Unit Test branch-tip CI is green. Do not start assigned Frontend before Integration is green. Do not award registry completion until required cumulative CI/batch registry gates pass. Presenter code remains private.

## Current verified state

- T01-T30: completed/verified batch registries.
- T31: Service + UT + Integration + Frontend complete; 80%; final registry checkpoint pending T31-T35 batch.
- T32: Service + UT + Integration + Frontend complete; 80%; final registry checkpoint pending T31-T35 batch.
- T33: Service + Unit Test/repair CI GREEN; local PostgreSQL + PostgreSQL-18 Testcontainers Integration implemented; branch-tip Integration CI IN PROGRESS; Frontend remains BLOCKED until Integration is green.
- T34-T60: pending unless later verified repository evidence supersedes this file.

## T33 exact evidence

Prior failure:
- Branch: `Presenter-Solutions-T31-T35`
- Service commit: `fec9bcdbdaa86e17c0b939a8020321de05c632c6`
- Unit-test/head commit: `4520f779a87bcac8c7628a90f0e6bc14fd87c6d8`
- Workflow `31946962274`, attempt 2: FAILURE
- Backend job `95189332185`: FAILURE at **Run Presenter solution tests with PostgreSQL**
- Frontend job `95189332541`: SUCCESS

Targeted diagnosis and verified repair:
- T33 duplicate test requires `" acc-0001 "` to query normalized business key `"ACC-0001"` and produce the duplicate error.
- `UpdateBookCopyServiceImpl` previously trimmed accession number but did not uppercase it before `findByNormalizedBusinessKey`.
- Repair commit: `fe4b8262bd9536cc0ce88569ae6031f7604e0132`.
- Verification workflow: `31973754438` at repair head: **SUCCESS**; backend PostgreSQL tests SUCCESS and frontend build SUCCESS.

Integration implementation:
- Local PostgreSQL integration commit: `b2d3a859eb250134c0b1d8c5666df7bf78d9a193`.
- PostgreSQL 18 Testcontainers integration commit: `2f1bea871d7b8f49fefdb2e8db699724051470da`.
- Integration coverage: successful current-row update with normalized accession/status plus duplicate-accession rejection against real PostgreSQL persistence.
- Branch-tip workflow: `31973983928` at `2f1bea871d7b8f49fefdb2e8db699724051470da`.
- Latest observed state: backend-test and frontend-build IN_PROGRESS/queued through the new Integration head.

## Immediate Agent 6 queue

1. Require workflow `31973983928` to complete SUCCESS before granting the T33 Integration checkpoint.
2. Only after Integration success, implement/advance the assigned T33 Frontend and cumulative CI.
3. If Integration CI fails, inspect the exact failure and make only an evidence-backed correction.
4. Continue T34 then T35; freeze T31-T35 registry only when all five tracks satisfy the gate.

## Current stream accounting

- Previous: **53.3333%**
- Updated: **53.3333%**
- Increase: **+0.0000%**
- Cycles without increase: **8**
- State: **STALE (>3 completed cycles without percentage increase)**, but the former Unit-Test blocker is closed and Integration verification is now active.

## Tasks Closed This Cycle

- **T33 targeted Unit-Test/CI repair — CLOSED.** Minimal normalization repair `fe4b8262...` passed workflow `31973754438` and unlocked Integration.

## Action Taken in This Cycle

Isolated and repaired the T33 accession normalization defect, verified the repair green through PostgreSQL CI, then implemented both dependency-allowed Integration layers at `b2d3a859...` and `2f1bea87...`. Workflow `31973983928` is validating the new Integration head. Frontend remains blocked until that run is green; no premature percentage was credited.
