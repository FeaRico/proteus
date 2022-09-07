package ru.makhach.proteus.core.model.event.vessel.base;

import ru.makhach.proteus.sse.event.ProteusEvent;

/**
 * Базовый абстрактный класс событий сущности судна
 */
public abstract class VesselEvent implements ProteusEvent {
    private final Long id;

    public VesselEvent(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getEventType() {
        return "vessel";
    }
}
