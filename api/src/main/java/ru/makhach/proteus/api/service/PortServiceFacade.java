package ru.makhach.proteus.api.service;

import ru.makhach.proteus.core.model.dto.base.PortDto;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageResponse;

import java.util.List;

/**
 * Сервис для работы с {@link PortDto}
 * Этот слой для взаимодействия
 * с сервисами связанных моделей
 */
public interface PortServiceFacade {
    List<PortDto> getAllPorts();

    PageResponse<List<PortDto>> getAllPortsPageable(PageRequest request);

    List<PortDto> getAllPortsByCity(Long cityId);

    List<PortDto> getAllPortsByCountry(Long countryId);

    PortDto getPortById(Long id);

    PortDto updatePort(PortDto port);

    PortDto savePort(PortDto port);

    PortDto deletePort(Long id);
}
