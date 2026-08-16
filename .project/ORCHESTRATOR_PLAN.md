# KHAE Full Stack — Orchestrator Plan

Updated for the documentation-first scale-up approved on 2026-08-16.

## Purpose

This file is the coordinator contract for the live dashboard and the scheduled KHAE Progress Watchdog. The watchdog must read this file, `.project/PROJECT_PROGRESS.md`, `.project/execution-cycle-monitor.yml`, and the four stream task files before selecting work.

## Frozen project weights

| Stream | Weight | Execution priority |
|---|---:|---|
| Document Rerun | 45% | PRIMARY |
| Presenter Solutions | 35% | SECONDARY |
| Classroom Release Preparation | 10% | SUPPORTING |
| Recovery / Final Integration | 10% | SUPPORTING |

Overall = Documents*0.45 + Presenter*0.35 + ClassroomRelease*0.10 + Recovery*0.10.

## Eight logical worker lanes

This repository records eight logical worker lanes. ChatGPT must not claim that separate autonomous agents exist unless an actual agent runtime is available. In a normal ChatGPT execution turn, independent lanes may be advanced in parallel by independent tool work, while this file remains the source of assignment/dependency truth.

| Lane | Role | Initial allocation | Parallelism rule |
|---|---|---|---|
| Coordinator | Primary coordinator | Reads dashboard/task files, assigns eligible work, consolidates results | Must remain single coordinator |
| Agent 1 | Document Rerun | T02 complete three-document set | May run independently of T03-T06 |
| Agent 2 | Document Rerun | T03 complete three-document set | May run independently of T02/T04-T06 |
| Agent 3 | Document Rerun | T04 complete three-document set | May run independently of T02-T03/T05-T06 |
| Agent 4 | Document Rerun | T05 complete three-document set | May run independently of T02-T04/T06 |
| Agent 5 | Document Rerun | T06 complete three-document set | May run independently of T02-T05 |
| Agent 6 | Presenter Solutions | Resume T33 verification/repair gate, then T33 Integration/Frontend | Must obey CI prerequisite gates |
| Agent 7 | Classroom Release Preparation | Advance prerequisite-free preparation only | No promotion before approved/materialized document prerequisite |
| Agent 8 | Recovery / Final Integration | Incremental registry validation for already-green tracks only | No batch/final freeze before dependent tracks are green |

## Document scale-up rule

The approved T01 three-document set is the scaling baseline. Each new track must be processed in this order:

1. Txx_01 Initial API Contract — success contract only; do not reveal later controlled-error catalogue.
2. Txx_02 Progressive Development Guide — exact package/source placement, WHY-before-HOW, Unit Test, observed failure, correction, JaCoCo, local PostgreSQL, DBeaver, Testcontainers, frontend integration, editable Draw.io, full visual QA.
3. Txx_03 Updated API Contract — final response catalogue grounded in verified Presenter/service behavior after the progressive sequence.
4. Repository materialization/re-fetch/hash verification.
5. User/Presenter approval when the workflow requires it.

Within a single track, Txx_03 must not be declared complete before the Progressive Guide has established the final behavior. Across different tracks, independent source-grounded generation and QA may proceed in parallel.

## Package/source placement quality gate

Every student guide and both API-contract documents must state:

- exact Maven/source folder;
- exact Java package;
- exact student-owned implementation/test file paths;
- Presenter-owned interface/controller/shared-infrastructure paths where relevant;
- explicit warning not to duplicate Presenter-provided interfaces in another package.

## Coordinator selection rules

At every watchdog/execution cycle:

1. Read all four stream task files plus the dashboard.
2. Prefer Document Rerun work while it remains the highest-weight stream and eligible document tasks exist.
3. Keep up to five independent document tracks active; never parallelize dependent stages within the same track prematurely.
4. Give Agent 6 only Presenter work whose preceding CI/contract gate is satisfied.
5. Give Agent 7 only release work whose document/release prerequisite is satisfied; prerequisite-free packaging/verification work may proceed earlier.
6. Give Agent 8 only recovery registry work for already verified components; do not freeze incomplete batches.
7. A task is CLOSED only with repository/test/QG evidence required by its definition of done.
8. CI/log inspection alone is an action, not task completion.
9. If a task remains open for 4+ completed cycles, mark STALLED and record `Action Taken in This Cycle`.
10. If a stream has no percentage increase for 4+ cycles, execute an unblock/fallback action rather than merely reporting it.
11. Update `.project/PROJECT_PROGRESS.md` after substantive gates and at live checkpoints during an active execution session.
12. Never write to the public classroom repository or the read-only Quality Gate repository.

## Consolidation rule

Do not declare a multi-lane batch or the overall task complete until all relevant independent lanes have returned evidence and the coordinator has reconciled:

- exact commit/blob SHAs;
- CI/workflow conclusions;
- QG results and artifact hashes;
- task-file statuses;
- stream percentages and weighted Overall percentage;
- blockers and stalled-cycle actions.

## Task files

- `.project/tasks/document-rerun.md`
- `.project/tasks/presenter-solutions.md`
- `.project/tasks/classroom-release.md`
- `.project/tasks/recovery-final-integration.md`

These files are the complete execution queues. The watchdog must update/read them before deciding what to do next; conversation memory is not authoritative.