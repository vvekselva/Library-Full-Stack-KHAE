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

- [x] Exact baseline source branch/commit identified and frozen: `Frontend-backend-Baseline` at `345d0abe73e0e9ac74d0148c90704611011e74f3`.
- [x] Controlled-error infrastructure placement inspected at the frozen baseline identity. The application package root exposes `contract`, `controller`, `dao`, `dataobject`, `dto`, `mapper`, and `service`, but no generic exception/advice package; direct lookup of the expected `exception/GlobalExceptionHandler.java` path returns Not Found.
- [ ] Generic controlled-error infrastructure located by exact repository path and immutable commit SHA — **BLOCKED because it is absent from the frozen baseline evidence**.
- [ ] Controlled-error behavior verified against the student-facing API/error contract — blocked until the infrastructure exists at an approved baseline identity.
- [ ] Every selected student guide is `APPROVED` and repository-verified.
- [ ] Exact selected document identities recorded before any copy/materialization step.

Current prerequisite decision: **BLOCKED — VERIFIED MISSING INFRASTRUCTURE**. This cycle converted the earlier unknown into exact negative evidence; no source is inferred and no release candidate is materialized.

## Private selection manifest

| Selection class | Required identity | Current decision |
|---|---|---|
| Student baseline source | exact branch + commit SHA | `Frontend-backend-Baseline` @ `345d0abe73e0e9ac74d0148c90704611011e74f3` |
| Controlled-error infrastructure | exact package/path + commit SHA | VERIFIED MISSING at frozen baseline; hard blocker |
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

Preparation and negative prerequisite verification are not release percentage gates. `source_identified` may now use the frozen baseline identity internally, but `contents_audited`, `private_branch_frozen`, `build_verified`, and `presenter_ready` remain PENDING until concrete release-candidate evidence exists.
