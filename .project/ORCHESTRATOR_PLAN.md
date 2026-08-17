# KHAE Full Stack — Orchestrator Plan

Updated for the high-parallelism Presenter/Classroom/Recovery execution phase on 2026-08-17.

## Purpose
This file is the coordinator contract for the live dashboard and scheduled execution cycles. Every cycle must read this file, `.project/PROJECT_PROGRESS.md`, `.project/execution-cycle-monitor.yml`, and the four stream task files before selecting work.

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
| Agent 1 | Presenter Solutions | Current Book Issue Service/contract execution; next T44 Service | Service work may start only from reconciled source/DAO/controller contract |
| Agent 2 | Presenter Solutions | Focused Unit/Integration/Testcontainers evidence for current eligible track | Unit follows Service; Integration follows green Service/Unit branch-tip CI |
| Agent 3 | Presenter Solutions | Source/contract and authoritative assigned-Frontend reconciliation for upcoming Book Issue tracks | Reconciliation may run independently; implementation cannot skip gates |
| Agent 4 | Classroom Release Preparation | Release-01 prerequisite/evidence and exact document identity audit | No materialization/freeze until selected documents are APPROVED and repository-verified |
| Agent 5 | Classroom Release Preparation | Release-02 baseline acceptance and document prerequisite mapping | Private verification only; no public write and no freeze before prerequisites |
| Agent 6 | Presenter Solutions | Assigned Frontend implementation and cumulative/regression CI readiness | Frontend implementation only after current track Integration CI is green |
| Agent 7 | Classroom Release Preparation | Manifest/checklist consistency and private promotion-boundary verification | Prerequisite-free private verification only; publication Presenter-only |
| Agent 8 | Recovery / Final Integration | T41-T45 registry candidate, immutable evidence capture and freeze guard | `freeze_allowed=false` until T41-T45 all complete plus cumulative/registry-tip CI |

## Current Presenter boundary
- T41 Create Book Issue: four component checkpoints VERIFIED GREEN.
- T42 Read Book Issue: four component checkpoints VERIFIED GREEN.
- T43 Update Book Issue: four component checkpoints VERIFIED GREEN.
- T44 Cancel Book Issue: next eligible Service stage.
- T45 Search Book Issue: source-reconciled, pending ordered execution.
- T41-T45 registry/freeze remains blocked by T44-T45 plus cumulative/registry-tip CI.

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
9. cumulative CI/registry evidence;
10. batch registry freeze only when the full five-track batch is ready.

No dependent stage may be started or credited prematurely.

## Classroom release rules
1. Private prerequisite-free audits, manifests, checklists and promotion-boundary verification may run in parallel.
2. Any release containing rerun documents is blocked until exact selected documents are APPROVED and repository-verified.
3. Release-02 controlled-error acceptance must remain tied to the approved baseline evidence.
4. ChatGPT/automation must never write to the public classroom repository; public publication is Presenter-only.
5. Quality Gate repository is read-only.

## Recovery rules
Registry evidence may be captured incrementally for verified checkpoints. A five-track batch must not be frozen until every track has immutable component evidence and required cumulative CI. Final integration cannot close while Presenter, Document or Classroom prerequisites remain incomplete.

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
