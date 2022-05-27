package ru.makhach.proteus.sse.event.dock;

import ru.makhach.proteus.sse.event.dock.base.DockEvent;

public class DockCreatedEvent extends DockEvent {
    private final Long createdAt;

    public DockCreatedEvent(Long id, Long createdAt) {
        super(id);
        this.createdAt = createdAt;
    }

    public Long getCreatedAt() {
        return createdAt;
    }
}
