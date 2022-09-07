package ru.makhach.proteus.core.model.event.city.base;

import ru.makhach.proteus.sse.event.ProteusEvent;

/**
 * Базовый абстрактный класс событий сущности города
 */
public abstract class CityEvent implements ProteusEvent {
    private final Long id;

    public CityEvent(Long id) {
        this.id = id;
    }

    @Override
    public String getEventType() {
        return "city";
    }
}
