package ru.makhach.proteus.sse.event.city;

import ru.makhach.proteus.sse.event.city.base.CityEvent;

public class CityCreatedEvent extends CityEvent {
    private final Long createdAt;

    public CityCreatedEvent(Long id, Long createdAt) {
        super(id);
        this.createdAt = createdAt;
    }

    public Long getCreatedAt() {
        return createdAt;
    }
}
