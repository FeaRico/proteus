package ru.makhach.proteus.model.dto.base;

import ru.makhach.proteus.model.base.interfaces.NamedObj;
import ru.makhach.proteus.validation.Marker;

import javax.validation.constraints.*;
import java.util.Objects;

public class CountryDto implements NamedObj {
    @Null(groups = Marker.Create.class)
    @NotNull(groups = Marker.Update.class)
    @Min(value = 1, groups = Marker.Update.class)
    private final Long id;

    @NotEmpty
    @Size(min = 1, max = 255)
    private final String name;

    @NotEmpty
    @Size(min = 1, max = 10)
    private final String code;

    public CountryDto(Long id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryDto that = (CountryDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code);
    }

    @Override
    public String toString() {
        return "CountryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
