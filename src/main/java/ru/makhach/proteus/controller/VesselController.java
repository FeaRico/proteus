package ru.makhach.proteus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.makhach.proteus.exceptions.EmptyParametersException;
import ru.makhach.proteus.model.base.types.Status;
import ru.makhach.proteus.model.dto.base.VesselDto;
import ru.makhach.proteus.model.dto.vessel.VesselFilterParam;
import ru.makhach.proteus.model.dto.vessel.types.VesselFilterParamType;
import ru.makhach.proteus.service.facade.VesselServiceFacade;
import ru.makhach.proteus.validation.Marker;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/vessels")
@Validated
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
     *
     * @param request запрос
     * @return коллекция целей
     */
    @GetMapping("/filter")
    public ResponseEntity<List<VesselDto>> filter(HttpServletRequest request) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        List<VesselDto> result;
        if (parameterMap.isEmpty())
            throw new EmptyParametersException();
        else {
            List<VesselFilterParam> filterParams = parameterMap.entrySet().stream()
                    .map(entry -> new VesselFilterParam(entry.getKey(), entry.getValue()[0])).collect(Collectors.toList());
            result = filterParams.stream()
                    .map(vesselServiceFacade::getAllVesselByFilter)
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/filter/params")
    public ResponseEntity<List<VesselFilterParamType>> getAllFilterParams() {
        return ResponseEntity.ok(List.of(VesselFilterParamType.values()));
    }

    @GetMapping("/country/{countryId}")
    public ResponseEntity<List<VesselDto>> getAllByCountry(@PathVariable @NotNull @Min(1) Long countryId) {
        return ResponseEntity.ok(vesselServiceFacade.getAllVesselsByCountry(countryId));
    }

    @GetMapping("/port/current/{portId}")
    public ResponseEntity<List<VesselDto>> getAllByCurrentPort(@PathVariable @NotNull @Min(1) Long portId) {
        return ResponseEntity.ok(vesselServiceFacade.getAllVesselsByCurrentPort(portId));
    }

    @GetMapping("/port/home/{portId}")
    public ResponseEntity<List<VesselDto>> getAllByHomePort(@PathVariable @NotNull @Min(1) Long portId) {
        return ResponseEntity.ok(vesselServiceFacade.getAllVesselsByHomePort(portId));
    }

    @GetMapping("/dock/{dockId}")
    public ResponseEntity<List<VesselDto>> getAllByDock(@PathVariable @NotNull @Min(1) Long dockId) {
        return ResponseEntity.ok(vesselServiceFacade.getAllVesselsByDock(dockId));
    }

    @GetMapping("/name/with/{name}")
    public ResponseEntity<List<VesselDto>> getWhereNameStartWith(@PathVariable @NotEmpty String name) {
        return ResponseEntity.ok(vesselServiceFacade.getAllVesselsWhereNameStartWith(name));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<VesselDto>> getByName(@PathVariable @NotEmpty String name) {
        return ResponseEntity.ok(vesselServiceFacade.getVesselByName(name));
    }

    @PutMapping("{id}")
    public ResponseEntity<VesselDto> updateStatusById(@PathVariable @NotNull @Min(1) Long id, @RequestParam @NotNull Status status) {
        return ResponseEntity.ok(vesselServiceFacade.updateStatusByVesselId(id, status));
    }

    @PutMapping
    @Validated(Marker.Update.class)
    public ResponseEntity<VesselDto> update(@RequestBody @Valid VesselDto vessel) {
        return ResponseEntity.ok(vesselServiceFacade.updateVessel(vessel));
    }

    @PostMapping
    @Validated(Marker.Create.class)
    public ResponseEntity<VesselDto> save(@RequestBody @Valid VesselDto vessel) {
        return ResponseEntity.ok(vesselServiceFacade.saveVessel(vessel));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<VesselDto> delete(@PathVariable @NotNull @Min(1) Long id) {
        return ResponseEntity.ok(vesselServiceFacade.deleteVessel(id));
    }
}
