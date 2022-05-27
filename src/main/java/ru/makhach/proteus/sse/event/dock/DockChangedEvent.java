package ru.makhach.proteus.sse.event.dock;

import ru.makhach.proteus.sse.event.dock.base.DockEvent;

public class DockChangedEvent extends DockEvent {
    private final Long changedAt;

    public DockChangedEvent(Long id, Long changedAt) {
        super(id);
        this.changedAt = changedAt;
    }

    public Long getChangedAt() {
        return changedAt;
    }
}
