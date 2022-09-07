package ru.makhach.proteus.core.service.impl.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import ru.makhach.proteus.core.model.dto.base.CountryDto;
import ru.makhach.proteus.core.model.event.country.CountryChangedEvent;
import ru.makhach.proteus.core.model.event.country.CountryCreatedEvent;
import ru.makhach.proteus.core.model.event.country.CountryDeletedEvent;
import ru.makhach.proteus.core.service.event.CountryEventService;

@Service
public class CountryEventServiceImpl implements CountryEventService {
    private final ApplicationEventPublisher eventPublisher;

    public CountryEventServiceImpl(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }


    @Override
    public void saveEvent(CountryDto country) {
        eventPublisher.publishEvent(new CountryCreatedEvent(country.getId(), System.currentTimeMillis()));
    }

    @Override
    public void updateEvent(CountryDto country) {
        eventPublisher.publishEvent(new CountryChangedEvent(country.getId(), System.currentTimeMillis()));
    }

    @Override
    public void deleteEvent(CountryDto country) {
        eventPublisher.publishEvent(new CountryDeletedEvent(country.getId(), System.currentTimeMillis()));
    }
}
