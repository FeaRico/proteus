package ru.makhach.vesselmanager.model.dto.base;

import ru.makhach.vesselmanager.model.base.interfaces.NamedObj;

import java.util.Objects;

public class CityDto implements NamedObj {
    private final Long id;
    private final String name;
    private final Long countryId;

    public CityDto(Long id, String name, Long countryId) {
        this.id = id;
        this.name = name;
        this.countryId = countryId;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDto cityDto = (CityDto) o;
        return Objects.equals(id, cityDto.id) && Objects.equals(name, cityDto.name) && Objects.equals(countryId, cityDto.countryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, countryId);
    }

    @Override
    public String toString() {
        return "CityDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryId=" + countryId +
                '}';
    }
}
