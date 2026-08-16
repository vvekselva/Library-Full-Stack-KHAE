# Recovery / Final Integration Task Queue

**Stream weight:** 10% — SUPPORTING.  
**Logical worker:** Agent 8.

## Dependency rules

1. Registry validation may advance incrementally for tracks/components that already have exact green SHAs.
2. Do not freeze a 5-track registry batch until every dependent track in that batch satisfies the required cumulative CI gate.
3. Do not infer registry completion from implementation percentage alone.
4. Final integration cannot close while required Presenter, Document or Release prerequisites remain incomplete.
5. Recovery validation must use exact commit/blob identities and workflow results.

## Registry coverage queue

| Registry / Recovery task | Status | Next action / dependency |
|---|---|---|
| T01-T05 registry | VERIFIED | Preserve exact evidence; no rewrite unless source changes |
| T06-T10 registry | VERIFIED | Preserve exact evidence |
| T11-T15 registry | VERIFIED | Preserve exact evidence |
| T16-T20 registry | VERIFIED | Preserve exact evidence |
| T21-T25 registry | VERIFIED | Preserve exact evidence |
| T26-T30 registry | VERIFIED | Preserve exact evidence; registry-tip CI already green |
| Incremental T31 evidence capture | ELIGIBLE | Record exact verified Service/UT/Integration/Frontend SHAs and cumulative CI evidence |
| Incremental T32 evidence capture | ELIGIBLE | Record exact verified Service/UT/Integration/Frontend SHAs and cumulative CI evidence |
| Incremental T33 evidence capture | PARTIAL | Record existing Service/UT identities; do not mark track registry-ready until repaired cumulative CI + Integration + Frontend are green |
| T34 evidence capture | BLOCKED | Requires T34 implementation/verification |
| T35 evidence capture | BLOCKED | Requires T35 implementation/verification |
| Freeze T31-T35 registry | BLOCKED | Requires T31-T35 all registry-ready and cumulative batch validation |
| Run T31-T35 registry-tip CI / VALIDATE_ONLY recovery test | BLOCKED | Requires frozen T31-T35 registry candidate |
| T36-T40 registry | PENDING | Requires Presenter tracks T36-T40 |
| T41-T45 registry | PENDING | Requires Presenter tracks T41-T45 |
| T46-T50 registry | PENDING | Requires Presenter tracks T46-T50 |
| T51-T55 registry | PENDING | Requires Presenter tracks T51-T55 |
| T56-T60 registry | PENDING | Requires Presenter tracks T56-T60 |
| Final full-registry reconciliation | BLOCKED | Requires all Presenter registry batches verified |
| Final integration validation | BLOCKED | Requires approved document/release state plus final registry reconciliation |
| Recovery completion freeze | BLOCKED | Requires successful final integration validation |

## Immediate Agent 8 queue

1. Capture the exact verified T31 evidence already available from cumulative CI and component commits.
2. Capture the exact verified T32 evidence already available from cumulative CI and component commits.
3. Capture only the currently valid partial T33 evidence; do not infer readiness.
4. Prepare the T31-T35 registry candidate structure without freezing it.
5. As Agent 6 closes T33, T34 and T35, add their exact verified identities.
6. Freeze and validate T31-T35 only after all five tracks are registry-ready.
7. Continue later batches incrementally using the same discipline.

## Stalled-stream requirement

If Recovery has no percentage increase for 4+ cycles, `Action Taken in This Cycle` must show a concrete eligible evidence-capture/validation/preparation action. Waiting for Presenter completion is not acceptable while verified T31/T32 evidence can still be captured.