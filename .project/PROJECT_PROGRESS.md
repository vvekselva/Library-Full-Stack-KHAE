# KHAE Full Stack - Live Project Progress

This file is the private, authoritative execution dashboard for the KHAE Full Stack classroom preparation project.

## Repository Roles

- Public classroom repository: `vvekselva/Library-Full-Stack-KHAE` - Presenter publication only; ChatGPT/automation does not write here.
- Private Master repository: `vvekselva/Library-Full-Stack-KHAE-Master` - all project commits by ChatGPT/automation.
- Quality Gate repository: `vvekselva/Library_KAHE_PRIVATE_RERUN` - read-only Golden Reference and quality authority.

## Frozen Progress Formula

- Document rerun: 45%
- Presenter solutions: 35%
- Classroom release preparation: 10%
- Recovery and final integration: 10%

`Overall = Documents*0.45 + PresenterSolutions*0.35 + ClassroomReleases*0.10 + Recovery*0.10`

## Live Percentage Comparison Rule

The dashboard shows three values for every stream:

- **Previous %** = the value immediately before the latest completed percentage-bearing gate.
- **Updated %** = the current authoritative value.
- **Increase** = the change from Previous to Updated using the underlying unrounded progress values.

A heartbeat-only or verification-only update does not erase the last meaningful comparison baseline. When a new implementation gate changes progress, the current Updated value becomes the next Previous value and the newly calculated value becomes Updated. Increase is calculated from the unrounded values and then rounded for display. Because Previous and Updated are independently displayed to two decimals, subtracting the displayed values can occasionally differ from the displayed Increase by 0.01 percentage point.

## Current Status - 2026-08-16 17:31 IST

| Stream | Previous % | Updated % | Increase | Current Stage |
|---|---:|---:|---:|---|
| Document Rerun | **0.47%** | **0.47%** | **+0.00%** | T01_02 QG-01 to QG-26 PASS; QG-27 OPEN. Exact accepted binary identity is unchanged. Materialization run `31941294901` failed with `base64: invalid input`. Successful canonical-source artifact `T01_02-canonical-source` from run `31939791535` contains normalized teaching source, editable Draw.io sources and content QA, but not the accepted 55-page DOCX. The available 42-page Golden Reference does not match the accepted artifact and will not be substituted. |
| Presenter Solutions | **51.00%** | **51.33%** | **+0.33%** | **T01-T30 VERIFIED; T31 Service/UT/Integration/Frontend COMPLETE; cumulative run `31945620654` SUCCESS at `9d2f5796`; final 20 T31 points remain batch-registry gated; T32 Read Book Copy Service IN PROGRESS.** |
| Classroom Release Preparation | **33.33%** | **33.33%** | **+0.00%** | Release-00 remains Presenter-ready and independently VERIFIED PASS by run `31930965288`. Release-01/02 pending. |
| Recovery / Final Integration | **20.00%** | **20.00%** | **+0.00%** | Verified solution-registry coverage remains **30/60 tracks = 50% coverage × 40% recovery weight = 20.00%**. T31-T35 registry is still waiting for the complete Book Copy batch. |
| **Overall** | **23.40%** | **23.51%** | **+0.12%** | Current raw formula result is approximately `23.5125%`, displayed as 23.51%. Previous raw overall was approximately `23.3958%`, displayed as 23.40%. The unrounded increase is approximately `0.1167%`, displayed as +0.12%. |

## Current 15-Minute Cycle Task Table

Current cycle: **C-20260816-1725**, nominal window **17:25-17:40 IST**. “More than 3 cycles” means **4 or more completed cycles**.

| Task | Stream | Taken Up This Cycle | Closed This Cycle | Current State | Consecutive Cycles Open | >3 Cycles |
|---|---|---|---|---|---:|---|
| Add live cycle-task and stalled-stream monitoring | Project Control | **Yes** | **Yes** | **CLOSED** at `fb917183` machine monitor + this dashboard update | 1 | No |
| Consume T31 cumulative CI and confirm final-checkpoint semantics | Presenter Solutions | **Yes** | **Yes** | **CLOSED** - run `31945620654` SUCCESS; final 20 points correctly remain batch-registry gated | 1 | No |
| Implement T32 Read Book Copy Service | Presenter Solutions | **Yes** | No | **IN PROGRESS** | 1 | No |
| Recover exact accepted T01_02 QG-27 DOCX binary | Document Rerun | No - carried forward | No | **IN PROGRESS / BLOCKED** by missing accepted 55-page binary | **4+** | **YES** |
| Freeze T31-T35 recovery registry | Recovery / Final Integration | No - dependency task | No | **WAITING** for complete T31-T35 component set and cumulative verification | **4+** | **YES** |

Machine-readable cycle state is maintained in `.project/execution-cycle-monitor.yml`.

## Streams With No Increase for More Than 3 Cycles

Only streams with **4 or more completed consecutive cycles without a percentage increase** are escalated here.

| Stream | Current % | Consecutive Cycles Without Increase | Last Known Increase / Baseline | Reason | Next Unblock Action |
|---|---:|---:|---|---|---|
| **Document Rerun** | **0.47%** | **4+** | No increase in the recent recorded cycle window | QG-27 exact accepted DOCX binary still unavailable; reconstruction failed | Recover exact binary and pass identity verification |
| **Classroom Release Preparation** | **33.33%** | **4+** | Release-00 verification is the current plateau | Release-01/02 remain behind prerequisite gates | Resume Release-01/02 preparation while preserving ownership boundaries |
| **Recovery / Final Integration** | **20.00%** | **4** | Last increase at the T01-T30 registry coverage checkpoint | T31-T35 registry cannot be frozen from a partial batch | Complete T31-T35, freeze exact SHAs, then run registry-tip CI |

Presenter Solutions and Overall are **not** in the stalled-stream table because they increased in the latest completed cycle.

## Active Work

- **Presenter code:** T31 Add Book Copy service is complete at `c03fdf121118fdaad8467deec492e97c92c033d9`. Unit tests are verified by run `31945047287`. The single 20-point Integration checkpoint is implementation-complete through local PostgreSQL `599dac48aa4f406c7f69c87c147527d3c10f9973` plus Testcontainers `192761ab22e10361ecc6456fcfa59402e3d792c5`. The assigned Update Book Copy recovery frontend is implemented at `9d2f5796edb1cd3bb34f56b0433c2c747687e5ed`.
- **T31 cumulative verification:** run `31945620654` completed **SUCCESS** at exact substantive tip `9d2f5796edb1cd3bb34f56b0433c2c747687e5ed`. Historical T26/T27 tracker evidence proves a track remains at 80% after Service + UT + Integration + Frontend; the final 20% is held until the batch cumulative CI/registry gate. Therefore no verification-only percentage is added to T31 now.
- **T32:** Read Book Copy Service is the active Presenter task. The implementation must replace the current fixed-response stub with persistence-backed read-by-ID behavior and preserve the progressive discovery model for an unknown ID before the controlled correction. The integration layer must additionally prove the withdrawn-copy state boundary before T32 advances through its integration checkpoint.
- **Document:** continue QG-27 recovery from canonical source/history without substituting a different DOCX. Exact accepted target remains size `234444`, SHA-256 `c1e43a93f7355032b8cc650815621613bf3cb2012c446756068961d13bf7cce4`, Git blob `853fe9b900ba04339441116bdf18e64289a59093`.
- **Recovery:** T01-T30 registry coverage is verified. The T31-T35 registry remains NOT_YET_CREATED and must be built only from exact verified component SHAs after cumulative batch completion.
- **Classroom release:** Release-00 remains verified. Release-01/02 work must preserve Presenter/student ownership boundaries and the Release-02 exception-infrastructure prerequisite.

## 15-Minute Execution Checkpoint Protocol

During an active execution window, each approximately 15-minute checkpoint must also update this file on `main` with evidence-based status. The checkpoint entry must record the timestamp, active branch/task, latest substantive branch commit, **Previous %, Updated %, and Increase**, blockers, and the next concrete action. A real checkpoint crossing is written immediately even if it occurs before the 15-minute heartbeat. A heartbeat-only code commit must not be created merely to manufacture activity; this dashboard update is the status record.

Each cycle must additionally maintain:

- tasks taken up in the cycle;
- tasks closed in the cycle;
- tasks still in progress;
- tasks open/progressing for 4 or more completed cycles;
- streams with 4 or more completed cycles without a percentage increase.

### Checkpoint Log

- **2026-08-16 17:31 IST** - Cycle-control extension activated. Added machine-readable `.project/execution-cycle-monitor.yml`, current-cycle task table, long-running-task escalation, and stalled-stream escalation. T31 cumulative run `31945620654` is confirmed **SUCCESS** at `9d2f5796`; historical tracker semantics keep T31 at 80% until the T31-T35 batch registry gate. Presenter remains **51.00% → 51.33% (+0.33%)** because this is verification-only; Overall remains **23.40% → 23.51% (+0.12%)**. T32 Read Book Copy Service is now IN PROGRESS.
- **2026-08-16 17:25 IST** - T31 Frontend implementation gate completed at `9d2f5796`. Existing `import.meta.glob` discovery means no shared routing modification was needed. The newest cumulative verification target is run `31945620654` at the exact frontend tip. Presenter comparison: **51.00% → 51.33% (+0.33%)**. Overall comparison: **23.40% → 23.51% (+0.12% from unrounded values)**. Document **0.47% → 0.47% (+0.00%)**; Classroom **33.33% → 33.33% (+0.00%)**; Recovery **20.00% → 20.00% (+0.00%)**.
- **2026-08-16 17:22 IST** - T31 Integration implementation gate completed. Local PostgreSQL test `599dac48` and PostgreSQL-18 Testcontainers test `192761ab` together complete the original single 20-point integration checkpoint. Integration CI run `31945515199` was still running at this checkpoint and could be superseded by the later frontend push. Presenter comparison: **50.67% → 51.00% (+0.33%)**. Overall comparison: **23.28% → 23.40% (+0.12%)**. Document **0.47% → 0.47% (+0.00%)**; Classroom **33.33% → 33.33% (+0.00%)**; Recovery **20.00% → 20.00% (+0.00%)**.
- **2026-08-16 17:15 IST** - Live format and verification gate update. T31 UT `6fdfc020` is VERIFIED by run `31945047287` SUCCESS at branch-tip migration commit `0a26ccad`. Presenter comparison: **50.33% → 50.67% (+0.34%)**. Overall comparison: **23.16% → 23.28% (+0.12%)**. Document **0.47% → 0.47% (+0.00%)**; Classroom **33.33% → 33.33% (+0.00%)**; Recovery **20.00% → 20.00% (+0.00%)**. New comparison-column rule became authoritative.
- **2026-08-16 17:09 IST** - 15-minute live checkpoint. T31 service `c03fdf12` COMPLETE. T31 UT `6fdfc020` IMPLEMENTED; exact direct CI run `31944909840` was then in progress and was later superseded by a newer push. Presenter implementation progress **50.67%**; Recovery **20.00%**; Overall **23.28%**.
- **2026-08-16 17:07 IST** - `Presenter-Solutions-T31-T35` exists from exact verified Book registry SHA `277e9e08bd07fb04ad77b18bf4d78d8651c175b6`. Book Copy foundation was confirmed already present. Presenter-owned T31-T35/P07 service codes were added at `0bf2687e`. T31 Add Book Copy service was completed at `c03fdf12`, advancing Presenter progress to **50.33%** and overall to **23.16%**.
- **2026-08-16 16:54 IST** - Exact registry-tip run `31943292080` re-fetched and confirmed `SUCCESS` with head SHA `277e9e08bd07fb04ad77b18bf4d78d8651c175b6`. Presenter machine progress was advanced to T01-T30 VERIFIED / **50.00%**; recovery registry coverage advanced to 30/60 tracks / **20.00% weighted progress**. Overall recalculated to **23.05%**. T31 source contract recovered.
- **2026-08-16 16:33 IST** - Book cumulative source run `31942708483` is SUCCESS at `1b931bf9`. Full T26-T30 commit/path evidence was reconciled and `.presenter/solution-registry/T26-T30.yml` frozen at substantive commit `277e9e08`. Exact-tip verification run `31943292080` was IN PROGRESS.
- **2026-08-16 16:23 IST** - T28 cumulative CI is VERIFIED PASS (`31942385786`). T29 implemented through frontend; T30 implemented through frontend with branch tip `1b931bf9`. Cumulative T30 run `31942708483` was still running at this checkpoint. Document recovery expanded: canonical-source artifact was inspected and the 42-page Golden Reference rejected as a QG-27 substitute because its identity differs.
- **2026-08-16 16:15 IST** - T28 substantive implementation completed through frontend at `a56daf48`; Presenter CI run `31942385786` was IN PROGRESS. Document QG-27 failure diagnosed as `base64: invalid input` with payload-path/staging mismatch. Release-00 run `31930965288` SUCCESS. Publisher registry correction run `31934851302` SUCCESS.
- **2026-08-16 16:03 IST** - Document stream verified at `Document-Rerun-QG` commit `2ac05ce`; QG-27 remained open. Presenter stream verified at T27 frontend commit `efaf7fc`; T28 was next.

## Presenter Commit Evidence - T26-T30

### T26 - Create Book
- `f22c79e2` - Book service codes
- `52075fd5` - Create Book service
- `6b24585a` - Create Book unit tests
- `92921cf5` - normalized ISBN protection
- `4c077af6` - local PostgreSQL integration
- `61a6e5f6` - Testcontainers integration
- `991e3404` - Update Book recovery frontend

### T27 - Read Book
- `f3a6d6cb` - Read Book service
- `2cdc5a66` - Read Book unit tests
- `0e5a2907` - local PostgreSQL integration
- `ac1906da` - Testcontainers integration
- `efaf7fc8` - Deactivate Book recovery frontend

### T28 - Update Book
- `d8ed5d99` - Update Book service
- `055da66b` - Update Book unit tests
- `03fe8e81` - Update Book local PostgreSQL integration
- `95f15e7d` - Update Book Testcontainers integration
- `a56daf48` - Search Book recovery frontend
- Verification: run `31942385786` **SUCCESS**

### T29 - Deactivate Book
- `aea3df18` - Deactivate Book service
- `31ad8b57` - Deactivate Book unit tests
- `fa8cc20a` - Deactivate Book local PostgreSQL integration
- `972e5147` - Deactivate Book Testcontainers integration
- `9c1a840b` - Create Book recovery frontend

### T30 - Search Book
- `b3e639af` - current case-insensitive Book search DAO
- `78fa9fff` - Search Book service
- `73401663` - Search Book unit tests
- `cb9989a2` - Search Book local PostgreSQL integration
- `223ba0ed` - Search Book Testcontainers integration
- `1b931bf9` - Book List/Read recovery frontend
- Cumulative source verification: run `31942708483` **SUCCESS**
- Registry freeze: `277e9e08bd07fb04ad77b18bf4d78d8651c175b6` - `.presenter/solution-registry/T26-T30.yml`
- Registry-tip verification: run `31943292080` **SUCCESS**

## T31 Evidence

- `0bf2687e1c2eee622dae9aec6f46579cd9598304` - Presenter-owned Book Copy service codes T31-T35/P07.
- `c03fdf121118fdaad8467deec492e97c92c033d9` - Student 31 Add Book Copy service solution.
- `6fdfc020cb4f5561ac1558e7d41c3610b0392a20` - Student 31 Add Book Copy unit tests.
- `0a26ccad874be9a2cb1e990b167506c032eb71eb` - Presenter-owned normalized Book Copy accession unique key.
- Unit-test verification run `31945047287` - **SUCCESS** at `0a26ccad`; verifies the T31 unit-test commit in branch history plus V015 migration.
- Direct unit-test run `31944909840` - superseded/cancelled by the later branch push; not counted as a pass or failure.
- `599dac48aa4f406c7f69c87c147527d3c10f9973` - T31 Create Book Copy local PostgreSQL integration.
- `192761ab22e10361ecc6456fcfa59402e3d792c5` - T31 Create Book Copy PostgreSQL-18 Testcontainers integration.
- `9d2f5796edb1cd3bb34f56b0433c2c747687e5ed` - T31 Update Book Copy recovery frontend.
- Cumulative verification run `31945620654` - **SUCCESS** at exact substantive T31 tip `9d2f5796`.
- Final CI / registry checkpoint - **PENDING** until the T31-T35 batch registry is frozen and exact-tip CI passes.

## Document QG-27 Status

Accepted artifact identity:
- Size: `234444` bytes
- SHA-256: `c1e43a93f7355032b8cc650815621613bf3cb2012c446756068961d13bf7cce4`
- Git blob SHA: `853fe9b900ba04339441116bdf18e64289a59093`

Known evidence:
- QG-01 through QG-26 PASS.
- `Materialize T01_02 Final DOCX` run `31941294901` failed at reconstruction with `base64: invalid input`.
- Workflow reads top-level `automation/materialization/T01_02/part-*`, while newer staged payload exists under `automation/materialization/T01_02/final/part-*`; available staged pieces are incomplete for the accepted binary.
- Canonical-source workflow run `31939791535` is SUCCESS and artifact `9261693562` is intact; it contains 15 normalized sections, 4 Draw.io source diagrams and `QUALITY_REPORT_CONTENT.md`.
- That canonical-source package does not contain the accepted 55-page DOCX.
- The available 42-page Golden Reference has size `1433406`, SHA-256 `9210c21a1a4856a6d5f8f45738c7ee000808a987469f97a9ca784447e98988c7`, and is therefore not the accepted QG-27 artifact.

Do not approve QG-27 until the exact accepted binary is committed to Private Master, re-fetched and identity-verified.

## Release-02 Prerequisite

Before `Classroom-Release-02-Student-Baseline` is frozen, move the generic Presenter-owned controlled-error infrastructure into the student baseline:
- `ApplicationServiceException.java`
- `ApplicationServiceExceptionHandler.java`

## Hard Rules

1. No ChatGPT/automation write to Public.
2. No further ChatGPT/automation write to Quality Gate.
3. All project changes are committed only to Private Master.
4. Documents require QG-27 before approval.
5. Presenter solution code remains private.
6. Public publication is always performed by the Presenter.
7. Percentages use frozen formulas and completed implementation checkpoints; pending CI/registry verification gates are shown explicitly.
8. During active 15-minute execution windows, `.project/PROJECT_PROGRESS.md` must be updated as the authoritative status checkpoint record.
9. Every live progress table must show Previous %, Updated %, and Increase so the actual percentage movement is visible.
10. Increase is derived from underlying unrounded values; two-decimal displayed totals can differ by 0.01 percentage point when subtracted directly.
11. Every cycle must show tasks taken up, tasks closed, tasks still in progress, and tasks open for more than 3 completed cycles.
12. Every cycle must show streams with no percentage increase for more than 3 completed cycles.
13. `.project/execution-cycle-monitor.yml` is the machine-readable source for cycle-age and stalled-stream escalation.