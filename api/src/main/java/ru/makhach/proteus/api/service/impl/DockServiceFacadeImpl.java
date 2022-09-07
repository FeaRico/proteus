package ru.makhach.proteus.api.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.makhach.proteus.core.mapper.DockMapper;
import ru.makhach.proteus.core.model.dto.base.DockDto;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageResponse;
import ru.makhach.proteus.core.model.entity.Dock;
import ru.makhach.proteus.core.model.entity.Port;
import ru.makhach.proteus.core.service.DockRecordService;
import ru.makhach.proteus.core.service.DockService;
import ru.makhach.proteus.core.service.PortService;
import ru.makhach.proteus.core.service.VesselService;
import ru.makhach.proteus.core.service.event.DockEventService;
import ru.makhach.proteus.api.service.DockServiceFacade;

import java.util.List;

@Service
public class DockServiceFacadeImpl implements DockServiceFacade {
    private final DockService dockService;
    private final DockMapper dockMapper;
    private final PortService portService;
    private final DockEventService eventService;
    private final VesselService vesselService;
    private final DockRecordService recordService;

    public DockServiceFacadeImpl(DockService dockService, DockMapper dockMapper, PortService portService, DockEventService eventService, VesselService vesselService, DockRecordService recordService) {
        this.dockService = dockService;
        this.dockMapper = dockMapper;
        this.portService = portService;
        this.eventService = eventService;
        this.vesselService = vesselService;
        this.recordService = recordService;
    }

    @Override
    public List<DockDto> getAllDocks() {
        return dockMapper.convertToDtos(dockService.getAllDocks());
    }

    @Override
    public PageResponse<List<DockDto>> getAllDocksPageable(PageRequest request) {
        Page<Dock> page = dockService.getAllDocksPageable(request);
        return dockMapper.convertToPageResponse(page, request);
    }

    @Override
    public List<DockDto> getAllDocksByPort(Long portId) {
        return dockMapper.convertToDtos(dockService.getAllDocksByPort(portId));
    }

    @Override
    public DockDto getDockById(Long id) {
        return dockMapper.convert(dockService.getDockById(id));
    }

    @Override
    public DockDto updateDock(DockDto dock) {
        Dock dockEntity = dockMapper.convert(dock);
        Port port = portService.getPortById(dock.getPortId());
        dockEntity.setPort(port);
        DockDto updatedDock = dockMapper.convert(dockService.updateDock(dockEntity));
        eventService.updateEvent(updatedDock);
        return updatedDock;
    }

    @Override
    public DockDto saveDock(DockDto dock) {
        Dock dockEntity = dockMapper.convert(dock);
        Port port = portService.getPortById(dock.getPortId());
        dockEntity.setPort(port);
        DockDto savedDock = dockMapper.convert(dockService.saveDock(dockEntity));
        eventService.saveEvent(savedDock);
        return savedDock;
    }

    @Override
    public DockDto deleteDock(Long id) {
        DockDto deletedDock = dockMapper.convert(dockService.deleteDock(id));
        eventService.deleteEvent(deletedDock);
        return deletedDock;
    }

    @Override
    public Integer countVesselsByDockId(Long id) {
        return dockService.countVesselsByDockId(id);
    }
}