package ru.makhach.proteus.service.impl.facade;

import org.springframework.stereotype.Service;
import ru.makhach.proteus.mapper.CityMapper;
import ru.makhach.proteus.model.dto.base.CityDto;
import ru.makhach.proteus.model.entity.City;
import ru.makhach.proteus.model.entity.Country;
import ru.makhach.proteus.service.CityService;
import ru.makhach.proteus.service.CountryService;
import ru.makhach.proteus.service.facade.CityServiceFacade;
import ru.makhach.proteus.sse.service.event.CityEventService;

import java.util.List;

@Service
public class CityServiceFacadeImpl implements CityServiceFacade {
    private final CityService cityService;
    private final CountryService countryService;
    private final CityMapper cityMapper;
    private final CityEventService eventService;

    public CityServiceFacadeImpl(CityService cityService, CountryService countryService, CityMapper cityMapper, CityEventService eventService) {
        this.cityService = cityService;
        this.countryService = countryService;
        this.cityMapper = cityMapper;
        this.eventService = eventService;
    }


    @Override
    public List<CityDto> getAllCities() {
        return cityMapper.convertToDtos(cityService.getAllCities());
    }

    @Override
    public List<CityDto> getAllCitiesByCountry(Long countryId) {
        return cityMapper.convertToDtos(cityService.getAllCitiesByCountry(countryId));
    }

    @Override
    public CityDto getCityById(Long id) {
        return cityMapper.convert(cityService.getCityById(id));
    }

    @Override
    public CityDto updateCity(CityDto city) {
        City cityEntity = cityMapper.convert(city);
        Country country = countryService.getCountryById(city.getCountryId());
        cityEntity.setCountry(country);
        CityDto updatedCity = cityMapper.convert(cityService.updateCity(cityEntity));
        eventService.updateEvent(updatedCity);
        return updatedCity;
    }

    @Override
    public CityDto saveCity(CityDto city) {
        City cityEntity = cityMapper.convert(city);
        Country country = countryService.getCountryById(city.getCountryId());
        cityEntity.setCountry(country);
        CityDto savedCity = cityMapper.convert(cityService.saveCity(cityEntity));
        eventService.saveEvent(city);
        return savedCity;
    }

    @Override
    public CityDto deleteCity(Long id) {
        CityDto deletedCity = cityMapper.convert(cityService.deleteCity(id));
        eventService.deleteEvent(deletedCity);
        return deletedCity;
    }
}
