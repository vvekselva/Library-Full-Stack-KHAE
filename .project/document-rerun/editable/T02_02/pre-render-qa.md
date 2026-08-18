# T02_02 Read Department — Pre-Render QA Evidence

Status: PRE_RENDER_QA_COMPLETE / FINAL_RENDER_GATES_PENDING

## Scope reviewed
- Editable source: `.project/document-rerun/editable/T02_02/guide-source.md`
- Draw.io assets: `request-flow.drawio`, `unit-test-isolation.drawio`, `postgres-integration.drawio`, `testcontainers-flow.drawio`
- Frozen grounding: T02 Read Department service, focused unit tests, local PostgreSQL integration, PostgreSQL 18 Testcontainers integration, assigned frontend.

## Content QA — PASS at editable-source stage
- The guide explains why a Read Department service exists in the Library Management application rather than treating it as only a SELECT statement.
- Browser -> REST Controller -> Service -> DAO -> PostgreSQL -> Mapper -> Response DTO is explained before isolated testing.
- The service implementation is explained line by line, including null-ID validation, current-record lookup, controlled NOT_FOUND handling, mapper use and application-code identity.
- Unit-test progression covers active Department, null ID and unknown ID.
- Local PostgreSQL integration explicitly distinguishes real Spring/DAO/database behavior from mocked unit testing and includes the inactive Department rule.
- PostgreSQL 18 Testcontainers is explained as a reproducible database environment rather than as another unit test.
- Frontend integration is tied to the frozen `/rest/departments/{id}` GET contract and the assigned T02 UI.
- Troubleshooting and regression guidance is included.

## Technical QA — PASS at editable-source stage
- The guide preserves the frozen Service -> DAO -> Mapper ownership boundary.
- It does not direct students to modify DTO shapes, REST URLs or persistence semantics to make tests pass.
- `DepartmentDao.findCurrentById(id)` semantics are consistently described as the current/visible-record read path.
- Controlled invalid-input and not-found outcomes are distinguished from null-pointer failures.
- Unit testing is described with mocks and no real PostgreSQL connection.
- Integration testing reconnects Spring, DAO, Flyway/database state and PostgreSQL.
- PostgreSQL 18 Testcontainers is treated as a disposable real database environment.

## Diagram QA — PASS at source-asset stage
Required editable Draw.io illustrations are materialized and their declared teaching roles are distinct:
1. `request-flow.drawio` — full browser-to-database request/response chain.
2. `unit-test-isolation.drawio` — normal chain versus JUnit + mocked dependencies.
3. `postgres-integration.drawio` — Spring Boot integration path to real PostgreSQL.
4. `testcontainers-flow.drawio` — Testcontainers lifecycle plus Spring application path to PostgreSQL 18.

Database elements are required to use cylinder notation. Final visual confirmation remains part of rendered-document QA.

## Accessibility / visual QA — PENDING RENDER
The editable source is structured with headings, explanatory paragraphs and code blocks, but final checks require the assembled DOCX/PDF render to verify:
- diagram text legibility at normal zoom;
- no clipped/cropped diagram content;
- adequate table and code-block contrast;
- heading hierarchy in the final document;
- captions associated with every illustration;
- no orphaned headings or one-line fragments created by pagination;
- alt-text or equivalent accessible description where supported by the final artifact workflow.

## Repository verification — PARTIAL PASS
Editable source and Draw.io source assets are present in the repository. Final repository verification must include the rendered DOCX artifact and hash/re-fetch evidence after assembly.

## Final gate
T02_02 is **not approved yet**. Remaining ordered work:
`assemble DOCX -> render -> visual/accessibility QA -> final content/technical spot-check -> repository re-fetch/hash verification -> approve T02_02`.

T02_03 remains blocked until this final gate closes.
