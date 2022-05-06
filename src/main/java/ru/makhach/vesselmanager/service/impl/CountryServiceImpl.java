package ru.makhach.vesselmanager.service.impl;

import org.springframework.stereotype.Service;
import ru.makhach.vesselmanager.exceptions.ResourceNotFoundException;
import ru.makhach.vesselmanager.mapper.CountryMapper;
import ru.makhach.vesselmanager.model.dto.CountryDto;
import ru.makhach.vesselmanager.model.entity.Country;
import ru.makhach.vesselmanager.repository.CountryRepository;
import ru.makhach.vesselmanager.service.CountryService;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public CountryServiceImpl(CountryRepository countryRepository, CountryMapper countryMapper) {
        this.countryRepository = countryRepository;
        this.countryMapper = countryMapper;
    }

    @Override
    public List<CountryDto> getAllCountries() {
        return countryMapper.entityToDto(countryRepository.findAll());
    }

    @Override
    public CountryDto getCountryById(Long id) {
        return countryMapper.entityToDto(countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Country.class, "id", id)));
    }

    @Override
    public CountryDto getCountryByCode(String code) {
        return countryMapper.entityToDto(countryRepository.findCountryEntityByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException(Country.class, "code", code)));
    }

    @Override
    public CountryDto updateCountry(CountryDto country) {
        Long id = country.getId();
        countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Country.class, "id", id));

        Country entity = countryMapper.dtoToEntity(country);
        return countryMapper.entityToDto(countryRepository.save(entity));
    }

    @Override
    public CountryDto saveCountry(CountryDto country) {
        Country entity = countryMapper.dtoToEntity(country);
        return countryMapper.entityToDto(countryRepository.save(entity));
    }

    @Override
    public CountryDto deleteCountry(Long id) {
        Country foundEntity = countryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Country.class, "id", id));
        countryRepository.delete(foundEntity);
        return countryMapper.entityToDto(foundEntity);
    }
}
