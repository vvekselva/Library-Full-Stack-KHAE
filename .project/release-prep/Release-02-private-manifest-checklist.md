# Release-02 Private Manifest and Validation Checklist

Status: PREPARED_PRIVATE_ONLY — CONTROLLED-ERROR ACCEPTED — DOCUMENT MATERIALIZATION BLOCKED

Purpose: prepare the Student Baseline release structure without publishing to the public classroom repository and without treating unresolved document prerequisites as complete.

## Frozen release intent

Release: `Classroom-Release-02-Student-Baseline`

Expected source families when all prerequisites are satisfied:

1. Presenter-approved `Frontend-backend-Baseline` source snapshot.
2. Verified generic controlled-error infrastructure required by the assigned student exercises.
3. Only student-facing guides that are `APPROVED` and repository-verified.
4. Classroom README/instructions required to build and use the baseline.
5. No Presenter solution implementation or private orchestration/control files.

## Current accepted baseline identity

- Application/source acceptance identity: `Frontend-backend-Baseline` @ `24179fb905fd69f816bfeb5db0ee7206401a3ceb`.
- Generic service/application exception blob: `6f3475ee7996fe761333810e92490df764c9e958`.
- Global REST exception handler blob: `f2b13a8e782705239a9ad821926b1f5beb1422f4`.
- Controlled response codes `01` through `05`: PASS through the acceptance test at application/source identity `24179fb905fd69f816bfeb5db0ee7206401a3ceb`.
- Verification run `31989985693`: backend job `95271686668` SUCCESS; frontend job `95271686680` SUCCESS.
- Classroom baseline README source: `BASELINE_README.md`.
- Previous README blob `2d0e170f9b6f42126f3d5619da2c56011971b79a` incorrectly stated that centralized exception handling was absent.
- README-only correction commit: `793371388d16fdefb5a7aa539927d738a5b25e41`.
- Corrected README blob: `01812dbf7c35a215cc831f7e5c767cf96ac9c7fd`.
- The README correction documents the already-accepted controlled-error infrastructure; it does not by itself re-credit build verification or any Classroom release percentage gate.

The earlier frozen identity `345d0abe73e0e9ac74d0148c90704611011e74f3` is historical pre-remediation evidence and is no longer the accepted Release-02 controlled-error baseline.

## Hard prerequisites before materialization

- [x] Exact student baseline application/source identity recorded.
- [x] Generic controlled-error infrastructure located by immutable blob identity.
- [x] Controlled-error behavior verified against the student-facing API/error contract.
- [x] Invalid-input response code `01` verified.
- [x] Not-found response code `02` verified.
- [x] Duplicate response code `03` verified.
- [x] Invalid-state response code `04` verified.
- [x] Dependency-exists response code `05` verified.
- [x] Backend verification green against the accepted application/source identity.
- [x] Frontend production build green against the accepted application/source identity.
- [x] Baseline README/instruction source identified and corrected to match accepted error-handling behavior.
- [ ] Every selected student guide is `APPROVED` and repository-verified.
- [ ] Exact selected document identities recorded before any copy/materialization step.
- [ ] Final release-candidate README identity frozen together with the document-complete candidate.

Current prerequisite decision: **BLOCKED BY REQUIRED RERUN DOCUMENTS FOR MATERIALIZATION/FREEZE**. Controlled-error infrastructure and the baseline README consistency defect are no longer blockers.

## Private selection manifest

| Selection class | Required identity | Current decision |
|---|---|---|
| Student baseline application/source | exact branch + commit SHA | `Frontend-backend-Baseline` @ `24179fb905fd69f816bfeb5db0ee7206401a3ceb` — ACCEPTED |
| Controlled-error infrastructure | exact immutable identities | exception blob `6f3475ee...`; handler blob `f2b13a8e...` — ACCEPTED |
| Controlled-error acceptance | exact test/run evidence | application/source `24179fb9...`; run `31989985693` backend/frontend SUCCESS — ACCEPTED |
| Baseline README/instructions | exact path + blob/commit identity | `BASELINE_README.md`; corrected at commit `79337138...`, blob `01812dbf...` — PREPARED |
| Approved student guides | exact repository path + blob/content identity | PENDING by Document approval/repository verification |
| Final release-candidate README | exact candidate identity | PENDING until document-complete candidate exists |
| Presenter solution code | none | EXCLUDED |
| Private `.project/` controls | none | EXCLUDED |

## Validation checklist after document prerequisites resolve

- [ ] Re-fetch each selected document at its approved frozen identity.
- [ ] Confirm no Presenter solution code is present.
- [ ] Confirm no private `.project/` orchestration/control content is present.
- [x] Verify controlled-error infrastructure compiles and is reachable from the accepted student baseline.
- [x] Verify backend build/tests against the accepted controlled-error baseline.
- [x] Verify frontend dependency install and production build against the accepted controlled-error baseline.
- [x] Correct baseline README text so it no longer contradicts the accepted controlled-error implementation.
- [ ] Verify selected document identities byte-for-byte against approved private artifacts.
- [ ] Inspect the private candidate root for unexpected files/directories after candidate materialization becomes eligible.
- [ ] Freeze the final README identity with the private release candidate.
- [ ] Freeze only the private release candidate after all checks pass.
- [ ] Stop automation at the private freeze boundary; public publication remains Presenter-only.

## Promotion rule

Controlled-error acceptance, baseline verification, and README consistency are prerequisite evidence, not release-percentage checkpoints by themselves. Candidate materialization, contents audit, private freeze, release-candidate build verification, and Presenter-ready promotion remain blocked by unresolved rerun-document prerequisites.

No public classroom write and no Quality Gate write was performed by this reconciliation.
