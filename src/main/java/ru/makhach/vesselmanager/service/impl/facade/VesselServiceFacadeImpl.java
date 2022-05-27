package ru.makhach.vesselmanager.service.impl.facade;

import org.springframework.stereotype.Service;
import ru.makhach.vesselmanager.mapper.VesselMapper;
import ru.makhach.vesselmanager.model.base.types.Status;
import ru.makhach.vesselmanager.model.base.types.Type;
import ru.makhach.vesselmanager.model.dto.base.VesselDto;
import ru.makhach.vesselmanager.model.entity.Country;
import ru.makhach.vesselmanager.model.entity.Dock;
import ru.makhach.vesselmanager.model.entity.Port;
import ru.makhach.vesselmanager.model.entity.Vessel;
import ru.makhach.vesselmanager.service.CountryService;
import ru.makhach.vesselmanager.service.DockService;
import ru.makhach.vesselmanager.service.PortService;
import ru.makhach.vesselmanager.service.VesselService;
import ru.makhach.vesselmanager.service.facade.VesselServiceFacade;

import java.util.List;

@Service
public class VesselServiceFacadeImpl implements VesselServiceFacade {
    private final VesselService vesselService;
    private final VesselMapper vesselMapper;
    private final CountryService countryService;
    private final PortService portService;
    private final DockService dockService;

    public VesselServiceFacadeImpl(VesselService vesselService, VesselMapper vesselMapper, CountryService countryService, PortService portService, DockService dockService) {
        this.vesselService = vesselService;
        this.vesselMapper = vesselMapper;
        this.countryService = countryService;
        this.portService = portService;
        this.dockService = dockService;
    }

    @Override
    public List<VesselDto> getAllVessels() {
        return vesselMapper.convertToDtos(vesselService.getAllVessels());
    }

    @Override
    public List<VesselDto> getAllVesselsByStatus(Status status) {
        return vesselMapper.convertToDtos(vesselService.getAllVesselsByStatus(status));
    }

    @Override
    public List<VesselDto> getAllVesselsByType(Type type) {
        return vesselMapper.convertToDtos(vesselService.getAllVesselsByType(type));
    }

    @Override
    public List<VesselDto> getAllVesselsByYearBuilt(Integer yearBuilt) {
        return vesselMapper.convertToDtos(vesselService.getAllVesselsByYearBuilt(yearBuilt));
    }

    @Override
    public List<VesselDto> getAllVesselsByCountry(Long countryId) {
        return vesselMapper.convertToDtos(vesselService.getAllVesselsByCountry(countryId));
    }

    @Override
    public List<VesselDto> getAllVesselsByCurrentPort(Long portId) {
        return vesselMapper.convertToDtos(vesselService.getAllVesselsByCurrentPort(portId));
    }

    @Override
    public List<VesselDto> getAllVesselsByHomePort(Long portId) {
        return vesselMapper.convertToDtos(vesselService.getAllVesselsByHomePort(portId));
    }

    @Override
    public List<VesselDto> getAllVesselsByDock(Long dockId) {
        return vesselMapper.convertToDtos(vesselService.getAllVesselsByDock(dockId));
    }

    @Override
    public List<VesselDto> getAllVesselsWhereNameStartWith(String name) {
        return vesselMapper.convertToDtos(vesselService.getAllVesselsWhereNameStartWith(name));
    }

    @Override
    public List<VesselDto> getVesselByName(String name) {
        return vesselMapper.convertToDtos(vesselService.getVesselByName(name));
    }

    @Override
    public VesselDto updateStatusByVesselId(Long id, Status status) {
        return vesselMapper.convert(vesselService.updateStatusByVesselId(id, status));
    }

    @Override
    public VesselDto updateVessel(VesselDto vessel) {
        return vesselMapper.convert(vesselService.updateVessel(configureVesselEntities(vessel)));
    }

    @Override
    public VesselDto saveVessel(VesselDto vessel) {
        return vesselMapper.convert(vesselService.saveVessel(configureVesselEntities(vessel)));
    }

    @Override
    public VesselDto deleteVessel(Long id) {
        return vesselMapper.convert(vesselService.deleteVessel(id));
    }

    private Vessel configureVesselEntities(VesselDto vessel) {
        Vessel vesselEntity = vesselMapper.convert(vessel);
        Country country = countryService.getCountryById(vessel.getCountryId());
        Port currentPort = portService.getPortById(vessel.getCurrentPortId());
        Port homePort = portService.getPortById(vessel.getHomePortId());
        Dock dock = dockService.getDockById(vessel.getDockId());
        vesselEntity.setCountry(country);
        vesselEntity.setCurrentPort(currentPort);
        vesselEntity.setHomePort(homePort);
        vesselEntity.setDock(dock);
        return vesselEntity;
    }
}
