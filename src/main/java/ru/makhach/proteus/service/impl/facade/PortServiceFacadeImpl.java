package ru.makhach.proteus.service.impl.facade;

import org.springframework.stereotype.Service;
import ru.makhach.proteus.mapper.PortMapper;
import ru.makhach.proteus.model.dto.base.PortDto;
import ru.makhach.proteus.model.entity.City;
import ru.makhach.proteus.model.entity.Port;
import ru.makhach.proteus.service.CityService;
import ru.makhach.proteus.service.PortService;
import ru.makhach.proteus.service.facade.PortServiceFacade;

import java.util.List;

@Service
public class PortServiceFacadeImpl implements PortServiceFacade {
    private final PortService portService;
    private final CityService cityService;
    private final PortMapper portMapper;

    public PortServiceFacadeImpl(PortService portService, CityService cityService, PortMapper portMapper) {
        this.portService = portService;
        this.cityService = cityService;
        this.portMapper = portMapper;
    }

    @Override
    public List<PortDto> getAllPorts() {
        return portMapper.convertToDtos(portService.getAllPorts());
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
        return portMapper.convert(portService.updatePort(portEntity));
    }

    @Override
    public PortDto savePort(PortDto port) {
        Port portEntity = portMapper.convert(port);
        City city = cityService.getCityById(port.getCityId());
        portEntity.setCity(city);
        return portMapper.convert(portService.savePort(portEntity));
    }

    @Override
    public PortDto deletePort(Long id) {
        return portMapper.convert(portService.deletePort(id));
    }
}