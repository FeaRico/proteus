package ru.makhach.proteus.core.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.data.domain.Page;
import ru.makhach.proteus.core.model.dto.base.DockRecordDto;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageResponse;
import ru.makhach.proteus.core.model.entity.DockRecord;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DockRecordMapper {
    @Mappings({
            @Mapping(target = "dockId", source = "dockRecord.dock.id"),
            @Mapping(target = "vesselId", source = "dockRecord.vessel.id")
    })
    DockRecordDto convert(DockRecord dockRecord);

    @Mapping(target = "createdAt", expression = "java(System.currentTimeMillis())")
    DockRecord convert(DockRecordDto dockRecordDto);

    List<DockRecordDto> convertToDtos(List<DockRecord> entities);

    List<DockRecord> convertToEntities(List<DockRecordDto> dtos);

    default PageResponse<List<DockRecordDto>> convertToPageResponse(Page<DockRecord> page, PageRequest request) {
        return PageResponse.<List<DockRecordDto>>builder()
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
