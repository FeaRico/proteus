package ru.makhach.proteus.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.data.domain.Page;
import ru.makhach.proteus.model.dto.base.DockDto;
import ru.makhach.proteus.model.dto.base.PortDto;
import ru.makhach.proteus.model.dto.filter.PageRequest;
import ru.makhach.proteus.model.dto.filter.PageResponse;
import ru.makhach.proteus.model.entity.Dock;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PortMapper.class})
public interface DockMapper {
    @Mappings({
            @Mapping(target = "id", source = "dock.id"),
            @Mapping(target = "name", source = "dock.name"),
            @Mapping(target = "vesselsCapacity", source = "dock.vesselsCapacity"),
            @Mapping(target = "latitude", source = "dock.latitude"),
            @Mapping(target = "longitude", source = "dock.longitude"),
            @Mapping(target = "portId", source = "dock.port.id")
    })
    DockDto convert(Dock dock);

    @Mappings({
            @Mapping(target = "id", source = "dockDto.id"),
            @Mapping(target = "name", source = "dockDto.name"),
            @Mapping(target = "vesselsCapacity", source = "dockDto.vesselsCapacity"),
            @Mapping(target = "latitude", source = "dockDto.latitude"),
            @Mapping(target = "longitude", source = "dockDto.longitude")
    })
    @Named("dockDtoToEntity")
    Dock convert(DockDto dockDto);

    @Mappings({
            @Mapping(target = "id", source = "dockDto.id"),
            @Mapping(target = "name", source = "dockDto.name"),
            @Mapping(target = "vesselsCapacity", source = "dockDto.vesselsCapacity"),
            @Mapping(target = "latitude", source = "dockDto.latitude"),
            @Mapping(target = "longitude", source = "dockDto.longitude"),
            @Mapping(target = "port", source = "portDto", qualifiedByName = "portDtoToEntity")
    })
    Dock convert(DockDto dockDto, PortDto portDto);

    List<DockDto> convertToDtos(List<Dock> docks);

    List<Dock> convertToEntities(List<DockDto> docksDto);

    default PageResponse<List<DockDto>> convertToPageResponse(Page<Dock> page, PageRequest request) {
        return PageResponse.<List<DockDto>>builder()
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
