package ru.makhach.vesselmanager.mapper;

import ru.makhach.vesselmanager.model.dto.DockDto;
import ru.makhach.vesselmanager.model.entity.DockEntity;

import java.util.List;

public interface DockMapper {
    DockEntity dtoToEntity(DockDto dto);

    List<DockEntity> dtoToEntity(List<DockDto> list);

    DockDto entityToDto(DockEntity entity);

    List<DockDto> entityToDto(List<DockEntity> list);
}
