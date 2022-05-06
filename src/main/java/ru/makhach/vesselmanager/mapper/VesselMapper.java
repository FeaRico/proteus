package ru.makhach.vesselmanager.mapper;

import ru.makhach.vesselmanager.model.dto.VesselDto;
import ru.makhach.vesselmanager.model.entity.Vessel;

import java.util.List;

public interface VesselMapper {
    Vessel dtoToEntity(VesselDto dto);

    List<Vessel> dtoToEntity(List<VesselDto> list);

    VesselDto entityToDto(Vessel entity);

    List<VesselDto> entityToDto(List<Vessel> list);
}
