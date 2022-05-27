package ru.makhach.proteus.service.facade;

import ru.makhach.proteus.model.dto.base.DockDto;

import java.util.List;

public interface DockServiceFacade {
    List<DockDto> getAllDocks();

    List<DockDto> getAllDocksByPort(Long portId);

    DockDto getDockById(Long id);

    DockDto updateDock(DockDto dock);

    DockDto saveDock(DockDto dock);

    DockDto deleteDock(Long id);
}
