# Recovery / Final Integration Task Queue

**Stream weight:** 10% — SUPPORTING.  
**Active logical worker:** Agent 8.

## Dependency rules
Registry evidence may be captured incrementally, but a 5-track batch must not be frozen until every dependent track has exact immutable evidence and required cumulative CI. Final integration cannot close while Presenter, Document, or Release prerequisites remain incomplete.

## Registry coverage queue
- T01-T30 registries: VERIFIED; preserve existing evidence.
- T31: registry-ready; cumulative run `31945620654` SUCCESS.
- T32: registry-ready; cumulative run `31946688302` SUCCESS.
- T33: registry-ready; cumulative run `31976478238` SUCCESS.
- T34: Service + Unit Test VERIFIED GREEN; local PostgreSQL and PostgreSQL 18 Testcontainers Integration committed; Integration workflow `31979478188` completed FAILURE; not registry-ready.
- T35: implementation evidence unavailable; source/contract reconciliation assigned to Presenter Agent 3; not registry-ready.
- T31-T35 freeze: BLOCKED until T34 and T35 are registry-ready.
- Later batches T36-T60: pending Presenter completion.
- Final reconciliation/integration/freeze: blocked by upstream completion.

## Candidate preparation
Private candidate: `.project/recovery/T31-T35-registry-candidate.yml`.

Current ready tracks: **3/5**. `freeze_allowed: false` remains mandatory.

## T34 evidence boundary
- Contract code `T34_DEACTIVATE_BOOK_COPY`; endpoint `DELETE /rest/book-copies/{id}`.
- Service `abb23be3f9e10dd53c9bf267a3a02b7acbd3e134`.
- Unit Test `bc15079bf17a219283f3465083b8577e7f9da16f`.
- Service/UT workflow `31979270908`: SUCCESS; backend `95243377910` SUCCESS; frontend `95243377846` SUCCESS.
- Local PostgreSQL Integration `f5c7804210431152ec40e54ca03d64a093fd9361`.
- PostgreSQL 18 Testcontainers Integration `d61995c62f19152ec5fb7ab9b3c30e6e52e5ab6e`.
- Integration workflow `31979478188`: **FAILURE**.
- Backend job `95243874899`: FAILURE at `Run Presenter solution tests with PostgreSQL`.
- Frontend job `95243874904`: SUCCESS.

## Current stream accounting
- Previous: **20.0000%**
- Updated: **20.0000%**
- Increase: **+0.0000%**
- State: **FREEZE GUARD ACTIVE — T31-T33 READY; T34 INTEGRATION RED; T35 PENDING**.

## Agent 8 current work
- Preserve T31-T33 immutable registry-ready evidence.
- Record T34 red Integration evidence without marking it registry-ready.
- Accept future T34/T35 evidence only after their dependency-safe Presenter checkpoints are verified.
- Keep `freeze_allowed=false` until all five tracks are ready.

## Completion rule
No Recovery percentage is credited before its defined registry/freeze checkpoint. Final integration cannot be declared complete until all upstream Presenter, Document and Classroom prerequisites are complete and reconciled by the primary coordinator.