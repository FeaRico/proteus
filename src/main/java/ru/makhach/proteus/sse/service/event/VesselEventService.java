package ru.makhach.proteus.sse.service.event;

import ru.makhach.proteus.model.dto.base.VesselDto;

/**
 * Слой событий для {@link VesselDto}
 */
public interface VesselEventService {
    void saveEvent(VesselDto vessel);

    void updateEvent(VesselDto vessel);

    void updateStatusEvent(VesselDto vessel);

    void deleteEvent(VesselDto vessel);
}
