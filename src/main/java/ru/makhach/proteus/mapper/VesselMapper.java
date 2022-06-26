package ru.makhach.proteus.mapper;

import org.mapstruct.*;
import org.springframework.data.domain.Page;
import ru.makhach.proteus.model.dto.base.CountryDto;
import ru.makhach.proteus.model.dto.base.DockDto;
import ru.makhach.proteus.model.dto.base.PortDto;
import ru.makhach.proteus.model.dto.base.VesselDto;
import ru.makhach.proteus.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.model.dto.filter.pageable.PageResponse;
import ru.makhach.proteus.model.entity.Vessel;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CountryMapper.class, PortMapper.class,
        DockMapper.class, EnumMapper.class})
public interface VesselMapper {
    @Mappings({
            @Mapping(target = "id", source = "vessel.id"),
            @Mapping(target = "name", source = "vessel.name"),
            @Mapping(target = "status", source = "vessel.status", qualifiedByName = "enumStatusToString"),
            @Mapping(target = "type", source = "vessel.type", qualifiedByName = "enumTypeToString"),
            @Mapping(target = "yearBuilt", source = "vessel.yearBuilt"),
            @Mapping(target = "latitude", source = "vessel.latitude"),
            @Mapping(target = "longitude", source = "vessel.longitude"),
            @Mapping(target = "countryId", source = "vessel.country.id"),
            @Mapping(target = "currentPortId", source = "vessel.currentPort.id"),
            @Mapping(target = "homePortId", source = "vessel.homePort.id"),
            @Mapping(target = "dockId", source = "vessel.dock.id")
    })
    VesselDto convert(Vessel vessel);

    @Mappings({
            @Mapping(target = "id", source = "vesselDto.id"),
            @Mapping(target = "createdAt", expression = "java(System.currentTimeMillis())"),
            @Mapping(target = "name", source = "vesselDto.name"),
            @Mapping(target = "status", source = "vesselDto.status", qualifiedByName = "stringStatusToEnum"),
            @Mapping(target = "type", source = "vesselDto.type", qualifiedByName = "stringTypeToEnum"),
            @Mapping(target = "yearBuilt", source = "vesselDto.yearBuilt"),
            @Mapping(target = "latitude", source = "vesselDto.latitude"),
            @Mapping(target = "longitude", source = "vesselDto.longitude"),
    })
    @Named("vesselDtoToEntity")
    Vessel convert(VesselDto vesselDto);

    @Mappings({
            @Mapping(target = "id", source = "vesselDto.id"),
            @Mapping(target = "name", source = "vesselDto.name"),
            @Mapping(target = "status", source = "vesselDto.status", qualifiedByName = "stringStatusToEnum"),
            @Mapping(target = "type", source = "vesselDto.type", qualifiedByName = "stringTypeToEnum"),
            @Mapping(target = "yearBuilt", source = "vesselDto.yearBuilt"),
            @Mapping(target = "latitude", source = "vesselDto.latitude"),
            @Mapping(target = "longitude", source = "vesselDto.longitude"),
            @Mapping(target = "country", source = "countryDto", qualifiedByName = "countryDtoToEntity"),
            @Mapping(target = "currentPort", source = "currentPortDto", qualifiedByName = "portDtoToEntity"),
            @Mapping(target = "homePort", source = "homePortDto", qualifiedByName = "portDtoToEntity"),
            @Mapping(target = "dock", source = "dockDto", qualifiedByName = "dockDtoToEntity")
    })
    Vessel convert(VesselDto vesselDto, CountryDto countryDto,
                   PortDto currentPortDto, PortDto homePortDto, DockDto dockDto);

    List<VesselDto> convertToDtos(List<Vessel> vessels);

    @IterableMapping(qualifiedByName = "vesselDtoToEntity")
    List<Vessel> convertToEntities(List<VesselDto> vesselsDto);

    default PageResponse<List<VesselDto>> convertToPageResponse(Page<Vessel> page, PageRequest request) {
        return PageResponse.<List<VesselDto>>builder()
                .content(convertToDtos(page.getContent()))
                .pageElements(page.getNumberOfElements())
                .totalElements(page.getTotalElements())
                .pageNumber(page.getNumber())
                .totalPages(page.getTotalPages())
                .sortBy(request.getSortBy())
                .sortDir(request.getSortDir())
                .isFirst(page.isFirst())
                .isLast(page.isLast())
                .build();
    }
}
