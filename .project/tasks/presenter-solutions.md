# Presenter Solutions Task Queue

**Stream weight:** 35% — SECONDARY while Documentation is the primary stream.  
**Logical worker:** Agent 6.  
**Per-track checkpoints:** Service → Unit Test → Integration (local PostgreSQL + PostgreSQL Testcontainers) → Assigned Frontend → cumulative CI/registry gate.

## Dependency rules

1. Do not start Integration before the track Service + Unit Test branch-tip CI is green.
2. Do not start the assigned Frontend if its backend/support contract is not source-grounded.
3. Do not award the final per-track registry checkpoint until cumulative CI and the required batch registry gate are green.
4. CI/log inspection is verification work, not an implementation checkpoint.
5. Presenter code remains private.

## Current verified state

- T01-T30: verified through their completed batch registries.
- T31: Service + UT + Integration + Frontend complete; 80%; final registry checkpoint pending T31-T35 batch.
- T32: Service + UT + Integration + Frontend complete; 80%; final registry checkpoint pending T31-T35 batch.
- T33: Service + Unit Test implemented; verification/repair gate unresolved; Integration and Frontend must not start prematurely.
- T34-T60: pending unless later repository evidence supersedes this file.

## Complete track queue

| Track | Service | Unit Test | Integration | Frontend | Registry / Final | State |
|---|---|---|---|---|---|---|
| T01-T05 | DONE | DONE | DONE | DONE | VERIFIED | CLOSED |
| T06-T10 | DONE | DONE | DONE | DONE | VERIFIED | CLOSED |
| T11-T15 | DONE | DONE | DONE | DONE | VERIFIED | CLOSED |
| T16-T20 | DONE | DONE | DONE | DONE | VERIFIED | CLOSED |
| T21-T25 | DONE | DONE | DONE | DONE | VERIFIED | CLOSED |
| T26-T30 | DONE | DONE | DONE | DONE | VERIFIED | CLOSED |
| T31 | DONE | DONE | DONE | DONE | WAIT T31-T35 REGISTRY | 80% |
| T32 | DONE | DONE | DONE | DONE | WAIT T31-T35 REGISTRY | 80% |
| T33 | DONE | IMPLEMENTED / CI REPAIR | BLOCKED BY UT CI | BLOCKED BY INTEGRATION | WAIT T31-T35 REGISTRY | ACTIVE BLOCKER |
| T34 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T35 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T36 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T37 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T38 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T39 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T40 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T41 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T42 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T43 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T44 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T45 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T46 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T47 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T48 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T49 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T50 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T51 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T52 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T53 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T54 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T55 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T56 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T57 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T58 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T59 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |
| T60 | PENDING | PENDING | PENDING | PENDING | PENDING | QUEUED |

## Immediate Agent 6 queue

1. Reconcile exact T33 branch-tip CI failure against current source/test state.
2. Apply only the proven T33 repair; no percentage for repair alone.
3. Require exact repaired branch-tip CI SUCCESS.
4. Implement T33 local PostgreSQL + PostgreSQL-18 Testcontainers Integration as one checkpoint.
5. Require cumulative Integration CI green.
6. Implement T33 assigned Frontend from the canonical manifest/audit.
7. Require cumulative branch-tip CI green.
8. Continue T34, then T35.
9. Trigger/freeze T31-T35 batch registry only when all five tracks satisfy the registry prerequisite.

## Coordination with Documentation

Agent 6 may continue independently, but Documentation receives priority compute/tool attention. Presenter work must not block five independent Document lanes unless a shared contract used by those documents requires Presenter source correction.