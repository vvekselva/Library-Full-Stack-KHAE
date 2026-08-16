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
| Reconcile Release-00 manifest against current Private Master | **DONE** | Frozen branch tree `418ff61219e3f7d7a009bee7be70705addfe853a` still contains only `README.md`, `backend/`, `frontend/`; verification run `31930965288` remains SUCCESS; evidence `951c9abbc238cd4cfcd47c7f0d6668276a38a73b` |
| Prepare Release-01 file-selection manifest | **DONE** | Private manifest committed at `5fe51ba6b4c8de57bdc71932673171f1ef25ed23` |
| Prepare Release-01 validation checklist | **DONE** | Private checklist committed at `f0a541258ac8dbf44d1cbb93aff262a779dced98` |
| Prepare Release-01 promotion workflow/private branch structure | **DONE** | Private-only promotion plan committed at `dd71bd33e898cbe61bf78c7b1630adad415aa41c` |
| Materialize approved T01 rerun set into Release-01 candidate | BLOCKED | Requires T01_01/T01_02/T01_03 APPROVED + repository verified |
| Add subsequent approved document sets to Release-01 candidate | BLOCKED | Requires each document set APPROVED |
| Run / freeze Release-01 candidate | BLOCKED | Requires candidate materialization and validation |
| Presenter manual publication of Release-01 | PRESENTER ONLY | Never performed by ChatGPT/automation |
| Verify controlled-error infrastructure placement for Release-02 | PENDING | Source-grounded architecture check required; repository code search found no indexed `ControllerAdvice` / `ExceptionHandler`, so this remains open rather than inferred |
| Prepare Release-02 manifest/checklist | PENDING | Can proceed privately |
| Materialize / validate / freeze Release-02 | BLOCKED | Requires controlled-error baseline + approved prerequisites |
| Presenter manual publication of Release-02 | PRESENTER ONLY | Never performed by ChatGPT/automation |

## Current stream accounting

- Previous: **33.3333%**
- Updated: **33.3333%**
- Increase: **+0.0000%**
- Cycles without increase: **13**
- State: **STALE** by percentage, despite completed prerequisite-free preparation.

## Tasks Closed This Cycle

- Reconcile Release-00 manifest against current Private Master — **CLOSED** with frozen release tree `418ff61219e3f7d7a009bee7be70705addfe853a`, successful verification run `31930965288`, and evidence commit `951c9abbc238cd4cfcd47c7f0d6668276a38a73b`.

## Action Taken in This Cycle

Reconciled the Release-00 manifest against the actual frozen private release branch and revalidated its successful verification workflow. The release snapshot still matches the recorded root-content boundary. Also searched for Release-02 controlled-error infrastructure markers (`ControllerAdvice` / `ExceptionHandler`); no indexed evidence was found, so that task remains open rather than being falsely closed. No public repository write was made.
