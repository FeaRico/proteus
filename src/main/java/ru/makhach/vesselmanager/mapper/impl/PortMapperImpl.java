package ru.makhach.vesselmanager.mapper.impl;

import org.springframework.stereotype.Component;
import ru.makhach.vesselmanager.mapper.CityMapper;
import ru.makhach.vesselmanager.mapper.PortMapper;
import ru.makhach.vesselmanager.model.dto.PortDto;
import ru.makhach.vesselmanager.model.entity.PortEntity;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class PortMapperImpl implements PortMapper {
    private CityMapper cityMapper;

    public PortMapperImpl(CityMapper cityMapper) {
        this.cityMapper = cityMapper;
    }

    Function<PortEntity, PortDto> entityToDto = entity ->
            new PortDto.Builder()
                    .setId(entity.getId())
                    .setName(entity.getName())
                    .setLatitude(entity.getLatitude())
                    .setLongitude(entity.getLongitude())
                    .setCity(cityMapper.entityToDto(entity.getCity()))
                    .build();

    Function<PortDto, PortEntity> dtoToEntity = dto -> {
        PortEntity entity = new PortEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setLatitude(dto.getLatitude());
        entity.setLongitude(dto.getLongitude());
        entity.setCity(cityMapper.dtoToEntity(dto.getCity()));
        return entity;
    };

    @Override
    public PortEntity dtoToEntity(PortDto dto) {
        return dtoToEntity.apply(dto);
    }

    @Override
    public List<PortEntity> dtoToEntity(List<PortDto> list) {
        return list.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

    @Override
    public PortDto entityToDto(PortEntity entity) {
        return entityToDto.apply(entity);
    }

    @Override
    public List<PortDto> entityToDto(List<PortEntity> list) {
        return list.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
