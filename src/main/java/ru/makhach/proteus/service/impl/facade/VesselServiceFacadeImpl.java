package ru.makhach.proteus.service.impl.facade;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.makhach.proteus.mapper.VesselMapper;
import ru.makhach.proteus.model.base.types.Status;
import ru.makhach.proteus.model.base.types.Type;
import ru.makhach.proteus.model.dto.base.DockRecordDto;
import ru.makhach.proteus.model.dto.base.VesselDto;
import ru.makhach.proteus.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.model.dto.filter.pageable.PageResponse;
import ru.makhach.proteus.model.dto.filter.vessel.VesselFilterParam;
import ru.makhach.proteus.model.entity.Country;
import ru.makhach.proteus.model.entity.Dock;
import ru.makhach.proteus.model.entity.Port;
import ru.makhach.proteus.model.entity.Vessel;
import ru.makhach.proteus.service.CountryService;
import ru.makhach.proteus.service.DockService;
import ru.makhach.proteus.service.PortService;
import ru.makhach.proteus.service.VesselService;
import ru.makhach.proteus.service.facade.DockRecordServiceFacade;
import ru.makhach.proteus.service.facade.VesselServiceFacade;
import ru.makhach.proteus.sse.service.event.VesselEventService;

import java.util.Collections;
import java.util.List;

@Service
public class VesselServiceFacadeImpl implements VesselServiceFacade {
    private final VesselService vesselService;
    private final VesselMapper vesselMapper;
    private final CountryService countryService;
    private final PortService portService;
    private final DockService dockService;
    private final VesselEventService eventService;
    private final DockRecordServiceFacade recordServiceFacade;

    public VesselServiceFacadeImpl(VesselService vesselService, VesselMapper vesselMapper, CountryService countryService, PortService portService, DockService dockService, VesselEventService eventService, DockRecordServiceFacade recordServiceFacade) {
        this.vesselService = vesselService;
        this.vesselMapper = vesselMapper;
        this.countryService = countryService;
        this.portService = portService;
        this.dockService = dockService;
        this.eventService = eventService;
        this.recordServiceFacade = recordServiceFacade;
    }

    @Override
    public List<VesselDto> getAllVessels() {
        return vesselMapper.convertToDtos(vesselService.getAllVessels());
    }

    @Override
    public PageResponse<List<VesselDto>> getAllVesselsPageable(PageRequest request) {
        Page<Vessel> page = vesselService.getAllVesselsPageable(request);
        return vesselMapper.convertToPageResponse(page, request);
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
    public List<VesselDto> getAllVesselByFilter(VesselFilterParam param) {
        switch (param.getType()) {
            case STATUS:
                return getAllVesselsByStatus(Status.valueOf(param.getValue()));
            case TYPE:
                return getAllVesselsByType(Type.valueOf(param.getValue()));
            case YEAR_BUILT:
                return getAllVesselsByYearBuilt(Integer.valueOf(param.getValue()));
            default:
                return Collections.emptyList();
        }
    }

    @Override
    public VesselDto getVesselById(Long id) {
        return vesselMapper.convert(vesselService.getVesselById(id));
    }

    @Override
    public VesselDto updateStatusByVesselId(Long id, Status status) {
        VesselDto updatedVessel = vesselMapper.convert(vesselService.updateStatusByVesselId(id, status));
        eventService.updateStatusEvent(updatedVessel);
        return updatedVessel;
    }

    @Override
    public VesselDto updateVessel(VesselDto vessel) {
        VesselDto updatedVessel = vesselMapper.convert(vesselService.updateVessel(configureVesselEntities(vessel)));
        eventService.updateEvent(updatedVessel);
        return updatedVessel;
    }

    @Override
    public VesselDto saveVessel(VesselDto vessel) {
        VesselDto savedVessel = vesselMapper.convert(vesselService.saveVessel(configureVesselEntities(vessel)));
        eventService.saveEvent(savedVessel);
        return savedVessel;
    }

    @Override
    public VesselDto deleteVessel(Long id) {
        VesselDto deletedVessel = vesselMapper.convert(vesselService.deleteVessel(id));
        eventService.deleteEvent(deletedVessel);
        return deletedVessel;
    }

    @Override
    public VesselDto mooringVessel(Long dockId, Long vesselId) {
        Vessel vessel = vesselService.getVesselById(vesselId);
        Dock dock = dockService.getDockById(dockId);
        dock.setVesselsCapacity(dock.getVesselsCapacity() + 1);
        dockService.updateDock(dock);
        vessel.setDock(dock);
        DockRecordDto dockRecord = DockRecordDto.builder()
                .vesselId(vesselId)
                .dockId(dockId)
                .build();
        recordServiceFacade.mooringVessel(dockRecord);
        return vesselMapper.convert(vesselService.updateVessel(vessel));
    }

    // TODO: 27.06.2022 Дописать контроллеры
    @Override
    public VesselDto unmooringVessel(Long dockId, Long vesselId) {
        Vessel vessel = vesselService.getVesselById(vesselId);
        Dock dock = dockService.getDockById(dockId);
        dock.setVesselsCapacity(dock.getVesselsCapacity() - 1);
        dockService.updateDock(dock);
        vessel.setDock(dock);
        DockRecordDto dockRecord = DockRecordDto.builder()
                .vesselId(vesselId)
                .dockId(dockId)
                .build();
        recordServiceFacade.unmooringVessel(dockRecord);
        return vesselMapper.convert(vesselService.updateVessel(vessel));
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
