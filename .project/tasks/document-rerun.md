# Document Rerun Task Queue

**Stream weight:** 45% — PRIMARY.  
**Task model:** 60 tracks × 3 documents = 180 document tasks.  
**Current eight-lane allocation:** NONE — Document work remains excluded from the Presenter/Classroom/Recovery allocation.

## Current dependency state
- T01_01: QUALITY_GATE_PASSED; repository materialization/re-fetch/identity transition pending.
- T01_02: APPROVED; repository verification complete.
- T01_03: QUALITY_GATE_PASSED; repository materialization/re-fetch/identity transition pending.
- T02_01-T06_01: APPROVED.
- T02_02-T06_02: GENERATING.
- T02_03-T06_03: PENDING behind same-track Progressive Guide approval.
- T07-T60: queued PENDING.

## Current stream accounting
- Previous: **5.3889%**
- Updated: **5.3889%**
- Increase: **+0.0000%**
- Completed stage points: **970 / 18000**
- Cycles without increase: **34**
- State: **STALE BY PERCENTAGE / UNFINISHED UPSTREAM DEPENDENCY**.

## Tasks Closed This Cycle
None. Document dependency revalidation is not progress.

## Tasks In Progress / Blocked
- T02_02-T06_02 remain GENERATING under the separate Document process; no current eight-lane worker is assigned.
- T01_01/T01_03 identity-control transition remains unfinished and blocks Classroom Release-01.
- T02_02/T02_03 continue to block Classroom Release-02 materialization/freeze.

## Open More Than 3 Cycles / Action Taken in This Cycle
Document Rerun is open for **39 coordinator cycles** and has **34 consecutive cycles without percentage increase**. **Action Taken in This Cycle:** dependency state was re-read only for Release-01/02 gating; no Document worker was allocated, no Document progress was credited, and no Quality Gate/public write occurred. State **STALE**.
