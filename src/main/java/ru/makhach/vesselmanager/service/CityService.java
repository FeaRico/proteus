package ru.makhach.vesselmanager.service;

import ru.makhach.vesselmanager.model.entity.City;

import java.util.List;

public interface CityService {
    List<City> getAllCities();

    List<City> getAllCitiesByCountry(Long countryId);

    City getCityById(Long id);

    City updateCity(City city);

    City saveCity(City city);

    City deleteCity(Long id);
}
