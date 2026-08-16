# Document Rerun Task Queue

**Stream weight:** 45% — PRIMARY.  
**Task model:** 60 tracks × 3 documents = 180 document tasks.  
**Stage model:** PENDING → BLUEPRINTING → BLUEPRINT_APPROVED → GENERATING → CONTENT_QA → VISUAL_QA → QUALITY_GATE_PASSED → REPOSITORY_VERIFIED → APPROVED.

## Mandatory definition of done for every document

- Content is grounded in the current verified track contract/code.
- Exact source folder, Java package and student-owned file path are explicit.
- Presenter-owned boundaries are explicit.
- Initial API Contract contains only the initial/success contract and must not prematurely reveal later error outcomes.
- Progressive Guide follows WHY-before-HOW and progressive Unit/Integration/Testcontainers/frontend discovery.
- Updated API Contract freezes the final verified response catalogue after progressive behavior is established.
- Required diagrams are editable Draw.io and rendered clearly.
- DOCX is rendered and visually inspected page-by-page.
- Accessibility/content/visual checks pass.
- Repository materialization, re-fetch and identity verification pass before REPOSITORY_VERIFIED.
- APPROVED requires the final approval gate defined by the project workflow.

## Active five-lane allocation

| Logical Agent | Current track | Dependency note |
|---|---|---|
| Agent 1 | T02 | Independent of T03-T06 |
| Agent 2 | T03 | Independent of T02/T04-T06 |
| Agent 3 | T04 | Independent of T02-T03/T05-T06 |
| Agent 4 | T05 | Independent of T02-T04/T06 |
| Agent 5 | T06 | Independent of T02-T05 |

Each agent completes its own track in the order `_01 Initial → _02 Progressive → _03 Updated`, with final contract closure dependent on the progressive behavior of that same track. When a lane closes a track, the coordinator assigns the next PENDING track.

## Complete 180-document queue

| Track | Txx_01 Initial API Contract | Txx_02 Progressive Guide | Txx_03 Updated API Contract | Lane / Queue State |
|---|---|---|---|---|
| T01 | USER_ACCEPTED; repository verification/update pending for revised `_01` | QG-27 PASS + repository verified + USER_ACCEPTED; tracker APPROVED update pending | USER_ACCEPTED; repository verification/update pending for revised `_03` | Baseline accepted; close repository/tracker gates before archival |
| T02 | PENDING | PENDING | PENDING | Agent 1 ACTIVE |
| T03 | PENDING | PENDING | PENDING | Agent 2 ACTIVE |
| T04 | PENDING | PENDING | PENDING | Agent 3 ACTIVE |
| T05 | PENDING | PENDING | PENDING | Agent 4 ACTIVE |
| T06 | PENDING | PENDING | PENDING | Agent 5 ACTIVE |
| T07 | PENDING | PENDING | PENDING | QUEUED |
| T08 | PENDING | PENDING | PENDING | QUEUED |
| T09 | PENDING | PENDING | PENDING | QUEUED |
| T10 | PENDING | PENDING | PENDING | QUEUED |
| T11 | PENDING | PENDING | PENDING | QUEUED |
| T12 | PENDING | PENDING | PENDING | QUEUED |
| T13 | PENDING | PENDING | PENDING | QUEUED |
| T14 | PENDING | PENDING | PENDING | QUEUED |
| T15 | PENDING | PENDING | PENDING | QUEUED |
| T16 | PENDING | PENDING | PENDING | QUEUED |
| T17 | PENDING | PENDING | PENDING | QUEUED |
| T18 | PENDING | PENDING | PENDING | QUEUED |
| T19 | PENDING | PENDING | PENDING | QUEUED |
| T20 | PENDING | PENDING | PENDING | QUEUED |
| T21 | PENDING | PENDING | PENDING | QUEUED |
| T22 | PENDING | PENDING | PENDING | QUEUED |
| T23 | PENDING | PENDING | PENDING | QUEUED |
| T24 | PENDING | PENDING | PENDING | QUEUED |
| T25 | PENDING | PENDING | PENDING | QUEUED |
| T26 | PENDING | PENDING | PENDING | QUEUED |
| T27 | PENDING | PENDING | PENDING | QUEUED |
| T28 | PENDING | PENDING | PENDING | QUEUED |
| T29 | PENDING | PENDING | PENDING | QUEUED |
| T30 | PENDING | PENDING | PENDING | QUEUED |
| T31 | PENDING | PENDING | PENDING | QUEUED |
| T32 | PENDING | PENDING | PENDING | QUEUED |
| T33 | PENDING | PENDING | PENDING | QUEUED |
| T34 | PENDING | PENDING | PENDING | QUEUED |
| T35 | PENDING | PENDING | PENDING | QUEUED |
| T36 | PENDING | PENDING | PENDING | QUEUED |
| T37 | PENDING | PENDING | PENDING | QUEUED |
| T38 | PENDING | PENDING | PENDING | QUEUED |
| T39 | PENDING | PENDING | PENDING | QUEUED |
| T40 | PENDING | PENDING | PENDING | QUEUED |
| T41 | PENDING | PENDING | PENDING | QUEUED |
| T42 | PENDING | PENDING | PENDING | QUEUED |
| T43 | PENDING | PENDING | PENDING | QUEUED |
| T44 | PENDING | PENDING | PENDING | QUEUED |
| T45 | PENDING | PENDING | PENDING | QUEUED |
| T46 | PENDING | PENDING | PENDING | QUEUED |
| T47 | PENDING | PENDING | PENDING | QUEUED |
| T48 | PENDING | PENDING | PENDING | QUEUED |
| T49 | PENDING | PENDING | PENDING | QUEUED |
| T50 | PENDING | PENDING | PENDING | QUEUED |
| T51 | PENDING | PENDING | PENDING | QUEUED |
| T52 | PENDING | PENDING | PENDING | QUEUED |
| T53 | PENDING | PENDING | PENDING | QUEUED |
| T54 | PENDING | PENDING | PENDING | QUEUED |
| T55 | PENDING | PENDING | PENDING | QUEUED |
| T56 | PENDING | PENDING | PENDING | QUEUED |
| T57 | PENDING | PENDING | PENDING | QUEUED |
| T58 | PENDING | PENDING | PENDING | QUEUED |
| T59 | PENDING | PENDING | PENDING | QUEUED |
| T60 | PENDING | PENDING | PENDING | QUEUED |

## T01 baseline acceptance actions still required

The reviewer accepted the complete T01 set on 2026-08-16. Before using T01 as a closed accounting baseline:

1. Materialize/re-fetch/hash-verify the accepted revised T01_01 and T01_03 files in Private Master.
2. Update `.project/document-rerun-progress.yml` to the actual achieved stages.
3. Mark T01_02 APPROVED because QG-27 repository verification and user acceptance are both present.
4. Mark T01_01/T01_03 APPROVED only after their repository-verification gate is complete.

## Lane refill rule

After T02-T06, refill lanes in ascending track order: Agent 1→T07, Agent 2→T08, Agent 3→T09, Agent 4→T10, Agent 5→T11, then continue in the same manner. The coordinator may rebalance if one track is blocked, but must record the reassignment here and must not bypass a dependency inside the same track.

## Stalled-task rule

For any document task open for 4+ completed cycles, add/update an `Action Taken in This Cycle` entry in the dashboard. A status/log inspection alone does not count as document progress.