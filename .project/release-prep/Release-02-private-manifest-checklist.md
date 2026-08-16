# Release-02 Private Manifest and Validation Checklist

Status: PREPARED_PRIVATE_ONLY — MATERIALIZATION BLOCKED

Purpose: prepare the Student Baseline release structure without publishing to the public classroom repository and without treating unverified dependencies as present.

## Frozen release intent

Release: `Classroom-Release-02-Student-Baseline`

Expected source families when prerequisites are satisfied:

1. Presenter-approved `Frontend-backend-Baseline` source snapshot.
2. Generic controlled-error infrastructure required by the assigned student exercises.
3. Only student-facing guides that are `APPROVED` and repository-verified.
4. Classroom README/instructions required to build and use the baseline.
5. No Presenter solution implementation or private orchestration/control files.

## Hard prerequisites before materialization

- [ ] Exact baseline source branch/commit identified and frozen.
- [ ] Generic controlled-error infrastructure located by exact repository path and immutable commit SHA.
- [ ] Controlled-error behavior verified against the student-facing API/error contract.
- [ ] Every selected student guide is `APPROVED` and repository-verified.
- [ ] Exact source/document identities recorded before any copy/materialization step.

Current prerequisite decision: **BLOCKED**. The current repository evidence does not yet prove the required generic `ControllerAdvice` / `ExceptionHandler` infrastructure, so no source is inferred and no release candidate is materialized.

## Private selection manifest template

| Selection class | Required identity | Current decision |
|---|---|---|
| Student baseline source | exact branch + commit SHA | PENDING |
| Controlled-error infrastructure | exact package/path + commit SHA | PENDING — hard blocker |
| Approved student guides | exact repository path + blob/content identity | PENDING by document approval |
| Classroom README/instructions | exact path + commit SHA | PENDING |
| Presenter solution code | none | EXCLUDED |
| Private `.project/` controls | none | EXCLUDED |

## Validation checklist after prerequisites resolve

- [ ] Re-fetch each selected source at its frozen identity.
- [ ] Confirm no Presenter solution code is present.
- [ ] Confirm no private `.project/` orchestration/control content is present.
- [ ] Verify controlled-error infrastructure compiles and is reachable from the student baseline.
- [ ] Verify backend build/tests against the release candidate.
- [ ] Verify frontend dependency install and production build.
- [ ] Verify selected document identities byte-for-byte against approved private artifacts.
- [ ] Inspect candidate root for unexpected files/directories.
- [ ] Freeze only the private release candidate after all checks pass.
- [ ] Stop automation at the private freeze boundary; public publication remains Presenter-only.

## Promotion rule

Preparation of this manifest/checklist is not a release gate. `source_identified`, `contents_audited`, `private_branch_frozen`, `build_verified`, and `presenter_ready` remain PENDING until their concrete evidence exists.
