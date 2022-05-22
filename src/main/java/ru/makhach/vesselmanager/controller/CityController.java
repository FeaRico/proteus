package ru.makhach.vesselmanager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.makhach.vesselmanager.model.dto.CityDto;
import ru.makhach.vesselmanager.service.facade.CityServiceFacade;

import java.util.List;

@RestController
@RequestMapping("api/v1/cities")
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
    public ResponseEntity<List<CityDto>> getAllByCountry(@PathVariable Long countryId) {
        return ResponseEntity.ok(cityServiceFacade.getAllCitiesByCountry(countryId));
    }

    @GetMapping("{id}")
    public ResponseEntity<CityDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(cityServiceFacade.getCityById(id));
    }

    @PutMapping
    public ResponseEntity<CityDto> update(@RequestBody CityDto city) {
        return ResponseEntity.ok(cityServiceFacade.updateCity(city));
    }

    @PostMapping
    public ResponseEntity<CityDto> save(@RequestBody CityDto city) {
        return ResponseEntity.ok(cityServiceFacade.saveCity(city));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CityDto> delete(@PathVariable Long id) {
        return ResponseEntity.ok(cityServiceFacade.deleteCity(id));
    }
}
