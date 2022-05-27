package ru.makhach.proteus.sse.event.port;

import ru.makhach.proteus.sse.event.port.base.PortEvent;

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
