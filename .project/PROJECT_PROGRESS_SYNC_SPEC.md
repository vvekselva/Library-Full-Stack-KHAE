# PROJECT_PROGRESS Synchronizer Specification

## Purpose
`.project/PROJECT_PROGRESS.md` is the single human-facing project dashboard. It is generated, not hand-maintained.

## Single-writer rule
The only writer of `.project/PROJECT_PROGRESS.md` is `PROJECT_PROGRESS_SYNCHRONIZER`.

The following must never write the dashboard directly:
- Presenter worker lanes
- Document worker lanes
- Classroom worker lanes
- Recovery worker lane
- watchdog coordinator
- manual coordinator

All workers/coordinators update their authoritative input evidence only. The synchronizer reads those inputs and regenerates the dashboard.

## Authoritative inputs
1. `.project/execution-cycle-monitor.yml`
2. `.project/tasks/document-rerun.md`
3. `.project/tasks/presenter-solutions.md`
4. `.project/tasks/classroom-release.md`
5. `.project/tasks/recovery-final-integration.md`
6. `.project/ORCHESTRATOR_PLAN.md`

## Generated output
- `.project/PROJECT_PROGRESS.md`

## Trigger
Run after any commit that changes one or more authoritative inputs. Manual `workflow_dispatch` is also supported.

## Processing contract
The processor must:
1. Read the completed cycle from `execution-cycle-monitor.yml`.
2. Read stream percentages and stale-cycle counters from the monitor.
3. Read current lane allocation from the monitor/orchestration plan.
4. Read current stream task files for human-readable component/checkpoint state and evidence.
5. Recalculate Overall using frozen weights: Documents 45%, Presenter 35%, Classroom 10%, Recovery 10%.
6. Refuse to invent missing stale counters or evidence; preserve `UNKNOWN_PENDING_RECONCILIATION` when needed.
7. Generate `PROJECT_PROGRESS.md` atomically.
8. Commit only when generated content differs.

## Lifecycle states
Dashboard component rows must use one of:
- `CLOSED / VERIFIED`
- `IN PROGRESS`
- `STALE / BLOCKED`
- `YET TO DO`

A status inspection is not progress. Percentage credit is allowed only when the corresponding defined checkpoint has verifiable evidence.

## Evidence display rule
Human-readable task/component name must appear first. Technical identifiers such as commit SHA, workflow ID, job ID, blob SHA, or branch are evidence fields adjacent to the human-readable name; a raw identifier must never substitute for the task name.

## Failure behaviour
If inputs are inconsistent, the processor must still publish the last verifiable percentages and mark:

`Synchronizer status: DEGRADED`

with the unresolved input/component named explicitly. It must not manufacture a number.

## Loop prevention
The synchronizer workflow triggers only from authoritative input paths. A commit that changes only `PROJECT_PROGRESS.md` must not retrigger the workflow.

## Safety
The synchronizer writes only inside the private Master repository. It never writes to the public Classroom repository or the read-only Quality Gate repository.
