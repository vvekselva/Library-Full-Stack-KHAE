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

## Current Status - 2026-08-16 16:33 IST

| Stream | Progress | Current Stage |
|---|---:|---|
| Document Rerun | **0.47%** | T01_02 QG-01 to QG-26 PASS; QG-27 OPEN. Exact accepted binary identity is unchanged. Materialization run `31941294901` failed with `base64: invalid input`. Successful canonical-source artifact `T01_02-canonical-source` from run `31939791535` contains normalized teaching source, editable Draw.io sources and content QA, but not the accepted 55-page DOCX. The available 42-page Golden Reference does not match the accepted artifact and will not be substituted. |
| Presenter Solutions | **42.67%** | **T26-T30 Book source CI PASS**: run `31942708483`, source SHA `1b931bf9`. Auditable registry `.presenter/solution-registry/T26-T30.yml` frozen at commit `277e9e08`. Registry-tip verification run `31943292080` is **IN PROGRESS**. T26-T30 will move to VERIFIED/100% only if this exact-tip run succeeds. |
| Classroom Release Preparation | **33.33%** | Release-00 remains Presenter-ready and independently VERIFIED PASS by run `31930965288`. Release-01/02 pending. |
| Recovery / Final Integration | **13.33%** | Publisher T21-T25 corrected registry remains VERIFIED SUCCESS by run `31934851302`; verified recovery through T20 is preserved. Book T26-T30 recovery promotion waits for registry-tip CI `31943292080`. |
| **Overall** | **19.81%** | Parallel execution active. Frozen percentages remain unchanged until defined completion checkpoints are crossed. |

## Active Work

- **Presenter code:** Book T26-T30 registry freeze is committed at `277e9e08bd07fb04ad77b18bf4d78d8651c175b6`. Run `31943292080` verifies that exact branch tip with PostgreSQL/Maven tests and the Vite frontend build. On PASS, mark T26-T30 VERIFIED, extend recovery status, create `Presenter-Solutions-T31-T35` from the verified tip, recover the exact Book Copy contracts and start T31.
- **Document:** continue QG-27 recovery from canonical source/history without substituting a different DOCX. Exact accepted target remains size `234444`, SHA-256 `c1e43a93f7355032b8cc650815621613bf3cb2012c446756068961d13bf7cce4`, Git blob `853fe9b900ba04339441116bdf18e64289a59093`.
- **Recovery:** preserve Publisher T21-T25 verified registry; promote Book T26-T30 only after the exact registry-tip CI succeeds.
- **Classroom release:** Release-00 remains verified. Release-01/02 work must preserve Presenter/student ownership boundaries and the Release-02 exception-infrastructure prerequisite.

## 15-Minute Execution Checkpoint Protocol

During an active execution window, each 15-minute checkpoint must also update this file on `main` with evidence-based status. The checkpoint entry must record the timestamp, active branch/task, latest substantive branch commit, blockers, and the next concrete action. A heartbeat-only code commit must not be created merely to manufacture activity; this dashboard update is the status record.

### Checkpoint Log

- **2026-08-16 16:33 IST** - Book cumulative source run `31942708483` is SUCCESS at `1b931bf9`. Full T26-T30 commit/path evidence was reconciled and `.presenter/solution-registry/T26-T30.yml` frozen at substantive commit `277e9e08`. Exact-tip verification run `31943292080` is IN PROGRESS. Next: if green, promote Book T26-T30 to VERIFIED/100%, update recovery/progress registries, create `Presenter-Solutions-T31-T35` from `277e9e08`, recover T31-T35 Book Copy contracts, and begin T31. QG-27 exact-DOCX recovery remains open independently.
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
- Registry freeze: `277e9e08` - `.presenter/solution-registry/T26-T30.yml`
- Registry-tip verification: run `31943292080` **IN PROGRESS**

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
7. Percentages use frozen formulas and completed checkpoints; pending CI/registry gates are shown explicitly.
8. During active 15-minute execution windows, `.project/PROJECT_PROGRESS.md` must be updated as the authoritative status checkpoint record.
