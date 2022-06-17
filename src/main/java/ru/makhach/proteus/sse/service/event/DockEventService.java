package ru.makhach.proteus.sse.service.event;

import ru.makhach.proteus.model.dto.base.DockDto;
import ru.makhach.proteus.sse.service.event.base.EventService;

/**
 * Слой событий для {@link DockDto}
 */
public interface DockEventService extends EventService<DockDto> {
}
