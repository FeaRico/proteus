package ru.makhach.proteus.sse.service.event;

import ru.makhach.proteus.model.dto.base.CityDto;
import ru.makhach.proteus.sse.service.event.base.EventService;

/**
 * Слой событий для {@link CityDto}
 */
public interface CityEventService extends EventService<CityDto> {
}
