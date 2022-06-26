package ru.makhach.proteus.sse.event.dock.record;

import ru.makhach.proteus.sse.event.dock.record.base.DockRecordEvent;

public class DockRecordCreatedEvent extends DockRecordEvent {
    private final Long createdAt;

    public DockRecordCreatedEvent(Long id, Long createdAt) {
        super(id);
        this.createdAt = createdAt;
    }

    public Long getCreatedAt() {
        return createdAt;
    }
}
