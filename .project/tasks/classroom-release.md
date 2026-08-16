# Classroom Release Preparation Task Queue

**Stream weight:** 10% — SUPPORTING.  
**Logical worker:** Agent 7.  
**Public repository publication:** Presenter-only/manual. ChatGPT/automation must not write to the public classroom repository.

## Dependency rules

1. Release preparation may advance independently when it does not require unapproved documents.
2. A release stage that includes rerun documents must not be promoted before those documents are APPROVED and repository-verified in Private Master.
3. Do not create a public publication commit from ChatGPT/automation.
4. Before Release-02, generic Presenter-owned controlled-error infrastructure required by student exercises must be present in the student baseline.
5. Release validation must use exact source/document identities, not approximate copies.

## Task queue

| Task | Status | Dependency / evidence |
|---|---|---|
| Verify Release-00 baseline | VERIFIED | Existing verification run `31930965288` remains authoritative unless superseded |
| Reconcile Release-00 manifest against current Private Master | DONE | Evidence `951c9abbc238cd4cfcd47c7f0d6668276a38a73b` |
| Prepare Release-01 file-selection manifest | DONE | `5fe51ba6b4c8de57bdc71932673171f1ef25ed23` |
| Prepare Release-01 validation checklist | DONE | `f0a541258ac8dbf44d1cbb93aff262a779dced98` |
| Prepare Release-01 promotion workflow/private branch structure | DONE | `dd71bd33e898cbe61bf78c7b1630adad415aa41c` |
| Materialize approved T01 rerun set into Release-01 candidate | BLOCKED | Requires T01_01/T01_02/T01_03 APPROVED + repository verified |
| Add subsequent approved document sets to Release-01 candidate | BLOCKED | Requires each document set APPROVED |
| Run / freeze Release-01 candidate | BLOCKED | Requires candidate materialization and validation |
| Presenter manual publication of Release-01 | PRESENTER ONLY | Never performed by ChatGPT/automation |
| Verify controlled-error infrastructure placement for Release-02 | **DONE — VERIFIED MISSING** | Frozen `Frontend-backend-Baseline` @ `345d0abe73e0e9ac74d0148c90704611011e74f3`; application package root has no generic exception/advice package and expected handler path is absent. Evidence record `6ba32469ebba0fb53ebf6865902ea0e45ce3912f` |
| Prepare Release-02 manifest/checklist | DONE | Private conditional manifest/checklist, now reconciled with exact baseline/negative infrastructure evidence |
| Materialize / validate / freeze Release-02 | BLOCKED | Requires controlled-error infrastructure to be added to an approved student baseline + approved document prerequisites |
| Presenter manual publication of Release-02 | PRESENTER ONLY | Never performed by ChatGPT/automation |

## Current stream accounting

- Previous: **33.3333%**
- Updated: **33.3333%**
- Increase: **+0.0000%**
- Cycles without increase: **15**
- State: **STALE — prerequisite verification advanced, percentage-bearing release gate still blocked**.

## Tasks Closed This Cycle

- **Verify controlled-error infrastructure placement for Release-02 — CLOSED WITH NEGATIVE RESULT.** The frozen source is now exact: `Frontend-backend-Baseline` at `345d0abe...`. Inspection proves the generic ControllerAdvice/ExceptionHandler infrastructure required by Release-02 is not present at that identity. This converts an unknown dependency into an explicit source blocker; it does not satisfy the prerequisite.

## Tasks In Progress / Blocked

- Release-01 materialization remains blocked by incomplete approved/repository-verified document prerequisites.
- Release-02 materialization remains blocked until the missing generic controlled-error infrastructure is added and verified on an approved student baseline.

## Action Taken in This Cycle

Used the Presenter CI wait window to resolve the Release-02 source ambiguity. Re-fetched the frozen baseline branch identity, inspected its backend application package structure, verified the expected global exception-handler path is absent, and updated the private Release-02 manifest at commit `6ba32469...`. No candidate was materialized, no public repository write occurred, and no percentage was credited for negative verification alone.
