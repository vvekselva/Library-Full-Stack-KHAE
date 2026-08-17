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
- T34: Service + Unit Test + Integration VERIFIED GREEN. Frontend commit `820ae6cf96a2fee1a688383f12db329994ea8cf7` exists; cumulative branch-tip run `31982423259` is still in progress, so T34 is not yet registry-ready.
- T35: route/envelope reconciliation CLOSED; Service commit `0591d97853970e83be826af8bb9fb1c19ed46b2c` and Unit Test commit `126fe8493f80d99ae1c5b1bcdfcaab06fb5b9823` exist; shared branch-tip run `31982423259` is still in progress, so Integration remains blocked.
- T31-T35 freeze: BLOCKED until T34 and T35 are registry-ready.
- Later batches T36-T60: pending Presenter completion.
- Final reconciliation/integration/freeze: blocked by upstream completion.

## Candidate preparation
Private candidate: `.project/recovery/T31-T35-registry-candidate.yml`.

Current ready tracks: **3/5**. `freeze_allowed: false` remains mandatory. Candidate evidence synchronized at commit `068b60d7a82d1afa26ebf9b7656cc1778d210ee9`.

## T34 current boundary
- Endpoint `DELETE /rest/book-copies/{id}`; code `34`.
- Service/Unit verified green.
- Integration replacement workflow `31981001820`: SUCCESS; backend `95247637400` SUCCESS; frontend `95247637355` SUCCESS.
- Assigned frontend commit `820ae6cf96a2fee1a688383f12db329994ea8cf7` adds the auto-discovered `t34-deactivate-book-copy.js` track against the frozen DELETE contract.
- Current cumulative validation: run `31982423259`; frontend job `95251485072` SUCCESS; backend PostgreSQL job `95251485194` still IN_PROGRESS at consolidation.
- T34 remains not registry-ready until the cumulative run is fully green.

## T35 current boundary
- Code `T35_SEARCH_BOOK_COPY = "35"`.
- Controller contract now frozen: `GET /rest/book-copies/search?text=...` returning `ApiResponse<List<BookCopyResponseDto>>` with code `35` and message `Book Copy Search Completed Successfully`.
- Interface `SearchBookCopyService.searchBookCopy(String text)`; DAO `BookCopyDao.search(String text)` uses `%text%` and orders by book-copy ID.
- Hard-coded STUB replaced at `0591d97853970e83be826af8bb9fb1c19ed46b2c` with null/blank validation, trim, DAO delegation and mapper conversion.
- Focused Unit Test added at `126fe8493f80d99ae1c5b1bcdfcaab06fb5b9823` for trim/delegate/map, invalid input and empty results.
- Service/Unit gate is not credited until run `31982423259` is fully green. Integration must not start while that gate is incomplete.

## Current stream accounting
- Previous: **20.0000%**
- Updated: **20.0000%**
- Increase: **+0.0000%**
- State: **STALE BY PERCENTAGE / FREEZE GUARD ACTIVE — 3/5 READY; T34/T35 CI IN FLIGHT**.

## Agent 8 Action Taken in This Cycle
- Corrected stale T34 candidate evidence from the old failed/in-progress Integration state to replacement run `31981001820` SUCCESS.
- Captured T34 Frontend commit and T35 frozen route/envelope + Service/Unit commits without prematurely marking either track registry-ready.
- Preserved `freeze_allowed=false`, 3/5 ready and the dependency rule that T35 Integration cannot start before Service/Unit CI is green.

## Completion rule
No Recovery percentage is credited before its defined registry/freeze checkpoint. Final integration cannot be declared complete until all upstream Presenter, Document and Classroom prerequisites are complete and reconciled by the primary coordinator.
