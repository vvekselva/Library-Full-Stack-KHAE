# Classroom Release Preparation Task Queue

**Stream weight:** 10% — SUPPORTING.  
**Logical worker:** Agent 7.  
**Public repository publication:** Presenter-only/manual. ChatGPT/automation must not write to the public classroom repository.

## Dependency rules
1. Release preparation may advance independently when it does not require unapproved documents.
2. A release stage that includes rerun documents must not be promoted before those documents are APPROVED and repository-verified in Private Master.
3. Do not create a public publication commit from ChatGPT/automation.
4. Before Release-02, generic controlled-error infrastructure required by student exercises must be present in the approved student baseline.
5. Release validation must use exact source/document identities.

## Task queue
| Task | Status | Dependency / evidence |
|---|---|---|
| Verify Release-00 baseline | VERIFIED | Existing verification run `31930965288` |
| Reconcile Release-00 manifest | DONE | `951c9abb...` |
| Prepare Release-01 selection manifest | DONE | `5fe51ba6...` |
| Prepare Release-01 validation checklist | DONE | `f0a54125...` |
| Prepare Release-01 private promotion structure | DONE | `dd71bd33...` |
| Materialize approved T01 rerun set | BLOCKED | T01_01/T01_03 repository verification incomplete |
| Run/freeze Release-01 candidate | BLOCKED | Candidate materialization required |
| Presenter publication Release-01 | PRESENTER ONLY | Automation forbidden |
| Verify Release-02 controlled-error prerequisite | DONE — VERIFIED MISSING | Frozen `Frontend-backend-Baseline@345d0abe...`; evidence `6ba32469...` |
| Prepare Release-02 manifest/checklist | DONE | Private conditional structure |
| Define Release-02 prerequisite remediation | DONE | `.project/classroom-release/Release-02-controlled-error-remediation.md`, commit `16382810ef29e68d0eac088f90b1626052c0edd9` |
| Materialize/validate/freeze Release-02 | BLOCKED | Requires approved student baseline containing controlled-error layer + approved document prerequisites |
| Presenter publication Release-02 | PRESENTER ONLY | Automation forbidden |

## Current cycle evidence
The private remediation contract now freezes the minimum prerequisite responsibilities: service/application exception with service/response codes, global REST exception translation into the frozen envelope, deterministic invalid-input/not-found/duplicate/invalid-state/dependency-exists handling, and tests proving controlled errors rather than 500/NPE behavior. It explicitly prohibits copying Presenter solution implementations and preserves Presenter-only public promotion.

## Current stream accounting
- Previous: **33.3333%**
- Updated: **33.3333%**
- Increase: **+0.0000%**
- Cycles without increase: **16**
- State: **STALE — PRIVATE REMEDIATION PREPARED; RELEASE GATE BLOCKED**.

## Tasks Closed This Cycle
- Release-02 controlled-error prerequisite remediation specification — CLOSED as private preparation, commit `16382810...`. This is not a percentage-bearing release gate.

## Tasks In Progress / Blocked
- Release-01 materialization remains blocked by document prerequisites.
- Release-02 materialization remains blocked until an approved student baseline contains and verifies the required generic controlled-error infrastructure.

## Action Taken in This Cycle
Converted the previously verified missing prerequisite into an exact private remediation contract so the release lane has an executable acceptance boundary rather than an ambiguous blocker. No public repository write occurred and no release percentage was credited.
