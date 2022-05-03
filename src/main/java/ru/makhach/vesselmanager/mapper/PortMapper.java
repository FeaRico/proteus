package ru.makhach.vesselmanager.mapper;

import ru.makhach.vesselmanager.model.dto.PortDto;
import ru.makhach.vesselmanager.model.entity.PortEntity;

import java.util.List;

public interface PortMapper {
    PortEntity dtoToEntity(PortDto dto);

    List<PortEntity> dtoToEntity(List<PortDto> list);

    PortDto entityToDto(PortEntity entity);

    List<PortDto> entityToDto(List<PortEntity> list);
}
