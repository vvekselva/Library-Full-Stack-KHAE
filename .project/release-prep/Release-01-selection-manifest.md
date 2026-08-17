# Release-01 Private Selection Manifest

Status: PREPARED / NOT PUBLISHED

## Publication boundary
This manifest is private preparation only. Automation must not write to the public classroom repository.

## Selection rules
1. Include only Presenter-approved student baseline source needed by the classroom exercise.
2. Include rerun documents only after the exact document reaches APPROVED and REPOSITORY_VERIFIED.
3. Resolve every included artifact by exact repository path and immutable commit/blob identity before candidate freeze.
4. Exclude private Presenter solution implementations, private registries, orchestration files, and recovery evidence.
5. Preserve the `/rest/` API contract and Presenter-owned shared infrastructure required by the selected student exercises.

## Current document eligibility
- T01_02: APPROVED and repository verified; eligible by document gate.
- T01_01: QUALITY_GATE_PASSED; repository materialization/re-fetch verification pending, so not yet eligible for candidate materialization.
- T01_03: QUALITY_GATE_PASSED; repository materialization/re-fetch verification pending, so not yet eligible for candidate materialization.
- T02_01–T06_01: APPROVED, but outside the selected T01 Release-01 rerun set.
- T02_02–T06_02: GENERATING with editable Private-Master sources; not eligible for release materialization.
- T02_03–T06_03: PENDING behind same-track Progressive Guide approval.

## Candidate state
No Release-01 candidate is frozen. Exact candidate artifact identities remain placeholders until every selected T01 document gate closes and immutable identities are resolved.
