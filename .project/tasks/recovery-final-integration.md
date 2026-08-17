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
- T35: Service + Unit verified green; local PostgreSQL and PostgreSQL 18 Testcontainers Integration committed. Run `31982678321` backend job `95252157107` FAILED; same-source rerun `95256133626` also FAILED. Deeper source/fixture reconciliation this cycle found no seed mismatch and no unique container-pattern mismatch; Integration still cannot be counted as registry evidence and Frontend remains blocked.
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
- State: **STALE BY PERCENTAGE / FREEZE GUARD ACTIVE — 4/5 READY; T35 INTEGRATION FAILED DETERMINISTICALLY**.

## Agent 8 Action Taken in This Cycle
- Consumed deeper Presenter evidence for T35: branch-tip delta is limited to the T35 Testcontainers class; its `ACC-0004` fixture matches V002 and its container pattern matches existing green PostgreSQL 18 tests.
- Kept T35 out of registry-ready state because the Maven backend Integration job remains failed and no exact Surefire error is available.
- Preserved T34 as the fourth registry-ready track and maintained `freeze_allowed=false`.
- Did not attempt T31-T35 freeze or downstream final integration.

## Tasks In Progress / Blocked
- T35 exact Integration failure diagnosis — upstream Presenter work in progress.
- T31-T35 freeze — BLOCKED at 4/5 ready.
- Final integration/freeze — BLOCKED by remaining Presenter, Document and Classroom prerequisites.

## Completion rule
No Recovery percentage is credited before its defined registry/freeze checkpoint. Final integration cannot be declared complete until all upstream Presenter, Document and Classroom prerequisites are complete and reconciled by the primary coordinator.