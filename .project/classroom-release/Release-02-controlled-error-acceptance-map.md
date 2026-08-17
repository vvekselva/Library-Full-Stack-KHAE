# Release-02 Controlled-Error Acceptance Map

Status: PRIVATE_BASELINE_BUILD_ACCEPTED / RESPONSE-CODE PROOF + RELEASE GATES REMAIN

## Purpose
This private record converts the Release-02 controlled-error remediation contract into exact acceptance evidence. It does not modify the public classroom repository or the read-only Quality Gate repository.

## Required acceptance evidence
| Requirement | Evidence required before Release-02 materialization | Current result |
|---|---|---|
| Generic service/application exception | Approved student-baseline file carrying service code, response code and message | PASS — exact Presenter blob `6f3475ee7996fe761333810e92490df764c9e958` materialized on `Frontend-backend-Baseline` |
| Global REST exception handler | Approved student-baseline handler translating controlled exceptions to the frozen API error envelope | PASS — exact Presenter blob `f2b13a8e782705239a9ad821926b1f5beb1422f4` materialized on `Frontend-backend-Baseline` |
| Invalid-input handling | Test proving response code `01` without unhandled 500/NPE | EXPLICIT RESPONSE-CODE PROOF STILL REQUIRED |
| Not-found handling | Test proving response code `02` | EXPLICIT RESPONSE-CODE PROOF STILL REQUIRED |
| Duplicate handling | Test proving response code `03` | EXPLICIT RESPONSE-CODE PROOF STILL REQUIRED |
| Invalid-state handling | Test proving response code `04` | EXPLICIT RESPONSE-CODE PROOF STILL REQUIRED |
| Dependency-exists handling | Test proving response code `05` | EXPLICIT RESPONSE-CODE PROOF STILL REQUIRED |
| Backend verification | Green verification run against the exact remediated baseline SHA | PASS — `Frontend-backend-Baseline@fb2ba9963f9e38ad40b6800082e03b1ffa7b7d37`, run `31986868374`, backend job `95263283779` SUCCESS |
| Frontend build | Green build against the exact remediated baseline SHA | PASS — run `31986868374`, frontend job `95263283732` SUCCESS |
| Release manifest freeze | Exact replacement baseline SHA plus successful verification run IDs recorded in private Release-02 manifest | PENDING — response-code proof and document prerequisites remain |

## Acceptance rule
Release-02 remains blocked until every row above has immutable evidence from the approved student baseline. Presenter solution implementation files must not be copied into the student baseline as a shortcut.

## Promotion boundary
- Automation may maintain this private evidence map.
- Automation must not publish to the public classroom repository.
- Public publication remains Presenter-only.
- No Release-02 candidate may be materialized or frozen while response-code proof or required rerun-document prerequisites remain incomplete.

## Current conclusion
The previous missing-source blocker and the private baseline build/acceptance gate are closed. Both backend and frontend verification are green on the exact remediated baseline SHA. Release-02 is still not eligible for materialization/freeze because explicit `01`-`05` response-code acceptance evidence and required approved rerun documents remain incomplete. No release percentage is credited yet.
