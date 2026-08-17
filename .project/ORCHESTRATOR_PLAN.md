# KHAE Full Stack — Orchestrator Plan

Updated for the high-parallelism Presenter/Classroom/Recovery execution phase on 2026-08-18.

## Purpose
This file is the coordinator contract for live execution. Every cycle must read this file, `.project/PROJECT_PROGRESS.md`, `.project/execution-cycle-monitor.yml`, and the four stream task files before selecting work.

## Frozen project weights
| Stream | Weight | Execution priority |
|---|---:|---|
| Document Rerun | 45% | UPSTREAM PREREQUISITE / NOT IN CURRENT EIGHT-LANE ALLOCATION |
| Presenter Solutions | 35% | ACTIVE — FOUR LANES |
| Classroom Release Preparation | 10% | ACTIVE — THREE LANES |
| Recovery / Final Integration | 10% | ACTIVE — ONE LANE |

`Overall = Documents*0.45 + Presenter*0.35 + ClassroomRelease*0.10 + Recovery*0.10`

## Primary coordinator + eight logical worker lanes
One primary coordinator remains responsible for dependency checks and consolidation. These are logical worker lanes; no autonomous-agent runtime is assumed.

| Lane | Role | Current allocation | Dependency boundary |
|---|---|---|---|
| Coordinator | Primary coordinator | Read live evidence, assign eligible independent work, reconcile all results | No overall/batch completion before consolidation |
| Agent 1 | Presenter Solutions | Current Presenter gate/evidence execution | Do not start a later gate before the current gate closes |
| Agent 2 | Presenter Solutions | CI/integration evidence and branch-tip verification | Integration/front-end credit requires exact green evidence |
| Agent 3 | Presenter Solutions | Source/contract reconciliation for next eligible work | Reconciliation may run independently; implementation may not skip ordered gates |
| Agent 4 | Classroom Release Preparation | Release-01 prerequisite/evidence and exact document identity audit | No materialization/freeze until selected documents are APPROVED and repository-verified |
| Agent 5 | Classroom Release Preparation | Release-02 baseline acceptance and document prerequisite mapping | Private verification only; no public write and no freeze before prerequisites |
| Agent 6 | Presenter Solutions | Assigned Frontend and cumulative/regression readiness | Frontend begins only after Integration is green |
| Agent 7 | Classroom Release Preparation | Manifest/checklist consistency and private promotion-boundary verification | Prerequisite-safe private work only; publication Presenter-only |
| Agent 8 | Recovery / Final Integration | Registry candidate, immutable evidence capture and freeze guard | Batch freeze only after all tracks and registry-tip CI are complete |

## Current Presenter boundary
- T01-T45: frozen/verified registries.
- **T46-T50 Book Return batch: FROZEN / VERIFIED** at registry commit `cd03adf2280237f35f85cdced7d97f1f1a888f5e`; exact registry-tip run `32056947711` SUCCESS. Corrected pre-freeze source `bca4c6d1a0813a6cbaf5e35c799eebc61ca1d374`, run `32056218735` SUCCESS.
- **T51-T55 Reservation batch: ACTIVE** on branch `Presenter-Solutions-T51-T55`, created from the verified T46-T50 freeze.
- T51-T55 source/contract reconciliation is committed at `a1570156d01f67955396f0639363c5520caafa06`.
- Application code constants for T51-T60/P11/P12 are added at `749ec8b3105444a2dfd30c6f746a5c5d09c4999e`.
- **T51 Create Reservation Service** implementation `42965168682f4b67450763005159685bd2a75090` and focused Unit Test `7c5de1548fc2c77c5f29a71103753732e443f4f6` are implemented; exact run `32058255359` is the Service+Unit branch-tip gate. No Integration may start until that run is fully green.
- T52-T55 implementation remains blocked behind the ordered per-track gates; source inspection is allowed independently.

## Current Classroom boundary
- Release-01 remains blocked by T01_01/T01_03 repository identity/materialization completion.
- Release-02 application/source acceptance remains anchored at `Frontend-backend-Baseline@24179fb905fd69f816bfeb5db0ee7206401a3ceb` with run `31989985693` SUCCESS.
- Release-02 remains document-gated by T02_02 GENERATING and T02_03 PENDING.

## Document work during this phase
T02_02-T06_02 remain unfinished upstream Document Rerun work, but they are not assigned one of the eight active lanes. T01_01/T01_03 identity-control transitions also remain unfinished. Classroom tasks that depend on these documents remain BLOCKED.

## Presenter dependency sequence
For every Presenter track:
1. source/contract reconciliation;
2. Service implementation;
3. focused Unit Test;
4. branch-tip CI proving Service + Unit green;
5. local PostgreSQL Integration;
6. PostgreSQL 18 Testcontainers Integration;
7. branch-tip Integration CI green;
8. assigned Frontend;
9. exact green cumulative CI/registry evidence;
10. batch registry freeze only when the full five-track batch is ready.

No dependent stage may be started or credited prematurely.

## Classroom release rules
1. Private prerequisite-free audits, manifests, checklists and promotion-boundary verification may run in parallel.
2. Any release containing rerun documents is blocked until exact selected documents are APPROVED and repository-verified.
3. ChatGPT/automation must never write to the public classroom repository; public publication is Presenter-only.
4. Quality Gate repository is read-only.

## Recovery rules
Registry evidence may be captured incrementally for verified checkpoints. A five-track batch must not be frozen until every track has immutable component evidence and required cumulative CI. Final integration cannot close while Presenter, Document or Classroom prerequisites remain incomplete.

## Evidence readability rule
Every dashboard/control entry must lead with the human-readable task/component name. Commit SHAs, blob SHAs, workflow IDs and job IDs are evidence placed beside that name; raw identifiers must not substitute for the component description.

## Coordinator selection rules
1. Read all required control/task files plus current branch and Actions evidence.
2. Use Agents 1, 2, 3 and 6 for independent eligible Presenter work.
3. Use Agents 4, 5 and 7 for independent prerequisite-safe Classroom work.
4. Use Agent 8 for Recovery evidence/freeze guarding only.
5. Do not substitute blocked dependent implementation with speculative changes.
6. A task is CLOSED only with the evidence required by its definition of done.
7. CI/log inspection alone is an action, not task completion.
8. If a task remains open for 4+ completed cycles, mark it stalled and record `Action Taken in This Cycle`.
9. Update `.project/PROJECT_PROGRESS.md` and `.project/execution-cycle-monitor.yml` after substantive gates/consolidation.
10. Never write to the public classroom repository or read-only Quality Gate repository.

## Consolidation rule
Do not declare a multi-lane batch or overall task complete until the primary coordinator has reconciled exact commit/blob SHAs, CI conclusions, task-file states, percentages, blockers, stalled-cycle actions and registry freeze eligibility.

## Task files
- `.project/tasks/document-rerun.md`
- `.project/tasks/presenter-solutions.md`
- `.project/tasks/classroom-release.md`
- `.project/tasks/recovery-final-integration.md`

These files remain the execution queues. Conversation memory is not authoritative.
