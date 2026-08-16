# Recovery / Final Integration Task Queue

**Stream weight:** 10% — SUPPORTING.  
**Logical worker:** Agent 8.

## Dependency rules

Registry evidence may be captured incrementally, but a 5-track batch must not be frozen until every dependent track has exact immutable evidence and required cumulative CI. Final integration cannot close while Presenter, Document, or Release prerequisites remain incomplete.

## Registry coverage queue

- T01-T30 registries: VERIFIED; preserve existing evidence.
- T31: exact component SHA and cumulative green-CI evidence CAPTURED; registry-ready for eventual batch freeze.
- T32: exact component SHA and cumulative green-CI evidence CAPTURED; registry-ready for eventual batch freeze.
- T33: targeted repair candidate recorded; verification CI IN PROGRESS; Integration/Frontend and registry readiness remain blocked until green.
- T34/T35: implementation evidence not yet available; blocked.
- T31-T35 freeze: BLOCKED until all five tracks are registry-ready.
- Later batches T36-T60: pending Presenter completion.
- Final reconciliation/integration/freeze: blocked by upstream completion.

## Candidate preparation

Private candidate structure: `.project/recovery/T31-T35-registry-candidate.yml`.

T31 and T32 remain registry-ready with cumulative successful runs `31945620654` and `31946688302`.

T33 candidate was advanced without freezing:
- Prior failing unit-test head: `4520f779a87bcac8c7628a90f0e6bc14fd87c6d8`.
- Targeted repair commit: `fe4b8262bd9536cc0ce88569ae6031f7604e0132`.
- Diagnosis: Update Book Copy duplicate lookup trimmed but did not canonicalize accession-number case required by the T33 test contract.
- Verification workflow: `31973754438`.
- Latest state: backend-test IN_PROGRESS; frontend-build SUCCESS.
- Registry candidate evidence update: `429d87fe14aeea79c98c8d996587848c5075eabb`.
- `freeze_allowed: false` remains mandatory.

## Current stream accounting

- Previous: **20.0000%**
- Updated: **20.0000%**
- Increase: **+0.0000%**
- Cycles without increase: **14**
- State: **STALE** by percentage.

## Tasks Closed This Cycle

None. Recording an unverified T33 repair candidate is useful integration work but does not satisfy a registry checkpoint.

## Action Taken in This Cycle

Updated the T31-T35 candidate with the evidence-backed T33 repair commit and live verification run while preserving T31/T32 immutable green evidence. The batch remains deliberately unfrozen and T34/T35 remain blocked. No percentage was credited before T33 branch-tip CI success.
