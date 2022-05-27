package ru.makhach.proteus.sse.event.dock.base;

import ru.makhach.proteus.sse.event.ProteusEvent;

/**
 * Базовый абстрактный класс событий сущности причала
 */
public abstract class DockEvent implements ProteusEvent {
    private final Long id;

    public DockEvent(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getEventType() {
        return "dock";
    }
}
