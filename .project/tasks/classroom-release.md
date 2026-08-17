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
- **Agent 4:** Release-01 prerequisite/evidence audit and exact selected-document identity verification; no candidate materialization before document approval/repository verification.
- **Agent 5:** Release-02 controlled-error remediation acceptance mapping — private mapping completed; actual release prerequisite remains unmet.
- **Agent 7:** Release manifest/checklist consistency plus private promotion-boundary verification; no public write and Presenter-only publication remains mandatory.

## Task queue
| Task | Status | Dependency / evidence |
|---|---|---|
| Verify Release-00 baseline | VERIFIED | Existing verification run `31930965288` |
| Reconcile Release-00 manifest | DONE | `951c9abb...` |
| Prepare Release-01 selection manifest | DONE | `5fe51ba6...` |
| Prepare Release-01 validation checklist | DONE | `f0a54125...` |
| Prepare Release-01 private promotion structure | DONE | `dd71bd33...` |
| Audit Release-01 selected document identities | ACTIVE — AGENT 4 | May inspect evidence now; materialization remains blocked |
| Materialize approved T01 rerun set | BLOCKED | T01_01/T01_03 repository verification incomplete |
| Run/freeze Release-01 candidate | BLOCKED | Candidate materialization required |
| Presenter publication Release-01 | PRESENTER ONLY | Automation forbidden |
| Verify Release-02 controlled-error prerequisite | DONE — VERIFIED MISSING | Frozen `Frontend-backend-Baseline@345d0abe...`; evidence `6ba32469...` |
| Prepare Release-02 manifest/checklist | DONE | Private conditional structure |
| Define Release-02 prerequisite remediation | DONE | `.project/classroom-release/Release-02-controlled-error-remediation.md`, commit `16382810ef29e68d0eac088f90b1626052c0edd9` |
| Map Release-02 remediation acceptance evidence | DONE — AGENT 5 | `.project/classroom-release/Release-02-controlled-error-acceptance-map.md`, commit `96ba936796e6dc418764568115f52299bf4192cf` |
| Verify manifest/checklist/promotion boundary consistency | ACTIVE — AGENT 7 | Private prerequisite-safe work only |
| Materialize/validate/freeze Release-02 | BLOCKED | Requires approved student baseline containing controlled-error layer + approved document prerequisites |
| Presenter publication Release-02 | PRESENTER ONLY | Automation forbidden |

## Release-02 acceptance result
The private acceptance map now requires immutable evidence for the generic service exception, global REST exception handler, controlled response codes `01`-`05`, green backend verification, green frontend build, exact approved replacement baseline SHA, and release-manifest evidence. The frozen student baseline still lacks the controlled-error layer, so actual Release-02 materialization remains blocked. No Presenter implementation was copied into the student baseline and no public write occurred.

## Current stream accounting
- Previous: **33.3333%**
- Updated: **33.3333%**
- Increase: **+0.0000%**
- State: **PRIVATE ACCEPTANCE MAPPING CLOSED; PERCENTAGE-BEARING RELEASE GATES REMAIN BLOCKED**.

## Tasks Taken Up / Closed This Cycle
- Agent 5 acceptance mapping: TAKEN UP and CLOSED with commit `96ba936796e6dc418764568115f52299bf4192cf`.
- Agent 4 Release-01 identity audit: IN PROGRESS, but document materialization remains dependency-blocked.
- Agent 7 manifest/checklist/promotion-boundary verification: IN PROGRESS; no public write.

## Completion rule
Private audits/acceptance mapping may close independently with exact evidence, but no release percentage is credited until its defined release gate completes. No public repository write is permitted.