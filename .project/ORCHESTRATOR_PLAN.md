# KHAE Full Stack — Orchestrator Plan

Updated 2026-08-18 for anti-stale critical-path execution.

## Purpose
One primary coordinator controls eight logical worker lanes. No autonomous-agent runtime is assumed. Allocation follows the active bottlenecks and dependency gates.

## Frozen project weights
| Stream | Weight | Current execution allocation |
|---|---:|---|
| Document Rerun | 45% | ACTIVE — THREE LANES |
| Presenter Solutions | 35% | ACTIVE — THREE LANES |
| Classroom Release Preparation | 10% | ACTIVE — ONE LANE |
| Recovery / Final Integration | 10% | ACTIVE — ONE LANE |

`Overall = Documents*0.45 + Presenter*0.35 + ClassroomRelease*0.10 + Recovery*0.10`

## Primary coordinator + eight logical worker lanes
| Lane | Role | Immediate responsibility | Dependency boundary |
|---|---|---|---|
| Coordinator | Primary coordinator | Read live evidence, enforce gates, reassign capacity, consolidate results | No batch completion before consolidation |
| Agent 1 | Presenter Solutions | T54 Service/Unit exact CI evidence; then next eligible Presenter gate | Integration cannot start until Service+Unit CI green |
| Agent 2 | Presenter Solutions | T54 Integration/Testcontainers after gate; then T55 ordered execution | No dependent gate prematurely |
| Agent 3 | Presenter Solutions | T55 source/test preparation and next eligible Presenter work | T55 implementation waits for ordered T54 completion |
| Agent 4 | Document Rerun | T02_02 Progressive Guide expansion -> render -> QA | No _03 before _02 gates pass |
| Agent 5 | Document Rerun | T03_02 then T04_02, independently and sequentially per document | Do not edit same document concurrently |
| Agent 6 | Document Rerun | T05_02 then T06_02 plus identity/QG preparation | No QG write; respect document stage ordering |
| Agent 7 | Classroom Release Preparation | Exhaust prerequisite-safe private release work; consume approved documents immediately | If no eligible work, WAITING_ON_DOCUMENT; no repeated unchanged polling |
| Agent 8 | Recovery / Final Integration | Capture newly green evidence and prepare/freeze eligible registry batches | If no new evidence, WAITING_ON_PRESENTER; no premature freeze |

## Anti-stale policy
- 0–3 no-progress cycles: normal execution.
- 4–6: `STALE`; mandatory alternative action.
- 7–10: `BLOCKED`; stop identical polling and execute a different recovery path.
- >10: `STRUCTURAL_BLOCKER`; coordinator must reallocate capacity or explicitly identify the dependency/allocation change required.
- Status checks alone never count as substantive progress.
- Downstream lanes must not repeatedly poll an unchanged upstream blocker.

## Current critical paths
### Presenter
T51–T55 Reservation batch is active on `Presenter-Solutions-T51-T55`. T51–T53 are closed through Assigned Frontend. T54 Service `3f8ebd45cf15c48418a9552fa09811612ddc7100` and Unit `1e37f0f25ba9765eb23caca8af23eb1ad5c942ca` are implemented but require exact green CI before Integration. T55 Search Reservation source/contract reconciliation is complete but implementation remains ordered behind T54.

Presenter sequence remains: source/contract -> Service -> Unit -> exact green CI -> local PostgreSQL Integration -> PostgreSQL 18 Testcontainers -> green Integration CI -> assigned Frontend -> cumulative registry evidence -> batch freeze.

### Documents
T02_02–T06_02 are the immediate upstream bottleneck and now receive Agents 4–6. Work per document is: expand editable source -> render -> Content QA -> Technical QA -> Diagram QA -> repository verification -> next document stage. T01_01/T01_03 identity-control reconciliation remains an explicit prerequisite where relevant.

### Classroom
Agent 7 performs only private prerequisite-safe work. When independent preparation is exhausted, state becomes `WAITING_ON_DOCUMENT`, not another stale polling action. Public publication remains Presenter-only. Quality Gate repository remains read-only.

### Recovery
Agent 8 reacts to newly verified Presenter/Document/Classroom evidence. When there is no new freezeable evidence, state becomes `WAITING_ON_PRESENTER` or the exact upstream dependency rather than repeated registry polling.

## Reallocation rule
At each meaningful gate the coordinator may move lanes toward the bottleneck. Current phase is 3 Presenter / 3 Document / 1 Classroom / 1 Recovery. When Documents unblock release materialization, target 3 Presenter / 1 Document / 3 Classroom / 1 Recovery. Near final integration, target approximately 2 Presenter / 2 Classroom / 4 Recovery/Integration.

## Safety and consolidation
Never write to the public classroom repository or read-only Quality Gate repository unless explicitly authorized. A task closes only with its defined evidence. Update stream task files, `.project/execution-cycle-monitor.yml`, and `.project/PROJECT_PROGRESS.md` after substantive gates/consolidation.
