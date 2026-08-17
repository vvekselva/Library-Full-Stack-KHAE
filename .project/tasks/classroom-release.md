# Classroom Release Preparation Task Queue

**Stream weight:** 10% — SUPPORTING.  
**Active logical workers:** Agents 4, 5 and 7.  
**Public repository publication:** Presenter-only/manual. ChatGPT/automation must not write to the public classroom repository.

## Dependency rules
1. Release preparation may advance independently when it does not require unapproved documents.
2. A release stage that includes rerun documents must not be promoted before those documents are APPROVED and repository-verified in Private Master.
3. Do not create a public publication commit from ChatGPT/automation.
4. Before Release-02, generic controlled-error infrastructure required by student exercises must be present in the approved student baseline and exact-source identity plus acceptance behavior must be verified.
5. Release validation must use exact source/document identities.

## Current three-lane allocation
- **Agent 4:** Release-01 prerequisite/evidence audit — CLOSED; candidate materialization remains blocked by T01_01/T01_03 repository verification.
- **Agent 5:** Release-02 controlled-error prerequisite + private acceptance — CLOSED GREEN.
- **Agent 7:** Release manifest/checklist/promotion-boundary audit — CLOSED; no public write.

## Release-02 acceptance evidence
- Exact Presenter-owned `ApplicationServiceException` blob in approved baseline: `6f3475ee7996fe761333810e92490df764c9e958`.
- Exact Presenter-owned `ApplicationServiceExceptionHandler` blob in approved baseline: `f2b13a8e782705239a9ad821926b1f5beb1422f4`.
- Added private acceptance test commit `24179fb905fd69f816bfeb5db0ee7206401a3ceb`, explicitly proving frozen controlled response codes `01`, `02`, `03`, `04`, and `05` through the Presenter-owned handler/envelope.
- Baseline acceptance run `31989985693`: backend `95271686668` SUCCESS; frontend `95271686680` SUCCESS.
- Acceptance map synchronized at `.project/classroom-release/Release-02-controlled-error-acceptance-map.md`, commit `27f26e59d2841b45b09ab865a836bd52fa351ec6`.

## Current document dependency
- T01_02 is APPROVED and repository-verified.
- T01_01 and T01_03 are QUALITY_GATE_PASSED but still await repository materialization/re-fetch verification.
- T02_01-T06_01 are APPROVED; T02_02-T06_02 remain GENERATING; none is assigned to the current eight logical worker lanes.

## Current stream accounting
- Previous: **33.3333%**
- Updated: **33.3333%**
- Increase: **+0.0000%**
- State: **STALE BY PERCENTAGE / RELEASE-02 CONTROLLED-ERROR ACCEPTANCE CLOSED; DOCUMENT RELEASE GATES REMAIN**.

## Tasks Taken Up / Closed This Cycle
- Release-02 remediated baseline backend/frontend acceptance — CLOSED GREEN.
- Explicit response-code `01`-`05` proof — CLOSED GREEN.
- Release-01 document and public-promotion boundaries — preserved; no public or Quality Gate write.

## Tasks In Progress / Blocked
- Release-01 materialization/freeze — BLOCKED by T01_01/T01_03 repository verification.
- Release-02 materialization/freeze — BLOCKED by required approved/repository-verified rerun documents; controlled-error infrastructure is no longer a blocker.
- Presenter publication — PRESENTER ONLY.

## Action Taken in This Cycle
Closed the private Release-02 controlled-error acceptance gate rather than stopping at source identity. The exact Presenter classes are in the approved baseline, a focused parameterized acceptance test proves response codes `01`-`05`, and run `31989985693` is green for both backend and frontend. No release percentage is credited because required document/promotion checkpoints remain incomplete. No public classroom or read-only Quality Gate write occurred.

## Completion rule
Private source/acceptance work may close independently, but no release percentage is credited until the defined release checkpoint with all required approved documents is complete. No public repository write is permitted.
