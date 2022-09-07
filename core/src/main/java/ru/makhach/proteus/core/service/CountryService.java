package ru.makhach.proteus.core.service;

import org.springframework.data.domain.Page;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.core.model.entity.Country;

import java.util.List;

/**
 * Сервис для работы с сущностью {@link Country}
 * Слой без логики
 */
public interface CountryService {
    List<Country> getAllCountries();

    Page<Country> getAllCountriesPageable(PageRequest request);

    Country getCountryById(Long id);

    Country getCountryByCode(String code);

    Country updateCountry(Country country);

    Country saveCountry(Country country);

    Country deleteCountry(Long id);
}
