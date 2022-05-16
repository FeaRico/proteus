package ru.makhach.vesselmanager.mapper.impl;

import org.springframework.stereotype.Component;
import ru.makhach.vesselmanager.mapper.DockMapper;
import ru.makhach.vesselmanager.mapper.PortMapper;
import ru.makhach.vesselmanager.model.dto.DockDto;
import ru.makhach.vesselmanager.model.entity.Dock;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class DockMapperImpl implements DockMapper {
    private PortMapper portMapper;

    public DockMapperImpl(PortMapper portMapper) {
        this.portMapper = portMapper;
    }

    Function<Dock, DockDto> entityToDto = entity ->
            new DockDto.Builder()
                    .setId(entity.getId())
                    .setVesselsCapacity(entity.getVesselsCapacity())
                    .setLatitude(entity.getLatitude())
                    .setLongitude(entity.getLongitude())
                    .setPort(entity.getPort().getId())
                    .build();

    Function<DockDto, Dock> dtoToEntity = dto -> {
        Dock entity = new Dock();
        entity.setId(dto.getId());
        entity.setVesselsCapacity(dto.getVesselsCapacity());
        entity.setLatitude(dto.getLatitude());
        entity.setLongitude(dto.getLongitude());
        return entity;
    };

    @Override
    public Dock dtoToEntity(DockDto dto) {
        return dtoToEntity.apply(dto);
    }

    @Override
    public List<Dock> dtoToEntity(List<DockDto> list) {
        return list.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

    @Override
    public DockDto entityToDto(Dock entity) {
        return entityToDto.apply(entity);
    }

    @Override
    public List<DockDto> entityToDto(List<Dock> list) {
        return list.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
