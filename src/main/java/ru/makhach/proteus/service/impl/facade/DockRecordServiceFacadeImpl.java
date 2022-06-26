package ru.makhach.proteus.service.impl.facade;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.makhach.proteus.mapper.DockRecordMapper;
import ru.makhach.proteus.model.dto.base.DockRecordDto;
import ru.makhach.proteus.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.model.dto.filter.pageable.PageResponse;
import ru.makhach.proteus.model.entity.Dock;
import ru.makhach.proteus.model.entity.DockRecord;
import ru.makhach.proteus.model.entity.Vessel;
import ru.makhach.proteus.service.DockRecordService;
import ru.makhach.proteus.service.DockService;
import ru.makhach.proteus.service.VesselService;
import ru.makhach.proteus.service.facade.DockRecordServiceFacade;
import ru.makhach.proteus.sse.service.event.DockRecordEventService;

import java.util.List;

@Service
public class DockRecordServiceFacadeImpl implements DockRecordServiceFacade {
    private final DockRecordService recordService;
    private final DockRecordMapper recordMapper;
    private final DockRecordEventService eventService;
    private final DockService dockService;
    private final VesselService vesselService;

    public DockRecordServiceFacadeImpl(DockRecordService recordService, DockRecordMapper recordMapper, DockRecordEventService eventService, DockService dockService, VesselService vesselService) {
        this.recordService = recordService;
        this.recordMapper = recordMapper;
        this.eventService = eventService;
        this.dockService = dockService;
        this.vesselService = vesselService;
    }

    @Override
    public List<DockRecordDto> getAll() {
        return recordMapper.convertToDtos(recordService.getAll());
    }

    @Override
    public PageResponse<List<DockRecordDto>> getAllPageable(PageRequest request) {
        Page<DockRecord> page = recordService.getAllPageable(request);
        return recordMapper.convertToPageResponse(page, request);
    }

    @Override
    public List<DockRecordDto> getAllByDock(Long id) {
        return null;
    }

    @Override
    public List<DockRecordDto> getAllByVessel(Long vesselId) {
        return recordMapper.convertToDtos(recordService.getAllByVessel(vesselId));
    }

    @Override
    public DockRecordDto getById(Long id) {
        return recordMapper.convert(recordService.getById(id));
    }

    @Override
    public DockRecordDto update(DockRecordDto dockRecordDto) {
        DockRecord dockRecord = recordMapper.convert(dockRecordDto);
        Dock dock = dockService.getDockById(dockRecordDto.getDockId());
        Vessel vessel = vesselService.getVesselById(dockRecordDto.getVesselId());
        dockRecord.setDock(dock);
        dockRecord.setVessel(vessel);
        DockRecordDto updatedDockRecord = recordMapper.convert(recordService.update(dockRecord));
        eventService.updateEvent(updatedDockRecord);
        return updatedDockRecord;
    }

    @Override
    public DockRecordDto save(DockRecordDto dockRecordDto) {
        DockRecord dockRecord = recordMapper.convert(dockRecordDto);
        Dock dock = dockService.getDockById(dockRecordDto.getDockId());
        Vessel vessel = vesselService.getVesselById(dockRecordDto.getVesselId());
        dockRecord.setDock(dock);
        dockRecord.setVessel(vessel);
        DockRecordDto savedDockRecord = recordMapper.convert(recordService.save(dockRecord));
        eventService.saveEvent(savedDockRecord);
        return savedDockRecord;
    }

    @Override
    public DockRecordDto delete(Long id) {
        DockRecordDto deletedDockRecord = recordMapper.convert(recordService.delete(id));
        eventService.deleteEvent(deletedDockRecord);
        return deletedDockRecord;
    }
}
