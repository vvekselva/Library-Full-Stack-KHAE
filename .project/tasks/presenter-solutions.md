# Presenter Solutions Task Queue

**Stream weight:** 35% — SECONDARY while Documentation is primary.  
**Logical worker:** Agent 6.  
**Per-track checkpoints:** Service → Unit Test → Integration (local PostgreSQL + PostgreSQL Testcontainers) → Assigned Frontend → cumulative CI/registry gate.

## Dependency rules

Do not start Integration before Service + Unit Test branch-tip CI is green. Do not start assigned Frontend before its backend/support contract is source-grounded. Do not award registry completion until required cumulative CI/batch registry gates pass. Presenter code remains private.

## Current verified state

- T01-T30: completed/verified batch registries.
- T31: Service + UT + Integration + Frontend complete; 80%; final registry checkpoint pending T31-T35 batch.
- T32: Service + UT + Integration + Frontend complete; 80%; final registry checkpoint pending T31-T35 batch.
- T33: Service + Unit Test implemented; targeted repair committed; branch-tip CI is IN PROGRESS; Integration and Frontend remain BLOCKED until green.
- T34-T60: pending unless later verified repository evidence supersedes this file.

## T33 exact evidence

Prior failure:
- Branch: `Presenter-Solutions-T31-T35`
- Service commit: `fec9bcdbdaa86e17c0b939a8020321de05c632c6`
- Unit-test/head commit: `4520f779a87bcac8c7628a90f0e6bc14fd87c6d8`
- Workflow `31946962274`, attempt 2: FAILURE
- Backend job `95189332185`: FAILURE at **Run Presenter solution tests with PostgreSQL**
- Frontend job `95189332541`: SUCCESS

Targeted diagnosis and repair:
- T33 duplicate test requires `" acc-0001 "` to query normalized business key `"ACC-0001"` and produce the duplicate error.
- `UpdateBookCopyServiceImpl` previously trimmed accession number but did not uppercase it before `findByNormalizedBusinessKey`.
- Repair commit: `fe4b8262bd9536cc0ce88569ae6031f7604e0132`.
- Repair: normalize the required accession number to uppercase with `Locale.ROOT` before duplicate lookup and mapper update.
- Verification workflow: `31973754438`, head `fe4b8262bd9536cc0ce88569ae6031f7604e0132`.
- Latest observed state: backend-test IN_PROGRESS at `Run Presenter solution tests with PostgreSQL`; frontend-build SUCCESS.

## Immediate Agent 6 queue

1. Require workflow `31973754438` to complete SUCCESS before granting the Unit Test checkpoint or starting Integration.
2. If green, record immutable run/job/head evidence and start T33 local PostgreSQL + PostgreSQL-18 Testcontainers Integration.
3. Only after Integration success, advance assigned Frontend and cumulative CI.
4. If the repair CI fails, inspect the exact new failure and make only another evidence-backed correction.
5. Continue T34 then T35; freeze T31-T35 registry only when all five tracks satisfy the gate.

## Current stream accounting

- Previous: **53.3333%**
- Updated: **53.3333%**
- Increase: **+0.0000%**
- Cycles without increase: **8**
- State: **STALE (>3 completed cycles without percentage increase)**, with substantive repair verification now in progress.

## Action Taken in This Cycle

Compared the committed T33 unit test directly with `UpdateBookCopyServiceImpl`, isolated the normalization mismatch, committed the minimal targeted repair `fe4b8262...`, and triggered branch-tip workflow `31973754438`. Frontend is green and backend verification remains in progress; no percentage or dependent Integration work was started before CI success.
