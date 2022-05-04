package ru.makhach.vesselmanager.service.impl;

import org.springframework.stereotype.Service;
import ru.makhach.vesselmanager.exceptions.ResourceNotFoundException;
import ru.makhach.vesselmanager.mapper.VesselMapper;
import ru.makhach.vesselmanager.model.dto.VesselDto;
import ru.makhach.vesselmanager.model.entity.VesselEntity;
import ru.makhach.vesselmanager.model.util.Status;
import ru.makhach.vesselmanager.model.util.Type;
import ru.makhach.vesselmanager.repository.VesselRepository;
import ru.makhach.vesselmanager.service.VesselService;

import java.util.List;

@Service
public class VesselServiceImpl implements VesselService {
    private final VesselMapper vesselMapper;
    private final VesselRepository vesselRepository;

    public VesselServiceImpl(VesselMapper vesselMapper, VesselRepository vesselRepository) {
        this.vesselMapper = vesselMapper;
        this.vesselRepository = vesselRepository;
    }

    @Override
    public List<VesselDto> getAllVessels() {
        return vesselMapper.entityToDto(vesselRepository.findAll());
    }

    @Override
    public List<VesselDto> getAllVesselsByStatus(Status status) {
        return vesselMapper.entityToDto(vesselRepository.findAllByStatus(status));
    }

    @Override
    public List<VesselDto> getAllVesselsByType(Type type) {
        return vesselMapper.entityToDto(vesselRepository.findAllByType(type));
    }

    @Override
    public List<VesselDto> getAllVesselsByYearBuilt(Integer yearBuilt) {
        return vesselMapper.entityToDto(vesselRepository.findAllByYearBuilt(yearBuilt));
    }

    @Override
    public List<VesselDto> getAllVesselsByCountry(Long countryId) {
        return vesselMapper.entityToDto(vesselRepository.findAllByCountry(countryId));
    }

    @Override
    public List<VesselDto> getAllVesselsByCurrentPort(Long portId) {
        return vesselMapper.entityToDto(vesselRepository.findAllByCurrentPort(portId));
    }

    @Override
    public List<VesselDto> getAllVesselsByHomePort(Long portId) {
        return vesselMapper.entityToDto(vesselRepository.findAllByHomePort(portId));
    }

    @Override
    public List<VesselDto> getAllVesselsByDock(Long dockId) {
        return vesselMapper.entityToDto(vesselRepository.findAllByDock(dockId));
    }

    @Override
    public List<VesselDto> getAllVesselsWhereNameStartWith(String name) {
        return vesselMapper.entityToDto(vesselRepository.findAllByNameStartsWith(name));
    }

    @Override
    public List<VesselDto> getVesselByName(String name) {
        return vesselMapper.entityToDto(vesselRepository.findAllByName(name));
    }

    @Override
    public VesselDto updateStatusByVesselId(Long id, Status status) {
        VesselEntity vesselEntity = vesselRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(VesselEntity.class, "id", id));
        vesselEntity.setStatus(status);

        return vesselMapper.entityToDto(vesselRepository.save(vesselEntity));
    }

    @Override
    public VesselDto updateVessel(VesselDto vessel) {
        Long id = vessel.getId();
        vesselRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(VesselEntity.class, "id", id));

        VesselEntity vesselEntity = vesselMapper.dtoToEntity(vessel);
        return vesselMapper.entityToDto(vesselRepository.save(vesselEntity));
    }

    @Override
    public VesselDto saveVessel(VesselDto vessel) {
        VesselEntity vesselEntity = vesselMapper.dtoToEntity(vessel);
        return vesselMapper.entityToDto(vesselRepository.save(vesselEntity));
    }

    @Override
    public VesselDto deleteVessel(Long id) {
        VesselEntity vesselEntity = vesselRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(VesselEntity.class, "id", id));

        vesselRepository.delete(vesselEntity);
        return vesselMapper.entityToDto(vesselEntity);
    }
}
