package ru.makhach.proteus.sse.service.event;

import ru.makhach.proteus.model.dto.base.CountryDto;
import ru.makhach.proteus.sse.service.event.base.EventService;

/**
 * Слой событий для {@link CountryDto}
 */
public interface CountryEventService extends EventService<CountryDto> {
}
