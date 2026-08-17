# Classroom Release Preparation Task Queue

**Stream weight:** 10% — SUPPORTING.  
**Active logical workers:** Agents 4, 5 and 7.  
**Public repository publication:** Presenter-only/manual. ChatGPT/automation must not write to the public classroom repository.

## Dependency rules
1. Release preparation may advance independently when it does not require unapproved documents.
2. A release stage that includes rerun documents must not be promoted before those documents are APPROVED and repository-verified in Private Master.
3. Do not create a public publication commit from ChatGPT/automation.
4. Before Release-02, generic controlled-error infrastructure required by student exercises must be present in the approved student baseline.
5. Release validation must use exact source/document identities.

## Current three-lane allocation
- **Agent 4:** Release-01 prerequisite/evidence audit and exact selected-document identity verification — PRIVATE AUDIT CLOSED; candidate materialization remains blocked.
- **Agent 5:** Release-02 controlled-error remediation acceptance mapping — previously CLOSED; current baseline prerequisite remains unmet and was revalidated without claiming a new release gate.
- **Agent 7:** Release manifest/checklist consistency plus private promotion-boundary verification — PRIVATE AUDIT CLOSED; stale Release-01 document-status wording synchronized.

## Task queue
| Task | Status | Dependency / evidence |
|---|---|---|
| Verify Release-00 baseline | VERIFIED | Existing verification run `31930965288` |
| Reconcile Release-00 manifest | DONE | `951c9abb...` |
| Prepare Release-01 selection manifest | DONE | `5fe51ba6...`; status wording synchronized this cycle at `e4c7c7925d547223c7098f2189b95b0370fa28ec` |
| Prepare Release-01 validation checklist | DONE | `f0a54125...` |
| Prepare Release-01 private promotion structure | DONE | `dd71bd33...` |
| Audit Release-01 selected document identities | DONE — AGENT 4 | Private audit `ec0760de4534bb6870e68527d688abc9bf29ca88`; T01_01/T01_03 repository verification still blocks materialization |
| Materialize approved T01 rerun set | BLOCKED | T01_01/T01_03 repository verification incomplete |
| Run/freeze Release-01 candidate | BLOCKED | Candidate materialization required |
| Presenter publication Release-01 | PRESENTER ONLY | Automation forbidden |
| Verify Release-02 controlled-error prerequisite | DONE — VERIFIED MISSING | Frozen `Frontend-backend-Baseline@345d0abe...`; evidence `6ba32469...` |
| Prepare Release-02 manifest/checklist | DONE | Private conditional structure |
| Define Release-02 prerequisite remediation | DONE | `.project/classroom-release/Release-02-controlled-error-remediation.md`, commit `16382810ef29e68d0eac088f90b1626052c0edd9` |
| Map Release-02 remediation acceptance evidence | DONE — AGENT 5 | `.project/classroom-release/Release-02-controlled-error-acceptance-map.md`, commit `96ba936796e6dc418764568115f52299bf4192cf` |
| Verify manifest/checklist/promotion boundary consistency | DONE — AGENT 7 | Private audit `f22fef99b99f55f0eb3a411fc1fbad510a758637`; manifest sync `e4c7c7925d547223c7098f2189b95b0370fa28ec` |
| Materialize/validate/freeze Release-02 | BLOCKED | Requires approved student baseline containing controlled-error layer + approved document prerequisites |
| Presenter publication Release-02 | PRESENTER ONLY | Automation forbidden |

## Current document dependency
- T01_02 is APPROVED and repository-verified.
- T01_01 and T01_03 are QUALITY_GATE_PASSED but still await repository materialization/re-fetch verification.
- T02_01-T06_01 are APPROVED; T02_02-T06_02 are GENERATING; none was assigned to the current eight logical worker lanes.

## Current stream accounting
- Previous: **33.3333%**
- Updated: **33.3333%**
- Increase: **+0.0000%**
- State: **STALE BY PERCENTAGE / PRIVATE RELEASE AUDITS ADVANCED; RELEASE GATES REMAIN BLOCKED**.

## Tasks Taken Up / Closed This Cycle
- Agent 4 Release-01 identity audit: TAKEN UP and CLOSED at `ec0760de...`.
- Agent 5 Release-02 acceptance-map prerequisite: revalidated; no new percentage-bearing task was claimed.
- Agent 7 boundary consistency audit: TAKEN UP and CLOSED at `f22fef99...`; stale manifest wording synchronized at `e4c7c792...`.

## Action Taken in This Cycle
Resolved the outstanding Release-01 identity/boundary preparation rather than re-reporting the blocker. The audits prove T01_01/T01_03 still block candidate materialization, identify and correct stale T02-T06 status wording, and preserve Presenter-only publication. No public or Quality Gate write occurred.

## Completion rule
Private audits may close independently with exact evidence, but no release percentage is credited until its defined release gate completes. No public repository write is permitted.
