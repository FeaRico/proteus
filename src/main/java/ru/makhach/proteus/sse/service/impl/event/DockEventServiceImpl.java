package ru.makhach.proteus.sse.service.impl.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import ru.makhach.proteus.model.dto.base.DockDto;
import ru.makhach.proteus.sse.event.dock.DockChangedEvent;
import ru.makhach.proteus.sse.event.dock.DockCreatedEvent;
import ru.makhach.proteus.sse.event.dock.DockDeletedEvent;
import ru.makhach.proteus.sse.service.event.DockEventService;

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
