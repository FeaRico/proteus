package ru.makhach.proteus.core.model.event.city;

import ru.makhach.proteus.core.model.event.city.base.CityEvent;

public class CityChangedEvent extends CityEvent {
    private final Long changedAt;

    public CityChangedEvent(Long id, Long changedAt) {
        super(id);
        this.changedAt = changedAt;
    }

    public Long getChangedAt() {
        return changedAt;
    }
}
