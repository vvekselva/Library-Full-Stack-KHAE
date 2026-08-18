# Classroom Promotion Boundary Guard — Private

This control prevents downstream release work from being mistaken for publication authorization.

## Allowed now
- Private manifests, identity maps, preflight checklists and candidate-readiness evidence.
- Revalidation of already accepted private application/source evidence.
- Private candidate construction only after all selected document prerequisites are APPROVED and repository-verified.

## Forbidden now
- Any write to the public classroom repository.
- Any write to the read-only Quality Gate repository.
- Freeze/materialization that substitutes QUALITY_GATE_PASSED, GENERATING or PENDING documents for APPROVED repository-verified identities.
- Percentage credit for inspection or preparation alone.

## Release transition rule
A release may leave BLOCKED only when every required upstream document identity is complete and the private candidate can be reproduced from exact source/document identities. Public promotion remains separately authorized and Presenter-controlled.
