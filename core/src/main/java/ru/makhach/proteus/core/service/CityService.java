package ru.makhach.proteus.core.service;

import org.springframework.data.domain.Page;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.core.model.entity.City;

import java.util.List;

/**
 * Сервис для работы с сущностью {@link City}
 * Слой без логики
 */
public interface CityService {
    List<City> getAllCities();

    Page<City> getAllCitiesPageable(PageRequest request);

    List<City> getAllCitiesByCountry(Long countryId);

    City getCityById(Long id);

    City updateCity(City city);

    City saveCity(City city);

    City deleteCity(Long id);
}
