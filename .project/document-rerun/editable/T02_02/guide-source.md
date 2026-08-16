# T02_02 Progressive Guide — Read Department

Status: EDITABLE_SOURCE_MATERIALIZED / EXPANSION_IN_PROGRESS

## Frozen grounding
- Registry verified source: `cdf4f8cb3d379216c5ffaaac7ba2622e246a4e6c`
- Service commit: `47fb4a0ac3d2b60d471dcae3d4e5a2eb6a10fed2`
- Unit-test commit: `86b522b754af31a7de52d2e5dfe7bf56d10823e8`
- Integration commit: `edce78fb39fd1c5c316625c7667f7a9b4aacd81c`
- Frontend commit: `46f6a5fc84f087dd86aea11582ab6eedcc0b397c`
- Service path: `backend/backend.lib.mgmt/src/main/java/self/learning/backend/lib/mgmt/service/impl/ReadDepartmentServiceImpl.java`
- Unit-test path: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/service/impl/ReadDepartmentServiceImplTest.java`
- Local PostgreSQL integration: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/integration/ReadDepartmentIntegrationTest.java`
- PostgreSQL Testcontainers integration: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/integration/ReadDepartmentTestcontainersIntegrationTest.java`
- Assigned frontend path: `frontend/frontend.lib.mgmt/src/tracks/t02-delete-department.js`

## Textbook chapter plan
1. Why a Read Department service is needed.
2. Request path from browser to REST controller to service to DAO and PostgreSQL.
3. DTO and response contract in simple English.
4. Empty-service stage and why unit testing removes application-chain dependencies.
5. Numbered, commented service implementation with line-by-line explanation.
6. Positive unit test, unknown-ID failure test, null/invalid-input test.
7. Run → observe → fail → correct → regression sequence.
8. Local PostgreSQL/DBeaver integration walkthrough.
9. PostgreSQL Testcontainers integration walkthrough.
10. JaCoCo execution and interpretation.
11. Frontend integration using the frozen assigned track.
12. Troubleshooting and exam-ready two-mark/five-mark material.

## Draw.io assets to create beside this source
- `request-flow.drawio`
- `unit-test-isolation.drawio`
- `postgres-integration.drawio`
- `testcontainers-flow.drawio`

## Quality gates before promotion
Content QA, visual QA, accessibility check, DOCX render/hash, repository re-fetch/hash verification. `_03` remains blocked until this guide is approved.
