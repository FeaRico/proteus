package ru.makhach.proteus.service.facade;

import ru.makhach.proteus.model.dto.base.DockRecordDto;
import ru.makhach.proteus.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.model.dto.filter.pageable.PageResponse;

import java.util.List;

public interface DockRecordServiceFacade {
    List<DockRecordDto> getAll();

    PageResponse<List<DockRecordDto>> getAllPageable(PageRequest request);

    List<DockRecordDto> getAllByDock(Long id);

    List<DockRecordDto> getAllByVessel(Long vesselId);

    DockRecordDto getById(Long id);

    DockRecordDto update(DockRecordDto dockRecordDto);

    DockRecordDto save(DockRecordDto dockRecordDto);

    DockRecordDto delete(Long id);
}
