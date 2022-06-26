package ru.makhach.proteus.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.makhach.proteus.model.dto.base.CountryDto;
import ru.makhach.proteus.model.dto.filter.pageable.PageRequest;
import ru.makhach.proteus.model.dto.filter.pageable.PageResponse;
import ru.makhach.proteus.service.facade.CountryServiceFacade;
import ru.makhach.proteus.validation.Marker;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/v1/countries")
@Validated
public class CountryController {
    private final CountryServiceFacade countryServiceFacade;

    public CountryController(CountryServiceFacade countryServiceFacade) {
        this.countryServiceFacade = countryServiceFacade;
    }

    @GetMapping
    public ResponseEntity<List<CountryDto>> getAll() {
        return ResponseEntity.ok(countryServiceFacade.getAllCountries());
    }

    @GetMapping("/pageable")
    public ResponseEntity<PageResponse<List<CountryDto>>> getAllPageable(@RequestParam(required = false, defaultValue = "0") @Min(0) Integer pageNum,
                                                                         @RequestParam(required = false, defaultValue = "20") @Min(1) Integer pageSize,
                                                                         @RequestParam(required = false, defaultValue = "id") String sortBy,
                                                                         @RequestParam(required = false, defaultValue = "ASC") String sortDir) {
        return ResponseEntity.ok(countryServiceFacade.getAllCountriesPageable(
                new PageRequest(pageNum, pageSize, sortBy, sortDir)
        ));
    }

    @GetMapping("{id}")
    public ResponseEntity<CountryDto> getById(@PathVariable @NotNull @Min(1) Long id) {
        return ResponseEntity.ok(countryServiceFacade.getCountryById(id));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<CountryDto> getByCode(@PathVariable @NotEmpty String code) {
        return ResponseEntity.ok(countryServiceFacade.getCountryByCode(code));
    }

    @PutMapping
    @Validated(Marker.Update.class)
    public ResponseEntity<CountryDto> update(@RequestBody @Valid CountryDto country) {
        return ResponseEntity.ok(countryServiceFacade.updateCountry(country));
    }

    @PostMapping
    @Validated(Marker.Create.class)
    public ResponseEntity<CountryDto> save(@RequestBody @Valid CountryDto country) {
        return ResponseEntity.ok(countryServiceFacade.saveCountry(country));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CountryDto> delete(@PathVariable @NotNull @Min(1) Long id) {
        return ResponseEntity.ok(countryServiceFacade.deleteCountry(id));
    }
}
