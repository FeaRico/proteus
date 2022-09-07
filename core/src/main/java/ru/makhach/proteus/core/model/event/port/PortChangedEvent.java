package ru.makhach.proteus.core.model.event.port;

import ru.makhach.proteus.core.model.event.port.base.PortEvent;

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
