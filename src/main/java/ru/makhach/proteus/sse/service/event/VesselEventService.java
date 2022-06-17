package ru.makhach.proteus.sse.service.event;

import ru.makhach.proteus.model.dto.base.VesselDto;

/**
 * Слой событий для {@link VesselDto}
 */
public interface VesselEventService extends EventService<VesselDto> {
    /**
     * Событие обновления статуса судна
     *
     * @param vessel судно с обновленным статусом
     */
    void updateStatusEvent(VesselDto vessel);
}
