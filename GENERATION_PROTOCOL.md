# Mandatory Generation Protocol

## Objective

Prevent quality loss during generation. Quality is checked while each guide is being created, not only after the DOCX exists.

## Stage 0 - Read the Controls

Before starting a task, read:

1. the approved Golden Reference in `golden-reference/`;
2. `QUALITY_GATE.md`;
3. `TASK_STATUS.md`;
4. the task-specific requirements/source material.

Do not begin document writing until the assignment and reference quality are understood.

## Stage 1 - Analyse the Assignment

Identify and record:

- student/task identifier;
- backend assignment;
- frontend assignment;
- fixed REST contract;
- business key and important business rules;
- presenter-owned components;
- student-modifiable components;
- dependencies on other student tasks/services;
- required positive tests;
- required negative/boundary tests;
- required integration paths;
- database verification requirements;
- relevant frontend/STUB/real-service integration path.

Unresolved requirements must be resolved from authoritative project material before generation. Do not invent missing project rules.

## Stage 2 - Build the Section Blueprint

Before producing the DOCX, create a section-by-section blueprint. For every major section record:

- section/stage title;
- learning objective;
- what is being built;
- why this stage exists;
- concepts to explain;
- Draw.io diagram(s) required;
- code fragment(s) required;
- code explanation required;
- exact student execution action;
- expected observation/output;
- deliberate failure/condition, if any;
- correction to make;
- test to add;
- regression tests/checks to rerun.

### Blueprint Gate

A major stage must not consist only of a heading plus code. If a stage lacks the necessary teaching explanation, execution/observation, or required illustration, repair the blueprint before document generation.

## Stage 3 - Generate One Major Section at a Time

Use the Golden Reference teaching sequence wherever applicable:

`Explain -> Why -> Illustrate -> Implement Small Step -> Explain Code -> Run -> Observe -> Introduce Next Condition -> Fail -> Explain Failure -> Correct -> Test -> Regression`

Do not generate an uncontrolled condensed final answer for the whole task.

## Stage 4 - Section Quality Gate

After every major section, check before proceeding:

- Does the section teach rather than merely state?
- Is the reason for the stage explained?
- Are new technical terms explained in simple English?
- Is a Draw.io illustration required and present?
- Are code fragments adequately commented?
- Are important code parts explained?
- Can a student reproduce the action from the instructions?
- Is the expected result stated?
- If the stage concerns a failure, does the student observe and understand it before the fix?
- Does the section retain Golden Reference depth?

If any required answer is `NO`, correct the section immediately. Do not defer the correction to the end.

## Stage 5 - Testing Progression

For progressive testing material:

1. Prove invocation/reachability when that is the intended first learning stage.
2. Add the normal successful behaviour.
3. Add a positive unit test and retain it as regression protection.
4. Introduce the next realistic invalid/boundary condition.
5. Run before fixing where the learning objective requires observing the failure.
6. Explain the exception/output and relevant application line.
7. Add controlled validation/correction.
8. Rerun the new test.
9. Rerun earlier successful tests.
10. Review JaCoCo where applicable.
11. Add missing tests for uncovered required paths.
12. Run local integration where applicable.
13. Verify persisted database state where applicable.
14. Repeat equivalent behaviour with Testcontainers where applicable.
15. Run final regression.

## Stage 6 - Frontend Progression

Where the task contains a frontend assignment, preserve the progressive approach required by the Golden Reference and task contract. Typically this means:

- understand/load the existing data when applicable;
- explain browser/DOM/module execution where relevant;
- first prove JavaScript/module/handler execution;
- make the fixed REST call;
- show request/response handling;
- first use presenter STUB/support where required;
- refactor only after the simple working path is proven;
- integrate the real partner service without changing the fixed URL;
- verify UI result and database effect where applicable;
- rerun regression checks.

Do not replace a detailed frontend learning path with a few code lines.

## Stage 7 - Assemble the DOCX

The document must preserve:

- consistent heading hierarchy;
- numbered code fragments;
- code explanations;
- readable Draw.io diagrams and captions;
- tables where they improve clarity;
- sample outputs where useful;
- student execution instructions;
- expected observations;
- learning summary/completion checklist;
- ownership/modification boundaries.

Page count is not itself a target. Instructional depth is the target.

## Stage 8 - Visual Inspection

After DOCX generation, render/open the complete document and inspect every page for:

- clipped text/code;
- tables crossing margins;
- unreadable or distorted diagrams;
- overlapping diagram objects/arrows;
- incorrect arrow direction;
- missing captions;
- broken heading/page breaks;
- accidental blank or nearly blank pages;
- excessive unexplained whitespace;
- inconsistent fonts/styles;
- missing headers/footers where the series uses them;
- broken numbering;
- duplicated or missing sections.

Correct visual defects and re-render until the inspection passes.

## Stage 9 - Final Quality Gate

Run QG-01 through QG-26 from `QUALITY_GATE.md` and record PASS/FAIL evidence for the task.

Any mandatory applicable `FAIL` sends the task back to correction. Do not mark the task complete.

## Stage 10 - Approval and Repository Status

Only after Quality Gate PASS:

1. update `TASK_STATUS.md`;
2. place/commit the approved output in the proper task/output location;
3. record the quality report/evidence;
4. mark the task `QUALITY GATE PASS` / `APPROVED` as applicable.

## Mandatory State Model

`PENDING -> ANALYSED -> BLUEPRINTED -> GENERATING -> GENERATED -> REVIEWING -> CORRECTING -> VISUALLY INSPECTED -> QUALITY GATE PASS -> APPROVED`

`QUALITY GATE FAIL` is not a terminal state. It always returns to `CORRECTING`.
