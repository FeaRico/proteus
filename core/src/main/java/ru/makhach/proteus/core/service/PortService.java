package ru.makhach.proteus.core.service;

import org.springframework.data.domain.Page;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.core.model.entity.Port;

import java.util.List;

/**
 * Сервис для работы с сущностью {@link Port}
 * Слой без логики
 */
public interface PortService {
    List<Port> getAllPorts();

    Page<Port> getAllPorts(PageRequest request);

    List<Port> getAllPortsByCity(Long cityId);

    List<Port> getAllPortsByCountry(Long countryId);

    Port getPortById(Long id);

    Port updatePort(Port port);

    Port savePort(Port port);

    Port deletePort(Long id);
}
