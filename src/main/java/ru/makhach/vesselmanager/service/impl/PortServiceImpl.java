package ru.makhach.vesselmanager.service.impl;

import org.springframework.stereotype.Service;
import ru.makhach.vesselmanager.exceptions.ResourceNotFoundException;
import ru.makhach.vesselmanager.mapper.PortMapper;
import ru.makhach.vesselmanager.model.dto.PortDto;
import ru.makhach.vesselmanager.model.entity.PortEntity;
import ru.makhach.vesselmanager.repository.PortRepository;
import ru.makhach.vesselmanager.service.PortService;

import java.util.List;

@Service
public class PortServiceImpl implements PortService {
    private final PortMapper portMapper;
    private final PortRepository portRepository;

    public PortServiceImpl(PortMapper portMapper, PortRepository portRepository) {
        this.portMapper = portMapper;
        this.portRepository = portRepository;
    }

    @Override
    public List<PortDto> getAllPorts() {
        return portMapper.entityToDto(portRepository.findAll());
    }

    @Override
    public List<PortDto> getAllPortsByCity(Long cityId) {
        return portMapper.entityToDto(portRepository.findAllByCity(cityId));
    }

    @Override
    public List<PortDto> getAllPortsByCountry(Long countryId) {
        return portMapper.entityToDto(portRepository.findAllByCountry(countryId));
    }

    @Override
    public PortDto getPortById(Long id) {
        return portMapper.entityToDto(portRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(PortEntity.class, "id", id)));
    }

    @Override
    public PortDto updatePort(PortDto port) {
        Long id = port.getId();
        portRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(PortEntity.class, "id", id));

        PortEntity entity = portMapper.dtoToEntity(port);
        return portMapper.entityToDto(portRepository.save(entity));
    }

    @Override
    public PortDto savePort(PortDto port) {
        PortEntity entity = portMapper.dtoToEntity(port);
        return portMapper.entityToDto(portRepository.save(entity));
    }

    @Override
    public PortDto deletePort(Long id) {
        PortEntity foundEntity = portRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(PortEntity.class, "id", id));

        portRepository.delete(foundEntity);
        return portMapper.entityToDto(foundEntity);
    }
}
