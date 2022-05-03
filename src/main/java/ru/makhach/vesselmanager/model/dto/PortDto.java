package ru.makhach.vesselmanager.model.dto;

import java.util.Objects;

public class PortDto {
    private final Long id;
    private final String name;
    private final Double latitude;
    private final Double longitude;
    private final CityDto city;

    private PortDto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
        this.city = builder.city;
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

    public CityDto getCity() {
        return city;
    }

    public static class Builder {
        private Long id;
        private String name;
        private Double latitude;
        private Double longitude;
        private CityDto city;

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

        public Builder setCity(CityDto city) {
            this.city = city;
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
        return Objects.equals(id, portDto.id) && Objects.equals(name, portDto.name) && Objects.equals(latitude, portDto.latitude) && Objects.equals(longitude, portDto.longitude) && Objects.equals(city, portDto.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, latitude, longitude, city);
    }

    @Override
    public String toString() {
        return "PortDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", city=" + city +
                '}';
    }
}
