package ru.makhach.proteus.service.facade;

import ru.makhach.proteus.model.dto.base.CityDto;
import ru.makhach.proteus.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.model.dto.filter.pageable.PageResponse;

import java.util.List;

/**
 * Сервис для работы с {@link CityDto}
 * Этот слой для взаимодействия
 * с сервисами связанных моделей
 */
public interface CityServiceFacade {
    List<CityDto> getAllCities();

    PageResponse<List<CityDto>> getAllCitiesPageable(PageRequest request);

    List<CityDto> getAllCitiesByCountry(Long countryId);

    CityDto getCityById(Long id);

    CityDto updateCity(CityDto city);

    CityDto saveCity(CityDto city);

    CityDto deleteCity(Long id);
}
