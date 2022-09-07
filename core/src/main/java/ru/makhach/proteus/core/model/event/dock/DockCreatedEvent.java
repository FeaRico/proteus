package ru.makhach.proteus.core.model.event.dock;

import ru.makhach.proteus.core.model.event.dock.base.DockEvent;

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
