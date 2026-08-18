# Document Rerun Task Queue

**Stream weight:** 45% — PRIMARY.  
**Task model:** 60 tracks × 3 documents = 180 document tasks.  
**Current eight-lane allocation:** Agents 4, 5 and 6 under the live anti-stale critical-path plan.

## Current dependency state
- T01_01: QUALITY_GATE_PASSED; repository materialization/re-fetch/identity transition pending.
- T01_02: APPROVED; repository verification complete.
- T01_03: QUALITY_GATE_PASSED; repository materialization/re-fetch/identity transition pending.
- T02_01-T06_01: APPROVED.
- T02_02-T06_02: GENERATING under Agents 4–6.
- T02_03-T06_03: PENDING behind same-track Progressive Guide approval.
- T07-T60: queued PENDING.

## Current anti-stale allocation
- Agent 4: T02_02 expansion → Draw.io → render → QA.
- Agent 5: T03_02, then T04_02 sequentially.
- Agent 6: T05_02, then T06_02, plus identity/QG preparation; no Quality Gate write.
- Do not edit the same document concurrently and do not begin any `_03` until its `_02` gates pass.

## Substantive execution evidence this cycle
### Agent 4 — T02_02 Read Department
- Prior expanded editable source remains at `aadfb12ed03aeac68135727816874cc48d953bf3`.
- All four required editable Draw.io assets are now materialized beside the source:
  - `request-flow.drawio` — commit `54514c0a3f1f278b4ce10ae3e49a06b7a6e5d90b`.
  - `unit-test-isolation.drawio` — commit `1b0551b1ad769f6b3b5f24e178270533af240188`.
  - `postgres-integration.drawio` — commit `63ff53926900b990af38c4a9f068fd7384633141`.
  - `testcontainers-flow.drawio` — commit `79450c2fc3a93b708dc90daf80a1ce60d2dd5fa9`.
- PostgreSQL nodes use Draw.io cylinder notation. Request, unit-test, local-integration and Testcontainers concepts are separated to avoid clutter.
- Next gate: assemble/render the guide, then Content/Technical/Diagram/visual/accessibility QA and repository verification.

### Agent 5 — T03_02 Update Department
- The outline-only editable source was expanded into a progressive teaching guide at `882e270fbd66d7aeac04d0a875b3cd4ca1d6ad99`.
- Added: WHY-before-HOW update rationale, ID/request responsibilities, service/DAO rules, unit-test isolation, positive/invalid/not-found/duplicate progression, JaCoCo guidance, local PostgreSQL integration, PostgreSQL 18 Testcontainers, assigned frontend integration, troubleshooting and exam-ready answers.
- Next gate: create the four declared Draw.io assets and then assemble/render/QA.

### Agent 6 — T05_02 Search Department
- The outline-only editable source was expanded into a progressive search-testing guide at `62f406ce17aa44c00fb00c16e34db5bf0ba7c8ba`.
- Added: search-vs-read explanation, DAO/service boundary, normalization/no-result behavior, isolated unit tests, local PostgreSQL query integration, PostgreSQL 18 Testcontainers, assigned frontend integration, troubleshooting and exam-ready answers.
- Next gate: create declared Draw.io assets and then assemble/render/QA.

## Current stream accounting
- Previous: **5.3889%**
- Updated: **5.3889%**
- Increase: **+0.0000%**
- Completed stage points: **970 / 18000**
- State: **STRUCTURAL BLOCKER UNDER ACTIVE CORRECTIVE EXECUTION**.

No percentage is credited because no `_02` document has yet crossed its defined approval/repository-verification gate.

## Tasks Closed This Cycle
- T02_02 editable Draw.io source-asset sub-stage — CLOSED / NON-PERCENTAGE.
- T03_02 full editable-source expansion sub-stage — CLOSED / NON-PERCENTAGE.
- T05_02 full editable-source expansion sub-stage — CLOSED / NON-PERCENTAGE.

## Tasks In Progress / Blocked
- T02_02 — render/QA/approval sequence IN PROGRESS.
- T03_02 — Draw.io/render/QA sequence IN PROGRESS.
- T04_02 — queued behind T03_02 within Agent 5 lane.
- T05_02 — Draw.io/render/QA sequence IN PROGRESS.
- T06_02 — queued behind T05_02 within Agent 6 lane.
- T01_01/T01_03 identity-control transition remains unfinished and blocks Classroom Release-01.
- T02_02/T02_03 continue to block Classroom Release-02 materialization/freeze until document gates pass.

## Open More Than 3 Cycles / Action Taken
Document Rerun remains beyond the structural-blocker threshold. **Action Taken in This Cycle:** three upstream lanes performed direct generation instead of polling: T02_02 gained all required editable Draw.io sources, T03_02 gained a full progressive source, and T05_02 gained a full progressive source. No percentage was claimed because approval gates remain open, and no Quality Gate/public write occurred.
