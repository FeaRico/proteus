package ru.makhach.proteus.core.service.impl.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import ru.makhach.proteus.core.model.base.types.DockStatus;
import ru.makhach.proteus.core.model.dto.base.DockRecordDto;
import ru.makhach.proteus.core.model.event.dock.record.DockRecordChangedEvent;
import ru.makhach.proteus.core.model.event.dock.record.DockRecordCreatedEvent;
import ru.makhach.proteus.core.model.event.dock.record.DockRecordDeletedEvent;
import ru.makhach.proteus.core.model.event.dock.record.DockVesselRecordEvent;
import ru.makhach.proteus.core.service.event.DockRecordEventService;

@Service
public class DockRecordEventServiceImpl implements DockRecordEventService {
    private final ApplicationEventPublisher eventPublisher;

    public DockRecordEventServiceImpl(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void vesselMooringEvent(DockRecordDto recordDto) {
        eventPublisher.publishEvent(new DockVesselRecordEvent(recordDto.getId(),
                recordDto.getVesselId(), recordDto.getDockId(), DockStatus.MOORED));
    }

    @Override
    public void vesselUnmooringEvent(DockRecordDto recordDto) {
        eventPublisher.publishEvent(new DockVesselRecordEvent(recordDto.getId(),
                recordDto.getVesselId(), recordDto.getDockId(), DockStatus.UNMOORED));
    }

    @Override
    public void saveEvent(DockRecordDto object) {
        eventPublisher.publishEvent(new DockRecordCreatedEvent(object.getId(),
                System.currentTimeMillis()));
    }

    @Override
    public void updateEvent(DockRecordDto object) {
        eventPublisher.publishEvent(new DockRecordChangedEvent(object.getId(),
                System.currentTimeMillis()));
    }

    @Override
    public void deleteEvent(DockRecordDto object) {
        eventPublisher.publishEvent(new DockRecordDeletedEvent(object.getId(),
                System.currentTimeMillis()));
    }
}
