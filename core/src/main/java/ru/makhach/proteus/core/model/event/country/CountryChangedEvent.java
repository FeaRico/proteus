package ru.makhach.proteus.core.model.event.country;

import ru.makhach.proteus.core.model.event.country.base.CountryEvent;

public class CountryChangedEvent extends CountryEvent {
    private final Long changedAt;

    public CountryChangedEvent(Long id, Long changedAt) {
        super(id);
        this.changedAt = changedAt;
    }

    public Long getChangedAt() {
        return changedAt;
    }
}
