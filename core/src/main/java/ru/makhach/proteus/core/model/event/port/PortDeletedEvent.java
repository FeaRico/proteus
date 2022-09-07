package ru.makhach.proteus.core.model.event.port;

import ru.makhach.proteus.core.model.event.port.base.PortEvent;

public class PortDeletedEvent extends PortEvent {
    private final Long deletedAt;

    public PortDeletedEvent(Long id, Long deletedAt) {
        super(id);
        this.deletedAt = deletedAt;
    }

    public Long getDeletedAt() {
        return deletedAt;
    }
}
