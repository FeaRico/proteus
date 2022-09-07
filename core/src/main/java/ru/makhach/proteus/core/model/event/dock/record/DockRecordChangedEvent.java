package ru.makhach.proteus.core.model.event.dock.record;

import ru.makhach.proteus.core.model.event.dock.record.base.DockRecordEvent;

public class DockRecordChangedEvent extends DockRecordEvent {
    private final Long changedAt;

    public DockRecordChangedEvent(Long id, Long changedAt) {
        super(id);
        this.changedAt = changedAt;
    }

    public Long getChangedAt() {
        return changedAt;
    }
}