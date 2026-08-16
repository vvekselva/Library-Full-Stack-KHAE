# KHAE Full Stack — Orchestrator Plan

Updated for the high-parallelism Presenter/Classroom/Recovery execution phase on 2026-08-17.

## Purpose

This file is the coordinator contract for the live dashboard and the scheduled KHAE Progress Watchdog. The watchdog must read this file, `.project/PROJECT_PROGRESS.md`, `.project/execution-cycle-monitor.yml`, and the four stream task files before selecting work.

## Frozen project weights

| Stream | Weight | Execution priority |
|---|---:|---|
| Document Rerun | 45% | UPSTREAM PREREQUISITE / NOT IN CURRENT EIGHT-LANE ALLOCATION |
| Presenter Solutions | 35% | ACTIVE — FOUR LANES |
| Classroom Release Preparation | 10% | ACTIVE — THREE LANES |
| Recovery / Final Integration | 10% | ACTIVE — ONE LANE |

Overall = Documents*0.45 + Presenter*0.35 + ClassroomRelease*0.10 + Recovery*0.10.

## Primary coordinator + eight logical worker lanes

One primary coordinator remains responsible for dependency checks and consolidation. This repository records eight logical worker lanes. ChatGPT must not claim that eight separate autonomous background processes exist unless an actual agent runtime is available; independent repository/tool work may nevertheless be advanced concurrently where dependencies permit.

| Lane | Role | Current allocation | Dependency boundary |
|---|---|---|---|
| Coordinator | Primary coordinator | Read live evidence, assign eligible independent work, reconcile all results | Single coordinator only; no overall completion before consolidation |
| Agent 1 | Presenter Solutions | T34 Integration CI failure diagnosis and exact failing-test/root-cause evidence | May diagnose immediately; no Frontend until Integration is green |
| Agent 2 | Presenter Solutions | T34 Integration implementation/test reconciliation against contract, DAO state and PostgreSQL behavior | May inspect/prepare repair independently; any code change must preserve verified Service/UT behavior |
| Agent 3 | Presenter Solutions | T35 source/contract/interface/controller/stub reconciliation only | Reconciliation may run independently; implementation cannot skip its Service → UT → CI gate sequence |
| Agent 4 | Classroom Release Preparation | Release-01 prerequisite/evidence audit and exact document identity verification | No materialization/freeze until selected documents are APPROVED and repository-verified |
| Agent 5 | Classroom Release Preparation | Release-02 controlled-error remediation acceptance mapping against approved student baseline requirements | May prepare/verify private acceptance evidence; no public write and no freeze before baseline is approved |
| Agent 6 | Presenter Solutions | Presenter regression/cumulative CI readiness across T31-T34 and exact Frontend readiness for T34 | T34 Frontend implementation remains blocked while Integration CI is red |
| Agent 7 | Classroom Release Preparation | Release manifest/checklist consistency and private promotion-boundary verification | Prerequisite-free private verification only; publication remains Presenter-only |
| Agent 8 | Recovery / Final Integration | T31-T35 registry candidate, immutable evidence capture and freeze guard | Capture verified evidence incrementally; `freeze_allowed=false` until all five tracks are registry-ready |

## Document work during this phase

T02_02-T06_02 remain unfinished upstream Document Rerun work, but they are not assigned one of the eight active lanes in this phase. Their existing state and percentages are preserved. Classroom tasks that depend on approved documents remain BLOCKED; this reallocation must not bypass those document gates.

## Presenter dependency sequence

For each Presenter track the required order remains:

1. source/contract reconciliation;
2. Service implementation;
3. focused Unit Test;
4. branch-tip CI proving Service + Unit Test green;
5. local PostgreSQL Integration;
6. PostgreSQL Testcontainers Integration;
7. branch-tip Integration CI green;
8. assigned Frontend;
9. cumulative CI/registry evidence;
10. batch registry freeze when the full batch is ready.

No dependent stage may be started or credited prematurely.

## Classroom release dependency rules

1. Private prerequisite-free audits, manifests, checklists and promotion-boundary verification may run in parallel.
2. Any stage containing rerun documents is blocked until exact selected documents are APPROVED and repository-verified.
3. Release-02 is blocked until the approved student baseline contains verified generic controlled-error infrastructure.
4. ChatGPT/automation must never write to the public classroom repository; public publication is Presenter-only.

## Recovery rules

Registry evidence may be captured incrementally for already verified checkpoints. A batch must not be frozen until every track has exact immutable component evidence and required cumulative CI. Final integration cannot close while Presenter, Document or Release prerequisites remain incomplete.

## Coordinator selection rules

At every watchdog/execution cycle:

1. Read all four stream task files plus the dashboard and current CI state.
2. Use Agents 1, 2, 3 and 6 for independent eligible Presenter work.
3. Use Agents 4, 5 and 7 for independent prerequisite-safe Classroom work.
4. Use Agent 8 for Recovery evidence/freeze guarding only.
5. Do not substitute blocked dependent implementation with speculative changes.
6. A task is CLOSED only with repository/test/QG evidence required by its definition of done.
7. CI/log inspection alone is an action, not task completion.
8. If a task remains open for 4+ completed cycles, mark STALLED and record `Action Taken in This Cycle`.
9. Update `.project/PROJECT_PROGRESS.md` after substantive gates and live checkpoints.
10. Never write to the public classroom repository or the read-only Quality Gate repository.

## Consolidation rule

Do not declare a multi-lane batch or the overall task complete until all relevant independent lanes have returned evidence and the primary coordinator has reconciled:

- exact commit/blob SHAs;
- CI/workflow conclusions and failed-step evidence;
- QG results and artifact hashes where applicable;
- task-file statuses;
- stream percentages and weighted Overall percentage;
- blockers and stalled-cycle actions;
- registry freeze eligibility.

## Task files

- `.project/tasks/document-rerun.md`
- `.project/tasks/presenter-solutions.md`
- `.project/tasks/classroom-release.md`
- `.project/tasks/recovery-final-integration.md`

These files remain the execution queues. Conversation memory is not authoritative.