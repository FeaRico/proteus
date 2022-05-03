package ru.makhach.vesselmanager.model.dto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CountryDto {
    private final Long id;
    private final String name;
    private final String code;
    private final List<CityDto> cities;

    public CountryDto(Long id, String name, String code, List<CityDto> cities) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.cities = cities;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public List<CityDto> getCities() {
        return Collections.unmodifiableList(cities);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryDto that = (CountryDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(code, that.code) && Objects.equals(cities, that.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, cities);
    }

    @Override
    public String toString() {
        return "CountryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", cities=" + cities +
                '}';
    }
}
