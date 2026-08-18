# Release-01 Private Selection Manifest

Status: PREPARED / NOT PUBLISHED / FINAL DOCUMENT APPROVAL GATED

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

- `T01_01_Initial_API_Contract.docx` — blob `b6bb206b9c3cb1b06175a29f97c764bf3e866d9b` — **REPOSITORY_VERIFIED**; Private-Master identity control recorded at commit `b336bb45a79596cdb0cb015783557d08eeb8fceb`; final APPROVED transition remains outstanding.
- `T01_02_Progressive_Development_Guide.docx` — blob `41c746d55d44ab944ee42a4c0ab73f6c7f381607` — **APPROVED / repository-verified**; eligible by the document gate.
- `T01_03_Updated_API_Contract.docx` — blob `fb3e68db5526dbcb5a03732feac1da67dda11608` — **REPOSITORY_VERIFIED**; Private-Master identity control recorded at commit `43cb7f557d7e808d814b3145e4c699a9d47da0f0`; final APPROVED transition remains outstanding.

The earlier repository-presence/identity uncertainty for T01_01 and T01_03 is closed. No Quality Gate mutation was required.

## Other document state
- T02_01-T06_01: APPROVED, but outside the selected T01 Release-01 rerun set.
- T02_02-T06_02: repository-materialized rerun candidates but not final-approved; not eligible for classroom materialization.
- T02_03-T06_03: PENDING behind same-track Progressive Guide approval.

## Candidate state
No Release-01 candidate is frozen. Exact T01 artifact paths and immutable blob identities are resolved. The identity-control prerequisite is complete for T01_01 and T01_03, but candidate materialization/freeze remains blocked until both documents receive the Document process's final **APPROVED** transition.

## Agent 4 action — 2026-08-18 23:00 IST cycle
Agent 4 reconciled this private manifest to the new T01 repository-verification evidence so the release gate is no longer described as an identity/materialization uncertainty. This is prerequisite-readiness work only and earns no Classroom percentage credit.

No public write or Quality Gate write was performed by this update.
