# KHAE Full Stack — Orchestrator Plan

Updated for the high-parallelism Presenter/Classroom/Recovery execution phase on 2026-08-17.

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
| Agent 1 | Presenter Solutions | Current Presenter gate/evidence execution | Do not start a later track before the current track gate closes |
| Agent 2 | Presenter Solutions | CI/integration evidence and branch-tip verification | Integration/front-end credit requires exact green evidence |
| Agent 3 | Presenter Solutions | Source/contract reconciliation for the next eligible track | Reconciliation may run independently; implementation may not skip ordered gates |
| Agent 4 | Classroom Release Preparation | Release-01 prerequisite/evidence and exact document identity audit | No materialization/freeze until selected documents are APPROVED and repository-verified |
| Agent 5 | Classroom Release Preparation | Release-02 baseline acceptance and document prerequisite mapping | Private verification only; no public write and no freeze before prerequisites |
| Agent 6 | Presenter Solutions | Assigned Frontend and cumulative/regression readiness | Frontend begins only after Integration is green |
| Agent 7 | Classroom Release Preparation | Manifest/checklist consistency and private promotion-boundary verification | Prerequisite-safe private work only; publication Presenter-only |
| Agent 8 | Recovery / Final Integration | T46-T50 registry candidate, immutable evidence capture and freeze guard | `freeze_allowed=false` until T46-T50 and registry-tip CI are complete |

## Current Presenter boundary
- T01-T45: frozen/verified registries.
- T46-T48: Service, Unit, Integration and Assigned Frontend VERIFIED GREEN; registry checkpoints await batch-final gate.
- **T49 Void Book Return: Service, Unit, Integration and Assigned Frontend VERIFIED GREEN.** Service `7489980269a9507ddc563d1833ac73c38ac201d8`; Unit `df220a49b43702d0228cc4c34d4142f2d6732ae4`, run `32053727532` SUCCESS; local Integration `d2b208aabebac93365129ca4716349a1b13b622e`; PostgreSQL 18 Testcontainers `7c8a0036b219dc91a9ead5f17ebb2ca62ca7ca72`, run `32054104356` SUCCESS; Create Book Return frontend `9fb00ca5bd812afd59b4951caf8f09e106238522`, run `32054478596` SUCCESS.
- **T50 Search Book Return: Service + Unit VERIFIED GREEN.** Service `2cdfae779007a44ce0385142bc005b70bfa8ccc7`; Unit `47ecb5f7017de476b5358559e9f1401987630ba1`; run `32055317199` backend/frontend SUCCESS.
- T50 local PostgreSQL Integration `2b810ec531cc52a556cee45068df4e7006abd701` and PostgreSQL 18 Testcontainers `6482ea1e8fd22b15edf42276fc6f87b0c1d7dbd4` are implemented; exact run `32055710410` is active. T50 Assigned Frontend remains blocked until this Integration run is fully green.
- T46-T50 registry/freeze remains blocked until T50 Assigned Frontend and exact registry-tip CI complete.

## Current Classroom boundary
- Release-01 remains blocked by T01_01/T01_03 repository identity/materialization completion.
- Release-02 application/source acceptance remains anchored at `Frontend-backend-Baseline@24179fb905fd69f816bfeb5db0ee7206401a3ceb` with controlled-error acceptance run `31989985693` SUCCESS.
- Release-02 baseline README consistency remains corrected privately at commit `793371388d16fdefb5a7aa539927d738a5b25e41`, blob `01812dbf7c35a215cc831f7e5c767cf96ac9c7fd`; this is prerequisite cleanup, not release-gate credit.
- Release-02 remains document-gated by T02_02 GENERATING and T02_03 PENDING.

## Document work during this phase
T02_02-T06_02 remain unfinished upstream Document Rerun work, but they are not assigned one of the eight active lanes. T01_01/T01_03 identity-control transitions also remain unfinished. Classroom tasks that depend on these documents remain BLOCKED; this allocation must not bypass Document gates.

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
3. Release-02 controlled-error acceptance remains tied to the accepted application/source identity; README-only corrections do not silently inherit or create new build credit.
4. ChatGPT/automation must never write to the public classroom repository; public publication is Presenter-only.
5. Quality Gate repository is read-only.

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
Do not declare a multi-lane batch or overall task complete until the primary coordinator has reconciled exact commit/blob SHAs, CI conclusions, QG/artifact evidence where applicable, task-file states, percentages, blockers, stalled-cycle actions and registry freeze eligibility.

## Task files
- `.project/tasks/document-rerun.md`
- `.project/tasks/presenter-solutions.md`
- `.project/tasks/classroom-release.md`
- `.project/tasks/recovery-final-integration.md`

These files remain the execution queues. Conversation memory is not authoritative.
