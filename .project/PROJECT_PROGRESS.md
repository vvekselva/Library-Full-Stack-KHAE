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

## Current Status - 2026-08-16 17:09 IST

| Stream | Progress | Current Stage |
|---|---:|---|
| Document Rerun | **0.47%** | T01_02 QG-01 to QG-26 PASS; QG-27 OPEN. Exact accepted binary identity is unchanged. Materialization run `31941294901` failed with `base64: invalid input`. Successful canonical-source artifact `T01_02-canonical-source` from run `31939791535` contains normalized teaching source, editable Draw.io sources and content QA, but not the accepted 55-page DOCX. The available 42-page Golden Reference does not match the accepted artifact and will not be substituted. |
| Presenter Solutions | **50.67%** | **T01-T30 VERIFIED; T31 Service COMPLETE; T31 UT IMPLEMENTED / CI PENDING.** Branch `Presenter-Solutions-T31-T35`; service `c03fdf12`; unit test `6fdfc020`; exact UT CI run `31944909840` is IN PROGRESS. Next gate: CI verification, then PostgreSQL integration. |
| Classroom Release Preparation | **33.33%** | Release-00 remains Presenter-ready and independently VERIFIED PASS by run `31930965288`. Release-01/02 pending. |
| Recovery / Final Integration | **20.00%** | Verified solution-registry coverage remains **30/60 tracks = 50% coverage × 40% recovery weight = 20.00%**. T31-T35 is not recoverable yet because its registry must be frozen only after cumulative CI. |
| **Overall** | **23.28%** | `0.4722×0.45 + 50.6667×0.35 + 33.3333×0.10 + 20×0.10 = 23.2792%`, displayed as 23.28%. Parallel execution continues with T31 verification/integration. |

## Active Work

- **Presenter code:** T31 Add Book Copy service is complete at `c03fdf121118fdaad8467deec492e97c92c033d9`. Unit tests are implemented at `6fdfc020cb4f5561ac1558e7d41c3610b0392a20`; exact CI run `31944909840` is in progress. The tests cover successful normalized create, null request, null/blank accession with exact `ACCESSION_NUMBER_REQUIRED`, missing Book ID, and duplicate accession behavior.
- **T31 exact teaching contract:** Student 31; Book Copy Management; Add Book Copy Service; `POST /rest/book-copies`; business key Accession Number; null `accessionNumber` must surface the intended unit-test discovery before controlled correction; persisted duplicate Accession Number must be rejected in integration; assignment-plan test value `ACC-000101`; assigned frontend is Update Book Copy UI `PUT /rest/book-copies/{id}` against Student 32's backend without changing the `/rest/` contract.
- **Source discrepancy retained explicitly:** the current 60-student assignment plan specifies null `accessionNumber` / `ACCESSION_NUMBER_REQUIRED` and duplicate `ACC-000101`; the later consistency-audit register uses generic null-request / `ACC-0001`. Student-facing implementation follows the assignment plan; schema/audit data is used only for repository compatibility.
- **Next T31 database step:** add Presenter-owned normalized uniqueness protection for Book Copy accession numbers following the existing V014 Book pattern, then add local PostgreSQL integration and Testcontainers integration. The database gate must prove persisted duplicate `ACC-000101` is rejected even with normalized input.
- **Document:** continue QG-27 recovery from canonical source/history without substituting a different DOCX. Exact accepted target remains size `234444`, SHA-256 `c1e43a93f7355032b8cc650815621613bf3cb2012c446756068961d13bf7cce4`, Git blob `853fe9b900ba04339441116bdf18e64289a59093`.
- **Recovery:** T01-T30 registry coverage is verified. The T31-T35 registry remains NOT_YET_CREATED and must be built only from exact verified component SHAs after cumulative CI.
- **Classroom release:** Release-00 remains verified. Release-01/02 work must preserve Presenter/student ownership boundaries and the Release-02 exception-infrastructure prerequisite.

## 15-Minute Execution Checkpoint Protocol

During an active execution window, each approximately 15-minute checkpoint must also update this file on `main` with evidence-based status. The checkpoint entry must record the timestamp, active branch/task, latest substantive branch commit, percentages, blockers, and the next concrete action. A real checkpoint crossing is written immediately even if it occurs before the 15-minute heartbeat. A heartbeat-only code commit must not be created merely to manufacture activity; this dashboard update is the status record.

### Checkpoint Log

- **2026-08-16 17:09 IST** - 15-minute live checkpoint. T31 service `c03fdf12` COMPLETE. T31 UT `6fdfc020` IMPLEMENTED; exact branch CI run `31944909840` is IN PROGRESS. Presenter implementation progress **50.67%**; Recovery **20.00%**; Overall **23.28%**. Next: consume CI result, then add normalized Book Copy uniqueness migration and T31 PostgreSQL integration test. No QG-27 or Release stream percentage change during this interval.
- **2026-08-16 17:07 IST** - `Presenter-Solutions-T31-T35` exists from exact verified Book registry SHA `277e9e08bd07fb04ad77b18bf4d78d8651c175b6`. Book Copy foundation was confirmed already present. Presenter-owned T31-T35/P07 service codes were added at `0bf2687e`. T31 Add Book Copy service was completed at `c03fdf12`, advancing Presenter progress to **50.33%** and overall to **23.16%**. Next: implement T31 unit tests proving the null-accession controlled correction and happy-path persistence interaction.
- **2026-08-16 16:54 IST** - Exact registry-tip run `31943292080` re-fetched and confirmed `SUCCESS` with head SHA `277e9e08bd07fb04ad77b18bf4d78d8651c175b6`. Presenter machine progress was advanced to T01-T30 VERIFIED / **50.00%**; recovery registry coverage advanced to 30/60 tracks / **20.00% weighted progress**. Overall recalculated to **23.05%**. T31 source contract recovered: Add Book Copy Service, `POST /rest/book-copies`, Accession Number business key, null-request-field unit discovery, duplicate persisted accession integration discovery, Update Book Copy UI. Next: create `Presenter-Solutions-T31-T35` from the exact verified SHA and implement T31 service.
- **2026-08-16 16:33 IST** - Book cumulative source run `31942708483` is SUCCESS at `1b931bf9`. Full T26-T30 commit/path evidence was reconciled and `.presenter/solution-registry/T26-T30.yml` frozen at substantive commit `277e9e08`. Exact-tip verification run `31943292080` was IN PROGRESS. Next was to promote Book T26-T30 on green.
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
- `6fdfc020cb4f5561ac1558e7d41c3610b0392a20` - Student 31 Add Book Copy unit tests; CI run `31944909840` IN PROGRESS at 17:09 IST.
- Local PostgreSQL integration - PENDING.
- Testcontainers integration - PENDING.
- Frontend - PENDING.
- Cumulative CI / registry - PENDING.

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
