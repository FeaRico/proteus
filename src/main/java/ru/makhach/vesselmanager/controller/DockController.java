package ru.makhach.vesselmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.makhach.vesselmanager.model.dto.base.DockDto;
import ru.makhach.vesselmanager.service.facade.DockServiceFacade;

import java.util.List;

@RestController
@RequestMapping("api/v1/docks")
public class DockController {
    private final DockServiceFacade dockServiceFacade;

    public DockController(DockServiceFacade dockServiceFacade) {
        this.dockServiceFacade = dockServiceFacade;
    }

    @GetMapping
    public ResponseEntity<List<DockDto>> getAll() {
        return ResponseEntity.ok(dockServiceFacade.getAllDocks());
    }

    @GetMapping("/port/{portId}")
    public ResponseEntity<List<DockDto>> getAllByPort(@PathVariable Long portId) {
        return ResponseEntity.ok(dockServiceFacade.getAllDocksByPort(portId));
    }

    @GetMapping("{id}")
    public ResponseEntity<DockDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(dockServiceFacade.getDockById(id));
    }

    @PutMapping
    public ResponseEntity<DockDto> update(@RequestBody DockDto dock) {
        return ResponseEntity.ok(dockServiceFacade.updateDock(dock));
    }

    @PostMapping
    public ResponseEntity<DockDto> save(@RequestBody DockDto dock) {
        return ResponseEntity.ok(dockServiceFacade.saveDock(dock));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<DockDto> delete(@PathVariable Long id) {
        return ResponseEntity.ok(dockServiceFacade.deleteDock(id));
    }

}

