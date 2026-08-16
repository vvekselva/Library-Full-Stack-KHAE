# Document Rerun Task Queue

**Stream weight:** 45% — PRIMARY.  
**Task model:** 60 tracks × 3 documents = 180 document tasks.  
**Stage model:** PENDING → BLUEPRINTING → BLUEPRINT_APPROVED → GENERATING → CONTENT_QA → VISUAL_QA → QUALITY_GATE_PASSED → REPOSITORY_VERIFIED → APPROVED.

## Mandatory definition of done

Every document must be source-grounded; exact student-owned package/path and Presenter-owned boundaries must be explicit; Initial contracts remain success-only; Progressive Guides follow WHY-before-HOW and progressive testing; Updated contracts contain only final source-proven outcomes; Draw.io sources remain editable; DOCX content/visual/accessibility checks and repository materialization/re-fetch/identity verification are mandatory before approval.

## Active five-lane allocation

| Logical lane | Track | Current valid stage | Next eligible work |
|---|---|---|---|
| Agent 1 | T02 | T02_01 BLUEPRINT_APPROVED | Generate T02_01 only |
| Agent 2 | T03 | T03_01 BLUEPRINT_APPROVED | Generate T03_01 only |
| Agent 3 | T04 | T04_01 BLUEPRINT_APPROVED | Generate T04_01 only |
| Agent 4 | T05 | T05_01 BLUEPRINT_APPROVED | Generate T05_01 only |
| Agent 5 | T06 | T06_01 BLUEPRINT_APPROVED | Generate T06_01 only |

Within each track: `_01 Initial → _02 Progressive → _03 Updated`. Cross-track work may proceed independently. Do not start a Progressive Guide before that track's Initial API Contract completes its required gates.

## Queue state

- T01_01: QUALITY_GATE_PASSED; reviewer accepted; repository materialization/re-fetch verification pending.
- T01_02: APPROVED; QG-27 and repository verification complete.
- T01_03: QUALITY_GATE_PASSED; reviewer accepted; repository materialization/re-fetch verification pending.
- T02_01, T03_01, T04_01, T05_01, T06_01: **BLUEPRINT_APPROVED**.
- T02_02/T02_03 through T06_02/T06_03: PENDING behind same-track Initial-contract gates.
- T07-T60: all three documents PENDING and queued; lane refill remains ascending T07, T08, T09, T10, T11, then onward.

## Source reconciliation evidence

The corrected blueprints on `Document-Rerun-QG` were reconciled against Presenter source, replacing earlier inaccurate draft contracts:

- T02: verified `GET /rest/departments/{id}` (`Long id`).
- T03: verified `PUT /rest/departments/{id}` and ID-based update behavior.
- T04: verified ID-based soft deactivation with active-member dependency guard rather than hard deletion.
- T05: verified `GET /rest/departments/search?text=...`.
- T06: verified current Member creation contract from the T06-T10 Presenter source.

Branch evidence: `Document-Rerun-QG` head `7b16dda6d8e89bed66703fded66ee19d2ded111a`. Machine progress file records T02_01–T06_01 as BLUEPRINT_APPROVED.

## Current stream accounting

- Previous: **1.5000%**
- Updated: **2.0556%**
- Increase: **+0.5556%**
- Completed stage points: **370 / 18000**

## Action Taken in This Cycle

Consolidated the five source-reconciled Initial-contract blueprints as accepted BLUEPRINT_APPROVED work, verified their current branch artifacts and exact Presenter API boundaries, and advanced each lane's next eligible action to Initial API Contract generation. No Progressive/Updated document was started prematurely.
