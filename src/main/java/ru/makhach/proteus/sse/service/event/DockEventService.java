package ru.makhach.proteus.sse.service.event;

import ru.makhach.proteus.model.dto.base.DockDto;

/**
 * Слой событий для {@link DockDto}
 */
public interface DockEventService {
    void saveEvent(DockDto dock);

    void updateEvent(DockDto dock);

    void deleteEvent(DockDto dock);
}
