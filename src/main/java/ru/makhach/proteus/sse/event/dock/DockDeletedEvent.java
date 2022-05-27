package ru.makhach.proteus.sse.event.dock;

import ru.makhach.proteus.sse.event.dock.base.DockEvent;

public class DockDeletedEvent extends DockEvent {
    private final Long deletedAt;

    public DockDeletedEvent(Long id, Long deletedAt) {
        super(id);
        this.deletedAt = deletedAt;
    }

    public Long getDeletedAt() {
        return deletedAt;
    }
}
