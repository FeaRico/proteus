package ru.makhach.vesselmanager.mapper.impl;

import org.springframework.stereotype.Component;
import ru.makhach.vesselmanager.mapper.DockMapper;
import ru.makhach.vesselmanager.mapper.PortMapper;
import ru.makhach.vesselmanager.model.dto.DockDto;
import ru.makhach.vesselmanager.model.entity.DockEntity;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class DockMapperImpl implements DockMapper {
    private PortMapper portMapper;

    public DockMapperImpl(PortMapper portMapper) {
        this.portMapper = portMapper;
    }

    Function<DockEntity, DockDto> entityToDto = entity ->
            new DockDto.Builder()
                    .setId(entity.getId())
                    .setVesselsCapacity(entity.getVesselsCapacity())
                    .setLatitude(entity.getLatitude())
                    .setLongitude(entity.getLongitude())
                    .setPort(portMapper.entityToDto(entity.getPort()))
                    .build();

    Function<DockDto, DockEntity> dtoToEntity = dto -> {
        DockEntity entity = new DockEntity();
        entity.setId(dto.getId());
        entity.setVesselsCapacity(dto.getVesselsCapacity());
        entity.setLatitude(dto.getLatitude());
        entity.setLongitude(dto.getLongitude());
        entity.setPort(portMapper.dtoToEntity(dto.getPort()));
        return entity;
    };

    @Override
    public DockEntity dtoToEntity(DockDto dto) {
        return dtoToEntity.apply(dto);
    }

    @Override
    public List<DockEntity> dtoToEntity(List<DockDto> list) {
        return list.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

    @Override
    public DockDto entityToDto(DockEntity entity) {
        return entityToDto.apply(entity);
    }

    @Override
    public List<DockDto> entityToDto(List<DockEntity> list) {
        return list.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
