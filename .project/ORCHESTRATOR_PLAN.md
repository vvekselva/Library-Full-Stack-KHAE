# KHAE Full Stack — Orchestrator Plan

Updated 2026-08-18 for the active stale-recovery allocation and single-writer dashboard architecture.

## Purpose
One primary coordinator controls eight logical worker lanes. No autonomous-agent runtime is assumed. The connected Private Master repository is the execution source of truth.

## Frozen project weights
| Stream | Weight | Current execution allocation |
|---|---:|---|
| Document Rerun | 45% | ACTIVE — FOUR LANES |
| Presenter Solutions | 35% | COMPLETE — TWO LANES RELEASED FROM IMPLEMENTATION |
| Classroom Release Preparation | 10% | ACTIVE — ONE EVENT-DRIVEN LANE |
| Recovery / Final Integration | 10% | ACTIVE — ONE LANE |

`Overall = Documents*0.45 + PresenterSolutions*0.35 + ClassroomRelease*0.10 + Recovery*0.10`

## Primary coordinator + eight logical worker lanes
| Lane | Role | Immediate responsibility | Dependency boundary |
|---|---|---|---|
| Coordinator | Primary coordinator | Read live evidence, enforce gates, wake blocked lanes only on prerequisite change, consolidate results | No batch completion before consolidation |
| Agent 1 | Presenter Solutions | COMPLETE / no remaining Presenter implementation | Do not invent new Presenter work |
| Agent 2 | Presenter Solutions | COMPLETE / no remaining Presenter CI gate | Do not invent new Presenter work |
| Agent 3 | Document Rerun | T02 priority: T02_02 completion/QA/approval, then T02_03 when eligible | No _03 before _02 required gates |
| Agent 4 | Document Rerun | T03 independent generation/render/QA progression | Preserve document QA ordering |
| Agent 5 | Document Rerun | T04 independent generation/render/QA progression | Preserve document QA ordering |
| Agent 6 | Document Rerun | T05/T06 progression plus T01 final approval transition when dependency-safe | Quality Gate repository remains read-only |
| Agent 7 | Classroom Release Preparation | Event-driven Release-01/02 private readiness and promotion preparation | Wake on Document prerequisite change; no public write without authorization |
| Agent 8 | Recovery / Final Integration | Final project integration readiness after Presenter completion | Final project freeze waits for Document/Classroom prerequisites |

## Stale-recovery rule
Document Rerun is the active structural-blocker recovery target. Agents 3-6 attack independent document work in parallel. Classroom uses one event-driven lane because its private preflights are complete and release materialization remains Document-gated. Recovery uses one lane for cumulative/final-integration readiness instead of unchanged polling.

## Presenter state
Presenter Solutions is complete at 300/300 checkpoints with all 60 Presenter registries frozen and verified. No new Presenter implementation work should be created unless the user explicitly changes scope.

## Document critical path
Highest priority is T02 because it directly gates Release-02. Drive T02_02 through completion, editable Draw.io, DOCX render, Content QA, Technical QA, Diagram QA, visual/accessibility QA and repository verification before approval, then begin T02_03 only when eligible. T03-T06 may progress independently. T01_01/T01_03 are repository-verified and now require their final APPROVED transition before Release-01 becomes eligible.

## Classroom rules
Agent 7 is event-driven. Do not repeatedly poll unchanged Document blockers. Release-01 waits for final T01_01/T01_03 approval. Release-02 remains blocked by T02_02 final approval/repository verification and T02_03. Never write to the public classroom repository unless promotion is explicitly authorized. Quality Gate repository is read-only.

## Recovery rules
Agent 8 captures final immutable evidence and prepares cumulative/final integration. All Presenter registries are frozen; final project integration waits on remaining Document and Classroom prerequisites.

## PROJECT_PROGRESS single-writer policy
`.project/PROJECT_PROGRESS.md` is the single human-facing authoritative dashboard.

The only writer is **`PROJECT_PROGRESS_SYNCHRONIZER`** implemented by:
- `scripts/project_progress_sync.py`
- `.github/workflows/project-progress-sync.yml`
- specification: `.project/PROJECT_PROGRESS_SYNC_SPEC.md`

### Mandatory write rules
- Worker lanes must never edit `.project/PROJECT_PROGRESS.md` directly.
- Watchdog/coordinator cycles must never edit `.project/PROJECT_PROGRESS.md` directly.
- Manual coordinator cycles must never edit `.project/PROJECT_PROGRESS.md` directly.
- Workers/coordinators write only the authoritative input evidence files.
- After an authoritative input commit, `PROJECT_PROGRESS_SYNCHRONIZER` regenerates the dashboard and commits it if changed.
- The synchronizer must use human-readable task names first and technical IDs only as adjacent evidence.
- The synchronizer must not invent percentages, stale counters, approvals, CI success, or evidence.
- If inputs conflict, publish the last verifiable values and mark synchronizer status `DEGRADED` with the unresolved item.

### Synchronizer authoritative inputs
1. `.project/execution-cycle-monitor.yml`
2. `.project/tasks/document-rerun.md`
3. `.project/tasks/presenter-solutions.md`
4. `.project/tasks/classroom-release.md`
5. `.project/tasks/recovery-final-integration.md`
6. `.project/ORCHESTRATOR_PLAN.md`

### Synchronizer output
- `.project/PROJECT_PROGRESS.md`

The dashboard workflow triggers on changes to authoritative inputs and may also be run manually with `workflow_dispatch`. A dashboard-only commit does not retrigger itself.

## Stale policy
- A status check is an action, not progress.
- 4-6 completed cycles without closure: STALE and mandatory alternative action.
- 7-10 cycles: BLOCKED; stop identical polling.
- More than 10 cycles: STRUCTURAL_BLOCKER; reallocate execution capacity or change strategy.
- Do not credit percentages for preparation, inspection, or incomplete gates.

### Mandatory stale-cycle accounting
Every future coordinator/watchdog cycle must maintain a persistent **total stale-cycle count** for each task or stream that is open more than three completed cycles.

For every row reported under **Tasks / Streams Open More Than 3 Cycles and Action Taken**, the required columns are:

| Task / Stream | State | Total Stale Cycles | Stale Since Cycle | Action Taken in This Cycle |
|---|---|---:|---|---|

Rules:
- `Total Stale Cycles` is the cumulative number of consecutive completed coordinator/watchdog cycles in which the task/stream remained open without its defined completion/percentage gate closing.
- Increment the counter by exactly 1 at each completed cycle that remains stale.
- Reset the counter to 0 when the relevant task/stream closes or records a genuine percentage-bearing progress gate, according to that task/stream's stale definition.
- `Stale Since Cycle` must preserve the first cycle ID of the current uninterrupted stale run.
- Do not replace the number with vague labels such as `>3 cycles`; always show the exact persisted count.
- If a historical exact count cannot be proven from repository evidence, mark it `UNKNOWN_PENDING_RECONCILIATION` rather than inventing a number.
- Watchdog/manual coordinator cycles persist these counters in `.project/execution-cycle-monitor.yml` and may mirror them into stream task files.
- `PROJECT_PROGRESS_SYNCHRONIZER` copies the persisted values into the generated dashboard.

## Safety and consolidation
Never write to the public classroom repository or read-only Quality Gate repository unless explicitly authorized. A task closes only with its defined evidence. Coordinator/watchdog cycles update stream task files and `.project/execution-cycle-monitor.yml`; the dedicated synchronizer alone updates `.project/PROJECT_PROGRESS.md`.
