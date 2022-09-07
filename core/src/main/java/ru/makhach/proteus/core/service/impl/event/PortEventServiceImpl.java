package ru.makhach.proteus.core.service.impl.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import ru.makhach.proteus.core.model.dto.base.PortDto;
import ru.makhach.proteus.core.service.event.PortEventService;
import ru.makhach.proteus.core.model.event.port.PortChangedEvent;
import ru.makhach.proteus.core.model.event.port.PortCreatedEvent;
import ru.makhach.proteus.core.model.event.port.PortDeletedEvent;

@Service
public class PortEventServiceImpl implements PortEventService {
    private final ApplicationEventPublisher eventPublisher;

    public PortEventServiceImpl(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void saveEvent(PortDto port) {
        eventPublisher.publishEvent(new PortCreatedEvent(port.getId(), System.currentTimeMillis()));
    }

    @Override
    public void updateEvent(PortDto port) {
        eventPublisher.publishEvent(new PortChangedEvent(port.getId(), System.currentTimeMillis()));
    }

    @Override
    public void deleteEvent(PortDto port) {
        eventPublisher.publishEvent(new PortDeletedEvent(port.getId(), System.currentTimeMillis()));
    }
}
