package ru.makhach.vesselmanager.mapper.impl;

import org.springframework.stereotype.Component;
import ru.makhach.vesselmanager.mapper.CityMapper;
import ru.makhach.vesselmanager.mapper.CountryMapper;
import ru.makhach.vesselmanager.model.dto.CityDto;
import ru.makhach.vesselmanager.model.entity.CityEntity;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CityMapperImpl implements CityMapper {
    private CountryMapper countryMapper;

    public CityMapperImpl(CountryMapper countryMapper) {
        this.countryMapper = countryMapper;
    }

    Function<CityEntity, CityDto> entityToDto = entity ->
            new CityDto(entity.getId(), entity.getName(),
                    countryMapper.entityToDto(entity.getCountry()));

    Function<CityDto, CityEntity> dtoToEntity = dto -> {
        CityEntity entity = new CityEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCountry(countryMapper.dtoToEntity(dto.getCountry()));
        return entity;
    };

    @Override
    public CityEntity dtoToEntity(CityDto dto) {
        return dtoToEntity.apply(dto);
    }

    @Override
    public List<CityEntity> dtoToEntity(List<CityDto> list) {
        return list.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

    @Override
    public CityDto entityToDto(CityEntity entity) {
        return entityToDto.apply(entity);
    }

    @Override
    public List<CityDto> entityToDto(List<CityEntity> list) {
        return list.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
