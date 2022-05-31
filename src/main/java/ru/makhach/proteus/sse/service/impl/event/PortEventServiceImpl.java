package ru.makhach.proteus.sse.service.impl.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import ru.makhach.proteus.model.dto.base.PortDto;
import ru.makhach.proteus.sse.event.port.PortChangedEvent;
import ru.makhach.proteus.sse.event.port.PortCreatedEvent;
import ru.makhach.proteus.sse.event.port.PortDeletedEvent;
import ru.makhach.proteus.sse.service.event.PortEventService;

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
