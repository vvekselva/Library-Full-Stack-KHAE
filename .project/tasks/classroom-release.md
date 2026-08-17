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
- **Agent 4:** Release-01 T01 document prerequisite/re-fetch audit.
- **Agent 5:** Release-02 controlled-error acceptance / remaining document-gate revalidation.
- **Agent 7:** release manifest/promotion boundary and no-public-write guard.

## Current verified state
- Release-02 controlled-error private acceptance remains CLOSED GREEN on run `31989985693`.
- T01_02 remains APPROVED and repository-verified.
- This cycle directly re-fetched the complete T01 three-document set from the read-only `Document-Rerun-QG` branch:
  - `T01_01_Initial_API_Contract.docx` blob `b6bb206b9c3cb1b06175a29f97c764bf3e866d9b`.
  - `T01_02_Progressive_Development_Guide.docx` blob `41c746d55d44ab944ee42a4c0ab73f6c7f381607`.
  - `T01_03_Updated_API_Contract.docx` blob `fb3e68db5526dbcb5a03732feac1da67dda11608`.
- Private audit evidence: `.project/classroom-release/Release-01-T01-re-fetch-audit-2026-08-17.md`, commit `3bdf4e1383ee67d490e1ff7bf9161a80e7fe1cc8`.
- The blocker is therefore narrowed: T01_01/T01_03 are materialized and re-fetchable, but the Document control process still needs the dedicated identity-control reconciliation required before APPROVED status. Presence alone was not treated as approval.
- T02_01-T06_01 remain APPROVED; T02_02-T06_02 remain GENERATING and were not assigned to the current eight logical lanes.

## Current stream accounting
- Previous: **33.3333%**
- Updated: **33.3333%**
- Increase: **+0.0000%**
- State: **STALE BY PERCENTAGE / SUBSTANTIVE PRIVATE DEPENDENCY NARROWING**.

No release percentage is credited because no release materialization/freeze checkpoint completed.

## Tasks Taken Up This Cycle
- Re-fetch Release-01 T01 document identities from the read-only QG branch.
- Revalidate Release-02 remaining prerequisites after controlled-error acceptance.
- Preserve private/public promotion boundaries.

## Tasks Closed This Cycle
- Release-01 uncertainty that T01_01/T01_03 were absent from repository materialization — CLOSED; both are directly re-fetchable with immutable blob identities.

## Tasks In Progress / Blocked
- Release-01 materialization/freeze — BLOCKED by T01_01/T01_03 identity-control reconciliation/APPROVED status.
- Release-02 materialization/freeze — BLOCKED by required approved/repository-verified rerun documents.
- Presenter publication — PRESENTER ONLY.

## Action Taken in This Cycle
Used the Presenter CI wait window for a read-only QG re-fetch rather than a status-only poll. The exact T01_01/T01_02/T01_03 repository blobs were captured in a private audit, narrowing Release-01's blocker to identity-control reconciliation. No Public write and no Quality Gate write occurred.
