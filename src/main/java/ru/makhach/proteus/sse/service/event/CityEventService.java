package ru.makhach.proteus.sse.service.event;

import ru.makhach.proteus.model.dto.base.CityDto;

/**
 * Слой событий для {@link CityDto}
 */
public interface CityEventService {
    void saveEvent(CityDto city);

    void updateEvent(CityDto city);

    void deleteEvent(CityDto city);
}
