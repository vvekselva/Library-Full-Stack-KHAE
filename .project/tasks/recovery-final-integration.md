# Recovery / Final Integration Task Queue

**Stream weight:** 10% — SUPPORTING.  
**Logical worker:** Agent 8.

## Dependency rules

Registry evidence may be captured incrementally, but a 5-track batch must not be frozen until every dependent track has exact immutable evidence and required cumulative CI. Final integration cannot close while Presenter, Document, or Release prerequisites remain incomplete.

## Registry coverage queue

- T01-T30 registries: VERIFIED; preserve existing evidence.
- T31: exact component SHA and cumulative green-CI evidence **CAPTURED**; registry-ready for eventual batch freeze.
- T32: exact component SHA and cumulative green-CI evidence **CAPTURED**; registry-ready for eventual batch freeze.
- T33: Service + Unit Test implemented, but unit-test CI is failed; Integration/Frontend and registry readiness remain blocked.
- T34/T35: implementation evidence not yet available; blocked.
- T31-T35 freeze: BLOCKED until all five tracks are registry-ready.
- Later batches T36-T60: pending Presenter completion.
- Final reconciliation/integration/freeze: blocked by upstream completion.

## Candidate preparation

Private candidate structure: `.project/recovery/T31-T35-registry-candidate.yml`.

This cycle captured immutable T31/T32 evidence into the candidate at commit `fdf65fac60be477458712d85396e875a4ff9d812`:
- T31 service `c03fdf12`, UT `6fdfc020`, migration `0a26ccad`, local integration `599dac48`, Testcontainers `192761ab`, frontend/head `9d2f5796`, cumulative run `31945620654` SUCCESS.
- T32 service `db2d4ec5`, UT `7d4571ec`, local integration `7c6ed2ed`, Testcontainers `59937e81`, frontend/head `ae74ded1`, integration run `31946440881` SUCCESS, cumulative run `31946688302` SUCCESS.
- T33 workflow `31946962274` attempt 2 remains FAILURE at unit-test head `4520f779`.
- T34/T35 remain blocked/not implemented.
- `freeze_allowed: false` remains mandatory until all five tracks are registry-ready.

## Current stream accounting

- Previous: **20.0000%**
- Updated: **20.0000%**
- Increase: **+0.0000%**
- Cycles without increase: **12**
- State: **STALE** by percentage.

## Tasks Closed This Cycle

- Capture exact T31 recovery component evidence — **CLOSED**.
- Capture exact T32 recovery component evidence — **CLOSED**.

## Action Taken in This Cycle

Closed the previously open T31/T32 evidence-capture work with exact immutable component SHAs and confirmed cumulative green CI. The T31-T35 batch was deliberately not frozen because T33-T35 are not registry-ready. This is substantive recovery preparation but does not earn final-integration percentage until the batch freeze gate is satisfied.
