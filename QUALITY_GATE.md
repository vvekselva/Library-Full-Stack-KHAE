# Mandatory Document Quality Gate

## Purpose

This Quality Gate prevents a regenerated student guide from being accepted merely because a DOCX file was produced. The approved Golden Reference defines the minimum expected teaching depth, progressive development method, explanation style, code treatment, diagram use, testing depth, execution guidance, and visual quality.

## Golden Reference Rule

Before generating any student guide, the approved Golden Reference in `golden-reference/` must be examined.

A later guide may differ because the assigned functionality is different, but it must not degrade into a summary, outline, notes sheet, checklist-only document, or code dump.

## Mandatory Quality Gates

| ID | Gate | PASS requirement |
|---|---|---|
| QG-01 | Golden Reference | Golden Reference examined before generation. |
| QG-02 | Assignment Contract | Backend, endpoint, business key, frontend integration, presenter-owned and student-owned responsibilities are clear. |
| QG-03 | Progressive Sequence | Development is taught progressively rather than jumping to the final solution. |
| QG-04 | WHY Explanation | Major stages explain why they are required. |
| QG-05 | Concept Explanation | Important new terms are explained in simple student-friendly English before or when first used. |
| QG-06 | Draw.io Illustrations | Appropriate architecture, invocation, dependency, testing, failure, integration and frontend flows are illustrated where visual explanation materially helps. |
| QG-07 | Code Fragment Numbering | Instructional fragments are numbered and labelled consistently. |
| QG-08 | Code Comments | Important instructional source code contains useful comments. |
| QG-09 | Code Explanation | Significant fragments are followed by explanation of important parts. |
| QG-10 | Student Execution | The guide tells the student what to run and where to run it. |
| QG-11 | Expected Observation | Expected JUnit, console, Maven, browser, REST or database results are stated and explained. |
| QG-12 | Failure Before Fix | Where applicable, the student observes the failure before the implementation is corrected. |
| QG-13 | Failure Explanation | Exception/output and the relevant application cause are explained. |
| QG-14 | Positive Tests | Normal successful behaviour has a persistent regression test. |
| QG-15 | Negative/Boundary Tests | Invalid, null, blank, duplicate or other relevant edge conditions are tested. |
| QG-16 | JaCoCo | Where applicable, coverage is reviewed as evidence of executed paths and uncovered paths are addressed. |
| QG-17 | Local Integration | Where applicable, real Spring/application/database integration is demonstrated. |
| QG-18 | Database Verification | Where applicable, persisted results are verified using the specified database tool/query. |
| QG-19 | Testcontainers | Where applicable, equivalent behaviour is tested against isolated PostgreSQL in Docker. |
| QG-20 | Regression | New corrections do not break previously working behaviour. |
| QG-21 | Frontend Progression | Where applicable, frontend development progresses from execution proof to API call, STUB support, refactoring and real integration. |
| QG-22 | Ownership Boundaries | Files/components the student may and may not modify are explicit. |
| QG-23 | Learning Closure | Learning summary and/or completion checklist is present. |
| QG-24 | No Unjustified Compression | Comparable scope has comparable instructional depth; content is not shortened merely to reduce page count. |
| QG-25 | Visual Inspection | Every DOCX page is rendered/opened and checked for layout, clipping, diagrams, tables, code, whitespace and numbering. |
| QG-26 | Final Golden Comparison | Final document is explicitly compared with the Golden Reference before delivery. |

## Progressive Teaching Pattern

For each applicable stage, preserve this teaching pattern:

`Explain -> Why -> Illustrate -> Implement Small Step -> Explain Code -> Run -> Observe -> Introduce Next Condition -> Fail -> Explain Failure -> Correct -> Test -> Regression`

Do not silently skip intermediate learning stages that are present for equivalent concepts in the Golden Reference.

## Draw.io Gate

Diagrams are part of the teaching material, not decoration. Where an equivalent concept in the Golden Reference is visually explained, the regenerated guide must use an appropriate Draw.io diagram unless there is a documented reason that a diagram adds no value.

Every diagram must be checked for readable text, correct arrows, no overlaps, no clipping, sufficient spacing, logical flow, and a meaningful caption.

## Code Gate

For every significant instructional code fragment:

1. State its purpose.
2. Number it consistently.
3. Add valid source comments where the format permits them.
4. Explain the important parts.
5. Tell the student how to execute/test it.
6. State the expected result and what that result proves.

JSON must remain valid JSON; do not insert `//` comments inside JSON.

## Failure-Observation Gate

Where the learning objective concerns an error, validation, boundary or defect, use:

`Write/prepare condition -> Run current implementation -> Observe failure -> Read output/stack trace -> Explain cause -> Correct implementation -> Run new test -> Run previous tests`

Do not present the corrected final implementation before the student has observed the relevant failure when the progressive lesson requires that experience.

## Compression Gate

This is a detailed student practical/learning guide. It is not a short summary.

If a regenerated document with scope comparable to the Golden Reference is dramatically smaller, generation must stop and the following omissions must be checked: WHY explanations, concepts, diagrams, comments, code explanations, execution steps, sample outputs, deliberate failures, failure analysis, corrections, boundary tests, coverage, integration, database verification, Testcontainers, regression, frontend progression, and learning closure.

## Hard Completion Rule

A generated file is **not** a completed task.

Required state flow:

`PENDING -> BLUEPRINTED -> GENERATING -> GENERATED -> REVIEWED -> CORRECTED (if needed) -> VISUALLY INSPECTED -> QUALITY GATE PASS -> APPROVED`

If any mandatory applicable gate is `FAIL`, the document must not be delivered or marked complete. Correct the failed section(s), rerun the relevant gate, and repeat until all mandatory applicable gates pass.
