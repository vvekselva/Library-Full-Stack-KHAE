# Release-01 Private Validation Checklist

Status: PREPARED / CANDIDATE NOT MATERIALIZED / DOCUMENT APPROVAL GATED

- [ ] Every selected document is APPROVED. T01_01 and T01_03 remain QUALITY_GATE_PASSED pending dedicated identity-control reconciliation.
- [ ] Every selected document is REPOSITORY_VERIFIED by the Document control process. Read-only re-fetch is proven for all three, but T01_01/T01_03 have not crossed the Document approval gate.
- [x] Exact blob identity is recorded for every selected artifact:
  - `Documents/Student-Guides/Department/T01_Create_Department/T01_01_Initial_API_Contract.docx` — `b6bb206b9c3cb1b06175a29f97c764bf3e866d9b`
  - `Documents/Student-Guides/Department/T01_Create_Department/T01_02_Progressive_Development_Guide.docx` — `41c746d55d44ab944ee42a4c0ab73f6c7f381607`
  - `Documents/Student-Guides/Department/T01_Create_Department/T01_03_Updated_API_Contract.docx` — `fb3e68db5526dbcb5a03732feac1da67dda11608`
- [ ] No Presenter solution implementation is included — verify after private candidate materialization becomes eligible.
- [ ] No `.presenter/` registry/evidence is included — verify after private candidate materialization becomes eligible.
- [ ] No `.project/` orchestration/recovery control file is included in classroom payload — verify after private candidate materialization becomes eligible.
- [ ] Student baseline compiles with required Presenter-owned shared infrastructure.
- [ ] Backend tests pass for the candidate.
- [ ] Frontend build passes for the candidate.
- [ ] `/rest/` API paths match the frozen student contracts.
- [x] Release manifest carries exact T01 repository paths/blobs; candidate tree reconciliation remains pending because the candidate is intentionally not materialized.
- [x] Public publication remains Presenter-only/manual; no automated Public write is authorized.

Read-only QG branch tip observed during the identity reconciliation: `c951f0e331007820997c590156cd14000b7c07b8`.

Current gate: candidate materialization remains BLOCKED because T01_01 and T01_03 still require the Document control process's dedicated identity-control reconciliation before APPROVED/REPOSITORY_VERIFIED status. Repository presence itself is no longer uncertain.
