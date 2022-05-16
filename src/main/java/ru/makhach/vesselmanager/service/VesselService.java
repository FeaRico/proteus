package ru.makhach.vesselmanager.service;

import ru.makhach.vesselmanager.model.entity.Vessel;
import ru.makhach.vesselmanager.model.util.Status;
import ru.makhach.vesselmanager.model.util.Type;

import java.util.List;

public interface VesselService {
    List<Vessel> getAllVessels();

    List<Vessel> getAllVesselsByStatus(Status status);

    List<Vessel> getAllVesselsByType(Type type);

    List<Vessel> getAllVesselsByYearBuilt(Integer yearBuilt);

    List<Vessel> getAllVesselsByCountry(Long countryId);

    List<Vessel> getAllVesselsByCurrentPort(Long portId);

    List<Vessel> getAllVesselsByHomePort(Long portId);

    List<Vessel> getAllVesselsByDock(Long dockId);

    List<Vessel> getAllVesselsWhereNameStartWith(String name);

    List<Vessel> getVesselByName(String name);

    Vessel updateStatusByVesselId(Long id, Status status);

    Vessel updateVessel(Vessel vessel);

    Vessel saveVessel(Vessel vessel);

    Vessel deleteVessel(Long id);
}