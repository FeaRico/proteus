package ru.makhach.vesselmanager.service;

import ru.makhach.vesselmanager.model.dto.CityDto;

import java.util.List;

public interface CityService {
    List<CityDto> getAllCities();

    List<CityDto> getAllCitiesByCountry(Long countryId);

    CityDto getCityById(Long id);

    CityDto updateCity(CityDto city);

    CityDto saveCity(CityDto city);

    CityDto deleteCity(Long id);
}
