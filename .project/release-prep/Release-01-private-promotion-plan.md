# Release-01 Private Promotion Plan

Status: PREPARED / NOT MATERIALIZED / NOT PUBLISHED

## Purpose

Define the private-only promotion structure for Release-01 without writing to the public classroom repository and without bypassing document approval gates.

## Inputs required before materialization

- Release-01 selection manifest is frozen in Private Master.
- Release-01 validation checklist is frozen in Private Master.
- Every selected rerun document is APPROVED and repository-verified in Private Master.
- Exact source/document identities are recorded; approximate or manually substituted copies are forbidden.

## Private promotion sequence

1. Create or refresh a private Release-01 candidate branch only after the selected documents satisfy all approval/repository gates.
2. Materialize exact approved document identities from Private Master into the candidate.
3. Run the Release-01 validation checklist against the candidate.
4. Record exact candidate commit SHA and validation evidence in the private release status.
5. Freeze the private candidate only when every checklist item passes.
6. Stop automation at the private freeze boundary. Public publication remains Presenter-only/manual.

## Hard guards

- No automation write to the public classroom repository.
- No automation write to the read-only Quality Gate repository.
- No materialization while T01_01/T01_03 or any selected later document lacks APPROVED + repository-verified evidence.
- No publication action is included in this plan.

## Current dependency result

BLOCKED_FOR_MATERIALIZATION. The private structure is ready, but document prerequisites are incomplete.
