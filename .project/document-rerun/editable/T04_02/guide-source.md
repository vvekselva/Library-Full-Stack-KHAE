# T04_02 Progressive Guide — Deactivate Department

Status: EDITABLE_SOURCE_MATERIALIZED / EXPANSION_IN_PROGRESS

## Frozen grounding
- Registry verified source: `cdf4f8cb3d379216c5ffaaac7ba2622e246a4e6c`
- Service commit: `ebfa51415092cd8dbac16c56d097229e18324399`
- Unit-test commit: `7ce2c0e3d2e07c988ff8eaba7c5f316a41488636`
- Integration commit: `b898ab306131407e8fdc1f1d8cc192e0f0a71ead`
- Frontend commit: `e7f0a4ab34f8182bae5d77af0f564deff050b84b`
- Service path: `backend/backend.lib.mgmt/src/main/java/self/learning/backend/lib/mgmt/service/impl/DeleteDepartmentServiceImpl.java`
- Unit-test path: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/service/impl/DeleteDepartmentServiceImplTest.java`
- Local PostgreSQL integration: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/integration/DeleteDepartmentIntegrationTest.java`
- PostgreSQL Testcontainers integration: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/integration/DeleteDepartmentTestcontainersIntegrationTest.java`
- Assigned frontend path: `frontend/frontend.lib.mgmt/src/tracks/t04-create-department.js`

## Textbook chapter plan
1. Why business applications often deactivate instead of physically deleting rows.
2. Request path and controlled dependency checks.
3. Active/inactive state, not-found behavior and dependency-exists behavior.
4. Empty-service stage and isolated unit-test reasoning.
5. Numbered/commented implementation with line-by-line explanation.
6. Success, null-ID, unknown-ID and dependency-blocked unit tests.
7. Run → observe → fail → correct → regression sequence.
8. Local PostgreSQL/DBeaver verification of soft deactivation.
9. PostgreSQL Testcontainers integration walkthrough.
10. JaCoCo execution and branch coverage.
11. Frontend integration using the frozen assigned track.
12. Troubleshooting and exam-ready material.

## Draw.io assets to create beside this source
- `soft-delete-flow.drawio`
- `dependency-guard.drawio`
- `unit-test-isolation.drawio`
- `testcontainers-flow.drawio`

## Quality gates before promotion
Content QA, visual QA, accessibility check, DOCX render/hash, repository re-fetch/hash verification. `_03` remains blocked until this guide is approved.
