package ru.makhach.proteus.service.facade;

import ru.makhach.proteus.model.dto.base.CityDto;

import java.util.List;

/**
 * Сервис для работы с {@link CityDto}
 * Этот слой для взаимодействия
 * с сервисами связанных моделей
 */
public interface CityServiceFacade {
    List<CityDto> getAllCities();

    List<CityDto> getAllCitiesByCountry(Long countryId);

    CityDto getCityById(Long id);

    CityDto updateCity(CityDto city);

    CityDto saveCity(CityDto city);

    CityDto deleteCity(Long id);
}
