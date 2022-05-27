package ru.makhach.proteus.sse.event.country.base;

import ru.makhach.proteus.sse.event.ProteusEvent;

/**
 * Базовый абстрактный класс событий сущности страны
 */
public abstract class CountryEvent implements ProteusEvent {
    private final Long id;

    protected CountryEvent(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getEventType() {
        return "country";
    }
}
