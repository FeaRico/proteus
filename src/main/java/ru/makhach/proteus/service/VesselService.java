package ru.makhach.proteus.service;

import org.springframework.data.domain.Page;
import ru.makhach.proteus.model.base.types.Status;
import ru.makhach.proteus.model.base.types.Type;
import ru.makhach.proteus.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.model.entity.Vessel;

import java.util.List;

/**
 * Сервис для работы с сущностью {@link Vessel}
 * Слой без логики
 */
public interface VesselService {
    List<Vessel> getAllVessels();

    Page<Vessel> getAllVesselsPageable(PageRequest request);

    List<Vessel> getAllVesselsByStatus(Status status);

    List<Vessel> getAllVesselsByType(Type type);

    List<Vessel> getAllVesselsByYearBuilt(Integer yearBuilt);

    List<Vessel> getAllVesselsByCountry(Long countryId);

    List<Vessel> getAllVesselsByCurrentPort(Long portId);

    List<Vessel> getAllVesselsByHomePort(Long portId);

    List<Vessel> getAllVesselsByDock(Long dockId);

    List<Vessel> getAllVesselsWhereNameStartWith(String name);

    List<Vessel> getVesselByName(String name);

    Vessel getVesselById(Long id);

    Vessel updateStatusByVesselId(Long id, Status status);

    Vessel updateVessel(Vessel vessel);

    Vessel saveVessel(Vessel vessel);

    Vessel deleteVessel(Long id);
}