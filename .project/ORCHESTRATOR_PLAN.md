# KHAE Full Stack — Orchestrator Plan

Updated 2026-08-18 for the requested Presenter/Classroom/Recovery allocation after the T51-T55 Reservation freeze.

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
| Agent 1 | Presenter Solutions | T56 Create Fine Service and next eligible Presenter gate | Unit follows Service; Integration requires green Service+Unit CI |
| Agent 2 | Presenter Solutions | T56 Unit/Integration readiness and execution after ordered gates | No dependent gate prematurely |
| Agent 3 | Presenter Solutions | T57-T60 Fine source/test reconciliation and next eligible Presenter work | Source inspection may run independently; implementation stays ordered |
| Agent 4 | Classroom Release Preparation | Release-01 prerequisite/identity audit and private readiness work | No materialization/freeze before document prerequisites |
| Agent 5 | Classroom Release Preparation | Release-02 accepted baseline/document prerequisite mapping | Private work only; no public write |
| Agent 6 | Presenter Solutions | Assigned Frontend/cumulative-regression readiness | Frontend only after Integration green |
| Agent 7 | Classroom Release Preparation | Manifest/checklist consistency and private promotion-boundary validation | No blocked candidate publication |
| Agent 8 | Recovery / Final Integration | T56-T60 registry evidence capture and freeze guard | Freeze only after full batch + registry-tip CI |

## Document rule for this phase
Document Rerun remains a material upstream dependency, but no Agents 1–8 are assigned Document work under this allocation. Report current document state when it affects Presenter/Classroom/Recovery dependencies. Do not imply document progress from status checks alone.

## Current Presenter critical path
- T01-T55 are closed/frozen/verified through the T51-T55 Reservation registry `4ec7937a06244d4e1eaa33dbbb16b968e7ccf73b`, with registry-tip workflow `32112252425` fully SUCCESS.
- **T56-T60 Fine is the active final Presenter batch** on branch `Presenter-Solutions-T56-T60`.
- Source/contract reconciliation is complete at `2bc7575a33185b7f65e5c746275aee24ef534174`.
- T56 Create Fine is the next eligible implementation. `FineRestController` defines T56 Create, T57 Read, T58 Update, T59 Void/Delete and T60 Search under `/rest/fines`; `FineDao` is the persistence authority; current `CreateFineServiceImpl` is a hard-coded teaching stub.

Presenter sequence: source/contract -> Service -> Unit -> exact green CI -> local PostgreSQL Integration -> PostgreSQL 18 Testcontainers -> green Integration CI -> assigned Frontend -> cumulative registry evidence -> batch freeze.

## Classroom rules
Agents 4, 5 and 7 may execute prerequisite-safe private work in parallel. Release-01 remains blocked by T01 identity completion. Release-02 remains blocked by T02_02 final approval/repository verification and T02_03. Never write to the public classroom repository unless promotion is explicitly authorized. Quality Gate repository is read-only.

## Recovery rules
Agent 8 captures newly verified immutable evidence and guards freeze eligibility. T51-T55 is now FROZEN_VERIFIED. `freeze_allowed=false` for T56-T60 until the full Fine batch is complete with registry-tip CI.

## Stale policy
- A status check is an action, not progress.
- 4+ completed cycles without task closure: mark STALE and record Action Taken in This Cycle.
- Repeated unchanged polling must be replaced by a different recovery action when possible.
- Do not credit percentages for preparation, inspection, or incomplete gates.

## Safety and consolidation
Never write to the public classroom repository or read-only Quality Gate repository unless explicitly authorized. A task closes only with its defined evidence. Update the stream task files, `.project/execution-cycle-monitor.yml`, and `.project/PROJECT_PROGRESS.md` after substantive gates/consolidation.
