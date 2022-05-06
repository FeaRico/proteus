package ru.makhach.vesselmanager.mapper.impl;

import org.springframework.stereotype.Component;
import ru.makhach.vesselmanager.mapper.CountryMapper;
import ru.makhach.vesselmanager.mapper.DockMapper;
import ru.makhach.vesselmanager.mapper.PortMapper;
import ru.makhach.vesselmanager.mapper.VesselMapper;
import ru.makhach.vesselmanager.model.dto.VesselDto;
import ru.makhach.vesselmanager.model.entity.Vessel;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class VesselMapperImpl implements VesselMapper {
    private CountryMapper countryMapper;
    private PortMapper portMapper;
    private DockMapper dockMapper;

    public VesselMapperImpl(CountryMapper countryMapper, PortMapper portMapper, DockMapper dockMapper) {
        this.countryMapper = countryMapper;
        this.portMapper = portMapper;
        this.dockMapper = dockMapper;
    }

    Function<Vessel, VesselDto> entityToDto = entity ->
            new VesselDto.Builder()
                    .setId(entity.getId())
                    .setName(entity.getName())
                    .setStatus(entity.getStatus())
                    .setType(entity.getType())
                    .setYearBuilt(entity.getYearBuilt())
                    .setLatitude(entity.getLatitude())
                    .setLongitude(entity.getLongitude())
                    .setCountry(countryMapper.entityToDto(entity.getCountry()))
                    .setCurrentPort(portMapper.entityToDto(entity.getCurrentPort()))
                    .setHomePort(portMapper.entityToDto(entity.getHomePort()))
                    .setDock(dockMapper.entityToDto(entity.getDock()))
                    .build();

    Function<VesselDto, Vessel> dtoToEntity = dto -> {
        Vessel entity = new Vessel();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        entity.setType(dto.getType());
        entity.setYearBuilt(dto.getYearBuilt());
        entity.setLatitude(dto.getLatitude());
        entity.setLongitude(dto.getLongitude());
        entity.setCountry(countryMapper.dtoToEntity(dto.getCountry()));
        entity.setCurrentPort(portMapper.dtoToEntity(dto.getCurrentPort()));
        entity.setHomePort(portMapper.dtoToEntity(dto.getHomePort()));
        entity.setDock(dockMapper.dtoToEntity(dto.getDock()));
        return entity;
    };

    @Override
    public Vessel dtoToEntity(VesselDto dto) {
        return dtoToEntity.apply(dto);
    }

    @Override
    public List<Vessel> dtoToEntity(List<VesselDto> list) {
        return list.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

    @Override
    public VesselDto entityToDto(Vessel entity) {
        return entityToDto.apply(entity);
    }

    @Override
    public List<VesselDto> entityToDto(List<Vessel> list) {
        return list.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
