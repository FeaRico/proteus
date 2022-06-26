package ru.makhach.proteus.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.makhach.proteus.exceptions.ResourceNotFoundException;
import ru.makhach.proteus.model.dto.filter.PageRequest;
import ru.makhach.proteus.model.entity.Dock;
import ru.makhach.proteus.repository.DockRepository;
import ru.makhach.proteus.service.DockService;
import ru.makhach.proteus.utils.PageableUtils;

import java.util.List;

@Service
@Transactional
public class DockServiceImpl implements DockService {
    private final DockRepository dockRepository;

    public DockServiceImpl(DockRepository dockRepository) {
        this.dockRepository = dockRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Dock> getAllDocks() {
        return dockRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Dock> getAllDocksPageable(PageRequest request) {
        Pageable pageable = PageableUtils.pageableFromRequest(request);
        return dockRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Dock> getAllDocksByPort(Long portId) {
        return dockRepository.findAllByPort(portId);
    }

    @Override
    @Transactional(readOnly = true)
    public Dock getDockById(Long id) {
        return dockRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Dock.class, "id", id));
    }

    @Override
    public Dock updateDock(Dock dock) {
        Long id = dock.getId();
        dockRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Dock.class, "id", id));

        return dockRepository.save(dock);
    }

    @Override
    public Dock saveDock(Dock dock) {
        return dockRepository.save(dock);
    }

    @Override
    public Dock deleteDock(Long id) {
        Dock foundEntity = dockRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Dock.class, "id", id));

        dockRepository.delete(foundEntity);
        return foundEntity;
    }

    @Override
    @Transactional(readOnly = true)
    public Integer countVesselsByDockId(Long id) {
        return dockRepository.countVesselByDock(id);
    }
}
