package ru.makhach.proteus.sse.service.event;

import ru.makhach.proteus.model.dto.base.CountryDto;

/**
 * Слой событий для {@link CountryDto}
 */
public interface CountryEventService {
    void saveEvent(CountryDto country);

    void updateEvent(CountryDto country);

    void deleteEvent(CountryDto country);
}
