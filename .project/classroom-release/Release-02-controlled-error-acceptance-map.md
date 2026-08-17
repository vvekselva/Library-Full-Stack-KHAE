# Release-02 Controlled-Error Acceptance Map

Status: PRIVATE_ACCEPTANCE_MAPPING_COMPLETE / RELEASE_GATE_BLOCKED

## Purpose
This private record converts the existing Release-02 controlled-error remediation contract into exact acceptance evidence. It does not modify the public classroom repository or the frozen student baseline.

## Required acceptance evidence
| Requirement | Evidence required before Release-02 materialization | Current result |
|---|---|---|
| Generic service/application exception | Approved student-baseline file carrying service code, response code and message | MISSING in frozen baseline `Frontend-backend-Baseline@345d0abe...` |
| Global REST exception handler | Approved student-baseline handler translating controlled exceptions to the frozen API error envelope | MISSING in frozen baseline |
| Invalid-input handling | Test proving response code `01` without unhandled 500/NPE | BLOCKED by missing controlled-error layer |
| Not-found handling | Test proving response code `02` | BLOCKED by missing controlled-error layer |
| Duplicate handling | Test proving response code `03` | BLOCKED by missing controlled-error layer |
| Invalid-state handling | Test proving response code `04` | BLOCKED by missing controlled-error layer |
| Dependency-exists handling | Test proving response code `05` | BLOCKED by missing controlled-error layer |
| Backend verification | Green verification run against the exact approved replacement baseline SHA | NOT ELIGIBLE YET |
| Frontend build | Green build against the exact approved replacement baseline SHA | NOT ELIGIBLE YET |
| Release manifest freeze | Exact replacement baseline SHA plus successful verification run IDs recorded in private Release-02 manifest | NOT ELIGIBLE YET |

## Acceptance rule
Release-02 remains blocked until every row above has immutable evidence from an approved student baseline. Presenter solution implementation files must not be copied into the student baseline as a shortcut.

## Promotion boundary
- Automation may maintain this private evidence map.
- Automation must not publish to the public classroom repository.
- Public publication remains Presenter-only.
- No Release-02 candidate may be materialized or frozen while the prerequisite rows remain missing/blocked.

## Current conclusion
The acceptance mapping is complete. The release percentage does not increase because the actual prerequisite is still absent from the approved student baseline.
