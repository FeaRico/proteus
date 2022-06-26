package ru.makhach.proteus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.makhach.proteus.model.dto.base.PortDto;
import ru.makhach.proteus.model.dto.filter.PageRequest;
import ru.makhach.proteus.model.dto.filter.PageResponse;
import ru.makhach.proteus.service.facade.PortServiceFacade;
import ru.makhach.proteus.validation.Marker;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("api/v1/ports")
@Validated
public class PortController {
    private final PortServiceFacade portServiceFacade;

    public PortController(PortServiceFacade portServiceFacade) {
        this.portServiceFacade = portServiceFacade;
    }

    @GetMapping
    public ResponseEntity<List<PortDto>> getAll() {
        return ResponseEntity.ok(portServiceFacade.getAllPorts());
    }

    @GetMapping("/pageable")
    public ResponseEntity<PageResponse<List<PortDto>>> getAllPageable(@RequestParam(required = false, defaultValue = "0") @Min(0) Integer pageNum,
                                                                      @RequestParam(required = false, defaultValue = "20") @Min(1) Integer pageSize,
                                                                      @RequestParam(required = false, defaultValue = "id") String sortBy,
                                                                      @RequestParam(required = false, defaultValue = "ASC") String sortDir) {
        return ResponseEntity.ok(portServiceFacade.getAllPortsPageable(new PageRequest(pageNum, pageSize, sortBy, sortDir)));
    }

    @GetMapping("/city/{cityId}")
    public ResponseEntity<List<PortDto>> getAllByCity(@PathVariable @NotNull @Min(1) Long cityId) {
        return ResponseEntity.ok(portServiceFacade.getAllPortsByCity(cityId));
    }

    @GetMapping("/country/{countryId}")
    public ResponseEntity<List<PortDto>> getAllByCountry(@PathVariable @NotNull @Min(1) Long countryId) {
        return ResponseEntity.ok(portServiceFacade.getAllPortsByCountry(countryId));
    }

    @GetMapping("{id}")
    public ResponseEntity<PortDto> getAllId(@PathVariable @NotNull @Min(1) Long id) {
        return ResponseEntity.ok(portServiceFacade.getPortById(id));
    }

    @PutMapping
    @Validated(Marker.Update.class)
    public ResponseEntity<PortDto> update(@RequestBody @Valid PortDto port) {
        return ResponseEntity.ok(portServiceFacade.updatePort(port));
    }

    @PostMapping
    @Validated(Marker.Create.class)
    public ResponseEntity<PortDto> save(@RequestBody @Valid PortDto port) {
        return ResponseEntity.ok(portServiceFacade.savePort(port));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<PortDto> delete(@PathVariable @NotNull @Min(1) Long id) {
        return ResponseEntity.ok(portServiceFacade.deletePort(id));
    }
}
