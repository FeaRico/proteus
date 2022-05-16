package ru.makhach.vesselmanager.service.facade;

import ru.makhach.vesselmanager.model.dto.VesselDto;
import ru.makhach.vesselmanager.model.util.Status;
import ru.makhach.vesselmanager.model.util.Type;

import java.util.List;

public interface VesselServiceFacade {
    List<VesselDto> getAllVessels();

    List<VesselDto> getAllVesselsByStatus(Status status);

    List<VesselDto> getAllVesselsByType(Type type);

    List<VesselDto> getAllVesselsByYearBuilt(Integer yearBuilt);

    List<VesselDto> getAllVesselsByCountry(Long countryId);

    List<VesselDto> getAllVesselsByCurrentPort(Long portId);

    List<VesselDto> getAllVesselsByHomePort(Long portId);

    List<VesselDto> getAllVesselsByDock(Long dockId);

    List<VesselDto> getAllVesselsWhereNameStartWith(String name);

    List<VesselDto> getVesselByName(String name);

    VesselDto updateStatusByVesselId(Long id, Status status);

    VesselDto updateVessel(VesselDto vessel);

    VesselDto saveVessel(VesselDto vessel);

    VesselDto deleteVessel(Long id);
}
