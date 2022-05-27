package ru.makhach.proteus.service.facade;

import ru.makhach.proteus.model.dto.base.CountryDto;

import java.util.List;

/**
 * Сервис для работы с {@link CountryDto}
 * Этот слой для взаимодействия
 * с сервисами связанных моделей
 */
public interface CountryServiceFacade {
    List<CountryDto> getAllCountries();

    CountryDto getCountryById(Long id);

    CountryDto getCountryByCode(String code);

    CountryDto updateCountry(CountryDto country);

    CountryDto saveCountry(CountryDto country);

    CountryDto deleteCountry(Long id);
}
