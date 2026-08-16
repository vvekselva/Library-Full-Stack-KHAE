# KHAE Full Stack - Live Project Progress

This file is the private, authoritative execution dashboard for the KHAE Full Stack classroom preparation project.

## Repository Roles

- Public classroom repository: `vvekselva/Library-Full-Stack-KHAE`
  - Presenter-controlled publication only.
  - ChatGPT/automation does not write to this repository.
- Private Master repository: `vvekselva/Library-Full-Stack-KHAE-Master`
  - The only repository where ChatGPT/automation commits project code, approved document candidates, release snapshots, progress files, and recovery assets.
- Quality Gate repository: `vvekselva/Library_KAHE_PRIVATE_RERUN`
  - Read-only quality authority for ChatGPT/automation.
  - Supplies the Golden Reference, `QUALITY_GATE.md`, `GENERATION_PROTOCOL.md`, and quality checkpoints.

## Frozen Progress Formula

Overall progress is calculated with these fixed weights:

- Document rerun: 45%
- Presenter solutions: 35%
- Classroom release preparation: 10%
- Recovery and final integration: 10%

`Overall = Documents*0.45 + PresenterSolutions*0.35 + ClassroomReleases*0.10 + Recovery*0.10`

### Document stage values

- PENDING = 0%
- BLUEPRINTING = 10%
- BLUEPRINT APPROVED = 20%
- GENERATING = 40%
- CONTENT QA = 55%
- VISUAL QA = 70%
- QUALITY GATE PASSED = 85%
- REPOSITORY VERIFIED = 95%
- APPROVED = 100%

Document stream progress is the average across all 180 required DOCX artifacts.

### Presenter solution stage values

Each student track has five equal checkpoints:

1. Service = 20%
2. Unit Test = 20%
3. Integration/Testcontainers = 20%
4. Frontend = 20%
5. Final CI + Solution Registry = 20%

Presenter solution stream progress is the average across T01-T60.

### Classroom release stage values

Each private classroom release has five equal gates:

1. Source identified = 20%
2. Contents audited = 20%
3. Private release branch frozen = 20%
4. Build/verification passed = 20%
5. Presenter-ready = 20%

The stream covers Release-00, Release-01, and Release-02. Publication to the Public repository is a Presenter action and is not included in this percentage.

### Recovery stage values

Recovery progress is split as follows:

- Verified solution-registry coverage for T01-T60 = 40%
- Recovery selection/dependency design = 20%
- Private recovery workflow implementation = 20%
- Full classroom recovery rehearsal = 20%

## Current Status - 2026-08-16

| Stream | Progress | Current Stage |
|---|---:|---|
| Document Rerun | 0.22% | T01_02 is GENERATING; Sections 01 and 02 are committed |
| Presenter Solutions | 25.67% | T01-T15 verified; T16 Service + Unit Test implemented; CI running |
| Classroom Release Preparation | 20.00% | Release-00 source audited and private branch frozen; build verification pending |
| Recovery / Final Integration | 10.00% | Verified recovery registries cover T01-T15; workflow not yet implemented |
| **Overall** | **12.08%** | Parallel execution active |

## Active Work

- Document: T01_02 Section 03 - Empty Service and First JUnit Invocation.
- Presenter code: T16 Create Category - CI run `31930163407`, then Integration/Testcontainers checkpoint.
- Classroom release: `Classroom-Release-00-Empty` verification/build gate.
- Recovery: extend registry coverage as each Presenter solution stage becomes verified.

## Release Prerequisite Discovered

Before `Classroom-Release-02-Student-Baseline` is frozen, the generic Presenter-owned controlled-error infrastructure must be present in the student baseline:

- `ApplicationServiceException.java`
- `ApplicationServiceExceptionHandler.java`

These classes currently exist in the verified Presenter-solution lineage but not in `Frontend-backend-Baseline`. Students must not be required to create this shared infrastructure.

## Hard Rules

1. No ChatGPT/automation write to the Public classroom repository.
2. No further ChatGPT/automation write to the Quality Gate repository.
3. All project changes are committed only to the Private Master repository.
4. A document is not approved until it passes the Golden Reference Quality Gate and final artifact verification.
5. QG-27 materialization/re-fetch/hash verification is performed against the private `Document-Rerun-QG` branch.
6. Presenter solution code remains private.
7. Public publication is always performed by the Presenter.
8. Progress percentages must use the fixed formulas in this file; they must not be changed merely to make progress appear faster.
