package ru.makhach.proteus.service;

import ru.makhach.proteus.model.entity.Dock;

import java.util.List;

public interface DockService {
    List<Dock> getAllDocks();

    List<Dock> getAllDocksByPort(Long portId);

    Dock getDockById(Long id);

    Dock updateDock(Dock dock);

    Dock saveDock(Dock dock);

    Dock deleteDock(Long id);
}
