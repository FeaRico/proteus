package ru.makhach.proteus.model.dto.base;

import ru.makhach.proteus.model.base.interfaces.CoordObj;
import ru.makhach.proteus.validation.Marker;

import javax.validation.constraints.*;
import java.util.Objects;

public class PortDto implements CoordObj {
    @Null(groups = Marker.Create.class)
    @NotNull(groups = Marker.Update.class)
    @Min(value = 1, groups = Marker.Update.class)
    private final Long id;

    @NotEmpty
    @Size(min = 1, max = 255)
    private final String name;

    private final Double latitude;

    private final Double longitude;

    @NotNull
    @Min(1)
    private final Long cityId;

    protected PortDto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
        this.cityId = builder.cityId;
    }

    public static PortDto.Builder builder() {
        return new PortDto.Builder();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Long getCityId() {
        return cityId;
    }

    public static class Builder {
        private Long id;
        private String name;
        private Double latitude;
        private Double longitude;
        private Long cityId;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setLatitude(Double latitude) {
            this.latitude = latitude;
            return this;
        }

        public Builder setLongitude(Double longitude) {
            this.longitude = longitude;
            return this;
        }

        public Builder setCityId(Long cityId) {
            this.cityId = cityId;
            return this;
        }

        public PortDto build() {
            return new PortDto(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PortDto portDto = (PortDto) o;
        return Objects.equals(id, portDto.id) && Objects.equals(name, portDto.name) && Objects.equals(latitude, portDto.latitude) && Objects.equals(longitude, portDto.longitude) && Objects.equals(cityId, portDto.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, latitude, longitude, cityId);
    }

    @Override
    public String toString() {
        return "PortDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", cityId=" + cityId +
                '}';
    }
}
