package ru.makhach.proteus.service.impl;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.makhach.proteus.exceptions.ResourceNotFoundException;
import ru.makhach.proteus.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.model.entity.Country;
import ru.makhach.proteus.repository.CountryRepository;
import ru.makhach.proteus.service.CountryService;
import ru.makhach.proteus.utils.PageableUtils;

import java.util.List;

@Service
@CacheConfig(cacheNames = "countryCache")
@Transactional
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(cacheNames = "countries")
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Country> getAllCountriesPageable(PageRequest request) {
        Pageable pageable = PageableUtils.pageableFromRequest(request);

        return countryRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(cacheNames = "country", key = "#id")
    public Country getCountryById(Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Country.class, "id", id));
    }

    @Override
    @Transactional(readOnly = true)
    public Country getCountryByCode(String code) {
        return countryRepository.findCountryEntityByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException(Country.class, "code", code));
    }

    @Override
    @CacheEvict(cacheNames = "countries", allEntries = true)
    public Country updateCountry(Country country) {
        Long id = country.getId();
        countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Country.class, "id", id));

        return countryRepository.save(country);
    }

    @Override
    @CacheEvict(cacheNames = "countries", allEntries = true)
    public Country saveCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    @Caching(
            evict = {
                    @CacheEvict(cacheNames = "countries", allEntries = true),
                    @CacheEvict(cacheNames = "country", key = "#id"),
            }
    )
    public Country deleteCountry(Long id) {
        Country foundEntity = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Country.class, "id", id));
        countryRepository.delete(foundEntity);
        return foundEntity;
    }
}