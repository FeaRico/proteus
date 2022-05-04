package ru.makhach.vesselmanager.service;

import ru.makhach.vesselmanager.model.dto.DockDto;

import java.util.List;

public interface DockService {
    List<DockDto> getAllDocks();

    List<DockDto> getAllDocksByPort(Long portId);

    DockDto getDockById(Long id);

    DockDto updateDock(DockDto dock);

    DockDto saveDock(DockDto dock);

    DockDto deleteDock(Long id);
}
