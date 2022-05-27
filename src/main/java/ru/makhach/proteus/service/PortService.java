package ru.makhach.proteus.service;

import ru.makhach.proteus.model.entity.Port;

import java.util.List;

public interface PortService {
    List<Port> getAllPorts();

    List<Port> getAllPortsByCity(Long cityId);

    List<Port> getAllPortsByCountry(Long countryId);

    Port getPortById(Long id);

    Port updatePort(Port port);

    Port savePort(Port port);

    Port deletePort(Long id);
}