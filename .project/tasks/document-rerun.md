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

## Progressive generation evidence

Read-only `Document-Rerun-QG` evidence `documents/rerun/PROGRESSIVE_DRAFT_GENERATION_T02_T06.md` confirms the first controlled drafts remain 8, 9, 8, 8 and 9 rendered pages for T02_02-T06_02. The accepted T01_02 benchmark is approximately 45 pages. Required next-pass gaps are textbook-depth simple-English explanation, numbered/commented code with line-by-line explanation, explicit run/observe/fail/correct/regression evidence, editable Draw.io teaching assets, and detailed JaCoCo/PostgreSQL/Testcontainers walkthroughs.

The same read-only branch contains the accepted T01_02 editable source/tooling structure, but no equivalent repository-editable T02_02-T06_02 source trees were found in the recursive branch inspection. Therefore the coordinator cannot truthfully expand the local binary rerun drafts through repository text edits alone. No write was made to `Document-Rerun-QG`.

## Current stream accounting

- Previous: **5.3889%**
- Updated: **5.3889%**
- Increase: **+0.0000%**
- Completed stage points: **970 / 18000**
- Cycles without increase: **3**
- State: **IN PROGRESS**; not yet over the 4-completed-cycle stale threshold after the prior advance.

## Action Taken in This Cycle

Kept all five independent T02-T06 lanes active at `GENERATING`, inspected the complete read-only rerun tree and generation evidence, confirmed the exact mandatory expansion gaps, and corrected the source diagnosis: T01_02 has editable source/tooling, but T02_02-T06_02 do not yet have equivalent editable rerun source trees. No under-depth draft was promoted, no `_03` work was started prematurely, and no percentage was claimed from inspection alone.
