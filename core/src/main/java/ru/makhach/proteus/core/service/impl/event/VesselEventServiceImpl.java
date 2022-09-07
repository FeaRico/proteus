package ru.makhach.proteus.core.service.impl.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import ru.makhach.proteus.core.model.dto.base.VesselDto;
import ru.makhach.proteus.core.model.event.vessel.VesselChangedEvent;
import ru.makhach.proteus.core.model.event.vessel.VesselCreatedEvent;
import ru.makhach.proteus.core.model.event.vessel.VesselDeletedEvent;
import ru.makhach.proteus.core.model.event.vessel.VesselStatusChangedEvent;
import ru.makhach.proteus.core.service.event.VesselEventService;

@Service
public class VesselEventServiceImpl implements VesselEventService {
    private final ApplicationEventPublisher eventPublisher;

    public VesselEventServiceImpl(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void saveEvent(VesselDto vessel) {
        eventPublisher.publishEvent(new VesselCreatedEvent(vessel.getId(), System.currentTimeMillis()));
    }

    @Override
    public void updateEvent(VesselDto vessel) {
        eventPublisher.publishEvent(new VesselChangedEvent(vessel.getId(), System.currentTimeMillis()));
    }

    @Override
    public void updateStatusEvent(VesselDto vessel) {
        long changedAt = System.currentTimeMillis();
        eventPublisher.publishEvent(new VesselStatusChangedEvent(vessel.getId(), changedAt, vessel.getStatus()));
    }

    @Override
    public void deleteEvent(VesselDto vessel) {
        eventPublisher.publishEvent(new VesselDeletedEvent(vessel.getId(), System.currentTimeMillis()));
    }
}
