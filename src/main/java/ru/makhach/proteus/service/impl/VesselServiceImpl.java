package ru.makhach.proteus.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.makhach.proteus.exceptions.ResourceNotFoundException;
import ru.makhach.proteus.model.base.types.Status;
import ru.makhach.proteus.model.base.types.Type;
import ru.makhach.proteus.model.entity.Vessel;
import ru.makhach.proteus.repository.VesselRepository;
import ru.makhach.proteus.service.VesselService;

import java.util.List;

@Service
@Transactional
public class VesselServiceImpl implements VesselService {
    private final VesselRepository vesselRepository;

    public VesselServiceImpl(VesselRepository vesselRepository) {
        this.vesselRepository = vesselRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vessel> getAllVessels() {
        return vesselRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vessel> getAllVesselsByStatus(Status status) {
        return vesselRepository.findAllByStatus(status);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vessel> getAllVesselsByType(Type type) {
        return vesselRepository.findAllByType(type);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vessel> getAllVesselsByYearBuilt(Integer yearBuilt) {
        return vesselRepository.findAllByYearBuilt(yearBuilt);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vessel> getAllVesselsByCountry(Long countryId) {
        return vesselRepository.findAllByCountry(countryId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vessel> getAllVesselsByCurrentPort(Long portId) {
        return vesselRepository.findAllByCurrentPort(portId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vessel> getAllVesselsByHomePort(Long portId) {
        return vesselRepository.findAllByHomePort(portId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vessel> getAllVesselsByDock(Long dockId) {
        return vesselRepository.findAllByDock(dockId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vessel> getAllVesselsWhereNameStartWith(String name) {
        return vesselRepository.findAllByNameStartsWith(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Vessel> getVesselByName(String name) {
        return vesselRepository.findAllByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public Vessel getVesselById(Long id) {
        return vesselRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Vessel.class, "id", id));
    }

    @Override
    public Vessel updateStatusByVesselId(Long id, Status status) {
        Vessel vesselEntity = vesselRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Vessel.class, "id", id));
        vesselEntity.setStatus(status);

        return vesselRepository.save(vesselEntity);
    }

    @Override
    public Vessel updateVessel(Vessel vessel) {
        Long id = vessel.getId();
        vesselRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Vessel.class, "id", id));

        return vesselRepository.save(vessel);
    }

    @Override
    public Vessel saveVessel(Vessel vessel) {
        return vesselRepository.save(vessel);
    }

    @Override
    public Vessel deleteVessel(Long id) {
        Vessel vesselEntity = vesselRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Vessel.class, "id", id));

        vesselRepository.delete(vesselEntity);
        return vesselEntity;
    }
}
