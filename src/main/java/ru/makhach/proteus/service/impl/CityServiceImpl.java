package ru.makhach.proteus.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.makhach.proteus.model.dto.filter.PageRequest;
import ru.makhach.proteus.utils.PageableUtils;
import ru.makhach.proteus.exceptions.ResourceNotFoundException;
import ru.makhach.proteus.model.entity.City;
import ru.makhach.proteus.repository.CityRepository;
import ru.makhach.proteus.service.CityService;

import java.util.List;

@Service
@Transactional
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<City> getAllCitiesPageable(PageRequest request) {
        Pageable pageable = PageableUtils.pageableFromRequest(request);
        return cityRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<City> getAllCitiesByCountry(Long countryId) {
        return cityRepository.findAllByCountry(countryId);
    }

    @Override
    @Transactional(readOnly = true)
    public City getCityById(Long id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(City.class, "id", id));
    }

    @Override
    public City updateCity(City city) {
        Long id = city.getId();
        cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(City.class, "id", id));

        return cityRepository.save(city);
    }

    @Override
    public City saveCity(City city) {
        return cityRepository.save(city);
    }

    @Override
    public City deleteCity(Long id) {
        City foundEntity = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(City.class, "id", id));

        cityRepository.delete(foundEntity);
        return foundEntity;
    }
}
