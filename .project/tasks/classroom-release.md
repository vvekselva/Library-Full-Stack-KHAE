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
- **Agent 4:** Release-01 T01 document prerequisite and exact identity reconciliation.
- **Agent 5:** Release-02 accepted controlled-error baseline and remaining document-gate reconciliation.
- **Agent 7:** release manifest/checklist consistency and no-public-write guard.

## Current verified state
### Release-01
- Complete T01 repository presence/re-fetch is proven on read-only `Document-Rerun-QG` at `Documents/Student-Guides/Department/T01_Create_Department/`.
- Exact blobs are now synchronized into the private manifest/checklist:
  - T01_01 `b6bb206b9c3cb1b06175a29f97c764bf3e866d9b`.
  - T01_02 `41c746d55d44ab944ee42a4c0ab73f6c7f381607`.
  - T01_03 `fb3e68db5526dbcb5a03732feac1da67dda11608`.
- Read-only QG branch tip observed: `c951f0e331007820997c590156cd14000b7c07b8`.
- T01_02 remains APPROVED/repository-verified.
- T01_01/T01_03 remain QUALITY_GATE_PASSED but still require the Document process's dedicated identity-control reconciliation before APPROVED/REPOSITORY_VERIFIED status.
- Private manifest reconciliation commit: `ad145529ef45126b2d3f7c3130e3ae9b78057d2f`.
- Private validation-checklist reconciliation commit: `77359328a75de11cf0932b13e83cefbb7bdfa7be`.

### Release-02
- Controlled-error acceptance remains CLOSED GREEN.
- Accepted student baseline is now exactly `Frontend-backend-Baseline@24179fb905fd69f816bfeb5db0ee7206401a3ceb`.
- Generic exception blob `6f3475ee7996fe761333810e92490df764c9e958` and global handler blob `f2b13a8e782705239a9ad821926b1f5beb1422f4` are accepted.
- Response codes `01` through `05` are verified by the accepted baseline test evidence.
- Run `31989985693`: backend `95271686668` SUCCESS; frontend `95271686680` SUCCESS.
- Private Release-02 manifest/checklist was corrected from the historical pre-remediation SHA to the accepted identity at commit `bb5679a207f99916c3c1420c6a4e2cb55db8baf5`.
- Release-02 remains blocked only by its required approved/repository-verified rerun documents and later private candidate checks; controlled-error infrastructure is no longer a blocker.

## Current stream accounting
- Previous: **33.3333%**
- Updated: **33.3333%**
- Increase: **+0.0000%**
- State: **STALE BY PERCENTAGE / SUBSTANTIVE PRIVATE PREPARATION ADVANCED**.

No release percentage is credited because no release materialization/freeze checkpoint completed.

## Tasks Taken Up This Cycle
- Reconcile Release-01 exact T01 paths/blobs into the private selection manifest and validation checklist.
- Reconcile Release-02 private manifest from historical pre-remediation identity to the accepted controlled-error baseline.
- Preserve all private/public/QG promotion boundaries during Presenter CI wait windows.

## Tasks Closed This Cycle
- Release-01 exact artifact-identity placeholders — CLOSED; all three T01 paths/blobs are now explicit in private release controls.
- Release-02 stale pre-remediation baseline identity in private manifest — CLOSED; accepted baseline/evidence is synchronized.

## Tasks In Progress / Blocked
- Release-01 materialization/freeze — BLOCKED by T01_01/T01_03 Document identity-control reconciliation and APPROVED/REPOSITORY_VERIFIED status.
- Release-02 materialization/freeze — BLOCKED by required approved/repository-verified rerun documents; controlled-error acceptance is complete.
- Presenter publication — PRESENTER ONLY.

## Open More Than 3 Cycles / Action Taken in This Cycle
- Release-01/Release-02 release progression remains open beyond 3 completed cycles. Action: removed stale identity uncertainty from both private manifests, captured immutable T01 artifacts, and synchronized the accepted Release-02 controlled-error baseline without materializing or publishing a blocked candidate.

## Action Taken in This Cycle
Used Presenter CI wait windows for independent private preparation: exact T01 immutable artifact identities were written into Release-01 controls, and Release-02 controls were corrected to the accepted remediated baseline and green acceptance run. No Public write and no Quality Gate write occurred.
