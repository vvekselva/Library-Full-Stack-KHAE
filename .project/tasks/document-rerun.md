# Document Rerun Task Queue

**Stream weight:** 45% — PRIMARY.  
**Task model:** 60 tracks × 3 documents = 180 document tasks.  
**Stage model:** PENDING → BLUEPRINTING → BLUEPRINT_APPROVED → GENERATING → CONTENT_QA → VISUAL_QA → QUALITY_GATE_PASSED → REPOSITORY_VERIFIED → APPROVED.

## Mandatory definition of done

Every document must be source-grounded; exact student-owned package/path and Presenter-owned boundaries must be explicit; Initial contracts remain success-only; Progressive Guides follow WHY-before-HOW and progressive testing; Updated contracts contain only final source-proven outcomes; Draw.io sources remain editable; DOCX content/visual/accessibility checks and repository materialization/re-fetch/identity verification are mandatory before approval.

## Active five-lane allocation

| Logical lane | Track | Current valid stage | Next eligible work |
|---|---|---|---|
| Agent 1 | T02 | T02_01 REPOSITORY_VERIFIED | Final `_01` approval; then T02_02 |
| Agent 2 | T03 | T03_01 REPOSITORY_VERIFIED | Final `_01` approval; then T03_02 |
| Agent 3 | T04 | T04_01 REPOSITORY_VERIFIED | Final `_01` approval; then T04_02 |
| Agent 4 | T05 | T05_01 REPOSITORY_VERIFIED | Final `_01` approval; then T05_02 |
| Agent 5 | T06 | T06_01 REPOSITORY_VERIFIED | Final `_01` approval; then T06_02 |

Within each track: `_01 Initial → _02 Progressive → _03 Updated`. Cross-track work may proceed independently. Do not start a Progressive Guide before that track's Initial API Contract reaches the workflow's final approval state.

## Queue state

- T01_01: QUALITY_GATE_PASSED; reviewer accepted; repository materialization/re-fetch verification pending.
- T01_02: APPROVED; QG-27 and repository verification complete.
- T01_03: QUALITY_GATE_PASSED; reviewer accepted; repository materialization/re-fetch verification pending.
- T02_01, T03_01, T04_01, T05_01, T06_01: **REPOSITORY_VERIFIED; FINAL APPROVAL PENDING**.
- T02_02/T02_03 through T06_02/T06_03: PENDING behind the same-track Initial-contract approval gate.
- T07-T60: all three documents PENDING and queued; lane refill remains ascending T07, T08, T09, T10, T11, then onward.

## Source reconciliation evidence

The corrected blueprints on `Document-Rerun-QG` were reconciled against the registered Presenter source before document promotion, replacing earlier inaccurate draft contracts:

- T02: verified `GET /rest/departments/{id}` (`Long id`).
- T03: verified `PUT /rest/departments/{id}` and ID-based update/duplicate behavior.
- T04: verified ID-based soft deactivation with active-member dependency guard rather than hard deletion.
- T05: verified `GET /rest/departments/search?text=...`.
- T06: verified Member creation fields `registrationNumber`, `fullName`, `email`, `departmentId` and normalization/duplicate behavior.

## Generated Initial-contract evidence

All five exact reviewed Initial API Contract binaries are materialized under `documents/rerun/Txx_01/artifacts/` on `Document-Rerun-QG`.

- Materialization commit: `bccb09bfe301e69ee02c362383cf2a890606528a`.
- QG-27 consolidated verification record: `documents/rerun/QG27_T02_T06_VERIFICATION.md` (record commit `a2d443b05257d45d80191f9384a5e44dceb6e3cd`).
- T02_01 Git blob: `aefe44ad6ea34332986b7de7ec02f2e83aadd1a3`.
- T03_01 Git blob: `50c56180a5eb8bd231c038123b258a7e1f5f54dc`.
- T04_01 Git blob: `6972b494a5f5cf8598a70e11b3623bd47b1e829f`.
- T05_01 Git blob: `3a8d901c2e45c9f9f397952f73e9ec3916c1b8e1`.
- T06_01 Git blob: `77f6dcf932afcd5b1fed3df89c8a7be673a12d4e`.

For each document: applicable Initial-contract content/source/ownership checks PASS; accessibility audit PASS with zero findings; QG-25 PASS after page-by-page rendering/inspection; QG-26 PASS for Initial-contract scope; QG-27 PASS by exact repository re-fetch/blob-identity verification.

## Current stream accounting

- Previous: **2.0556%**
- Updated: **4.1389%**
- Increase: **+2.0833%**
- Completed stage points: **745 / 18000**

## Action Taken in This Cycle

Ran all five manual document lanes through source reconciliation, controlled Initial-contract generation, content/accessibility checks, page-by-page visual QA, Golden/T01 comparison, repository materialization and QG-27 identity verification. The workflow stopped correctly at `REPOSITORY_VERIFIED`: no `_01` was auto-approved and no `_02` Progressive Guide was started prematurely.
