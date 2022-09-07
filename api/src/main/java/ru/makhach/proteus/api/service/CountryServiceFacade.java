package ru.makhach.proteus.api.service;

import ru.makhach.proteus.core.model.dto.base.CountryDto;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageResponse;

import java.util.List;

/**
 * Сервис для работы с {@link CountryDto}
 * Этот слой для взаимодействия
 * с сервисами связанных моделей
 */
public interface CountryServiceFacade {
    List<CountryDto> getAllCountries();

    PageResponse<List<CountryDto>> getAllCountriesPageable(PageRequest request);

    CountryDto getCountryById(Long id);

    CountryDto getCountryByCode(String code);

    CountryDto updateCountry(CountryDto country);

    CountryDto saveCountry(CountryDto country);

    CountryDto deleteCountry(Long id);
}
