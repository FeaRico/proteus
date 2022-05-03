package ru.makhach.vesselmanager.mapper.impl;

import org.springframework.stereotype.Component;
import ru.makhach.vesselmanager.mapper.CountryMapper;
import ru.makhach.vesselmanager.model.dto.CountryDto;
import ru.makhach.vesselmanager.model.entity.CountryEntity;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CountryMapperImpl implements CountryMapper {
    Function<CountryEntity, CountryDto> entityToDto = entity ->
            new CountryDto(entity.getId(), entity.getName(),
                    entity.getCode());

    Function<CountryDto, CountryEntity> dtoToEntity = dto -> {
        CountryEntity entity = new CountryEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        return entity;
    };

    @Override
    public CountryEntity dtoToEntity(CountryDto dto) {
        return dtoToEntity.apply(dto);
    }

    @Override
    public List<CountryEntity> dtoToEntity(List<CountryDto> list) {
        return list.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

    @Override
    public CountryDto entityToDto(CountryEntity entity) {
        return entityToDto.apply(entity);
    }

    @Override
    public List<CountryDto> entityToDto(List<CountryEntity> list) {
        return list.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
