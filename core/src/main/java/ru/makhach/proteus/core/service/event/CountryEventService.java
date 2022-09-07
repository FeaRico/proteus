package ru.makhach.proteus.core.service.event;

import ru.makhach.proteus.core.model.dto.base.CountryDto;
import ru.makhach.proteus.sse.service.event.EventService;

/**
 * Слой событий для {@link CountryDto}
 */
public interface CountryEventService extends EventService<CountryDto> {
}
