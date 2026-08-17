# Release-02 Controlled-Error Acceptance Map

Status: PRIVATE_CONTROLLED_ERROR_ACCEPTANCE_COMPLETE / DOCUMENT + RELEASE GATES REMAIN

## Purpose
This private record converts the Release-02 controlled-error remediation contract into exact acceptance evidence. It does not modify the public classroom repository or the read-only Quality Gate repository.

## Required acceptance evidence
| Requirement | Evidence required before Release-02 materialization | Current result |
|---|---|---|
| Generic service/application exception | Approved student-baseline file carrying service code, response code and message | PASS — exact Presenter blob `6f3475ee7996fe761333810e92490df764c9e958` materialized on `Frontend-backend-Baseline` |
| Global REST exception handler | Approved student-baseline handler translating controlled exceptions to the frozen API error envelope | PASS — exact Presenter blob `f2b13a8e782705239a9ad821926b1f5beb1422f4` materialized on `Frontend-backend-Baseline` |
| Invalid-input handling | Test proving response code `01` without unhandled 500/NPE | PASS — parameterized handler acceptance test on `24179fb905fd69f816bfeb5db0ee7206401a3ceb` |
| Not-found handling | Test proving response code `02` | PASS — same acceptance test/run |
| Duplicate handling | Test proving response code `03` | PASS — same acceptance test/run |
| Invalid-state handling | Test proving response code `04` | PASS — same acceptance test/run |
| Dependency-exists handling | Test proving response code `05` | PASS — same acceptance test/run |
| Backend verification | Green verification run against the exact acceptance-test baseline SHA | PASS — run `31989985693`, backend job `95271686668` SUCCESS |
| Frontend build | Green build against the exact acceptance-test baseline SHA | PASS — run `31989985693`, frontend job `95271686680` SUCCESS |
| Release manifest freeze | Exact baseline SHA plus successful verification run IDs recorded in private Release-02 manifest | PENDING — required rerun-document prerequisites remain |

## Acceptance rule
The controlled-error prerequisite is accepted only when the exact Presenter-owned infrastructure exists in the approved private baseline, response codes `01`-`05` are proven through the frozen envelope, and backend/frontend verification are green. Those conditions are now satisfied.

## Promotion boundary
- Automation may maintain this private evidence map.
- Automation must not publish to the public classroom repository.
- Public publication remains Presenter-only.
- No Release-02 candidate may be materialized or frozen while required rerun-document prerequisites remain incomplete.

## Current conclusion
Release-02 controlled-error remediation and private acceptance are complete. The source files are identity-verified, all five controlled response codes are explicitly covered, and run `31989985693` is green for both backend and frontend. Release-02 still cannot be materialized/frozen because its required approved rerun documents are not ready. No release percentage is credited until the defined release checkpoint completes.
