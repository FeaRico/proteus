package ru.makhach.proteus.sse.event.city;

import ru.makhach.proteus.sse.event.city.base.CityEvent;

public class CityDeletedEvent extends CityEvent {
    private final Long deletedAt;

    public CityDeletedEvent(Long id, Long deletedAt) {
        super(id);
        this.deletedAt = deletedAt;
    }

    public Long getDeletedAt() {
        return deletedAt;
    }
}
