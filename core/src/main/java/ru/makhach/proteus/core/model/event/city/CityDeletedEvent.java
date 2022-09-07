package ru.makhach.proteus.core.model.event.city;

import ru.makhach.proteus.core.model.event.city.base.CityEvent;

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
