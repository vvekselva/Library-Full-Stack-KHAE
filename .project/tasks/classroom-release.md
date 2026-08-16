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

| Task | Status | Dependency / definition of done |
|---|---|---|
| Verify Release-00 baseline | VERIFIED | Existing verification run `31930965288` remains authoritative unless superseded |
| Reconcile Release-00 manifest against current Private Master | PENDING | Safe prerequisite-free verification task |
| Prepare Release-01 file-selection manifest | PENDING | May prepare paths/selection rules now; document identities remain placeholders until APPROVED |
| Prepare Release-01 validation checklist | PENDING | Prerequisite-free |
| Prepare Release-01 promotion workflow/private branch structure | PENDING | May be prepared privately; do not publish |
| Materialize approved T01 rerun set into Release-01 candidate | BLOCKED | Requires T01_01/T01_02/T01_03 APPROVED + repository verified |
| Add subsequent approved document sets to Release-01 candidate | BLOCKED | Requires each document set APPROVED |
| Run Release-01 candidate validation | BLOCKED | Requires candidate materialization |
| Freeze Release-01 private candidate | BLOCKED | Requires successful validation |
| Presenter manual publication of Release-01 | PRESENTER ONLY | Never performed by ChatGPT/automation |
| Verify controlled-error infrastructure placement for Release-02 | PENDING | Must reconcile shared ApplicationServiceException/handler baseline requirement |
| Move/ensure Presenter-owned generic controlled-error infrastructure in student baseline | BLOCKED / ARCHITECTURE GATE | Perform only after exact baseline/source verification; avoid duplicate framework copies |
| Prepare Release-02 file-selection manifest | PENDING | Can be drafted independently |
| Prepare Release-02 validation checklist | PENDING | Can be drafted independently |
| Materialize Release-02 private candidate | BLOCKED | Requires controlled-error baseline gate + approved document/source prerequisites |
| Run Release-02 candidate validation | BLOCKED | Requires materialized candidate |
| Freeze Release-02 private candidate | BLOCKED | Requires validation success |
| Presenter manual publication of Release-02 | PRESENTER ONLY | Never performed by ChatGPT/automation |

## Immediate Agent 7 queue

1. Reconcile Release-00 manifest/state with current Private Master.
2. Prepare Release-01 selection manifest and validation checklist without promoting unapproved artifacts.
3. Record exact dependency on the accepted T01 set and later approved document sets.
4. Inspect the Release-02 controlled-error infrastructure prerequisite and produce a source-grounded change plan; do not modify the student baseline prematurely.
5. When a Document set becomes APPROVED, consume its exact repository identity and advance the candidate immediately.

## Stalled-stream requirement

If Classroom Release has no percentage increase for 4+ cycles, `Action Taken in This Cycle` must show a concrete prerequisite-free preparation/verification action. Waiting for Documentation alone is not an acceptable no-action cycle.