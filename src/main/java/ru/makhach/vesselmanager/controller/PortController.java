package ru.makhach.vesselmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.makhach.vesselmanager.model.dto.base.PortDto;
import ru.makhach.vesselmanager.service.facade.PortServiceFacade;

import java.util.List;

@RestController
@RequestMapping("api/v1/ports")
public class PortController {
    private final PortServiceFacade portServiceFacade;

    public PortController(PortServiceFacade portServiceFacade) {
        this.portServiceFacade = portServiceFacade;
    }

    @GetMapping
    public ResponseEntity<List<PortDto>> getAll() {
        return ResponseEntity.ok(portServiceFacade.getAllPorts());
    }

    @GetMapping("/city/{cityId}")
    public ResponseEntity<List<PortDto>> getAllByCity(@PathVariable Long cityId) {
        return ResponseEntity.ok(portServiceFacade.getAllPortsByCity(cityId));
    }

    @GetMapping("/country/{countryId}")
    public ResponseEntity<List<PortDto>> getAllByCountry(@PathVariable Long countryId) {
        return ResponseEntity.ok(portServiceFacade.getAllPortsByCountry(countryId));
    }

    @GetMapping("{id}")
    public ResponseEntity<PortDto> getAllId(@PathVariable Long id) {
        return ResponseEntity.ok(portServiceFacade.getPortById(id));
    }

    @PutMapping
    public ResponseEntity<PortDto> update(@RequestBody PortDto port) {
        return ResponseEntity.ok(portServiceFacade.updatePort(port));
    }

    @PostMapping
    public ResponseEntity<PortDto> save(@RequestBody PortDto port) {
        return ResponseEntity.ok(portServiceFacade.savePort(port));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<PortDto> delete(@PathVariable Long id) {
        return ResponseEntity.ok(portServiceFacade.deletePort(id));
    }
}
