# Presenter Solutions Task Queue

**Stream weight:** 35% — SECONDARY while Documentation is primary.  
**Logical worker:** Agent 6.  
**Per-track checkpoints:** Service → Unit Test → Integration (local PostgreSQL + PostgreSQL Testcontainers) → Assigned Frontend → cumulative CI/registry gate.

## Dependency rules

Do not start Integration before Service + Unit Test branch-tip CI is green. Do not start assigned Frontend before its backend/support contract is source-grounded. Do not award registry completion until required cumulative CI/batch registry gates pass. CI/log inspection is verification, not an implementation checkpoint. Presenter code remains private.

## Current verified state

- T01-T30: completed/verified batch registries.
- T31: Service + UT + Integration + Frontend complete; 80%; final registry checkpoint pending T31-T35 batch.
- T32: Service + UT + Integration + Frontend complete; 80%; final registry checkpoint pending T31-T35 batch.
- T33: Service + Unit Test implemented; verification/repair gate unresolved; Integration and Frontend BLOCKED.
- T34-T60: pending unless later verified repository evidence supersedes this file.

## T33 exact evidence

- Branch: `Presenter-Solutions-T31-T35`
- Service commit: `fec9bcdbdaa86e17c0b939a8020321de05c632c6`
- Unit-test/head commit: `4520f779a87bcac8c7628a90f0e6bc14fd87c6d8`
- Workflow: `31946962274`, attempt 2, FAILURE
- Backend job: `95189332185`, FAILURE
- Frontend job: `95189332541`, SUCCESS
- Exact failed backend step: **Run Presenter solution tests with PostgreSQL**.
- The available connector exposes the failed step and terminal exit code but still does not provide the Maven/Surefire assertion/error body needed for a proven repair.

## Immediate Agent 6 queue

1. Obtain the exact T33 backend Maven/Surefire failing test/error from a usable Actions log/report surface.
2. Apply only the proven repair; do not grant percentage for repair alone.
3. Require branch-tip CI SUCCESS before T33 Integration.
4. Then implement/verify T33 local PostgreSQL + PostgreSQL-18 Testcontainers Integration.
5. Only after Integration success, advance assigned Frontend and cumulative CI.
6. Continue T34 then T35; freeze T31-T35 registry only when all five tracks satisfy the gate.

## Current stream accounting

- Previous: **53.3333%**
- Updated: **53.3333%**
- Increase: **+0.0000%**
- Cycles without increase: **6**
- State: **STALE (>3 completed cycles without percentage increase)**.

## Action Taken in This Cycle

Narrowed the T33 CI failure from a generic backend failure to the exact workflow step `Run Presenter solution tests with PostgreSQL`, re-read the T33 unit-test commit and service implementation, and confirmed no source-grounded repair can be justified without the Maven/Surefire failure body. No speculative code change or blind rerun was performed; Integration/Frontend remain blocked.
