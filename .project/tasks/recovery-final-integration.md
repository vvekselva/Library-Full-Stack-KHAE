# Recovery / Final Integration Task Queue

**Stream weight:** 10% — SUPPORTING.  
**Active logical worker:** Agent 8.

## Dependency rules
Registry evidence may be captured incrementally, but a 5-track batch must not be frozen until every dependent track has exact immutable evidence, green Integration, assigned Frontend and required cumulative CI. Final integration cannot close while Presenter, Document, or Release prerequisites remain incomplete.

## Registry coverage queue
- T01-T30 registries: VERIFIED.
- T31-T35 registry: FROZEN / VERIFIED at `83d51d4343fd79f8609e4bc73a483ce85615a276`.
- T36-T40 recovery candidate: OPEN at `.project/recovery/T36-T40-registry-candidate.yml`.
- T41-T60: pending matching Presenter batches.
- Final registry reconciliation/integration/freeze: blocked by later Presenter batches plus Document/Classroom release state.

## T36-T40 evidence captured this cycle
- Candidate opened from the verified T31-T35 base at commit `b76ec88f37f58b8c9ec97496e65775dc5d332cbf`.
- Candidate advanced after green Service+Unit evidence at commit `9593771f2db10855796e03a3fa26d26390ac933c`.
- Shared Service+Unit run `31991520031`: backend `95275836101` SUCCESS; frontend `95275836078` SUCCESS.
- Shared local PostgreSQL Integration run `31991835066`: backend `95276657850` SUCCESS; frontend `95276658008` SUCCESS.
- PostgreSQL 18 Testcontainers branch tip `95fed17f1e9a19ae349188f5a18fba564146a6a0` is under run `31992068286`; frontend `95277279026` SUCCESS while backend `95277279036` remained IN_PROGRESS at this control-file update.
- `freeze_allowed=false` remains mandatory. No T36-T40 track is registry-ready yet because the complete Integration gate, assigned Frontend and cumulative registry verification are not complete.

## Current stream accounting
- Previous: **20.0000%**
- Updated: **20.0000%**
- Increase: **+0.0000%**
- State: **STALE BY PERCENTAGE / SUBSTANTIVE T36-T40 EVIDENCE CAPTURE**.

The Recovery control plane still defines no numeric sub-allocation for intermediate evidence capture, so no percentage is invented.

## Tasks Taken Up This Cycle
- Open T36-T40 candidate only after the verified T31-T35 registry base.
- Capture exact T36-T40 Service/Unit component commits and green shared CI.
- Capture local Integration commits and green shared Integration prerequisite run.
- Maintain the Testcontainers/Frontend/registry freeze guard.

## Tasks Closed This Cycle
- T36-T40 Service+Unit evidence capture — CLOSED GREEN.
- T36-T40 local PostgreSQL Integration evidence capture — CLOSED GREEN as an intermediate prerequisite.

## Tasks In Progress / Blocked
- T36-T40 PostgreSQL 18 Testcontainers evidence — IN PROGRESS.
- T36-T40 registry-ready state — BLOCKED by Testcontainers Integration, assigned Frontend and cumulative registry verification.
- Later registry batches — BLOCKED by corresponding Presenter tracks.
- Final integration/freeze — BLOCKED by remaining Presenter, Document and Classroom prerequisites.

## Agent 8 Action Taken in This Cycle
Opened a new T36-T40 candidate with exact immutable Service/Unit evidence and `freeze_allowed=false`, consumed the green Service+Unit and local Integration gates as they became available, and kept Testcontainers, Frontend and final registry freeze dependency-gated. No premature freeze was performed.

## Completion rule
A batch may close only with exact immutable evidence and green registry-tip validation. Final integration cannot be declared complete until all remaining Presenter batches and required Document/Classroom release prerequisites are complete and reconciled.
