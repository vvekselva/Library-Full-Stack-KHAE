# T02-T06 Progressive Guide Editable-Source Recovery Plan

Status: ACTIVE_UNBLOCK_FALLBACK

## Reason for this fallback

T02_02-T06_02 are active at GENERATING, but the read-only `Document-Rerun-QG` evidence exposes only the controlled DOCX drafts (8, 9, 8, 8 and 9 pages) and does not expose equivalent editable generation-source trees for those five Progressive Guides. The accepted T01_02 guide is approximately 45 pages and has an editable source/tooling structure.

The coordinator must not promote under-depth binary drafts or write to the read-only Quality Gate branch. This plan defines the safe recovery route in Private Master.

## Per-lane recovery contract

For T02, T03, T04, T05 and T06 independently:

1. Reuse only the accepted T01_02 source/tooling structure as the structural baseline, not its track-specific content.
2. Ground every section in the exact Presenter/controller/interface/DTO/service/test paths already frozen in the corresponding blueprint and approved Initial API Contract.
3. Reconstruct an editable Progressive Guide source tree in Private Master before regenerating DOCX.
4. Expand the guide to textbook depth in simple English with WHY-before-HOW ordering.
5. Include numbered and commented code plus line-by-line explanation.
6. Include explicit run → observe → fail → correct → regression evidence.
7. Include JaCoCo, local PostgreSQL/DBeaver and PostgreSQL Testcontainers walkthroughs.
8. Include editable Draw.io teaching assets and retain source files beside the generation source.
9. Render DOCX, run content QA, visual QA and accessibility checks.
10. Only after those gates pass may the corresponding `_02` advance; `_03` remains blocked until `_02` approval.

## Recovery evidence required before generation resumes

Each lane must record:

- exact editable source path;
- exact source commit SHA;
- exact Presenter/source identities used for grounding;
- rendered DOCX path and hash;
- page count;
- Draw.io source paths;
- content-QA result;
- visual-QA result;
- repository re-fetch/hash verification result.

## Safety boundaries

- No write to `Document-Rerun-QG`.
- No approximation of missing source content.
- No promotion based only on page count.
- No `_03` start before corresponding `_02` approval.
- No percentage credit for this recovery-plan preparation itself.

## Immediate next action

Create the five independent editable source trees in Private Master using the accepted T01_02 tooling structure plus each track's already-approved source-grounded blueprint. Then generate the next controlled T02_02-T06_02 drafts in parallel and submit them to the defined QA sequence.
