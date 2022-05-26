package ru.makhach.vesselmanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import ru.makhach.vesselmanager.model.dto.DockDto;
import ru.makhach.vesselmanager.model.dto.PortDto;
import ru.makhach.vesselmanager.model.entity.Dock;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PortMapper.class})
public interface DockMapper {
    @Mappings({
            @Mapping(target = "id", source = "dock.id"),
            @Mapping(target = "vesselsCapacity", source = "dock.vesselsCapacity"),
            @Mapping(target = "latitude", source = "dock.latitude"),
            @Mapping(target = "longitude", source = "dock.longitude"),
            @Mapping(target = "portId", source = "dock.port.id")
    })
    DockDto convert(Dock dock);

    @Mappings({
            @Mapping(target = "id", source = "dockDto.id"),
            @Mapping(target = "vesselsCapacity", source = "dockDto.vesselsCapacity"),
            @Mapping(target = "latitude", source = "dockDto.latitude"),
            @Mapping(target = "longitude", source = "dockDto.longitude")
    })
    @Named("dockDtoToEntity")
    Dock convert(DockDto dockDto);

    @Mappings({
            @Mapping(target = "id", source = "dockDto.id"),
            @Mapping(target = "vesselsCapacity", source = "dockDto.vesselsCapacity"),
            @Mapping(target = "latitude", source = "dockDto.latitude"),
            @Mapping(target = "longitude", source = "dockDto.longitude"),
            @Mapping(target = "port", source = "portDto", qualifiedByName = "portDtoToEntity")
    })
    Dock convert(DockDto dockDto, PortDto portDto);

    List<DockDto> convertToDtos(List<Dock> docks);

    List<Dock> convertToEntities(List<DockDto> docksDto);
}
