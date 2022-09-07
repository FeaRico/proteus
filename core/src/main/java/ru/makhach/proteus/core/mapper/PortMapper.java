package ru.makhach.proteus.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.springframework.data.domain.Page;
import ru.makhach.proteus.core.model.dto.base.CityDto;
import ru.makhach.proteus.core.model.dto.base.PortDto;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageResponse;
import ru.makhach.proteus.core.model.entity.Port;

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
            @Mapping(target = "createdAt", expression = "java(System.currentTimeMillis())"),
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

    default PageResponse<List<PortDto>> convertToPageResponse(Page<Port> page, PageRequest request) {
        return PageResponse.<List<PortDto>>builder()
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
