# KHAE Full Stack — Orchestrator Plan

Updated 2026-08-18 for stale-recovery execution after Presenter reached the final T59/T60 path.

## Purpose
One primary coordinator controls eight logical worker lanes. No autonomous-agent runtime is assumed. The connected Private Master repository is the execution source of truth.

## Frozen project weights
| Stream | Weight | Current execution allocation |
|---|---:|---|
| Document Rerun | 45% | ACTIVE — FOUR LANES |
| Presenter Solutions | 35% | ACTIVE — TWO LANES |
| Classroom Release Preparation | 10% | ACTIVE — ONE LANE |
| Recovery / Final Integration | 10% | ACTIVE — ONE LANE |

`Overall = Documents*0.45 + Presenter*0.35 + ClassroomRelease*0.10 + Recovery*0.10`

## Primary coordinator + eight logical worker lanes
| Lane | Role | Immediate responsibility | Dependency boundary |
|---|---|---|---|
| Coordinator | Primary coordinator | Read live evidence, enforce gates, wake blocked lanes only on prerequisite change, consolidate results | No batch completion before consolidation |
| Agent 1 | Presenter Solutions | T59 Integration -> Testcontainers -> next eligible Presenter gate | Frontend only after combined Integration green |
| Agent 2 | Presenter Solutions | T59 Frontend -> T60 ordered pipeline when dependencies permit | T60 implementation must not overtake T59 closure |
| Agent 3 | Document Rerun | T02 highest priority: T02_02 render/QA/approval -> T02_03 when eligible | No _03 before T02_02 required gates |
| Agent 4 | Document Rerun | T03 independent generation/render/QA progression | Preserve document QA ordering |
| Agent 5 | Document Rerun | T04 independent generation/render/QA progression | Preserve document QA ordering |
| Agent 6 | Document Rerun | T05/T06 progression plus T01 identity blocker when dependency-safe | Do not write to read-only Quality Gate repository |
| Agent 7 | Classroom Release Preparation | Event-driven Release-01/02 private readiness and promotion preparation | Wake on document prerequisite change; no public write without authorization |
| Agent 8 | Recovery / Final Integration | T56-T60 registry evidence, cumulative-regression readiness, final-integration preparation and freeze guard | Freeze only after full batch + registry-tip CI |

## Stale-recovery rule
Document Rerun is now an active structural-blocker recovery target. Agents 3-6 attack independent document identities in parallel. Classroom is reduced to one event-driven lane because its private preflights are complete and release materialization remains document-gated. Recovery remains one lane but may use CI wait windows for cumulative/final-integration readiness rather than unchanged registry polling.

## Current Presenter critical path
T01-T55 are frozen/verified. T56-T60 Fine is the active final Presenter batch on `Presenter-Solutions-T56-T60`. Current ordered path is T59 Integration -> T59 Frontend -> T60 -> final T56-T60 registry. Presenter sequence remains source/contract -> Service -> Unit -> exact green CI -> local PostgreSQL Integration -> PostgreSQL 18 Testcontainers -> green combined Integration -> assigned Frontend -> cumulative registry evidence -> batch freeze.

## Document critical path
Highest priority is T02 because it directly gates Release-02. Drive T02_02 through textbook completion, editable Draw.io, DOCX render, Content QA, Technical QA, Diagram QA, visual/accessibility QA and repository verification before approval, then start T02_03 only when eligible. T03-T06 progress independently. Resolve the T01_01/T01_03 identity transition when dependency-safe because it gates Release-01.

## Classroom rules
Agent 7 is event-driven. Do not repeatedly poll unchanged document blockers. Release-01 remains blocked by T01 identity completion. Release-02 remains blocked by T02_02 final approval/repository verification and T02_03. Never write to the public classroom repository unless promotion is explicitly authorized. Quality Gate repository is read-only.

## Recovery rules
Agent 8 captures newly verified immutable Presenter evidence, prepares cumulative regression/final integration, and guards freeze eligibility. `freeze_allowed=false` for T56-T60 until the full Fine batch is complete with registry-tip CI.

## Stale policy
- A status check is an action, not progress.
- 4-6 completed cycles without closure: STALE and mandatory alternative action.
- 7-10 cycles: BLOCKED; stop identical polling.
- More than 10 cycles: STRUCTURAL_BLOCKER; reallocate execution capacity or change strategy.
- Do not credit percentages for preparation, inspection, or incomplete gates.

## Safety and consolidation
Never write to the public classroom repository or read-only Quality Gate repository unless explicitly authorized. A task closes only with its defined evidence. Update the stream task files, `.project/execution-cycle-monitor.yml`, and `.project/PROJECT_PROGRESS.md` after substantive gates/consolidation.
