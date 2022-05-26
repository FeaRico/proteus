package ru.makhach.vesselmanager.service.facade;

import ru.makhach.vesselmanager.model.dto.base.CountryDto;

import java.util.List;

public interface CountryServiceFacade {
    List<CountryDto> getAllCountries();

    CountryDto getCountryById(Long id);

    CountryDto getCountryByCode(String code);

    CountryDto updateCountry(CountryDto country);

    CountryDto saveCountry(CountryDto country);

    CountryDto deleteCountry(Long id);
}
