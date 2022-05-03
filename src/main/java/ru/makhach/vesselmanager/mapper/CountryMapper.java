package ru.makhach.vesselmanager.mapper;

import ru.makhach.vesselmanager.model.dto.CountryDto;
import ru.makhach.vesselmanager.model.entity.CountryEntity;

import java.util.List;

public interface CountryMapper {
    CountryEntity dtoToEntity(CountryDto dto);

    List<CountryEntity> dtoToEntity(List<CountryDto> list);

    CountryDto entityToDto(CountryEntity entity);

    List<CountryDto> entityToDto(List<CountryEntity> list);
}
