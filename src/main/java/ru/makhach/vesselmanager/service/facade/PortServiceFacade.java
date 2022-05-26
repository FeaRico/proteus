package ru.makhach.vesselmanager.service.facade;

import ru.makhach.vesselmanager.model.dto.base.PortDto;

import java.util.List;

public interface PortServiceFacade {
    List<PortDto> getAllPorts();

    List<PortDto> getAllPortsByCity(Long cityId);

    List<PortDto> getAllPortsByCountry(Long countryId);

    PortDto getPortById(Long id);

    PortDto updatePort(PortDto port);

    PortDto savePort(PortDto port);

    PortDto deletePort(Long id);
}
