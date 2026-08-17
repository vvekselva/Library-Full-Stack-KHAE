# Release-01 Private Selection Manifest

Status: PREPARED / NOT PUBLISHED / DOCUMENT IDENTITY GATED

## Publication boundary
This manifest is private preparation only. Automation must not write to the public classroom repository. The `Document-Rerun-QG` branch is read-only.

## Selection rules
1. Include only Presenter-approved student baseline source needed by the classroom exercise.
2. Include rerun documents only after the exact document reaches APPROVED and REPOSITORY_VERIFIED.
3. Resolve every included artifact by exact repository path and immutable commit/blob identity before candidate freeze.
4. Exclude private Presenter solution implementations, private registries, orchestration files, and recovery evidence.
5. Preserve the `/rest/` API contract and Presenter-owned shared infrastructure required by the selected student exercises.

## Exact T01 repository identities
Read-only re-fetch from `Document-Rerun-QG` proves the selected T01 set is materialized at:

`Documents/Student-Guides/Department/T01_Create_Department/`

- `T01_01_Initial_API_Contract.docx` — blob `b6bb206b9c3cb1b06175a29f97c764bf3e866d9b` — QUALITY_GATE_PASSED; materialized/re-fetchable; dedicated identity-control reconciliation still required before APPROVED.
- `T01_02_Progressive_Development_Guide.docx` — blob `41c746d55d44ab944ee42a4c0ab73f6c7f381607` — APPROVED and repository-verified; eligible by the document gate.
- `T01_03_Updated_API_Contract.docx` — blob `fb3e68db5526dbcb5a03732feac1da67dda11608` — QUALITY_GATE_PASSED; materialized/re-fetchable; dedicated identity-control reconciliation still required before APPROVED.

Read-only QG branch tip observed during reconciliation: `c951f0e331007820997c590156cd14000b7c07b8`.

## Other document state
- T02_01–T06_01: APPROVED, but outside the selected T01 Release-01 rerun set.
- T02_02–T06_02: GENERATING with editable Private-Master sources; not eligible for release materialization.
- T02_03–T06_03: PENDING behind same-track Progressive Guide approval.

## Candidate state
No Release-01 candidate is frozen. The earlier repository-presence uncertainty is closed, and the exact T01 artifact paths/blobs are now resolved in this private manifest. Materialization/freeze remains blocked because T01_01 and T01_03 have not yet crossed the Document process's identity-control reconciliation into APPROVED/REPOSITORY_VERIFIED state.

No public write or Quality Gate write was performed by this update.
