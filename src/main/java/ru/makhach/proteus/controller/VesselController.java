package ru.makhach.proteus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.makhach.proteus.model.base.types.Status;
import ru.makhach.proteus.model.base.types.Type;
import ru.makhach.proteus.model.dto.base.VesselDto;
import ru.makhach.proteus.service.facade.VesselServiceFacade;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/vessels")
public class VesselController {
    private final VesselServiceFacade vesselServiceFacade;

    public VesselController(VesselServiceFacade vesselServiceFacade) {
        this.vesselServiceFacade = vesselServiceFacade;
    }

    @GetMapping
    public ResponseEntity<List<VesselDto>> getAll() {
        return ResponseEntity.ok(vesselServiceFacade.getAllVessels());
    }

    /**
     * Фильтр по параметрам. Обходим в карте все параметры и отдаём собранный результат.
     * Если параметров нет, отдаются все данные.
     * TODO: кидать эксепш при попытке вызвать метод без параметров
     * TODO: написать енд-поинт, выдающий параметры для фильтра
     *
     * @param request запрос
     * @return коллекция целей
     */
    @GetMapping("/filter")
    public ResponseEntity<List<VesselDto>> filter(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        List<VesselDto> result;
        if (parameterMap.isEmpty())
            result = vesselServiceFacade.getAllVessels();
        else result = parameterMap.entrySet().stream()
                .map(entry -> getResultByParam(entry.getKey(), entry.getValue()[0]))
                .flatMap(Collection::stream).collect(Collectors.toList());

        return ResponseEntity.ok(result);
    }

    private List<VesselDto> getResultByParam(String paramName, String value) {
        switch (paramName) {
            case "status":
                return vesselServiceFacade.getAllVesselsByStatus(Status.valueOf(value));
            case "type":
                return vesselServiceFacade.getAllVesselsByType(Type.valueOf(value));
            case "yearBuilt":
                return vesselServiceFacade.getAllVesselsByYearBuilt(Integer.valueOf(value));
            default:
                return Collections.emptyList();
        }
    }

    @GetMapping("/country/{countryId}")
    public ResponseEntity<List<VesselDto>> getAllByCountry(@PathVariable Long countryId) {
        return ResponseEntity.ok(vesselServiceFacade.getAllVesselsByCountry(countryId));
    }

    @GetMapping("/port/current/{portId}")
    public ResponseEntity<List<VesselDto>> getAllByCurrentPort(@PathVariable Long portId) {
        return ResponseEntity.ok(vesselServiceFacade.getAllVesselsByCurrentPort(portId));
    }

    @GetMapping("/port/home/{portId}")
    public ResponseEntity<List<VesselDto>> getAllByHomePort(@PathVariable Long portId) {
        return ResponseEntity.ok(vesselServiceFacade.getAllVesselsByHomePort(portId));
    }

    @GetMapping("/dock/{dockId}")
    public ResponseEntity<List<VesselDto>> getAllByDock(@PathVariable Long dockId) {
        return ResponseEntity.ok(vesselServiceFacade.getAllVesselsByDock(dockId));
    }

    @GetMapping("/name/with/{name}")
    public ResponseEntity<List<VesselDto>> getWhereNameStartWith(@PathVariable String name) {
        return ResponseEntity.ok(vesselServiceFacade.getAllVesselsWhereNameStartWith(name));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<VesselDto>> getByName(@PathVariable String name) {
        return ResponseEntity.ok(vesselServiceFacade.getVesselByName(name));
    }

    @PutMapping("{id}")
    public ResponseEntity<VesselDto> updateStatusById(@PathVariable Long id, @RequestParam Status status) {
        return ResponseEntity.ok(vesselServiceFacade.updateStatusByVesselId(id, status));
    }

    @PutMapping
    public ResponseEntity<VesselDto> update(@RequestBody VesselDto vessel) {
        return ResponseEntity.ok(vesselServiceFacade.updateVessel(vessel));
    }

    @PostMapping
    public ResponseEntity<VesselDto> save(@RequestBody VesselDto vessel) {
        return ResponseEntity.ok(vesselServiceFacade.saveVessel(vessel));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<VesselDto> delete(@PathVariable Long id) {
        return ResponseEntity.ok(vesselServiceFacade.deleteVessel(id));
    }
}
