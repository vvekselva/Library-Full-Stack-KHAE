# Document Rerun Task Queue

**Stream weight:** 45% — PRIMARY UPSTREAM DEPENDENCY.  
**Task model:** 60 tracks × 3 documents = 180 document tasks.  
**Authoritative active logical workers:** Agents 3, 4, 5 and 6 under the current `ORCHESTRATOR_PLAN.md`.

## Current dependency state
- T01_01: QUALITY_GATE_PASSED; repository materialization/re-fetch/identity transition pending.
- T01_02: APPROVED; repository verification complete.
- T01_03: QUALITY_GATE_PASSED; repository materialization/re-fetch/identity transition pending.
- T02_01-T06_01: APPROVED.
- T02_02-T06_02: rerun candidates are repository-materialized but **not final-approved**; outstanding work is rendered-document visual/accessibility QA, final content/technical spot-check, and approved-artifact identity/hash verification.
- T02_03-T06_03: PENDING behind same-track Progressive Guide approval.
- T07-T60: queued PENDING.

## Repository materialization evidence created this cycle
- T02 audit: `Document-Rerun-QG@a021babacee922fa400c2ba0de037ca65b498d60`; candidate DOCX blob `aa450d585b405f1e8974534392705aafa4e993a2`.
- T03 audit: `Document-Rerun-QG@ff248fae5655c58ca2b11e846be25beb8a335006`; candidate DOCX blob `56bb0a7d61936cd8eb3a4e446f315f7b02441b55`.
- T04 audit: `Document-Rerun-QG@21e73d7ed3b6a541d9fdb44690aa074fae521e9a`; candidate DOCX blob `bc4ea52ff6c2caffb31c283b173609b78bab7a2a`.
- T05 audit: `Document-Rerun-QG@fb478c71d143a9fcf962f119010fd7e11e6a3b5c`; candidate DOCX blob `abb008de95d62079fe7d12172f84a6d33b85ceef`.
- T06 audit: `Document-Rerun-QG@86d073d7de6c511defff95192a116f8556c45fa9`; candidate DOCX blob `fcaddddc428cfaf436b9bc13822ce360a0594646`.

## Current stream accounting
- Previous: **5.3889%**
- Updated: **5.3889%**
- Increase: **+0.0000%**
- Completed stage points: **970 / 18000**
- State: **STRUCTURAL BLOCKER — ACTIVE CORRECTION; MATERIALIZATION CONFIRMED, FINAL QA REMAINS**.

## Current lane actions
- Agent 3: T02 priority; repository candidate identity confirmed; next gate final render/visual/accessibility/identity verification, then T02_03.
- Agent 4: T03 candidate identity confirmed; next final QA/verification gate.
- Agent 5: T04 candidate identity confirmed; next final QA/verification gate.
- Agent 6: T05 and T06 candidate identities confirmed; T01 identity blocker retained for safe recovery.

## Tasks closed this cycle
- T02-T06 repository materialization audit substages — CLOSED, non-percentage. These audits do not equal document approval.

## >3-cycle stalled action
Document Rerun remains beyond the structural-blocker threshold. **Action Taken in This Cycle:** four Document lanes were restored per the authoritative orchestration plan and replaced passive status polling with exact candidate DOCX/blob materialization audits. No final approval or percentage was invented.

## Safety
- No write to the public Classroom repository.
- No write to the read-only Quality Gate repository.
