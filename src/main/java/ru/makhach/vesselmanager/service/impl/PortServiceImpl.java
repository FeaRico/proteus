package ru.makhach.vesselmanager.service.impl;

import org.springframework.stereotype.Service;
import ru.makhach.vesselmanager.exceptions.ResourceNotFoundException;
import ru.makhach.vesselmanager.model.entity.Port;
import ru.makhach.vesselmanager.repository.PortRepository;
import ru.makhach.vesselmanager.service.PortService;

import java.util.List;

@Service
public class PortServiceImpl implements PortService {
    private final PortRepository portRepository;

    public PortServiceImpl(PortRepository portRepository) {
        this.portRepository = portRepository;
    }

    @Override
    public List<Port> getAllPorts() {
        return portRepository.findAll();
    }

    @Override
    public List<Port> getAllPortsByCity(Long cityId) {
        return portRepository.findAllByCity(cityId);
    }

    @Override
    public List<Port> getAllPortsByCountry(Long countryId) {
        return portRepository.findAllByCountry(countryId);
    }

    @Override
    public Port getPortById(Long id) {
        return portRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Port.class, "id", id));
    }

    @Override
    public Port updatePort(Port port) {
        Long id = port.getId();
        portRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Port.class, "id", id));

        return portRepository.save(port);
    }

    @Override
    public Port savePort(Port port) {
        return portRepository.save(port);
    }

    @Override
    public Port deletePort(Long id) {
        Port foundEntity = portRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Port.class, "id", id));

        portRepository.delete(foundEntity);
        return foundEntity;
    }
}
