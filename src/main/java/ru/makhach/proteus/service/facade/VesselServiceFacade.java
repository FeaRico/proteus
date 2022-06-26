package ru.makhach.proteus.service.facade;

import ru.makhach.proteus.model.base.types.Status;
import ru.makhach.proteus.model.base.types.Type;
import ru.makhach.proteus.model.dto.base.VesselDto;
import ru.makhach.proteus.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.model.dto.filter.pageable.PageResponse;
import ru.makhach.proteus.model.dto.filter.vessel.VesselFilterParam;

import java.util.List;

/**
 * Сервис для работы с {@link VesselDto}
 * Этот слой для взаимодействия
 * с сервисами связанных моделей
 */
public interface VesselServiceFacade {
    List<VesselDto> getAllVessels();

    PageResponse<List<VesselDto>> getAllVesselsPageable(PageRequest request);

    List<VesselDto> getAllVesselsByStatus(Status status);

    List<VesselDto> getAllVesselsByType(Type type);

    List<VesselDto> getAllVesselsByYearBuilt(Integer yearBuilt);

    List<VesselDto> getAllVesselsByCountry(Long countryId);

    List<VesselDto> getAllVesselsByCurrentPort(Long portId);

    List<VesselDto> getAllVesselsByHomePort(Long portId);

    List<VesselDto> getAllVesselsByDock(Long dockId);

    List<VesselDto> getAllVesselsWhereNameStartWith(String name);

    List<VesselDto> getVesselByName(String name);

    List<VesselDto> getAllVesselByFilter(VesselFilterParam param);

    VesselDto getVesselById(Long id);

    VesselDto updateStatusByVesselId(Long id, Status status);

    VesselDto updateVessel(VesselDto vessel);

    VesselDto saveVessel(VesselDto vessel);

    VesselDto deleteVessel(Long id);
}
