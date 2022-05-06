package ru.makhach.vesselmanager.mapper;

import ru.makhach.vesselmanager.model.dto.PortDto;
import ru.makhach.vesselmanager.model.entity.Port;

import java.util.List;

public interface PortMapper {
    Port dtoToEntity(PortDto dto);

    List<Port> dtoToEntity(List<PortDto> list);

    PortDto entityToDto(Port entity);

    List<PortDto> entityToDto(List<Port> list);
}
