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

## Current Status - 2026-08-16

| Stream | Progress | Current Stage |
|---|---:|---|
| Document Rerun | **0.47%** | T01_02 QG-01 to QG-26 PASS; only QG-27 Private Master binary materialization/hash verification remains |
| Presenter Solutions | **42.67%** | T01-T20 fully verified; T21-T25 implementation complete with registry correction CI running; T26 and T27 at 80% |
| Classroom Release Preparation | **33.33%** | Release-00 is Presenter-ready; Release-01/02 pending |
| Recovery / Final Integration | **13.33%** | Fully verified recovery registries cover T01-T20; Publisher correction validation running |
| **Overall** | **19.81%** | Parallel execution active |

## Active Work

- Document: close T01_02 QG-27 by committing the exact accepted DOCX binary to `Document-Rerun-QG`, re-fetching it, and verifying SHA-256 `c1e43a93f7355032b8cc650815621613bf3cb2012c446756068961d13bf7cce4`.
- Presenter code: `Presenter-Solutions-T26-T30`; T26 Create Book and T27 Read Book have Service, Unit Test, Integration/Testcontainers, and assigned frontend components implemented.
- Publisher recovery registry: corrected T22 frontend path is under CI run `31934851302`.
- Book CI: cumulative Book branch CI is running after T27 implementation.
- Classroom release: `Classroom-Release-00-Empty` remains Presenter-ready; no Public write is performed by ChatGPT.

## Completed Since Previous Dashboard

- T01_02 assembled to a 55-page DOCX and passed QG-25/QG-26; exact current binary was re-rendered and all 55 pages match the reviewed render set byte-for-byte.
- T21-T25 Publisher implementation completed and source-tip CI passed.
- Publisher T21-T25 solution registry was created; one T22 file-path typo was detected during reuse, corrected, and is being revalidated.
- Successive Book stage `Presenter-Solutions-T26-T30` created.
- T26 Create Book: service codes, service, Mockito Unit Tests, normalized-ISBN migration, local PostgreSQL integration, PostgreSQL Testcontainers, and Update Book frontend implemented.
- T27 Read Book: service, Mockito Unit Tests, local PostgreSQL current/inactive integration, PostgreSQL Testcontainers, and Deactivate Book frontend implemented.

## Document QG-27 Blocker

The accepted T01_02 DOCX is locally verified but the current GitHub connector's normal contents API is text-oriented and does not directly accept the local binary file path. QG-27 remains open until an exact Private Master artifact is physically committed and re-fetched/hash-verified. This blocker does not stop independent Presenter-code work.

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
