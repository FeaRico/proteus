package ru.makhach.vesselmanager.service;

import ru.makhach.vesselmanager.model.dto.CountryDto;

import java.util.List;

public interface CountryService {
    List<CountryDto> getAllCountries();

    CountryDto getCountryById(Long id);

    CountryDto getCountryByCode(String code);

    CountryDto updateCountry(CountryDto country);

    CountryDto saveCountry(CountryDto country);

    CountryDto deleteCountry(Long id);
}
