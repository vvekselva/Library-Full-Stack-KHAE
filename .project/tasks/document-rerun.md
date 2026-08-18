# Document Rerun Task Queue

**Stream weight:** 45% — PRIMARY UPSTREAM DEPENDENCY.  
**Task model:** 60 tracks × 3 documents = 180 document tasks.  
**Active logical workers:** Agents 3, 4, 5 and 6 under the current 2 Presenter / 4 Document / 1 Classroom / 1 Recovery stale-recovery allocation.

## Current dependency state
- T01_01: QUALITY_GATE_PASSED; repository materialization/re-fetch/identity transition pending.
- T01_02: APPROVED; repository verification complete.
- T01_03: QUALITY_GATE_PASSED; repository materialization/re-fetch/identity transition pending.
- T02_01-T06_01: APPROVED.
- T02_02-T06_02: GENERATING.
- T02_02, T03_02 and T05_02 retain repository-backed pre-render Content/Technical/Diagram QA from prior correction work.
- T02_03-T06_03: PENDING behind same-track Progressive Guide approval.
- T07-T60: queued PENDING.

## Current lane allocation
- Agent 3: T02 highest priority — T02_02 completion/render/QA/approval, then T02_03 only when eligible.
- Agent 4: T03 independent progression.
- Agent 5: T04 independent progression.
- Agent 6: T05/T06 progression plus T01_01/T01_03 identity blocker when dependency-safe.

## Current stream accounting
- Previous: **5.3889%**
- Updated: **5.3889%**
- Increase: **+0.0000%**
- Completed stage points: **970 / 18000**
- State: **STRUCTURAL_BLOCKER — ACTIVE STALE-RECOVERY EXECUTION WITH FOUR LANES**.

## Tasks in progress
- T02_02 — priority render/QA/approval path under Agent 3.
- T03_02 — active independent progression under Agent 4.
- T04_02 — active independent progression under Agent 5.
- T05_02/T06_02 and T01 identity reconciliation — active/queued under Agent 6 according to dependency safety.

## Dependency guards
- No `_03` begins before the matching `_02` required gates pass.
- Do not edit the same document concurrently.
- No write to the read-only Quality Gate repository.
- No public Classroom repository write.

## >3-cycle stalled action
Document Rerun remains beyond the structural-blocker threshold. **Action Taken:** four logical lanes were reallocated directly to Document execution instead of continuing dependency-only polling. Percentage remains unchanged until a defined document gate closes.
