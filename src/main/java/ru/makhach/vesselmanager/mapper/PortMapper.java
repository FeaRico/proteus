package ru.makhach.vesselmanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import ru.makhach.vesselmanager.model.dto.CityDto;
import ru.makhach.vesselmanager.model.dto.PortDto;
import ru.makhach.vesselmanager.model.entity.Port;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CityMapper.class})
public interface PortMapper {
    @Mappings({
            @Mapping(target = "id", source = "port.id"),
            @Mapping(target = "name", source = "port.name"),
            @Mapping(target = "latitude", source = "port.latitude"),
            @Mapping(target = "longitude", source = "port.longitude"),
            @Mapping(target = "cityId", source = "port.city.id")
    })
    PortDto convert(Port port);

    @Mappings({
            @Mapping(target = "id", source = "portDto.id"),
            @Mapping(target = "name", source = "portDto.name"),
            @Mapping(target = "latitude", source = "portDto.latitude"),
            @Mapping(target = "longitude", source = "portDto.longitude")
    })
    @Named("portDtoToEntity")
    Port convert(PortDto portDto);

    @Mappings({
            @Mapping(target = "id", source = "portDto.id"),
            @Mapping(target = "name", source = "portDto.name"),
            @Mapping(target = "latitude", source = "portDto.latitude"),
            @Mapping(target = "longitude", source = "portDto.longitude"),
            @Mapping(target = "city", source = "cityDto", qualifiedByName = "cityDtoToEntity")
    })
    @Named("portDtoToEntityWithCity")
    Port convert(PortDto portDto, CityDto cityDto);

    List<PortDto> convertToDtos(List<Port> ports);

    List<Port> convertToEntities(List<PortDto> portsDto);
}
