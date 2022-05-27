package ru.makhach.proteus.service.facade;

import ru.makhach.proteus.model.dto.base.PortDto;

import java.util.List;

/**
 * Сервис для работы с {@link PortDto}
 * Этот слой для взаимодействия
 * с сервисами связанных моделей
 */
public interface PortServiceFacade {
    List<PortDto> getAllPorts();

    List<PortDto> getAllPortsByCity(Long cityId);

    List<PortDto> getAllPortsByCountry(Long countryId);

    PortDto getPortById(Long id);

    PortDto updatePort(PortDto port);

    PortDto savePort(PortDto port);

    PortDto deletePort(Long id);
}
