package ru.makhach.proteus.service.facade;

import ru.makhach.proteus.model.dto.base.CityDto;

import java.util.List;

public interface CityServiceFacade {
    List<CityDto> getAllCities();

    List<CityDto> getAllCitiesByCountry(Long countryId);

    CityDto getCityById(Long id);

    CityDto updateCity(CityDto city);

    CityDto saveCity(CityDto city);

    CityDto deleteCity(Long id);
}
