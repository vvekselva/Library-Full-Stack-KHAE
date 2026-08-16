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
- T34: Service + Unit Test VERIFIED GREEN = 40%. Local PostgreSQL + PostgreSQL 18 Testcontainers Integration are committed, but branch-tip workflow `31979478188` completed FAILURE. Frontend remains blocked.
- T35-T60: pending unless newer verified evidence supersedes this file.

## Current four-lane allocation
- **Agent 1:** T34 Integration CI failure diagnosis and exact failing-test/root-cause evidence.
- **Agent 2:** T34 Integration implementation/test reconciliation against the frozen contract, DAO state and PostgreSQL behavior; prepare/perform only evidence-supported repair.
- **Agent 3:** T35 source/contract/interface/controller/stub reconciliation only; do not skip Service → UT → CI ordering.
- **Agent 6:** T31-T34 cumulative regression/registry readiness and exact T34 Frontend readiness inspection; do not implement T34 Frontend while Integration is red.

## T34 exact evidence
Frozen source reconciliation:
- Code `T34_DEACTIVATE_BOOK_COPY = "34"`.
- REST contract `DELETE /rest/book-copies/{id}`.
- Interface `DeleteBookCopyService.deleteBookCopy(Long id)`.
- DAO guards: `findCurrentById(id)` excludes WITHDRAWN; `countDependencies(id)` counts ACTIVE Book Issues.

Verified checkpoints:
- Service implementation `abb23be3f9e10dd53c9bf267a3a02b7acbd3e134`.
- Unit tests `bc15079bf17a219283f3465083b8577e7f9da16f`.
- Verification workflow `31979270908`: SUCCESS; frontend job `95243377846` SUCCESS; backend PostgreSQL job `95243377910` SUCCESS.

Integration evidence:
- Local PostgreSQL integration `f5c7804210431152ec40e54ca03d64a093fd9361`.
- PostgreSQL 18 Testcontainers integration `d61995c62f19152ec5fb7ab9b3c30e6e52e5ab6e`.
- Workflow `31979478188`: **FAILURE**.
- Backend job `95243874899`: **FAILURE** specifically at `Run Presenter solution tests with PostgreSQL`; setup/container/checkout/Java steps succeeded.
- Frontend job `95243874904`: **SUCCESS**.

## Current stream accounting
- Previous: **54.6667%**
- Updated: **54.6667%**
- Increase: **+0.0000%**
- State: **T34 INTEGRATION RED — FOUR INDEPENDENT PRESENTER LANES ACTIVE WITH DEPENDENCY GUARDS**.

## Tasks In Progress
- Diagnose T34 backend Integration failure.
- Reconcile T34 Integration tests/implementation to isolate evidence-supported repair.
- Reconcile T35 source/contract ownership without starting dependent implementation prematurely.
- Audit cumulative-regression and T34 Frontend readiness while preserving Frontend block.

## Completion rule
No Presenter percentage is credited for T34 Integration until a branch-tip Integration workflow is fully green. T34 Frontend remains blocked until then.