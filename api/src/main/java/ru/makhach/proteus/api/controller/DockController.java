package ru.makhach.proteus.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.makhach.proteus.core.model.dto.base.DockDto;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageResponse;
import ru.makhach.proteus.api.service.DockServiceFacade;
import ru.makhach.proteus.core.validation.Marker;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("api/v1/docks")
@Validated
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
    public ResponseEntity<List<DockDto>> getAllByPort(@PathVariable @NotNull @Min(1) Long portId) {
        return ResponseEntity.ok(dockServiceFacade.getAllDocksByPort(portId));
    }

    @GetMapping("/pageable")
    public ResponseEntity<PageResponse<List<DockDto>>> getAllPageable(@RequestParam(required = false, defaultValue = "0") @Min(0) Integer pageNum,
                                                                      @RequestParam(required = false, defaultValue = "20") @Min(1) Integer pageSize,
                                                                      @RequestParam(required = false, defaultValue = "id") String sortBy,
                                                                      @RequestParam(required = false, defaultValue = "ASC") String sortDir) {
        return ResponseEntity.ok(dockServiceFacade.getAllDocksPageable(new PageRequest(pageNum, pageSize, sortBy, sortDir)));
    }

    @GetMapping("{id}")
    public ResponseEntity<DockDto> getById(@PathVariable @NotNull @Min(1) Long id) {
        return ResponseEntity.ok(dockServiceFacade.getDockById(id));
    }

    @PutMapping
    @Validated(Marker.Update.class)
    public ResponseEntity<DockDto> update(@RequestBody @Valid DockDto dock) {
        return ResponseEntity.ok(dockServiceFacade.updateDock(dock));
    }

    @PostMapping
    @Validated(Marker.Create.class)
    public ResponseEntity<DockDto> save(@RequestBody @Valid DockDto dock) {
        return ResponseEntity.ok(dockServiceFacade.saveDock(dock));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<DockDto> delete(@PathVariable @NotNull @Min(1) Long id) {
        return ResponseEntity.ok(dockServiceFacade.deleteDock(id));
    }
}

