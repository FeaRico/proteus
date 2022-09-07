package ru.makhach.proteus.core.service.event;

import ru.makhach.proteus.core.model.dto.base.CityDto;
import ru.makhach.proteus.sse.service.event.EventService;

/**
 * Слой событий для {@link CityDto}
 */
public interface CityEventService extends EventService<CityDto> {
}
