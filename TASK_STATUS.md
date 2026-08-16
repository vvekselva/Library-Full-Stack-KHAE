# Task Status Register

This file is the authoritative status register for the document-regeneration activity.

## Status Rules

A file being generated does not make a task complete.

Allowed working states include:

- `PENDING`
- `ANALYSING`
- `BLUEPRINTED`
- `GENERATING`
- `GENERATED`
- `REVIEWING`
- `QUALITY GATE FAIL`
- `CORRECTING`
- `VISUALLY INSPECTED`
- `QUALITY GATE PASS`
- `APPROVED`

A task may be marked `APPROVED` only after all mandatory applicable gates in `QUALITY_GATE.md` pass.

## Initial Register

| Task | Role | Previous Output | Redo Status | Quality Gate | Final Status | Notes |
|---|---|---|---|---|---|---|
| T01_01 / Student 01 Create Department | Golden Reference | Approved detailed guide | Reference - no redo | PASS | APPROVED | This is the quality baseline for the regenerated series. |
| T01_02 | First controlled redo | Condensed progressive guide | REDO REQUIRED | NOT RUN | PENDING | This task will validate the new Generation Protocol and Quality Gate. |
| Remaining affected tasks | Controlled redo queue | Previous generated documents | REDO REQUIRED | NOT RUN | PENDING | Exact task inventory must be reconstructed before generation starts. |

## Mandatory Next Control Point

Before T01_02 document generation begins:

1. place the approved Golden Reference in `golden-reference/`;
2. reconstruct the exact redo task inventory;
3. analyse T01_02 against authoritative task/project requirements;
4. create the T01_02 section blueprint;
5. run the Blueprint Gate.

Do not batch-regenerate the remaining tasks until T01_02 has passed the complete Quality Gate and proven the process.
