# Document Rerun Task Queue

**Stream weight:** 45% — PRIMARY.  
**Task model:** 60 tracks × 3 documents = 180 document tasks.  
**Stage model:** PENDING → BLUEPRINTING → BLUEPRINT_APPROVED → GENERATING → CONTENT_QA → VISUAL_QA → QUALITY_GATE_PASSED → REPOSITORY_VERIFIED → APPROVED.

## Mandatory definition of done

Every document must be source-grounded; exact student-owned package/path and Presenter-owned boundaries must be explicit; Initial contracts remain success-only; Progressive Guides follow WHY-before-HOW and progressive testing; Updated contracts contain only final source-proven outcomes; Draw.io sources remain editable; DOCX content/visual/accessibility checks and repository materialization/re-fetch/identity verification are mandatory before approval.

## Active five-lane allocation

| Logical lane | Track | Current valid stage | Next eligible work |
|---|---|---|---|
| Agent 1 | T02 | T02_01 APPROVED; T02_02 BLUEPRINTING | Complete/QA T02_02 blueprint |
| Agent 2 | T03 | T03_01 APPROVED; T03_02 BLUEPRINTING | Complete/QA T03_02 blueprint |
| Agent 3 | T04 | T04_01 APPROVED; T04_02 BLUEPRINTING | Complete/QA T04_02 blueprint |
| Agent 4 | T05 | T05_01 APPROVED; T05_02 BLUEPRINTING | Complete/QA T05_02 blueprint |
| Agent 5 | T06 | T06_01 APPROVED; T06_02 BLUEPRINTING | Complete/QA T06_02 blueprint |

Within each track: `_01 Initial → _02 Progressive → _03 Updated`. Cross-track work may proceed independently. The `_01` approval dependency has now been satisfied for T02-T06; `_03` remains blocked behind the corresponding `_02` approval.

## Queue state

- T01_01: QUALITY_GATE_PASSED; reviewer accepted; repository materialization/re-fetch verification pending.
- T01_02: APPROVED; QG-27 and repository verification complete.
- T01_03: QUALITY_GATE_PASSED; reviewer accepted; repository materialization/re-fetch verification pending.
- T02_01, T03_01, T04_01, T05_01, T06_01: **APPROVED** by reviewer confirmation after QG-27 PASS.
- T02_02, T03_02, T04_02, T05_02, T06_02: **BLUEPRINTING — ACTIVE**.
- T02_03/T03_03/T04_03/T05_03/T06_03: PENDING behind same-track Progressive Guide approval.
- T07-T60: all three documents PENDING and queued; lane refill remains ascending T07, T08, T09, T10, T11, then onward.

## Source reconciliation evidence

The corrected blueprints on `Document-Rerun-QG` were reconciled against the registered Presenter source before document promotion:

- T02: verified `GET /rest/departments/{id}` (`Long id`); Progressive progression includes invocation proof, successful read, unit isolation, invalid ID, not-found, JaCoCo, local PostgreSQL/DBeaver, Testcontainers and assigned frontend integration.
- T03: verified `PUT /rest/departments/{id}`; Progressive progression includes success, validation, not-found, duplicate normalization, unit/integration/Testcontainers coverage and assigned frontend integration.
- T04: verified ID-based soft deactivation with active-member dependency guard; Progressive progression must prove that the row remains and becomes inactive rather than teaching a hard delete.
- T05: verified `GET /rest/departments/search?text=...`; Progressive progression covers successful free-text search, DAO delegation, blank-input fail/correct cycle and testing layers.
- T06: verified Member creation fields `registrationNumber`, `fullName`, `email`, `departmentId`; Progressive progression covers required fields, normalization, duplicate behavior, normalized-key migration, testing layers and frontend integration.

## Generated Initial-contract evidence

All five exact reviewed Initial API Contract binaries remain materialized under `documents/rerun/Txx_01/artifacts/` on `Document-Rerun-QG`.

- Materialization commit: `bccb09bfe301e69ee02c362383cf2a890606528a`.
- QG-27 consolidated verification record: `documents/rerun/QG27_T02_T06_VERIFICATION.md` (record commit `a2d443b05257d45d80191f9384a5e44dceb6e3cd`).
- T02_01 Git blob: `aefe44ad6ea34332986b7de7ec02f2e83aadd1a3`.
- T03_01 Git blob: `50c56180a5eb8bd231c038123b258a7e1f5f54dc`.
- T04_01 Git blob: `6972b494a5f5cf8598a70e11b3623bd47b1e829f`.
- T05_01 Git blob: `3a8d901c2e45c9f9f397952f73e9ec3916c1b8e1`.
- T06_01 Git blob: `77f6dcf932afcd5b1fed3df89c8a7be673a12d4e`.

For each `_01`: applicable Initial-contract content/source/ownership checks PASS; accessibility audit PASS with zero findings; QG-25 PASS after page-by-page rendering/inspection; QG-26 PASS for Initial-contract scope; QG-27 PASS by exact repository re-fetch/blob-identity verification. Reviewer confirmation now supplies the final approval gate.

## Current stream accounting

- Previous: **4.1389%**
- Updated: **4.5556%**
- Increase: **+0.4167%**
- Completed stage points: **820 / 18000**

## Action Taken in This Cycle

Recorded the user's clarification that the five final `_01` Initial API Contracts were already approved. The tracker was corrected from `REPOSITORY_VERIFIED` to `APPROVED`, and all five Progressive Guide lanes T02_02-T06_02 were released and started at `BLUEPRINTING`. No `_03` task was started prematurely.
