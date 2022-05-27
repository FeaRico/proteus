package ru.makhach.proteus.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.makhach.proteus.exceptions.ResourceNotFoundException;
import ru.makhach.proteus.model.entity.Port;
import ru.makhach.proteus.repository.PortRepository;
import ru.makhach.proteus.service.PortService;

import java.util.List;

@Service
@Transactional
public class PortServiceImpl implements PortService {
    private final PortRepository portRepository;

    public PortServiceImpl(PortRepository portRepository) {
        this.portRepository = portRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Port> getAllPorts() {
        return portRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Port> getAllPortsByCity(Long cityId) {
        return portRepository.findAllByCity(cityId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Port> getAllPortsByCountry(Long countryId) {
        return portRepository.findAllByCountry(countryId);
    }

    @Override
    @Transactional(readOnly = true)
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
