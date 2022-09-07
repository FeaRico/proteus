package ru.makhach.proteus.api.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.makhach.proteus.core.mapper.PortMapper;
import ru.makhach.proteus.core.model.dto.base.PortDto;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageResponse;
import ru.makhach.proteus.core.model.entity.City;
import ru.makhach.proteus.core.model.entity.Port;
import ru.makhach.proteus.core.service.CityService;
import ru.makhach.proteus.core.service.PortService;
import ru.makhach.proteus.core.service.event.PortEventService;
import ru.makhach.proteus.api.service.PortServiceFacade;

import java.util.List;

@Service
public class PortServiceFacadeImpl implements PortServiceFacade {
    private final PortService portService;
    private final CityService cityService;
    private final PortMapper portMapper;
    private final PortEventService eventService;

    public PortServiceFacadeImpl(PortService portService, CityService cityService, PortMapper portMapper, PortEventService eventService) {
        this.portService = portService;
        this.cityService = cityService;
        this.portMapper = portMapper;
        this.eventService = eventService;
    }

    @Override
    public List<PortDto> getAllPorts() {
        return portMapper.convertToDtos(portService.getAllPorts());
    }

    @Override
    public PageResponse<List<PortDto>> getAllPortsPageable(PageRequest request) {
        Page<Port> page = portService.getAllPorts(request);
        return portMapper.convertToPageResponse(page, request);
    }

    @Override
    public List<PortDto> getAllPortsByCity(Long cityId) {
        return portMapper.convertToDtos(portService.getAllPortsByCity(cityId));
    }

    @Override
    public List<PortDto> getAllPortsByCountry(Long countryId) {
        return portMapper.convertToDtos(portService.getAllPortsByCountry(countryId));
    }

    @Override
    public PortDto getPortById(Long id) {
        return portMapper.convert(portService.getPortById(id));
    }

    @Override
    public PortDto updatePort(PortDto port) {
        Port portEntity = portMapper.convert(port);
        City city = cityService.getCityById(port.getCityId());
        portEntity.setCity(city);
        PortDto updatedPort = portMapper.convert(portService.updatePort(portEntity));
        eventService.updateEvent(updatedPort);
        return updatedPort;
    }

    @Override
    public PortDto savePort(PortDto port) {
        Port portEntity = portMapper.convert(port);
        City city = cityService.getCityById(port.getCityId());
        portEntity.setCity(city);
        PortDto savedPort = portMapper.convert(portService.savePort(portEntity));
        eventService.saveEvent(savedPort);
        return savedPort;
    }

    @Override
    public PortDto deletePort(Long id) {
        PortDto deletedPort = portMapper.convert(portService.deletePort(id));
        eventService.deleteEvent(deletedPort);
        return deletedPort;
    }
}
