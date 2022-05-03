package ru.makhach.vesselmanager.mapper;

import ru.makhach.vesselmanager.model.dto.CityDto;
import ru.makhach.vesselmanager.model.entity.CityEntity;

import java.util.List;

public interface CityMapper {
    CityEntity dtoToEntity(CityDto dto);

    List<CityEntity> dtoToEntity(List<CityDto> list);

    CityDto entityToDto(CityEntity entity);

    List<CityDto> entityToDto(List<CityEntity> list);
}
