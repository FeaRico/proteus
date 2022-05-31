package ru.makhach.proteus.sse.service.impl.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import ru.makhach.proteus.model.dto.base.CityDto;
import ru.makhach.proteus.sse.event.city.CityChangedEvent;
import ru.makhach.proteus.sse.event.city.CityCreatedEvent;
import ru.makhach.proteus.sse.event.city.CityDeletedEvent;
import ru.makhach.proteus.sse.service.event.CityEventService;

@Service
public class CityEventServiceImpl implements CityEventService {
    private final ApplicationEventPublisher eventPublisher;

    public CityEventServiceImpl(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Override
    public void saveEvent(CityDto city) {
        eventPublisher.publishEvent(new CityCreatedEvent(city.getId(), System.currentTimeMillis()));
    }

    @Override
    public void updateEvent(CityDto city) {
        eventPublisher.publishEvent(new CityChangedEvent(city.getId(), System.currentTimeMillis()));
    }

    @Override
    public void deleteEvent(CityDto city) {
        eventPublisher.publishEvent(new CityDeletedEvent(city.getId(), System.currentTimeMillis()));
    }
}
