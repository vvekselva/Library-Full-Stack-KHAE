# Recovery / Final Integration Task Queue

**Stream weight:** 10% — SUPPORTING.  
**Logical worker:** Agent 8.

## Dependency rules
Registry evidence may be captured incrementally, but a 5-track batch must not be frozen until every dependent track has exact immutable evidence and required cumulative CI. Final integration cannot close while Presenter, Document, or Release prerequisites remain incomplete.

## Registry coverage queue
- T01-T30 registries: VERIFIED; preserve existing evidence.
- T31: registry-ready; cumulative run `31945620654` SUCCESS.
- T32: registry-ready; cumulative run `31946688302` SUCCESS.
- T33: registry-ready; cumulative run `31976478238` SUCCESS.
- T34: exact contract reconciled; Service + Unit Test committed; verification workflow `31979270908` running; not registry-ready.
- T35: implementation evidence unavailable; blocked behind queue progression.
- T31-T35 freeze: BLOCKED until T34 and T35 are registry-ready.
- Later batches T36-T60: pending Presenter completion.
- Final reconciliation/integration/freeze: blocked by upstream completion.

## Candidate preparation
Private candidate: `.project/recovery/T31-T35-registry-candidate.yml`.

Current ready tracks: **3/5**. `freeze_allowed: false` remains mandatory.

T34 evidence captured this cycle:
- Contract code `T34_DEACTIVATE_BOOK_COPY`.
- Endpoint `DELETE /rest/book-copies/{id}`.
- Service interface `DeleteBookCopyService`.
- Service implementation commit `abb23be3f9e10dd53c9bf267a3a02b7acbd3e134`.
- Unit-test commit `bc15079bf17a219283f3465083b8577e7f9da16f`.
- Verification workflow `31979270908`; frontend job SUCCESS; backend PostgreSQL job IN_PROGRESS at last check.
- Candidate evidence update commit `5ab448efb252f75fca9f5c8a7579cf3026968811`.

## Current stream accounting
- Previous: **20.0000%**
- Updated: **20.0000%**
- Increase: **+0.0000%**
- Cycles without increase: **16**
- State: **STALE BY PERCENTAGE / T34 EVIDENCE ADVANCING**.

## Tasks Closed This Cycle
- T34 exact candidate identity capture — CLOSED as an evidence-preparation task; registry readiness remains open.

## Tasks In Progress This Cycle
- Preserve T31-T33 immutable registry-ready evidence.
- Await T34 Service/UT green CI; only then allow Integration.
- Keep T31-T35 freeze blocked until all five tracks are registry-ready.

## Action Taken in This Cycle
Updated the private T31-T35 registry candidate with exact T34 endpoint, interface, implementation, unit-test commits and live verification run while preserving `freeze_allowed=false`. No Recovery percentage is credited before the batch/freeze checkpoint itself is satisfied.
