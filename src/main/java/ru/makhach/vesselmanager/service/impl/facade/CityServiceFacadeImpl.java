package ru.makhach.vesselmanager.service.impl.facade;

import org.springframework.stereotype.Service;
import ru.makhach.vesselmanager.mapper.CityMapper;
import ru.makhach.vesselmanager.model.dto.CityDto;
import ru.makhach.vesselmanager.model.entity.City;
import ru.makhach.vesselmanager.model.entity.Country;
import ru.makhach.vesselmanager.service.CityService;
import ru.makhach.vesselmanager.service.CountryService;
import ru.makhach.vesselmanager.service.facade.CityServiceFacade;

import java.util.List;

@Service
public class CityServiceFacadeImpl implements CityServiceFacade {
    private final CityService cityService;
    private final CountryService countryService;
    private final CityMapper cityMapper;

    public CityServiceFacadeImpl(CityService cityService, CountryService countryService, CityMapper cityMapper) {
        this.cityService = cityService;
        this.countryService = countryService;
        this.cityMapper = cityMapper;
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
        return cityMapper.convert(cityService.updateCity(cityEntity));
    }

    @Override
    public CityDto saveCity(CityDto city) {
        City cityEntity = cityMapper.convert(city);
        Country country = countryService.getCountryById(city.getCountryId());
        cityEntity.setCountry(country);
        return cityMapper.convert(cityService.saveCity(cityEntity));
    }

    @Override
    public CityDto deleteCity(Long id) {
        return cityMapper.convert(cityService.deleteCity(id));
    }
}
