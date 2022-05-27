package ru.makhach.proteus.model.dto.base;

import ru.makhach.proteus.model.base.interfaces.NamedObj;
import ru.makhach.proteus.validation.Marker;

import javax.validation.constraints.*;
import java.util.Objects;

public class CityDto implements NamedObj {
    @Null(groups = Marker.Create.class)
    @NotNull(groups = Marker.Update.class)
    @Min(value = 1, groups = Marker.Update.class)
    private final Long id;

    @NotEmpty
    @Size(min = 1, max = 255)
    private final String name;

    @NotNull
    @Min(1)
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
