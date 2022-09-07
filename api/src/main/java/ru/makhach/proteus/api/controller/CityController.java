package ru.makhach.proteus.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.makhach.proteus.core.model.dto.base.CityDto;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.core.model.dto.filter.pageable.PageResponse;
import ru.makhach.proteus.api.service.CityServiceFacade;
import ru.makhach.proteus.core.validation.Marker;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("api/v1/cities")
@Validated
public class CityController {
    private final CityServiceFacade cityServiceFacade;

    public CityController(CityServiceFacade cityServiceFacade) {
        this.cityServiceFacade = cityServiceFacade;
    }

    @GetMapping
    public ResponseEntity<List<CityDto>> getAll() {
        return ResponseEntity.ok(cityServiceFacade.getAllCities());
    }


    @GetMapping("/pageable")
    public ResponseEntity<PageResponse<List<CityDto>>> getAllPageable(@RequestParam(required = false, defaultValue = "0") @Min(0) Integer pageNum,
                                                                      @RequestParam(required = false, defaultValue = "20") @Min(1) Integer pageSize,
                                                                      @RequestParam(required = false, defaultValue = "id") String sortBy,
                                                                      @RequestParam(required = false, defaultValue = "ASC") String sortDir) {
        return ResponseEntity.ok(cityServiceFacade.getAllCitiesPageable(
                new PageRequest(pageNum, pageSize, sortBy, sortDir))
        );
    }

    @GetMapping("/country/{countryId}")
    public ResponseEntity<List<CityDto>> getAllByCountry(@PathVariable @NotNull @Min(1) Long countryId) {
        return ResponseEntity.ok(cityServiceFacade.getAllCitiesByCountry(countryId));
    }

    @GetMapping("{id}")
    public ResponseEntity<CityDto> getById(@PathVariable @NotNull @Min(1) Long id) {
        return ResponseEntity.ok(cityServiceFacade.getCityById(id));
    }

    @PutMapping
    @Validated(Marker.Update.class)
    public ResponseEntity<CityDto> update(@RequestBody @Valid CityDto city) {
        return ResponseEntity.ok(cityServiceFacade.updateCity(city));
    }

    @PostMapping
    @Validated(Marker.Create.class)
    public ResponseEntity<CityDto> save(@RequestBody @Valid CityDto city) {
        return ResponseEntity.ok(cityServiceFacade.saveCity(city));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CityDto> delete(@PathVariable @NotNull @Min(1) Long id) {
        return ResponseEntity.ok(cityServiceFacade.deleteCity(id));
    }
}
