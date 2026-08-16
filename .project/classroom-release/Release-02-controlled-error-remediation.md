# Release-02 Controlled-Error Prerequisite Remediation

Status: PRIVATE_PREPARATION_COMPLETE / PUBLIC_MATERIALIZATION_BLOCKED

## Frozen baseline evidence
- Student baseline: `Frontend-backend-Baseline@345d0abe...`
- Prior verification established that the generic controlled application-error / exception-handler infrastructure required by Release-02 is absent from that frozen student baseline.

## Minimum prerequisite contract
Before Release-02 may be materialized, the approved student baseline must expose a generic controlled-error layer equivalent in responsibility to:
- application/service exception carrying service code, response code and message;
- global REST exception handler translating the exception into the frozen API error envelope;
- deterministic handling for invalid input, not found, duplicate, invalid state and dependency-exists outcomes;
- tests proving the handler returns the frozen response contract rather than an unhandled 500/NPE.

## Release safety gates
1. Do not copy Presenter solution implementations into the classroom baseline.
2. Do not publish from automation; Public promotion remains Presenter-only.
3. Do not materialize Release-02 until the controlled-error prerequisite is present in an approved student baseline.
4. After the prerequisite exists, re-run backend verification and frontend build before freezing the private candidate.
5. Record the exact baseline SHA and successful verification run IDs in the Release-02 manifest before Presenter promotion.

## Current result
The prerequisite-remediation specification is complete, but implementation is outside this private release-preparation lane because the public/student baseline must not be modified by this automation. Release-02 therefore remains dependency-blocked rather than falsely promoted.
