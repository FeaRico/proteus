package ru.makhach.vesselmanager.service;

import ru.makhach.vesselmanager.model.entity.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();

    Country getCountryById(Long id);

    Country getCountryByCode(String code);

    Country updateCountry(Country country);

    Country saveCountry(Country country);

    Country deleteCountry(Long id);
}
