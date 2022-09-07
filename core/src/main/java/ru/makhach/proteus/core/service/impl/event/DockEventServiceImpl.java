package ru.makhach.proteus.core.service.impl.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import ru.makhach.proteus.core.model.dto.base.DockDto;
import ru.makhach.proteus.core.service.event.DockEventService;
import ru.makhach.proteus.core.model.event.dock.DockChangedEvent;
import ru.makhach.proteus.core.model.event.dock.DockCreatedEvent;
import ru.makhach.proteus.core.model.event.dock.DockDeletedEvent;

@Service
public class DockEventServiceImpl implements DockEventService {
    private final ApplicationEventPublisher eventPublisher;

    public DockEventServiceImpl(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void saveEvent(DockDto dock) {
        eventPublisher.publishEvent(new DockCreatedEvent(dock.getId(), System.currentTimeMillis()));
    }

    @Override
    public void updateEvent(DockDto dock) {
        eventPublisher.publishEvent(new DockChangedEvent(dock.getId(), System.currentTimeMillis()));
    }

    @Override
    public void deleteEvent(DockDto dock) {
        eventPublisher.publishEvent(new DockDeletedEvent(dock.getId(), System.currentTimeMillis()));
    }
}
