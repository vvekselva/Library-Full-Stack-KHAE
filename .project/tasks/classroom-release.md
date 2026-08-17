# Classroom Release Preparation Task Queue

**Stream weight:** 10% — SUPPORTING.  
**Active logical workers:** Agents 4, 5 and 7.  
**Public publication:** Presenter-only/manual. No ChatGPT/automation write is permitted to the public classroom repository.

## Dependency rules
1. Private release preparation may advance independently only where it does not consume unapproved documents.
2. Any release including rerun documents remains blocked until the required documents are APPROVED and repository-verified.
3. No automated public publication commit.
4. Release validation must use exact source/document identities.
5. Quality Gate is read-only.

## Current three-lane allocation
- **Agent 4:** Release-01 T01 document prerequisite and exact identity guard.
- **Agent 5:** Release-02 accepted controlled-error baseline and remaining document-gate guard.
- **Agent 7:** release manifest/checklist consistency and no-public-write guard.

## Current verified state
### Release-01
- Exact private manifest/checklist identities remain synchronized: T01_01 `b6bb206b9c3cb1b06175a29f97c764bf3e866d9b`, T01_02 `41c746d55d44ab944ee42a4c0ab73f6c7f381607`, T01_03 `fb3e68db5526dbcb5a03732feac1da67dda11608`.
- T01_02 is APPROVED/repository-verified.
- T01_01/T01_03 remain QUALITY_GATE_PASSED and still require the dedicated Document identity-control transition before release consumption.
- Therefore Release-01 materialization/freeze remains blocked.

### Release-02
- Controlled-error acceptance remains CLOSED GREEN on accepted baseline `Frontend-backend-Baseline@24179fb905fd69f816bfeb5db0ee7206401a3ceb`.
- Acceptance run `31989985693`: backend `95271686668` SUCCESS; frontend `95271686680` SUCCESS.
- Remaining blocker is approved/repository-verified rerun documents plus later private candidate checks.

## Current stream accounting
- Previous: **33.3333%**
- Updated: **33.3333%**
- Increase: **+0.0000%**
- State: **STALE BY PERCENTAGE / RELEASES REMAIN DOCUMENT-GATED**.

## Tasks Taken Up This Cycle
- Revalidate Release-01 exact document status against authoritative Document/Project controls.
- Revalidate Release-02 accepted controlled-error baseline and remaining document dependency.
- Recheck private/public/QG promotion boundary while Presenter T41 CI completed.

## Tasks Closed This Cycle
- No percentage-bearing Classroom task closed this cycle.

## Tasks In Progress / Blocked
- Release-01 materialization/freeze — BLOCKED by T01_01/T01_03 Document identity-control transition to APPROVED/REPOSITORY_VERIFIED.
- Release-02 materialization/freeze — BLOCKED by required approved/repository-verified rerun documents.
- Presenter publication — PRESENTER ONLY.

## Open More Than 3 Cycles / Action Taken in This Cycle
Release progression remains open beyond 3 completed cycles. Action Taken in This Cycle: revalidated both private release gates from exact existing evidence and preserved the no-public/no-QG boundary; no status-only check was counted as percentage progress.

## Action Taken in This Cycle
Agents 4, 5 and 7 performed dependency-safe private release verification during the Presenter CI window. No candidate was materialized because the document gates are still unsatisfied. No Public write and no Quality Gate write occurred.
