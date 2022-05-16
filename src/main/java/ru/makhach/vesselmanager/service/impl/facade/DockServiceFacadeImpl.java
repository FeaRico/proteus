package ru.makhach.vesselmanager.service.impl.facade;

import org.springframework.stereotype.Service;
import ru.makhach.vesselmanager.mapper.DockMapper;
import ru.makhach.vesselmanager.model.dto.DockDto;
import ru.makhach.vesselmanager.model.entity.Dock;
import ru.makhach.vesselmanager.model.entity.Port;
import ru.makhach.vesselmanager.service.DockService;
import ru.makhach.vesselmanager.service.PortService;
import ru.makhach.vesselmanager.service.facade.DockServiceFacade;

import java.util.List;

@Service
public class DockServiceFacadeImpl implements DockServiceFacade {
    private final DockService dockService;
    private final DockMapper dockMapper;
    private final PortService portService;

    public DockServiceFacadeImpl(DockService dockService, PortService portService, DockMapper dockMapper) {
        this.dockService = dockService;
        this.portService = portService;
        this.dockMapper = dockMapper;
    }

    @Override
    public List<DockDto> getAllDocks() {
        return dockMapper.entityToDto(dockService.getAllDocks());
    }

    @Override
    public List<DockDto> getAllDocksByPort(Long portId) {
        return dockMapper.entityToDto(dockService.getAllDocksByPort(portId));
    }

    @Override
    public DockDto getDockById(Long id) {
        return dockMapper.entityToDto(dockService.getDockById(id));
    }

    @Override
    public DockDto updateDock(DockDto dock) {
        Dock dockEntity = dockMapper.dtoToEntity(dock);
        Port port = portService.getPortById(dock.getPortId());
        dockEntity.setPort(port);
        return dockMapper.entityToDto(dockService.updateDock(dockEntity));
    }

    @Override
    public DockDto saveDock(DockDto dock) {
        Dock dockEntity = dockMapper.dtoToEntity(dock);
        Port port = portService.getPortById(dock.getPortId());
        dockEntity.setPort(port);
        return dockMapper.entityToDto(dockService.saveDock(dockEntity));
    }

    @Override
    public DockDto deleteDock(Long id) {
        return dockMapper.entityToDto(dockService.deleteDock(id));
    }
}
