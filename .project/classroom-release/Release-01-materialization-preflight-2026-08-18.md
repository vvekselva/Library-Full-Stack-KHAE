# Release-01 Materialization Preflight — Private

Purpose: define the exact private go/no-go checks before Release-01 materialization. This file does not materialize or publish a release.

## Required document gates
- T01_01 must be APPROVED and repository-verified with its final immutable identity recorded.
- T01_02 is already APPROVED and repository-verified.
- T01_03 must be APPROVED and repository-verified with its final immutable identity recorded.

## Go / No-Go
- Current decision: NO-GO.
- Blocking items: T01_01 and T01_03 remain at QUALITY_GATE_PASSED with repository materialization/re-fetch/identity transition pending.

## When the blockers clear
1. Re-fetch all three selected document identities from Private Master.
2. Verify the expected immutable hashes/identities against the release manifest.
3. Confirm no selected document is GENERATING, PENDING, or identity-unresolved.
4. Build only the private Release-01 candidate.
5. Run candidate consistency/manifest checks.
6. Freeze only after the private candidate is reproducible from the recorded identities.

## Hard boundary
- No public classroom repository write is authorized.
- Quality Gate repository is read-only.
- A status check alone is not evidence of document completion.
