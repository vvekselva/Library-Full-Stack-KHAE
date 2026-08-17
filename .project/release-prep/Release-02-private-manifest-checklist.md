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

- Branch: `Frontend-backend-Baseline`
- Current accepted head: `24179fb905fd69f816bfeb5db0ee7206401a3ceb`
- Generic service/application exception blob: `6f3475ee7996fe761333810e92490df764c9e958`
- Global REST exception handler blob: `f2b13a8e782705239a9ad821926b1f5beb1422f4`
- Controlled response codes `01` through `05`: PASS through the acceptance test at head `24179fb905fd69f816bfeb5db0ee7206401a3ceb`
- Verification run `31989985693`: backend job `95271686668` SUCCESS; frontend job `95271686680` SUCCESS.

The earlier frozen identity `345d0abe73e0e9ac74d0148c90704611011e74f3` is historical pre-remediation evidence and is no longer the accepted Release-02 controlled-error baseline.

## Hard prerequisites before materialization

- [x] Exact student baseline source branch/commit identified and frozen at the accepted remediation identity.
- [x] Generic controlled-error infrastructure located by immutable blob identity.
- [x] Controlled-error behavior verified against the student-facing API/error contract.
- [x] Invalid-input response code `01` verified.
- [x] Not-found response code `02` verified.
- [x] Duplicate response code `03` verified.
- [x] Invalid-state response code `04` verified.
- [x] Dependency-exists response code `05` verified.
- [x] Backend verification green against the accepted baseline identity.
- [x] Frontend production build green against the accepted baseline identity.
- [ ] Every selected student guide is `APPROVED` and repository-verified.
- [ ] Exact selected document identities recorded before any copy/materialization step.
- [ ] Classroom README/instruction identity frozen for the release candidate.

Current prerequisite decision: **BLOCKED BY REQUIRED RERUN DOCUMENTS ONLY FOR MATERIALIZATION/FREEZE**. Controlled-error infrastructure is no longer a blocker.

## Private selection manifest

| Selection class | Required identity | Current decision |
|---|---|---|
| Student baseline source | exact branch + commit SHA | `Frontend-backend-Baseline` @ `24179fb905fd69f816bfeb5db0ee7206401a3ceb` — ACCEPTED |
| Controlled-error infrastructure | exact immutable identities | exception blob `6f3475ee...`; handler blob `f2b13a8e...` — ACCEPTED |
| Controlled-error acceptance | exact test/run evidence | `24179fb9...`; run `31989985693` backend/frontend SUCCESS — ACCEPTED |
| Approved student guides | exact repository path + blob/content identity | PENDING by Document approval/repository verification |
| Classroom README/instructions | exact path + commit SHA | PENDING |
| Presenter solution code | none | EXCLUDED |
| Private `.project/` controls | none | EXCLUDED |

## Validation checklist after document prerequisites resolve

- [ ] Re-fetch each selected document at its approved frozen identity.
- [ ] Confirm no Presenter solution code is present.
- [ ] Confirm no private `.project/` orchestration/control content is present.
- [x] Verify controlled-error infrastructure compiles and is reachable from the accepted student baseline.
- [x] Verify backend build/tests against the accepted controlled-error baseline.
- [x] Verify frontend dependency install and production build against the accepted controlled-error baseline.
- [ ] Verify selected document identities byte-for-byte against approved private artifacts.
- [ ] Inspect the private candidate root for unexpected files/directories after candidate materialization becomes eligible.
- [ ] Freeze only the private release candidate after all checks pass.
- [ ] Stop automation at the private freeze boundary; public publication remains Presenter-only.

## Promotion rule

Controlled-error acceptance and baseline verification are prerequisite gates, not release-percentage checkpoints by themselves. `source_identified` and controlled-error acceptance are complete, while candidate materialization, contents audit, private freeze, release-candidate build verification, and Presenter-ready promotion remain blocked by unresolved rerun-document prerequisites.

No public classroom write and no Quality Gate write was performed by this reconciliation.
