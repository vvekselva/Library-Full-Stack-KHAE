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
- T34: Service + Unit Test VERIFIED GREEN. Prior Integration failure is source-diagnosed as test/seed misalignment; repaired local/Testcontainers tests are committed, but replacement branch-tip CI `31981001820` is still in progress. Not registry-ready.
- T35: service code/interface/DAO/STUB reconciliation is active; implementation not yet registry-ready.
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
- Prior Integration workflow `31979478188`: FAILURE because both success tests used seeded Book Copy ID `2`, which has an ACTIVE Book Issue and is correctly blocked by the dependency guard.
- Local PostgreSQL repair `325c7102ddc2e9911a4abff6e3ec0e80d7701113` uses dependency-free ID `4` for successful withdrawal and explicitly tests ID `2` dependency rejection.
- PostgreSQL 18 Testcontainers repair `2f2081c062585e1a59a924eff8487f5454fd9025` applies the same deterministic alignment.
- Replacement workflow `31981001820`: frontend job `95247637355` SUCCESS; backend PostgreSQL job `95247637400` still IN PROGRESS at the latest consolidation checkpoint.

## T35 evidence boundary
- Code `T35_SEARCH_BOOK_COPY = "35"`.
- Interface `SearchBookCopyService.searchBookCopy(String text)`.
- DAO `BookCopyDao.search(String text)` searches accession number using `%text%` and orders by book-copy ID.
- Current service implementation is still a hard-coded STUB and is not registry-ready.

## Current stream accounting
- Previous: **20.0000%**
- Updated: **20.0000%**
- Increase: **+0.0000%**
- State: **FREEZE GUARD ACTIVE — T31-T33 READY; T34 REPAIR CI PENDING; T35 RECONCILIATION ACTIVE**.

## Agent 8 current work
- Preserve T31-T33 immutable registry-ready evidence.
- Capture exact T34 failure/repair evidence without marking it registry-ready before green replacement CI and later Frontend/registry gates.
- Capture T35 reconciliation evidence without inferring implementation completion.
- Keep `freeze_allowed=false` until all five tracks are ready.

## Completion rule
No Recovery percentage is credited before its defined registry/freeze checkpoint. Final integration cannot be declared complete until all upstream Presenter, Document and Classroom prerequisites are complete and reconciled by the primary coordinator.