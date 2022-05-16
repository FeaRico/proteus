package ru.makhach.vesselmanager.service.impl;

import org.springframework.stereotype.Service;
import ru.makhach.vesselmanager.exceptions.ResourceNotFoundException;
import ru.makhach.vesselmanager.model.entity.Vessel;
import ru.makhach.vesselmanager.model.util.Status;
import ru.makhach.vesselmanager.model.util.Type;
import ru.makhach.vesselmanager.repository.VesselRepository;
import ru.makhach.vesselmanager.service.VesselService;

import java.util.List;

@Service
public class VesselServiceImpl implements VesselService {
    private final VesselRepository vesselRepository;

    public VesselServiceImpl(VesselRepository vesselRepository) {
        this.vesselRepository = vesselRepository;
    }

    @Override
    public List<Vessel> getAllVessels() {
        return vesselRepository.findAll();
    }

    @Override
    public List<Vessel> getAllVesselsByStatus(Status status) {
        return vesselRepository.findAllByStatus(status);
    }

    @Override
    public List<Vessel> getAllVesselsByType(Type type) {
        return vesselRepository.findAllByType(type);
    }

    @Override
    public List<Vessel> getAllVesselsByYearBuilt(Integer yearBuilt) {
        return vesselRepository.findAllByYearBuilt(yearBuilt);
    }

    @Override
    public List<Vessel> getAllVesselsByCountry(Long countryId) {
        return vesselRepository.findAllByCountry(countryId);
    }

    @Override
    public List<Vessel> getAllVesselsByCurrentPort(Long portId) {
        return vesselRepository.findAllByCurrentPort(portId);
    }

    @Override
    public List<Vessel> getAllVesselsByHomePort(Long portId) {
        return vesselRepository.findAllByHomePort(portId);
    }

    @Override
    public List<Vessel> getAllVesselsByDock(Long dockId) {
        return vesselRepository.findAllByDock(dockId);
    }

    @Override
    public List<Vessel> getAllVesselsWhereNameStartWith(String name) {
        return vesselRepository.findAllByNameStartsWith(name);
    }

    @Override
    public List<Vessel> getVesselByName(String name) {
        return vesselRepository.findAllByName(name);
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
