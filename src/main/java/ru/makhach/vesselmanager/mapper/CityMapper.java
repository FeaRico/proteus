package ru.makhach.vesselmanager.mapper;

import ru.makhach.vesselmanager.model.dto.CityDto;
import ru.makhach.vesselmanager.model.entity.City;

import java.util.List;

public interface CityMapper {
    City dtoToEntity(CityDto dto);

    List<City> dtoToEntity(List<CityDto> list);

    CityDto entityToDto(City entity);

    List<CityDto> entityToDto(List<City> list);
}
