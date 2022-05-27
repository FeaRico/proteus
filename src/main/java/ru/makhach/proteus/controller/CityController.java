package ru.makhach.proteus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.makhach.proteus.model.dto.base.CityDto;
import ru.makhach.proteus.service.facade.CityServiceFacade;
import ru.makhach.proteus.validation.Marker;

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
