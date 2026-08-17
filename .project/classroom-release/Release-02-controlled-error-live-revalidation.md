# Release-02 Controlled-Error Live Revalidation

Status: VERIFIED_MISSING_IN_APPROVED_BASELINE / PRESENTER_REFERENCE_VERIFIED

Revalidated on 2026-08-17 against the live private repository before any Release-02 materialization.

## Approved student baseline check

Baseline branch: `Frontend-backend-Baseline` (frozen baseline evidence remains `345d0abe...`).

The following exact prerequisite paths return `404 Not Found` on the approved baseline:

- `backend/backend.lib.mgmt/src/main/java/self/learning/backend/lib/mgmt/exception/ApplicationServiceException.java`
- `backend/backend.lib.mgmt/src/main/java/self/learning/backend/lib/mgmt/exception/ApplicationServiceExceptionHandler.java`

Therefore the approved baseline still does not contain the generic controlled-error layer required by Release-02.

## Presenter reference verification

The private Presenter branch `Presenter-Solutions-T31-T35` contains both generic Presenter-owned reference components:

- `ApplicationServiceException.java` — Git blob `6f3475ee7996fe761333810e92490df764c9e958`; carries `serviceCode`, `responseCode`, and message.
- `ApplicationServiceExceptionHandler.java` — Git blob `f2b13a8e782705239a9ad821926b1f5beb1422f4`; `@RestControllerAdvice` maps the controlled exception to the frozen `ApiResponse<Object>` envelope with HTTP 200 and null data.

This verification is evidence only. Presenter solution code must not be copied blindly into the student baseline, and automation must not publish to the public classroom repository.

## Gate decision

`Release-02 materialize/validate/freeze = BLOCKED`.

The gate may reopen only after an approved student baseline contains the required generic controlled-error responsibility and that exact baseline passes the defined backend/frontend verification. Document prerequisites remain independently applicable.