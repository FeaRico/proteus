package ru.makhach.proteus.sse.event.port.base;

import ru.makhach.proteus.sse.event.ProteusEvent;

/**
 * Базовый абстрактный класс событий сущности порта
 */
public abstract class PortEvent implements ProteusEvent {
    private final Long id;

    public PortEvent(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getEventType() {
        return "port";
    }
}
