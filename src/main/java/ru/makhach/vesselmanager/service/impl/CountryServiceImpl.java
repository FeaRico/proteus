package ru.makhach.vesselmanager.service.impl;

import org.springframework.stereotype.Service;
import ru.makhach.vesselmanager.exceptions.ResourceNotFoundException;
import ru.makhach.vesselmanager.model.entity.Country;
import ru.makhach.vesselmanager.repository.CountryRepository;
import ru.makhach.vesselmanager.service.CountryService;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country getCountryById(Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Country.class, "id", id));
    }

    @Override
    public Country getCountryByCode(String code) {
        return countryRepository.findCountryEntityByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException(Country.class, "code", code));
    }

    @Override
    public Country updateCountry(Country country) {
        Long id = country.getId();
        countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Country.class, "id", id));

        return countryRepository.save(country);
    }

    @Override
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country deleteCountry(Long id) {
        Country foundEntity = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Country.class, "id", id));
        countryRepository.delete(foundEntity);
        return foundEntity;
    }
}
