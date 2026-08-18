# Document Rerun Task Queue

**Stream weight:** 45% — PRIMARY.  
**Task model:** 60 tracks × 3 documents = 180 document tasks.  
**Current eight-lane allocation:** Agents 4, 5 and 6 under the current anti-stale critical-path plan.

## Current dependency state
- T01_01: QUALITY_GATE_PASSED; repository materialization/re-fetch/identity transition pending.
- T01_02: APPROVED; repository verification complete.
- T01_03: QUALITY_GATE_PASSED; repository materialization/re-fetch/identity transition pending.
- T02_01-T06_01: APPROVED.
- T02_02-T06_02: GENERATING and now the immediate upstream bottleneck assigned to Agents 4–6.
- T02_03-T06_03: PENDING behind same-track Progressive Guide approval.
- T07-T60: queued PENDING.

## Current anti-stale allocation
- Agent 4: T02_02 expansion → render → QA.
- Agent 5: T03_02, then T04_02 sequentially per document.
- Agent 6: T05_02, then T06_02, plus identity/QG preparation; no Quality Gate write.
- Do not edit the same document concurrently and do not begin any `_03` until its `_02` gates pass.

## Current stream accounting
- Previous: **5.3889%**
- Updated: **5.3889%**
- Increase: **+0.0000%**
- Completed stage points: **970 / 18000**
- Cycles without increase before the anti-stale manual cycle: **46**
- State: **STRUCTURAL BLOCKER UNDER ACTIVE CORRECTIVE REALLOCATION**.

## Tasks Closed This Scheduled Cycle
None. The newer manual anti-stale cycle owns active Document execution and is already RUNNING.

## Tasks In Progress / Blocked
- T02_02-T06_02 — IN PROGRESS under Agents 4–6 in the newer user-authorized anti-stale cycle.
- T01_01/T01_03 identity-control transition remains unfinished and blocks Classroom Release-01.
- T02_02/T02_03 continue to block Classroom Release-02 materialization/freeze until document gates pass.

## Open More Than 3 Cycles / Action Taken
Document Rerun has exceeded the structural-blocker threshold. **Action Taken:** the newer user-authorized orchestration plan reallocated three lanes upstream to Documents, replacing the older no-Document allocation. This scheduled run detected that superseding plan and stopped competing with the manual Document execution. No Quality Gate/public write occurred.
