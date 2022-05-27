package ru.makhach.proteus.service;

import ru.makhach.proteus.model.entity.City;

import java.util.List;

/**
 * Сервис для работы с сущностью {@link City}
 * Слой без логики
 */
public interface CityService {
    List<City> getAllCities();

    List<City> getAllCitiesByCountry(Long countryId);

    City getCityById(Long id);

    City updateCity(City city);

    City saveCity(City city);

    City deleteCity(Long id);
}
