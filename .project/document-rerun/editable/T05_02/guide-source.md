# T05_02 Progressive Guide — Search Department

Status: EDITABLE_SOURCE_MATERIALIZED / EXPANSION_IN_PROGRESS

## Frozen grounding
- Registry verified source: `cdf4f8cb3d379216c5ffaaac7ba2622e246a4e6c`
- DAO commit: `3e0dcbf5633c1f28f744b02b4ce9db2ac54b3b03`
- Service commit: `a5d8e04b5ac06ae4994d3604ef8d1d6eca81d8bc`
- Unit-test commit: `d75de9d9705ceae6344d15d4cbc449ec5bb5718b`
- Integration commit: `d4ffc2ceab6ffd0d9141c51bd9241f3ff806761e`
- Frontend commit: `cdf4f8cb3d379216c5ffaaac7ba2622e246a4e6c`
- DAO path: `backend/backend.lib.mgmt/src/main/java/self/learning/backend/lib/mgmt/dao/DepartmentDao.java`
- Service path: `backend/backend.lib.mgmt/src/main/java/self/learning/backend/lib/mgmt/service/impl/SearchDepartmentServiceImpl.java`
- Unit-test path: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/service/impl/SearchDepartmentServiceImplTest.java`
- Local PostgreSQL integration: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/integration/SearchDepartmentIntegrationTest.java`
- PostgreSQL Testcontainers integration: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/integration/SearchDepartmentTestcontainersIntegrationTest.java`
- Assigned frontend path: `frontend/frontend.lib.mgmt/src/tracks/t05-read-list-department.js`

## Textbook chapter plan
1. Why search needs different DAO and service reasoning from read-by-ID.
2. Browser → REST → service → DAO query → PostgreSQL result flow.
3. Search text normalization, empty-input behavior and result-list contract.
4. Empty-service stage and isolated unit-test reasoning.
5. Numbered/commented DAO and service code with line-by-line explanation.
6. Positive, no-result, null/blank and normalization unit tests.
7. Run → observe → fail → correct → regression sequence.
8. Local PostgreSQL/DBeaver query walkthrough.
9. PostgreSQL Testcontainers integration walkthrough.
10. JaCoCo execution and branch coverage.
11. Frontend integration using the frozen assigned track.
12. Troubleshooting and exam-ready material.

## Draw.io assets to create beside this source
- `search-query-flow.drawio`
- `dao-service-boundary.drawio`
- `unit-test-isolation.drawio`
- `testcontainers-flow.drawio`

## Quality gates before promotion
Content QA, visual QA, accessibility check, DOCX render/hash, repository re-fetch/hash verification. `_03` remains blocked until this guide is approved.
