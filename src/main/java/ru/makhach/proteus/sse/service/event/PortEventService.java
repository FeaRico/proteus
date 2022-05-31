package ru.makhach.proteus.sse.service.event;

import ru.makhach.proteus.model.dto.base.PortDto;

/**
 * Слой событий для {@link PortDto}
 */
public interface PortEventService {
    void saveEvent(PortDto port);

    void updateEvent(PortDto port);

    void deleteEvent(PortDto port);
}
