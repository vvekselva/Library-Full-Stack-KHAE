# T06_02 Progressive Guide — Create Member

Status: EDITABLE_SOURCE_MATERIALIZED / EXPANSION_IN_PROGRESS

## Frozen grounding
- Registry verified source: `b2e7893f93d70a7b35364184f58cfa1c713da569`
- Service commit: `d9a35f189247d963a712ff48d1ec72379c2721ba`
- Unit-test commit: `b72622039855cc0f2caa660a9156ce495bbac214`
- Integration commit: `07f171b48cf464f6026ca4597de664df7603baa4`
- Frontend commit: `8bc9e991182e2e9573187e65bde25da42a75fa81`
- Migration path: `backend/backend.lib.mgmt/src/main/resources/db/migration/V010__t06_member_normalized_unique_key.sql`
- Service path: `backend/backend.lib.mgmt/src/main/java/self/learning/backend/lib/mgmt/service/impl/CreateMemberServiceImpl.java`
- Unit-test path: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/service/impl/CreateMemberServiceImplTest.java`
- Local PostgreSQL integration: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/integration/CreateMemberIntegrationTest.java`
- PostgreSQL Testcontainers integration: `backend/backend.lib.mgmt/src/test/java/self/learning/backend/lib/mgmt/integration/CreateMemberTestcontainersIntegrationTest.java`
- Assigned frontend path: `frontend/frontend.lib.mgmt/src/tracks/t06-update-member.js`

## Textbook chapter plan
1. Why Member creation needs validation, business-key normalization and persistence rules.
2. Browser → REST → service → DAO → PostgreSQL create flow.
3. Request DTO, application codes and controlled error contract.
4. Empty-service stage and isolated unit-test reasoning.
5. Numbered/commented implementation with line-by-line explanation.
6. Positive, null, blank, duplicate and normalization unit tests.
7. Run → observe → fail → correct → regression sequence.
8. Flyway normalized-key migration and local PostgreSQL/DBeaver walkthrough.
9. PostgreSQL Testcontainers integration walkthrough.
10. JaCoCo execution and interpretation.
11. Frontend integration using the frozen assigned track.
12. Troubleshooting and exam-ready material.

## Draw.io assets to create beside this source
- `create-member-flow.drawio`
- `validation-normalization.drawio`
- `unit-test-isolation.drawio`
- `testcontainers-flow.drawio`

## Quality gates before promotion
Content QA, visual QA, accessibility check, DOCX render/hash, repository re-fetch/hash verification. `_03` remains blocked until this guide is approved.
