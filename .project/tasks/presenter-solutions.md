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
- T33: Service + Unit Test/repair GREEN; local PostgreSQL + PostgreSQL-18 Testcontainers Integration GREEN; assigned Frontend implemented at `c82d0f0ed896bc9f6d729e8db34855040ce2fbaa`; cumulative branch-tip workflow `31976478238` is still running. Frontend build is SUCCESS while backend PostgreSQL tests remain IN_PROGRESS.
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
- Verification workflow: `31973754438`: **SUCCESS**.

Integration checkpoint — VERIFIED:
- Local PostgreSQL integration commit: `b2d3a859eb250134c0b1d8c5666df7bf78d9a193`.
- PostgreSQL 18 Testcontainers integration commit: `2f1bea871d7b8f49fefdb2e8db699724051470da`.
- Integration coverage: successful current-row update with normalized accession/status plus duplicate-accession rejection against real PostgreSQL persistence.
- Branch-tip workflow `31973983928`: **SUCCESS**.
- This closes the T33 Integration checkpoint and legitimately unlocks Frontend.

Assigned Frontend — IMPLEMENTED, CUMULATIVE CI PENDING:
- Used the existing verified Update Book Copy frontend recovery pattern and T33's source-proven PUT contract.
- New track file: `frontend/frontend.lib.mgmt/src/tracks/t33-update-book-copy.js`.
- Frontend commit: `c82d0f0ed896bc9f6d729e8db34855040ce2fbaa`.
- Workflow `31976478238`: IN_PROGRESS at this checkpoint.
- Frontend job `95236646591`: SUCCESS, including dependency installation and Vite production build.
- Backend job `95236646515`: IN_PROGRESS at `Run Presenter solution tests with PostgreSQL`.
- Do not credit the Frontend checkpoint until cumulative branch-tip CI completes green.

## Immediate Agent 6 queue

1. Require workflow `31976478238` to complete SUCCESS before granting the T33 Frontend checkpoint.
2. If green, preserve T33 cumulative evidence and advance only dependency-eligible T34 work.
3. If it fails, inspect the exact failure and make only an evidence-backed correction.
4. Freeze T31-T35 registry only when all five tracks satisfy the gate.

## Current stream accounting

- Previous: **53.3333%**
- Updated: **53.6667%**
- Increase: **+0.3334%**
- Cycles without increase: **0**
- State: **IN PROGRESS — ADVANCED THIS CYCLE**.

## Tasks Closed This Cycle

- **T33 Integration checkpoint — CLOSED.** Workflow `31973983928` completed SUCCESS at Testcontainers head `2f1bea871d7b8f49fefdb2e8db699724051470da`.

## Tasks In Progress This Cycle

- **T33 assigned Frontend / cumulative CI.** Implementation commit `c82d0f0e...`; frontend build green; cumulative backend test job still running.

## Action Taken in This Cycle

Verified the previously pending Integration workflow green, awarded only the Integration checkpoint, then implemented the now-unblocked T33 Update Book Copy recovery frontend without changing shared frontend infrastructure. The push triggered workflow `31976478238`; its frontend build is green and backend PostgreSQL tests remain active. No Frontend percentage is credited until the complete branch-tip workflow is green.
