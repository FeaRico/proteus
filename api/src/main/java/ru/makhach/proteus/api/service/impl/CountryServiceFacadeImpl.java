package ru.makhach.proteus.api.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.makhach.proteus.core.mapper.CountryMapper;
import ru.makhach.proteus.core.model.dto.base.CountryDto;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageResponse;
import ru.makhach.proteus.core.model.entity.Country;
import ru.makhach.proteus.core.service.CountryService;
import ru.makhach.proteus.core.service.event.CountryEventService;
import ru.makhach.proteus.api.service.CountryServiceFacade;

import java.util.List;

@Service
public class CountryServiceFacadeImpl implements CountryServiceFacade {
    private final CountryService countryService;
    private final CountryMapper countryMapper;
    private final CountryEventService eventService;

    public CountryServiceFacadeImpl(CountryService countryService, CountryMapper countryMapper, CountryEventService eventService) {
        this.countryService = countryService;
        this.countryMapper = countryMapper;
        this.eventService = eventService;
    }

    public List<CountryDto> getAllCountries() {
        return countryMapper.convertToDtos(countryService.getAllCountries());
    }

    @Override
    public PageResponse<List<CountryDto>> getAllCountriesPageable(PageRequest request) {
        Page<Country> page = countryService.getAllCountriesPageable(request);
        return countryMapper.convertToPageResponse(page, request);
    }

    @Override
    public CountryDto getCountryById(Long id) {
        return countryMapper.convert(countryService.getCountryById(id));
    }

    @Override
    public CountryDto getCountryByCode(String code) {
        return countryMapper.convert(countryService.getCountryByCode(code));
    }

    @Override
    public CountryDto updateCountry(CountryDto country) {
        Country entity = countryMapper.convert(country);
        CountryDto updatedCountry = countryMapper.convert(countryService.updateCountry(entity));
        eventService.updateEvent(updatedCountry);
        return updatedCountry;
    }

    @Override
    public CountryDto saveCountry(CountryDto country) {
        Country entity = countryMapper.convert(country);
        CountryDto savedCountry = countryMapper.convert(countryService.saveCountry(entity));
        eventService.saveEvent(savedCountry);
        return savedCountry;
    }

    @Override
    public CountryDto deleteCountry(Long id) {
        CountryDto deletedCountry = countryMapper.convert(countryService.deleteCountry(id));
        eventService.deleteEvent(deletedCountry);
        return deletedCountry;
    }
}
