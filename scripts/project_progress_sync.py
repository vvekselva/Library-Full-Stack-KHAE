#!/usr/bin/env python3
from pathlib import Path
from datetime import datetime
import yaml

ROOT = Path(__file__).resolve().parents[1]
PROJECT = ROOT / '.project'
MONITOR = PROJECT / 'execution-cycle-monitor.yml'
OUTPUT = PROJECT / 'PROJECT_PROGRESS.md'

WEIGHTS = {
    'Document Rerun': 0.45,
    'Presenter Solutions': 0.35,
    'Classroom Release Preparation': 0.10,
    'Recovery / Final Integration': 0.10,
}

TASK_FILES = {
    'Document Rerun': PROJECT / 'tasks/document-rerun.md',
    'Presenter Solutions': PROJECT / 'tasks/presenter-solutions.md',
    'Classroom Release Preparation': PROJECT / 'tasks/classroom-release.md',
    'Recovery / Final Integration': PROJECT / 'tasks/recovery-final-integration.md',
}


def load_yaml(path: Path):
    with path.open('r', encoding='utf-8') as f:
        return yaml.safe_load(f)


def fmt_pct(v):
    try:
        return f'{float(v):.4f}%'
    except Exception:
        return str(v)


def stream_map(monitor):
    result = {}
    for item in monitor.get('stream_stall_monitor', []):
        result[item.get('stream')] = item
    return result


def find_stream(sm, name):
    if name in sm:
        return sm[name]
    aliases = {
        'Classroom Release Preparation': ['Classroom Release', 'Classroom Release Preparation'],
        'Recovery / Final Integration': ['Recovery / Final Integration'],
    }
    for alias in aliases.get(name, []):
        if alias in sm:
            return sm[alias]
    return {}


def current_state(item):
    if item.get('over_three_cycles'):
        return 'STALE / BLOCKED'
    if float(item.get('current_percent', 0) or 0) >= 100:
        return 'CLOSED / VERIFIED'
    return 'IN PROGRESS'


def read_task_snapshot(path: Path):
    if not path.exists():
        return 'Task file missing.'
    text = path.read_text(encoding='utf-8').strip()
    # Keep the detailed stream ledger in the dashboard so component/checkpoint state remains auditable.
    return text


def main():
    monitor = load_yaml(MONITOR)
    sm = stream_map(monitor)
    cycle = monitor.get('current_cycle', {})
    orchestration = monitor.get('orchestration', {})

    rows = []
    computed_overall = 0.0
    for stream, weight in WEIGHTS.items():
        item = find_stream(sm, stream)
        current = float(item.get('current_percent', 0) or 0)
        computed_overall += current * weight
        rows.append((stream, weight, item))

    monitor_overall = sm.get('Overall', {})
    sync_status = 'SUCCESS'
    unresolved = []
    if monitor_overall:
        try:
            stated = float(monitor_overall.get('current_percent'))
            if abs(stated - computed_overall) > 0.001:
                sync_status = 'DEGRADED'
                unresolved.append(f'Overall mismatch: monitor={stated:.4f}, calculated={computed_overall:.4f}')
        except Exception:
            sync_status = 'DEGRADED'
            unresolved.append('Overall percentage in monitor is not numeric.')

    updated_at = monitor.get('updated_at') or datetime.now().astimezone().isoformat(timespec='seconds')
    cycle_id = cycle.get('cycle_id', 'UNKNOWN')

    out = []
    out += [
        '# KHAE Full Stack — Live Project Progress',
        '',
        '> **AUTHORITATIVE GENERATED DASHBOARD**',
        '>',
        '> This file is generated only by `PROJECT_PROGRESS_SYNCHRONIZER`.',
        '> Worker lanes, watchdogs, and manual coordinators must update source evidence files instead of editing this dashboard directly.',
        '',
        f'- **Last synchronized cycle:** `{cycle_id}`',
        f'- **Last source update:** `{updated_at}`',
        f'- **Synchronizer status:** **{sync_status}**',
        '- **Processor:** `scripts/project_progress_sync.py`',
        '- **Workflow:** `.github/workflows/project-progress-sync.yml`',
        '',
    ]
    if unresolved:
        out.append('## Synchronizer warnings')
        out.extend([f'- {x}' for x in unresolved])
        out.append('')

    out += [
        '## Frozen Progress Formula',
        '- Document Rerun: 45%',
        '- Presenter Solutions: 35%',
        '- Classroom Release Preparation: 10%',
        '- Recovery / Final Integration: 10%',
        '',
        '`Overall = Documents*0.45 + PresenterSolutions*0.35 + ClassroomReleases*0.10 + Recovery*0.10`',
        '',
        '## Current Status',
        '',
        '| Stream | Weight | Previous % | Updated % | Increase | Lifecycle State | Stale Cycles | Action Taken in Latest Cycle |',
        '|---|---:|---:|---:|---:|---|---:|---|',
    ]
    for stream, weight, item in rows:
        stale = item.get('total_stale_cycles', 0)
        action = str(item.get('action_taken_in_this_cycle', '')).replace('|', '\\|')
        out.append(
            f"| {stream} | {weight*100:.0f}% | {fmt_pct(item.get('previous_percent', 0))} | "
            f"**{fmt_pct(item.get('current_percent', 0))}** | {fmt_pct(item.get('increase', 0))} | "
            f"**{current_state(item)}** | {stale} | {action} |"
        )
    overall_prev = monitor_overall.get('previous_percent', computed_overall)
    overall_inc = monitor_overall.get('increase', 0)
    out.append(
        f"| **Overall** | **100%** | {fmt_pct(overall_prev)} | **{computed_overall:.4f}%** | "
        f"{fmt_pct(overall_inc)} | **IN PROGRESS** | {monitor_overall.get('total_stale_cycles', 0)} | "
        f"{str(monitor_overall.get('action_taken_in_this_cycle', '')).replace('|', '\\|')} |"
    )

    out += ['', '## Active Logical Lanes', '', '| Lane | Assignment |', '|---|---|']
    allocation = orchestration.get('allocation', {})
    for key in sorted(allocation.keys()):
        label = key.replace('_', ' ').title()
        out.append(f"| {label} | {str(allocation[key]).replace('|', '\\|')} |")

    out += ['', '## Latest Cycle Tasks', '', '| Human-readable Task | Stream | Status | Closed This Cycle | Evidence | Action Taken |', '|---|---|---|---|---|---|']
    for task in cycle.get('tasks', []):
        out.append(
            f"| {str(task.get('task','')).replace('|','\\|')} | {str(task.get('stream','')).replace('|','\\|')} | "
            f"**{str(task.get('status','')).replace('|','\\|')}** | {task.get('closed_this_cycle', False)} | "
            f"{str(task.get('evidence','')).replace('|','\\|')} | {str(task.get('action_taken_in_this_cycle','')).replace('|','\\|')} |"
        )

    out += ['', '## Tasks / Streams Open More Than 3 Cycles and Action Taken', '', '| Task / Stream | State | Total Stale Cycles | Stale Since Cycle | Action Taken in This Cycle |', '|---|---|---:|---|---|']
    for task in monitor.get('stalled_tasks', []):
        out.append(
            f"| {str(task.get('task','')).replace('|','\\|')} | **{str(task.get('state','')).replace('|','\\|')}** | "
            f"{task.get('total_stale_cycles','UNKNOWN_PENDING_RECONCILIATION')} | {task.get('stale_since_cycle','UNKNOWN_PENDING_RECONCILIATION')} | "
            f"{str(task.get('action_taken_in_this_cycle','')).replace('|','\\|')} |"
        )

    out += [
        '',
        '## Component / Checkpoint Detail',
        '',
        'The following stream ledgers are copied from the authoritative task files at synchronization time so every component/checkpoint, evidence item, blocker and next gate remains visible from this one dashboard.',
        '',
    ]
    for stream, path in TASK_FILES.items():
        out += [f'### {stream}', '', read_task_snapshot(path), '']

    safety = monitor.get('safety', {})
    out += [
        '## Safety',
        f"- Public classroom write: **{safety.get('public_classroom_write','FORBIDDEN')}**",
        f"- Quality Gate write: **{safety.get('quality_gate_write','FORBIDDEN')}**",
        '- Percentage credit is never granted for inspection/preparation alone.',
        '- Dependent tasks must not start before their defined prerequisite gate closes.',
        '',
        '## Synchronizer Inputs',
        '- `.project/execution-cycle-monitor.yml`',
        '- `.project/tasks/document-rerun.md`',
        '- `.project/tasks/presenter-solutions.md`',
        '- `.project/tasks/classroom-release.md`',
        '- `.project/tasks/recovery-final-integration.md`',
        '- `.project/ORCHESTRATOR_PLAN.md`',
        '',
    ]

    new_content = '\n'.join(out).rstrip() + '\n'
    OUTPUT.write_text(new_content, encoding='utf-8')
    print(f'Generated {OUTPUT.relative_to(ROOT)} for {cycle_id} with status {sync_status}')


if __name__ == '__main__':
    main()
