# KHAE Full Stack — Orchestrator Plan

Updated 2026-08-18 for the coordinator/watchdog Presenter-Classroom-Recovery execution allocation.

## Purpose
One primary coordinator controls eight logical worker lanes. No autonomous-agent runtime is assumed. The connected Private Master repository is the execution source of truth.

## Frozen project weights
| Stream | Weight | Current execution allocation |
|---|---:|---|
| Document Rerun | 45% | UPSTREAM DEPENDENCY — NO CURRENT LANE |
| Presenter Solutions | 35% | ACTIVE — FOUR LANES |
| Classroom Release Preparation | 10% | ACTIVE — THREE LANES |
| Recovery / Final Integration | 10% | ACTIVE — ONE LANE |

`Overall = Documents*0.45 + Presenter*0.35 + ClassroomRelease*0.10 + Recovery*0.10`

## Primary coordinator + eight logical worker lanes
| Lane | Role | Immediate responsibility | Dependency boundary |
|---|---|---|---|
| Coordinator | Primary coordinator | Read live evidence, enforce gates, assign independent work, consolidate results | No batch completion before consolidation |
| Agent 1 | Presenter Solutions | T59 PostgreSQL 18 Testcontainers / combined Integration | No Frontend before combined Integration green |
| Agent 2 | Presenter Solutions | T59 Assigned Frontend after combined Integration, then T60 ordered execution | T60 must not overtake T59 |
| Agent 3 | Presenter Solutions | T60 source/test reconciliation and next eligible implementation preparation | Preparation only until T59 ordered gate opens |
| Agent 4 | Classroom Release Preparation | Release-01 prerequisite/identity audit and private readiness | No materialization before document prerequisites |
| Agent 5 | Classroom Release Preparation | Release-02 accepted baseline/document prerequisite mapping | Private work only; no public write |
| Agent 6 | Presenter Solutions | Frontend/cumulative-regression readiness for final Fine batch | No dependent execution prematurely |
| Agent 7 | Classroom Release Preparation | Manifest/checklist consistency and private promotion-boundary validation | No blocked publication |
| Agent 8 | Recovery / Final Integration | T56-T60 registry evidence, cumulative regression and freeze guard | Freeze only after full batch + registry-tip CI |

## Document rule for this phase
Document Rerun remains a material upstream dependency, but Agents 1-8 are not assigned Document work under this allocation. Report current Document state when it materially gates Classroom or final integration. Status inspection alone is not Document progress.

## Current Presenter critical path
T01-T55 are frozen/verified. T56-T60 Fine is the active final Presenter batch on `Presenter-Solutions-T56-T60`. T56-T58 are complete through Assigned Frontend. T59 Service/Unit and local PostgreSQL Integration are verified green. Current ordered path is T59 PostgreSQL 18 Testcontainers -> combined Integration -> T59 Assigned Frontend -> T60 -> final T56-T60 registry.

Presenter sequence: source/contract -> Service -> Unit -> exact green CI -> local PostgreSQL Integration -> PostgreSQL 18 Testcontainers -> green combined Integration -> assigned Frontend -> cumulative registry evidence -> batch freeze.

## Classroom rules
Agents 4, 5 and 7 may execute prerequisite-safe private readiness work in parallel. Release-01 remains blocked by T01 identity completion. Release-02 remains blocked by T02_02 final approval/repository verification and T02_03. Never write to the public classroom repository unless promotion is explicitly authorized. Quality Gate repository is read-only.

## Recovery rules
Agent 8 captures newly verified immutable Presenter evidence, prepares cumulative regression/final integration, and guards freeze eligibility. `freeze_allowed=false` for T56-T60 until the full Fine batch is complete with registry-tip CI.

## Stale policy
- A status check is an action, not progress.
- 4+ completed cycles without task closure: mark STALE and record Action Taken in This Cycle.
- Repeated unchanged polling must be replaced by a different recovery action when possible.
- Do not credit percentages for preparation, inspection, or incomplete gates.

## Safety and consolidation
Never write to the public classroom repository or read-only Quality Gate repository unless explicitly authorized. A task closes only with its defined evidence. Update stream task files, `.project/execution-cycle-monitor.yml`, and `.project/PROJECT_PROGRESS.md` after substantive gates/consolidation.
