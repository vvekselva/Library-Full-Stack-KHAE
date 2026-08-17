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
- **Agent 5:** Release-02 controlled-error prerequisite — LIVE REVALIDATION CLOSED; approved baseline still lacks both exact generic controlled-error classes.
- **Agent 7:** Release manifest/checklist consistency plus private promotion-boundary verification — PRIVATE AUDIT CLOSED; no public write.

## Task queue
| Task | Status | Dependency / evidence |
|---|---|---|
| Verify Release-00 baseline | VERIFIED | Existing verification run `31930965288` |
| Reconcile Release-00 manifest | DONE | `951c9abb...` |
| Prepare Release-01 selection manifest | DONE | `5fe51ba6...`; synchronized at `e4c7c7925d547223c7098f2189b95b0370fa28ec` |
| Prepare Release-01 validation checklist | DONE | `f0a54125...` |
| Prepare Release-01 private promotion structure | DONE | `dd71bd33...` |
| Audit Release-01 selected document identities | DONE — AGENT 4 | Private audit `ec0760de4534bb6870e68527d688abc9bf29ca88`; T01_01/T01_03 repository verification still blocks materialization |
| Materialize approved T01 rerun set | BLOCKED | T01_01/T01_03 repository verification incomplete |
| Run/freeze Release-01 candidate | BLOCKED | Candidate materialization required |
| Presenter publication Release-01 | PRESENTER ONLY | Automation forbidden |
| Verify Release-02 controlled-error prerequisite | DONE — VERIFIED MISSING | Approved `Frontend-backend-Baseline`; both exact prerequisite paths return 404 in live revalidation |
| Prepare Release-02 manifest/checklist | DONE | Private conditional structure |
| Define Release-02 prerequisite remediation | DONE | `.project/classroom-release/Release-02-controlled-error-remediation.md`, commit `16382810ef29e68d0eac088f90b1626052c0edd9` |
| Map Release-02 remediation acceptance evidence | DONE — AGENT 5 | `.project/classroom-release/Release-02-controlled-error-acceptance-map.md`, commit `96ba936796e6dc418764568115f52299bf4192cf` |
| Live revalidate Release-02 prerequisite | DONE — AGENT 5 | `.project/classroom-release/Release-02-controlled-error-live-revalidation.md`, commit `d9149c96f028649af2b775b17d62e260091e2e42`; Presenter blobs `6f3475ee...` and `f2b13a8e...`, baseline exact paths absent |
| Verify manifest/checklist/promotion boundary consistency | DONE — AGENT 7 | Private audit `f22fef99b99f55f0eb3a411fc1fbad510a758637`; manifest sync `e4c7c7925d547223c7098f2189b95b0370fa28ec` |
| Materialize/validate/freeze Release-02 | BLOCKED | Requires approved student baseline containing controlled-error layer + approved document prerequisites |
| Presenter publication Release-02 | PRESENTER ONLY | Automation forbidden |

## Current document dependency
- T01_02 is APPROVED and repository-verified.
- T01_01 and T01_03 are QUALITY_GATE_PASSED but still await repository materialization/re-fetch verification.
- T02_01-T06_01 are APPROVED; T02_02-T06_02 are GENERATING; none is assigned to the current eight logical worker lanes.

## Current stream accounting
- Previous: **33.3333%**
- Updated: **33.3333%**
- Increase: **+0.0000%**
- State: **STALE BY PERCENTAGE / PRIVATE PREREQUISITE EVIDENCE ADVANCED; RELEASE GATES REMAIN BLOCKED**.

## Tasks Taken Up / Closed This Cycle
- Agent 5 revalidated the Release-02 prerequisite against both live branches and recorded exact Presenter blobs plus baseline absence; private evidence task CLOSED.
- Agents 4/7 preserved the already-completed Release-01 identity and promotion-boundary evidence; no duplicate percentage-bearing checkpoint claimed.

## Action Taken in This Cycle
Re-proved the Release-02 blocker instead of assuming stale evidence: Presenter reference components exist at blobs `6f3475ee7996fe761333810e92490df764c9e958` and `f2b13a8e782705239a9ad821926b1f5beb1422f4`, while the exact paths are absent from the approved `Frontend-backend-Baseline`. Recorded private evidence at `d9149c96f028649af2b775b17d62e260091e2e42`; no public or Quality Gate write occurred.

## Completion rule
Private audits may close independently with exact evidence, but no release percentage is credited until its defined release gate completes. No public repository write is permitted.