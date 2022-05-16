package ru.makhach.vesselmanager.service.impl;

import org.springframework.stereotype.Service;
import ru.makhach.vesselmanager.exceptions.ResourceNotFoundException;
import ru.makhach.vesselmanager.model.entity.City;
import ru.makhach.vesselmanager.repository.CityRepository;
import ru.makhach.vesselmanager.service.CityService;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    @Override
    public List<City> getAllCitiesByCountry(Long countryId) {
        return cityRepository.findAllByCountry(countryId);
    }

    @Override
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
