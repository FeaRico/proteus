package ru.makhach.proteus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.makhach.proteus.model.dto.base.CountryDto;
import ru.makhach.proteus.service.facade.CountryServiceFacade;

import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
public class CountryController {
    private final CountryServiceFacade countryServiceFacade;

    public CountryController(CountryServiceFacade countryServiceFacade) {
        this.countryServiceFacade = countryServiceFacade;
    }

    @GetMapping
    public ResponseEntity<List<CountryDto>> getAll() {
        return ResponseEntity.ok(countryServiceFacade.getAllCountries());
    }

    @GetMapping("{id}")
    public ResponseEntity<CountryDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(countryServiceFacade.getCountryById(id));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<CountryDto> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(countryServiceFacade.getCountryByCode(code));
    }

    @PutMapping
    public ResponseEntity<CountryDto> update(@RequestBody CountryDto country) {
        return ResponseEntity.ok(countryServiceFacade.updateCountry(country));
    }

    @PostMapping
    public ResponseEntity<CountryDto> save(@RequestBody CountryDto country) {
        return ResponseEntity.ok(countryServiceFacade.saveCountry(country));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CountryDto> delete(@PathVariable Long id) {
        return ResponseEntity.ok(countryServiceFacade.deleteCountry(id));
    }
}
