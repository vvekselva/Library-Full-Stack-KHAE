# T03_02 Progressive Guide — Update Department

Status: EDITABLE_SOURCE_MATERIALIZED / EXPANSION_IN_PROGRESS

## Frozen grounding
- Registry verified source: `cdf4f8cb3d379216c5ffaaac7ba2622e246a4e6c`
- Service commit: `df921d3081e00782cfae616ab223b404ea6a738d`
- Unit-test commit: `ee84af6e7f7b7affaa5ab7d877175d90ff7dfb5b`
- Integration commit: `18936b6f75bc53d0ccebfc0f4916bb239ecfcbd1`
- Frontend commit: `c21b3e2c78dce328fbaad93d95b21f11120d6eb5`
- Service path: `backend/backend.lib.mgmt/src/main/java/self/learning/backend/lib/mgmt/service/impl/UpdateDepartmentServiceImpl.java`
- Unit-test path: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/service/impl/UpdateDepartmentServiceImplTest.java`
- Local PostgreSQL integration: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/integration/UpdateDepartmentIntegrationTest.java`
- PostgreSQL Testcontainers integration: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/integration/UpdateDepartmentTestcontainersIntegrationTest.java`
- Assigned frontend path: `frontend/frontend.lib.mgmt/src/tracks/t03-search-department.js`

## Textbook chapter plan
1. Why update is different from create and read.
2. Browser → REST → service → DAO → PostgreSQL request/response path.
3. Update DTO, ID handling, normalization and controlled errors.
4. Empty-service stage and isolated unit-test reasoning.
5. Numbered/commented implementation with line-by-line explanation.
6. Positive, null, unknown-ID and duplicate/validation unit tests.
7. Run → observe → fail → correct → regression sequence.
8. Local PostgreSQL/DBeaver integration walkthrough.
9. PostgreSQL Testcontainers integration walkthrough.
10. JaCoCo execution and coverage gaps.
11. Frontend integration using the frozen assigned track.
12. Troubleshooting and exam-ready material.

## Draw.io assets to create beside this source
- `update-request-flow.drawio`
- `unit-test-isolation.drawio`
- `validation-decision-flow.drawio`
- `testcontainers-flow.drawio`

## Quality gates before promotion
Content QA, visual QA, accessibility check, DOCX render/hash, repository re-fetch/hash verification. `_03` remains blocked until this guide is approved.
