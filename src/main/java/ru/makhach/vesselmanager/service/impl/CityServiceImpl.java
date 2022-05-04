package ru.makhach.vesselmanager.service.impl;

import org.springframework.stereotype.Service;
import ru.makhach.vesselmanager.exceptions.ResourceNotFoundException;
import ru.makhach.vesselmanager.mapper.CityMapper;
import ru.makhach.vesselmanager.model.dto.CityDto;
import ru.makhach.vesselmanager.model.entity.CityEntity;
import ru.makhach.vesselmanager.repository.CityRepository;
import ru.makhach.vesselmanager.service.CityService;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public CityServiceImpl(CityRepository cityRepository, CityMapper cityMapper) {
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
    }

    @Override
    public List<CityDto> getAllCities() {
        return cityMapper.entityToDto(cityRepository.findAll());
    }

    @Override
    public List<CityDto> getAllCitiesByCountry(Long countryId) {
        return cityMapper.entityToDto(cityRepository.findAllByCountry(countryId));
    }

    @Override
    public CityDto getCityById(Long id) {
        return cityMapper.entityToDto(cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(CityEntity.class, "id", id)));
    }

    @Override
    public CityDto updateCity(CityDto city) {
        Long id = city.getId();
        cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(CityEntity.class, "id", id));

        CityEntity entity = cityMapper.dtoToEntity(city);
        return cityMapper.entityToDto(cityRepository.save(entity));
    }

    @Override
    public CityDto saveCity(CityDto city) {
        CityEntity entity = cityMapper.dtoToEntity(city);
        return cityMapper.entityToDto(cityRepository.save(entity));
    }

    @Override
    public CityDto deleteCity(Long id) {
        CityEntity foundEntity = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(CityEntity.class, "id", id));

        cityRepository.delete(foundEntity);
        return cityMapper.entityToDto(foundEntity);
    }
}
