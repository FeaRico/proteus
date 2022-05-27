package ru.makhach.proteus.sse.event.country;

import ru.makhach.proteus.sse.event.country.base.CountryEvent;

public class CountryCreatedEvent extends CountryEvent {
    private final Long createdAt;

    public CountryCreatedEvent(Long id, Long createdAt) {
        super(id);
        this.createdAt = createdAt;
    }

    public Long getCreatedAt() {
        return createdAt;
    }
}
