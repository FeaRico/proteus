package ru.makhach.proteus.core.service;

import org.springframework.data.domain.Page;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.core.model.entity.Dock;

import java.util.List;

/**
 * Сервис для работы с сущностью {@link Dock}
 * Слой без логики
 */
public interface DockService {
    List<Dock> getAllDocks();

    Page<Dock> getAllDocksPageable(PageRequest request);

    List<Dock> getAllDocksByPort(Long portId);

    Dock getDockById(Long id);

    Dock updateDock(Dock dock);

    Dock saveDock(Dock dock);

    Dock deleteDock(Long id);

    Integer countVesselsByDockId(Long id);
}
