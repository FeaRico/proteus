package ru.makhach.proteus.service.facade;

import ru.makhach.proteus.model.base.types.Status;
import ru.makhach.proteus.model.base.types.Type;
import ru.makhach.proteus.model.dto.base.VesselDto;

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
