# Release-02 Materialization Preflight — Private

Purpose: define the exact private go/no-go checks before Release-02 materialization. This file does not materialize or publish a release.

## Accepted application baseline
- `Frontend-backend-Baseline@24179fb905fd69f816bfeb5db0ee7206401a3ceb`.
- Accepted workflow `31989985693`.
- Backend `95271686668`: SUCCESS.
- Frontend `95271686680`: SUCCESS.

## Required document gates
- T02_01: APPROVED.
- T02_02: must finish final DOCX render, visual/accessibility QA, approval and repository verification.
- T02_03: must complete after T02_02 approval and be repository-verified.

## Go / No-Go
- Current decision: NO-GO.
- Current blockers: T02_02 remains GENERATING; T02_03 remains PENDING.

## When the blockers clear
1. Re-fetch immutable identities for T02_01, T02_02 and T02_03.
2. Confirm all selected documents are APPROVED and repository-verified.
3. Bind the private candidate to the accepted application/source baseline above.
4. Build the private candidate and generate its README/build identity.
5. Re-run private acceptance/consistency checks.
6. Freeze only when candidate inputs and outputs are reproducible from exact identities.

## Hard boundary
- No public classroom repository write is authorized.
- Quality Gate repository is read-only.
- Accepted application evidence does not override unfinished document prerequisites.
