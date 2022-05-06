package ru.makhach.vesselmanager.mapper;

import ru.makhach.vesselmanager.model.dto.CountryDto;
import ru.makhach.vesselmanager.model.entity.Country;

import java.util.List;

public interface CountryMapper {
    Country dtoToEntity(CountryDto dto);

    List<Country> dtoToEntity(List<CountryDto> list);

    CountryDto entityToDto(Country entity);

    List<CountryDto> entityToDto(List<Country> list);
}
