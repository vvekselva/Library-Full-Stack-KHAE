# Document Rerun Task Queue

**Stream weight:** 45% — PRIMARY.  
**Task model:** 60 tracks × 3 documents = 180 document tasks.  
**Stage model:** PENDING → BLUEPRINTING → BLUEPRINT_APPROVED → GENERATING → CONTENT_QA → VISUAL_QA → QUALITY_GATE_PASSED → REPOSITORY_VERIFIED → APPROVED.

## Mandatory definition of done

Every document must be source-grounded; exact student-owned package/path and Presenter-owned boundaries must be explicit; Initial contracts remain success-only; Progressive Guides follow WHY-before-HOW and progressive testing; Updated contracts contain only final source-proven outcomes; Draw.io sources remain editable; DOCX content/visual/accessibility checks and repository materialization/re-fetch/identity verification are mandatory before approval.

## Active five-lane allocation

| Logical lane | Track | Current valid stage | Next eligible work |
|---|---|---|---|
| Agent 1 | T02 | T02_01 APPROVED; T02_02 GENERATING | Expand T02_02 to T01_02 textbook depth |
| Agent 2 | T03 | T03_01 APPROVED; T03_02 GENERATING | Expand T03_02 to T01_02 textbook depth |
| Agent 3 | T04 | T04_01 APPROVED; T04_02 GENERATING | Expand T04_02 to T01_02 textbook depth |
| Agent 4 | T05 | T05_01 APPROVED; T05_02 GENERATING | Expand T05_02 to T01_02 textbook depth |
| Agent 5 | T06 | T06_01 APPROVED; T06_02 GENERATING | Expand T06_02 to T01_02 textbook depth |

Within each track: `_01 Initial → _02 Progressive → _03 Updated`. Cross-track work may proceed independently. The `_01` approval dependency is satisfied for T02-T06; `_03` remains blocked behind the corresponding `_02` approval.

## Queue state

- T01_01: QUALITY_GATE_PASSED; reviewer accepted; repository materialization/re-fetch verification pending.
- T01_02: APPROVED; QG-27 and repository verification complete.
- T01_03: QUALITY_GATE_PASSED; reviewer accepted; repository materialization/re-fetch verification pending.
- T02_01, T03_01, T04_01, T05_01, T06_01: **APPROVED** by reviewer confirmation after QG-27 PASS.
- T02_02, T03_02, T04_02, T05_02, T06_02: **GENERATING — ACTIVE**.
- T02_03/T03_03/T04_03/T05_03/T06_03: PENDING behind same-track Progressive Guide approval.
- T07-T60: all three documents PENDING and queued; lane refill remains ascending T07, T08, T09, T10, T11, then onward.

## Progressive blueprint QA

All five `_02` blueprints were checked against the accepted T01_02 15-stage instructional structure and frozen Presenter behavior. The QA records are committed under `Documents/Rerun-Control/T02` through `T06` on `Document-Rerun-QG`.

All five passed:
- WHY before HOW.
- Successful path before negative conditions.
- Failure/observation before correction.
- Exact frozen endpoint and source behavior.
- Explicit Student/Presenter ownership boundaries.
- Unit testing, JaCoCo, local PostgreSQL/DBeaver, Testcontainers and frontend integration.
- Editable Draw.io requirement.
- QG-25, QG-26 and QG-27 retention.

## First controlled generation pass

Generation evidence is committed at `documents/rerun/PROGRESSIVE_DRAFT_GENERATION_T02_T06.md` on `Document-Rerun-QG` (commit `c027411c58510b390ad71e0afab9b4c431fb9b5e`).

- T02_02: 8-page first draft; SHA-256 `3859b98e5f5d567e74cbc30781f37b1e564f32f574103bf8a3006a33112a7e57`.
- T03_02: 9-page first draft; SHA-256 `d2220881158f75f86ce3a46cd4f6d96d89bd346a5c6c8f88175c8b844f5461e8`.
- T04_02: 8-page first draft; SHA-256 `24216d62147b5edb6d19e5f8b4e4c15607bbf7290a6fbd20c7f880e7f9045f58`.
- T05_02: 8-page first draft; SHA-256 `95787fdc3b8ef972dd227221ca72dca06a19baeef36af71827ec7a68e6b28c2f`.
- T06_02: 9-page first draft; SHA-256 `1bffb5b81089a2bca5c902bbfcc5ed00c2da90253b6ce16e73a6c94920ad253f`.

The drafts were rendered to page images for the generation check. Layout is sufficiently clean to continue authoring, but the accepted T01_02 baseline is 45 pages and these first drafts are only 8–9 pages. Therefore **no document has been promoted to CONTENT_QA**. The next generation pass must add the missing textbook depth, line-by-line explanation, run/observe/fail/correct evidence and editable Draw.io assets before QA begins.

## Current stream accounting

- Previous: **4.8333%**
- Updated: **5.3889%**
- Increase: **+0.5556%**
- Completed stage points: **970 / 18000**

## Action Taken in This Cycle

Corrected the control state using the user's clarification that all five final `_01` contracts were already approved, released all five Progressive Guide lanes, completed independent blueprint QA, generated and rendered first controlled DOCX drafts, and stopped them honestly at `GENERATING` because their current depth is below the approved T01_02 textbook standard. No `_03` task was started prematurely.
