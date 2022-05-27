package ru.makhach.proteus.service.impl.facade;

import org.springframework.stereotype.Service;
import ru.makhach.proteus.mapper.CountryMapper;
import ru.makhach.proteus.model.dto.base.CountryDto;
import ru.makhach.proteus.model.entity.Country;
import ru.makhach.proteus.service.CountryService;
import ru.makhach.proteus.service.facade.CountryServiceFacade;

import java.util.List;

@Service
public class CountryServiceFacadeImpl implements CountryServiceFacade {
    private final CountryService countryService;
    private final CountryMapper countryMapper;

    public CountryServiceFacadeImpl(CountryService countryService, CountryMapper countryMapper) {
        this.countryService = countryService;
        this.countryMapper = countryMapper;
    }

    public List<CountryDto> getAllCountries() {
        return countryMapper.convertToDtos(countryService.getAllCountries());
    }

    @Override
    public CountryDto getCountryById(Long id) {
        return countryMapper.convert(countryService.getCountryById(id));
    }

    @Override
    public CountryDto getCountryByCode(String code) {
        return countryMapper.convert(countryService.getCountryByCode(code));
    }

    @Override
    public CountryDto updateCountry(CountryDto country) {
        Country entity = countryMapper.convert(country);
        return countryMapper.convert(countryService.updateCountry(entity));
    }

    @Override
    public CountryDto saveCountry(CountryDto country) {
        Country entity = countryMapper.convert(country);
        return countryMapper.convert(countryService.saveCountry(entity));
    }

    @Override
    public CountryDto deleteCountry(Long id) {
        return countryMapper.convert(countryService.deleteCountry(id));
    }
}
