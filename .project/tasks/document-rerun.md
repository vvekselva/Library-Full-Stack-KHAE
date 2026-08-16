# Document Rerun Task Queue

**Stream weight:** 45% — PRIMARY.  
**Task model:** 60 tracks × 3 documents = 180 document tasks.  
**Stage model:** PENDING → BLUEPRINTING → BLUEPRINT_APPROVED → GENERATING → CONTENT_QA → VISUAL_QA → QUALITY_GATE_PASSED → REPOSITORY_VERIFIED → APPROVED.

## Mandatory definition of done
Every document must be source-grounded; exact student-owned package/path and Presenter-owned boundaries must be explicit; Initial contracts remain success-only; Progressive Guides follow WHY-before-HOW and progressive testing; Updated contracts contain only final source-proven outcomes; Draw.io sources remain editable; DOCX content/visual/accessibility checks and repository materialization/re-fetch/identity verification are mandatory before approval.

## Active five-lane allocation
| Logical lane | Track | Current valid stage | Next eligible work |
|---|---|---|---|
| Agent 1 | T02 | T02_01 APPROVED; T02_02 GENERATING | Expand `.project/document-rerun/editable/T02_02/guide-source.md`; create Draw.io sources; render/QA |
| Agent 2 | T03 | T03_01 APPROVED; T03_02 GENERATING | Expand `.project/document-rerun/editable/T03_02/guide-source.md`; create Draw.io sources; render/QA |
| Agent 3 | T04 | T04_01 APPROVED; T04_02 GENERATING | Expand `.project/document-rerun/editable/T04_02/guide-source.md`; create Draw.io sources; render/QA |
| Agent 4 | T05 | T05_01 APPROVED; T05_02 GENERATING | Expand `.project/document-rerun/editable/T05_02/guide-source.md`; create Draw.io sources; render/QA |
| Agent 5 | T06 | T06_01 APPROVED; T06_02 GENERATING | Expand `.project/document-rerun/editable/T06_02/guide-source.md`; create Draw.io sources; render/QA |

Within each track: `_01 Initial → _02 Progressive → _03 Updated`. `_03` remains blocked until the corresponding `_02` is APPROVED.

## Queue state
- T01_01: QUALITY_GATE_PASSED; repository materialization/re-fetch verification pending.
- T01_02: APPROVED; QG-27 and repository verification complete.
- T01_03: QUALITY_GATE_PASSED; repository materialization/re-fetch verification pending.
- T02_01–T06_01: APPROVED.
- T02_02–T06_02: **GENERATING — EDITABLE SOURCE MATERIALIZED; EXPANSION IN PROGRESS**.
- T02_03–T06_03: PENDING behind same-track Progressive Guide approval.
- T07–T60: queued PENDING.

## Current cycle evidence
The prior read-only QG drafts remain 8, 9, 8, 8 and 9 pages versus the accepted T01_02 ~45-page benchmark, so no draft was promoted. The former repository blocker—absence of editable T02_02–T06_02 generation source—was actively removed in Private Master by materializing five independent source roots grounded to immutable Presenter registries:
- T02: `.project/document-rerun/editable/T02_02/guide-source.md` — commit `079a0ec3dd1e1d67a79bc48ef77aa42ce04af015`
- T03: `.project/document-rerun/editable/T03_02/guide-source.md` — commit `4e36b130881c1c5fa495173836229a820d638426`
- T04: `.project/document-rerun/editable/T04_02/guide-source.md` — commit `89231a43f2023b1e667cc438f4347af1207e7447`
- T05: `.project/document-rerun/editable/T05_02/guide-source.md` — commit `f39b8a21b7629c8bb7516204b9259d21ae326623`
- T06: `.project/document-rerun/editable/T06_02/guide-source.md` — commit `6d6db31ab0e1967053097f4aa94ca3fb62de8ac4`

Grounding uses Presenter registry `T01-T05.yml` verified source `cdf4f8cb...` for T02–T05 and `T06-T10.yml` verified source `b2e7893f...` for T06. Each source root records exact service/unit/integration/frontend identities, textbook-depth chapter structure, required Draw.io assets, and the QA gates.

## Current stream accounting
- Previous: **5.3889%**
- Updated: **5.3889%**
- Increase: **+0.0000%**
- Completed stage points: **970 / 18000**
- Cycles without increase: **5**
- State: **STALE BY PERCENTAGE / ACTIVE EXPANSION**.

## Tasks Closed This Cycle
- Editable-source recovery/materialization for T02_02, T03_02, T04_02, T05_02 and T06_02 — CLOSED as an unblock prerequisite. This is not a percentage-bearing document gate.

## Tasks In Progress This Cycle
- Five Progressive Guides remain independently active at GENERATING. Expansion, editable Draw.io creation, DOCX render and QA remain open.

## Action Taken in This Cycle
Executed the five-lane fallback rather than re-reporting the source blocker: created all five editable source roots in Private Master with exact registry evidence. No write was made to `Document-Rerun-QG`, no under-depth document was promoted, and no `_03` work was started prematurely.
