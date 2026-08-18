# KHAE Full Stack — Orchestrator Plan

Updated 2026-08-18 for the requested watchdog allocation and single-writer dashboard architecture.

## Purpose
One primary coordinator controls eight logical worker lanes. No autonomous-agent runtime is assumed. The connected Private Master repository is the execution source of truth.

## Frozen project weights
| Stream | Weight | Current execution allocation |
|---|---:|---|
| Document Rerun | 45% | DEPENDENCY ONLY — NO CURRENT LANE |
| Presenter Solutions | 35% | COMPLETE — FOUR LOGICAL LANES RETAINED AS VERIFICATION/IDLE GUARDS |
| Classroom Release Preparation | 10% | ACTIVE — THREE PRIVATE READINESS LANES |
| Recovery / Final Integration | 10% | ACTIVE — ONE LANE |

`Overall = Documents*0.45 + PresenterSolutions*0.35 + ClassroomRelease*0.10 + Recovery*0.10`

## Primary coordinator + eight logical worker lanes
| Lane | Role | Immediate responsibility | Dependency boundary |
|---|---|---|---|
| Coordinator | Primary coordinator | Read live evidence, enforce gates, assign eligible independent work, consolidate results | No batch completion before consolidation |
| Agent 1 | Presenter Solutions | Presenter complete; revalidate immutable final registry evidence only when needed | Do not invent new Presenter implementation |
| Agent 2 | Presenter Solutions | Presenter complete; revalidate final CI/registry-tip evidence only when needed | Do not invent new Presenter CI gates |
| Agent 3 | Presenter Solutions | Presenter complete; preserve T01-T60 contract/registry closure | No new implementation unless scope changes explicitly |
| Agent 4 | Classroom Release Preparation | Release-01 private manifest and prerequisite reconciliation | No candidate materialization before required Document APPROVED gates |
| Agent 5 | Classroom Release Preparation | Release-02 private baseline/manifest/document prerequisite readiness | No candidate materialization before T02_02/T02_03 completion |
| Agent 6 | Presenter Solutions | Presenter complete; cumulative regression/contract guard only | No new Presenter work |
| Agent 7 | Classroom Release Preparation | Release validation checklist, promotion-boundary and private readiness matrix | No public write without explicit promotion authorization |
| Agent 8 | Recovery / Final Integration | Final project integration readiness after Presenter completion | Final project freeze waits for Document/Classroom prerequisites |

These are logical worker lanes only; no autonomous-agent runtime is exposed.

## Allocation rule
The current authoritative allocation is **4 Presenter / 3 Classroom / 1 Recovery**. Document Rerun is dependency-only and receives no Agent 1–8 lane under this plan. Report Document state whenever it materially gates Classroom or Recovery, but do not perform Document execution in these eight lanes unless this plan is explicitly changed again.

## Presenter state
Presenter Solutions is complete at 300/300 checkpoints with all 60 Presenter registries frozen and verified. Agents 1, 2, 3 and 6 therefore perform only evidence/contract guards and must not create artificial work or percentage credit.

## Document dependency state
Document Rerun remains the upstream dependency. Current verified stream state is 5.5000%. T01_01 and T01_03 are REPOSITORY_VERIFIED but still require final APPROVED transition. T02_02-T06_02 remain not final-approved; T02_03-T06_03 remain dependent on same-track Progressive Guide approval. No Document lane is allocated in this plan.

## Classroom rules
Agents 4, 5 and 7 execute prerequisite-safe private work in parallel. Release-01 waits for final T01_01/T01_03 APPROVED transition. Release-02 remains blocked by T02_02 final QA/approval plus T02_03 completion. Private manifests/checklists/readiness matrices may be reconciled to current immutable evidence while blocked; blocked candidate materialization is forbidden. Never write to the public classroom repository unless promotion is explicitly authorized. Quality Gate repository is read-only.

## Recovery rules
Agent 8 retains immutable final Presenter evidence and prepares final project integration. All Presenter registries are frozen; no final project freeze is allowed before required Document and Classroom gates close.

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
- Workers/coordinators write only authoritative input evidence files.
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
Every coordinator/watchdog cycle must maintain a persistent total stale-cycle count for each task or stream open more than three completed cycles.

For every row reported under **Tasks / Streams Open More Than 3 Cycles and Action Taken**, use:

| Task / Stream | State | Total Stale Cycles | Stale Since Cycle | Action Taken in This Cycle |
|---|---|---:|---|---|

Rules:
- `Total Stale Cycles` is the cumulative number of consecutive completed coordinator/watchdog cycles in which the task/stream remained open without its defined completion/percentage gate closing.
- Increment by exactly 1 at each completed cycle that remains stale.
- Reset to 0 when the relevant task/stream closes or records a genuine percentage-bearing progress gate under that task/stream's stale definition.
- `Stale Since Cycle` preserves the first cycle ID of the uninterrupted stale run.
- Never replace a known number with vague `>3 cycles` text.
- If historical exact count cannot be proven from repository evidence, retain `UNKNOWN_PENDING_RECONCILIATION` rather than inventing a number.
- Watchdog/manual coordinator cycles persist counters in `.project/execution-cycle-monitor.yml` and may mirror them into stream task files.
- `PROJECT_PROGRESS_SYNCHRONIZER` copies persisted values into the generated dashboard.

## Safety and consolidation
Never write to the public classroom repository or read-only Quality Gate repository unless explicitly authorized. A task closes only with defined evidence. Coordinator/watchdog cycles update stream task files and `.project/execution-cycle-monitor.yml`; the dedicated synchronizer alone updates `.project/PROJECT_PROGRESS.md`.
