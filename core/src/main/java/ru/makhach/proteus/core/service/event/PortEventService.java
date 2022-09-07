package ru.makhach.proteus.core.service.event;

import ru.makhach.proteus.core.model.dto.base.PortDto;
import ru.makhach.proteus.sse.service.event.EventService;

/**
 * Слой событий для {@link PortDto}
 */
public interface PortEventService extends EventService<PortDto> {
}
