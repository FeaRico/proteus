package ru.makhach.proteus.core.service.event;

import ru.makhach.proteus.core.model.dto.base.DockDto;
import ru.makhach.proteus.sse.service.event.EventService;

/**
 * Слой событий для {@link DockDto}
 */
public interface DockEventService extends EventService<DockDto> {
}
