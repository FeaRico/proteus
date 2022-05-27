package ru.makhach.proteus.sse.event.port;

import ru.makhach.proteus.sse.event.port.base.PortEvent;

public class PortCreatedEvent extends PortEvent {
    private final Long createdAt;

    public PortCreatedEvent(Long id, Long createdAt) {
        super(id);
        this.createdAt = createdAt;
    }

    public Long getCreatedAt() {
        return createdAt;
    }
}
