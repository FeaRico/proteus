package ru.makhach.proteus.core.service;

import org.springframework.data.domain.Page;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.core.model.entity.DockRecord;

import java.util.List;

public interface DockRecordService {
    List<DockRecord> getAll();

    Page<DockRecord> getAllPageable(PageRequest request);

    List<DockRecord> getAllByDock(Long id);

    List<DockRecord> getAllByVessel(Long vesselId);

    DockRecord getById(Long id);

    DockRecord update(DockRecord dockRecord);

    DockRecord save(DockRecord dockRecord);

    DockRecord delete(Long id);
}
