package ru.makhach.vesselmanager.mapper;

import ru.makhach.vesselmanager.model.dto.VesselDto;
import ru.makhach.vesselmanager.model.entity.VesselEntity;

import java.util.List;

public interface VesselMapper {
    VesselEntity dtoToEntity(VesselDto dto);

    List<VesselEntity> dtoToEntity(List<VesselDto> list);

    VesselDto entityToDto(VesselEntity entity);

    List<VesselDto> entityToDto(List<VesselEntity> list);
}
