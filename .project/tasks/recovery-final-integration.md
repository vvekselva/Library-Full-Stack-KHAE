# Recovery / Final Integration Task Queue

**Stream weight:** 10% — SUPPORTING.  
**Active logical worker:** Agent 8.

## Dependency rules
Registry evidence may be captured incrementally, but a 5-track batch must not be frozen until every dependent track has exact immutable evidence and required cumulative CI. Final integration cannot close while Presenter, Document, or Release prerequisites remain incomplete.

## Registry coverage queue
- T01-T30 registries: VERIFIED.
- T31: registry-ready; cumulative run `31945620654` SUCCESS.
- T32: registry-ready; cumulative run `31946688302` SUCCESS.
- T33: registry-ready; cumulative run `31976478238` SUCCESS.
- T34: registry-ready; cumulative run `31982423259` SUCCESS after Service + Unit + Integration + Frontend.
- T35: Service + Unit verified green; local PostgreSQL and PostgreSQL 18 Testcontainers Integration committed; run `31982678321` is in progress. Frontend remains blocked.
- T31-T35 freeze: BLOCKED until T35 is registry-ready.
- Later batches T36-T60: pending Presenter completion.
- Final reconciliation/integration/freeze: blocked by upstream completion.

## Candidate preparation
Private candidate: `.project/recovery/T31-T35-registry-candidate.yml`.

Current ready tracks: **4/5**. `freeze_allowed: false` remains mandatory. Candidate evidence synchronized at `5f314d90b09307cfa302cdaff28d0b2a16fae030`.

## Current stream accounting
- Previous: **20.0000%**
- Updated: **20.0000%**
- Increase: **+0.0000%**
- State: **STALE BY PERCENTAGE / FREEZE GUARD ACTIVE — 4/5 READY; T35 INTEGRATION CI IN FLIGHT**.

## Agent 8 Action Taken in This Cycle
- Promoted T34 to registry-ready only after cumulative run `31982423259` was fully green.
- Captured T35 Service/Unit green evidence plus Integration commits `6881ec4a...` and `31c51de7...` and run `31982678321` as in progress.
- Preserved `freeze_allowed=false`; no batch freeze was attempted.

## Completion rule
No Recovery percentage is credited before its defined registry/freeze checkpoint. Final integration cannot be declared complete until all upstream Presenter, Document and Classroom prerequisites are complete and reconciled by the primary coordinator.
