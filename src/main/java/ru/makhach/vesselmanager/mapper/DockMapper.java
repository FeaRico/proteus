package ru.makhach.vesselmanager.mapper;

import ru.makhach.vesselmanager.model.dto.DockDto;
import ru.makhach.vesselmanager.model.entity.Dock;

import java.util.List;

public interface DockMapper {
    Dock dtoToEntity(DockDto dto);

    List<Dock> dtoToEntity(List<DockDto> list);

    DockDto entityToDto(Dock entity);

    List<DockDto> entityToDto(List<Dock> list);
}
