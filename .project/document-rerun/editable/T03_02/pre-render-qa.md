# T03_02 Update Department — Pre-Render QA Evidence

Status: PRE_RENDER_QA_COMPLETE / FINAL_RENDER_GATES_PENDING

## Scope reviewed
- Editable source: `.project/document-rerun/editable/T03_02/guide-source.md`
- Draw.io assets: `update-request-flow.drawio`, `unit-test-isolation.drawio`, `validation-decision-flow.drawio`, `testcontainers-flow.drawio`
- Frozen grounding: Update Department service, focused unit tests, local PostgreSQL integration, PostgreSQL 18 Testcontainers integration and assigned frontend.

## Content QA — PASS at editable-source stage
- The guide clearly differentiates Update from Create and Read using Library Management Department data.
- It explains that the URL ID selects the existing Department while the request body supplies proposed values.
- Service responsibilities are broken into identifier validation, request validation, current-record lookup, normalization, duplicate/business-rule checks, persistence and mapping.
- The empty-service/isolation stage explains why JUnit + Mockito narrows the failure surface.
- Positive, invalid-input, unknown-ID and duplicate/conflict cases are included.
- Local PostgreSQL integration requires proving both the intended row changed and unrelated data did not change.
- PostgreSQL 18 Testcontainers is presented as a reproducibility check against a disposable real database.
- Frontend integration remains tied to the frozen `/rest/` contract.
- Troubleshooting and exam-ready summaries are present.

## Technical QA — PASS at editable-source stage
- The guide does not permit an update to silently create a missing Department.
- Duplicate checking is correctly described as update-specific: the target may already own its current business key.
- Normalization is required before duplicate checking where the frozen contract specifies normalization.
- Save/persistence is described only after guards pass.
- Unit tests are expected to verify both returned behavior and important persistence interactions.
- Integration testing reintroduces Spring, DAO/repository, Flyway-managed schema and PostgreSQL.
- Testcontainers is not presented as a mock database.

## Diagram QA — PASS at source-asset stage
Required editable Draw.io illustrations are materialized and have non-overlapping teaching purposes:
1. `update-request-flow.drawio` — URL ID + request body through controller/service/DAO/PostgreSQL and mapped response.
2. `unit-test-isolation.drawio` — full chain versus JUnit with mocked dependencies.
3. `validation-decision-flow.drawio` — guard sequence through successful Save/Map with controlled error exits.
4. `testcontainers-flow.drawio` — PostgreSQL 18 container lifecycle plus Spring execution path.

PostgreSQL/database elements must use cylinder notation. Final visual confirmation remains pending until render.

## Accessibility / visual QA — PENDING RENDER
Final artifact review must verify diagram label size, arrow clarity, no crossing/clipping, caption placement, code readability, heading hierarchy, page breaks and accessible diagram descriptions/alt-text where supported.

## Repository verification — PARTIAL PASS
Editable source and all declared Draw.io assets are present. Final repository verification requires the assembled DOCX plus re-fetch/hash evidence.

## Final gate
T03_02 is **not approved yet**. Remaining ordered work:
`assemble DOCX -> render -> visual/accessibility QA -> final content/technical spot-check -> repository re-fetch/hash verification -> approve T03_02`.

T04_02 remains queued behind this lane's T03_02 final gate, and T03_03 remains blocked until T03_02 approval.
