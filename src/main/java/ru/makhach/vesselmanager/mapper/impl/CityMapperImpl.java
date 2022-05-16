package ru.makhach.vesselmanager.mapper.impl;

import org.springframework.stereotype.Component;
import ru.makhach.vesselmanager.mapper.CityMapper;
import ru.makhach.vesselmanager.mapper.CountryMapper;
import ru.makhach.vesselmanager.model.dto.CityDto;
import ru.makhach.vesselmanager.model.entity.City;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CityMapperImpl implements CityMapper {
    private CountryMapper countryMapper;

    public CityMapperImpl(CountryMapper countryMapper) {
        this.countryMapper = countryMapper;
    }

    Function<City, CityDto> entityToDto = entity ->
            new CityDto(entity.getId(), entity.getName(),
                    entity.getCountry().getId());

    Function<CityDto, City> dtoToEntity = dto -> {
        City entity = new City();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        return entity;
    };

    @Override
    public City dtoToEntity(CityDto dto) {
        return dtoToEntity.apply(dto);
    }

    @Override
    public List<City> dtoToEntity(List<CityDto> list) {
        return list.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

    @Override
    public CityDto entityToDto(City entity) {
        return entityToDto.apply(entity);
    }

    @Override
    public List<CityDto> entityToDto(List<City> list) {
        return list.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
