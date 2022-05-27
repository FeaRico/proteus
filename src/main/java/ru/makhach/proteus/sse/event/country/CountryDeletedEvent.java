package ru.makhach.proteus.sse.event.country;

import ru.makhach.proteus.sse.event.country.base.CountryEvent;

public class CountryDeletedEvent extends CountryEvent {
    private final Long deletedAt;

    public CountryDeletedEvent(Long id, Long deletedAt) {
        super(id);
        this.deletedAt = deletedAt;
    }

    public Long getDeletedAt() {
        return deletedAt;
    }
}
