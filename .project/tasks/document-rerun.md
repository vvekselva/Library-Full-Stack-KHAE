# Document Rerun Task Queue

**Stream weight:** 45% — PRIMARY UPSTREAM DEPENDENCY.  
**Task model:** 60 tracks × 3 documents = 180 document tasks.  
**Authoritative active logical workers:** Agents 3, 4, 5 and 6 under the current `ORCHESTRATOR_PLAN.md`.

## Current dependency state
- T01_01: QUALITY_GATE_PASSED; repository materialization/re-fetch/identity transition pending.
- T01_02: APPROVED; repository verification complete.
- T01_03: QUALITY_GATE_PASSED; repository materialization/re-fetch/identity transition pending.
- T02_01-T06_01: APPROVED.
- T02_02-T06_02: rerun candidates are repository-materialized but **not final-approved**; outstanding work remains rendered-document visual/accessibility QA, final content/technical spot-check, and approved-artifact identity/hash verification.
- T02_03-T06_03: PENDING behind same-track Progressive Guide approval.
- T07-T60: queued PENDING.

## Repository candidate identity evidence
- T02_02 was re-fetched from `Document-Rerun-QG` and still resolves to blob `aa450d585b405f1e8974534392705aafa4e993a2`, matching the materialization audit.
- T03_02 was re-fetched and still resolves to blob `56bb0a7d61936cd8eb3a4e446f315f7b02441b55`, matching the materialization audit.
- T04_02 was re-fetched and still resolves to blob `bc4ea52ff6c2caffb31c283b173609b78bab7a2a`, matching the materialization audit.
- T05/T06 materialization evidence remains retained from the prior audit; no final QA approval is claimed in this watchdog cycle.

## Current stream accounting
- Previous: **5.3889%**
- Updated: **5.3889%**
- Increase: **+0.0000%**
- Completed stage points: **970 / 18000**
- State: **STRUCTURAL BLOCKER — ACTIVE CORRECTION; MATERIALIZATION CONFIRMED, FINAL QA REMAINS**.

## Current lane actions
- Agent 3: T02 exact candidate identity revalidated; final visual/accessibility/content/technical QA remains the approval gate.
- Agent 4: T03 exact candidate identity revalidated; final QA remains.
- Agent 5: T04 exact candidate identity revalidated; final QA remains.
- Agent 6: T05/T06 progression and safe T01 identity recovery retained; no Quality Gate write.

## Tasks closed this cycle
- T02-T04 repository re-fetch/identity revalidation substages — CLOSED, non-percentage. These do not equal final document approval.

## >3-cycle stalled action
Document Rerun remains beyond the structural-blocker threshold. **Action Taken in This Cycle:** four Document lanes remained allocated; T02-T04 exact candidate identities were re-fetched and matched the recorded audit blobs, replacing passive polling with concrete repository verification. Final rendered QA remains outstanding, so no percentage was invented.

## Safety
- No write to the public Classroom repository.
- No write to the read-only Quality Gate repository.
