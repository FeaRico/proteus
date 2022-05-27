package ru.makhach.proteus.sse.event.port;

import ru.makhach.proteus.sse.event.port.base.PortEvent;

public class PortChangedEvent extends PortEvent {
    private final Long changedAt;

    public PortChangedEvent(Long id, Long changedAt) {
        super(id);
        this.changedAt = changedAt;
    }

    public Long getChangedAt() {
        return changedAt;
    }
}
