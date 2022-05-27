package ru.makhach.proteus.service.impl.facade;

import org.springframework.stereotype.Service;
import ru.makhach.proteus.mapper.DockMapper;
import ru.makhach.proteus.model.dto.base.DockDto;
import ru.makhach.proteus.model.entity.Dock;
import ru.makhach.proteus.model.entity.Port;
import ru.makhach.proteus.service.DockService;
import ru.makhach.proteus.service.PortService;
import ru.makhach.proteus.service.facade.DockServiceFacade;

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
        return dockMapper.convertToDtos(dockService.getAllDocks());
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
        return dockMapper.convert(dockService.updateDock(dockEntity));
    }

    @Override
    public DockDto saveDock(DockDto dock) {
        Dock dockEntity = dockMapper.convert(dock);
        Port port = portService.getPortById(dock.getPortId());
        dockEntity.setPort(port);
        return dockMapper.convert(dockService.saveDock(dockEntity));
    }

    @Override
    public DockDto deleteDock(Long id) {
        return dockMapper.convert(dockService.deleteDock(id));
    }
}
