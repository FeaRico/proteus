package ru.makhach.vesselmanager.model.dto;

import ru.makhach.vesselmanager.model.util.Status;
import ru.makhach.vesselmanager.model.util.Type;

import java.util.Objects;
//TODO: вынести координаты в отдельный класс
public class VesselDto {
    private final Long id;
    private final String name;
    private final Status status;
    private final Type type;
    private final Integer yearBuilt;
    private final Double latitude;
    private final Double longitude;
    private final CountryDto country;
    private final PortDto currentPort;
    private final PortDto homePort;
    private final DockDto dock;

    private VesselDto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.status = builder.status;
        this.type = builder.type;
        this.yearBuilt = builder.yearBuilt;
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
        this.country = builder.country;
        this.currentPort = builder.currentPort;
        this.homePort = builder.homePort;
        this.dock = builder.dock;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public Type getType() {
        return type;
    }

    public Integer getYearBuilt() {
        return yearBuilt;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public CountryDto getCountry() {
        return country;
    }

    public PortDto getCurrentPort() {
        return currentPort;
    }

    public PortDto getHomePort() {
        return homePort;
    }

    public DockDto getDock() {
        return dock;
    }

    public static class Builder {
        private Long id;
        private String name;
        private Status status;
        private Type type;
        private Integer yearBuilt;
        private Double latitude;
        private Double longitude;
        private CountryDto country;
        private PortDto currentPort;
        private PortDto homePort;
        private DockDto dock;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setStatus(Status status) {
            this.status = status;
            return this;
        }

        public Builder setType(Type type) {
            this.type = type;
            return this;
        }

        public Builder setYearBuilt(Integer yearBuilt) {
            this.yearBuilt = yearBuilt;
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

        public Builder setCountry(CountryDto country) {
            this.country = country;
            return this;
        }

        public Builder setCurrentPort(PortDto currentPort) {
            this.currentPort = currentPort;
            return this;
        }

        public Builder setHomePort(PortDto homePort) {
            this.homePort = homePort;
            return this;
        }

        public Builder setDock(DockDto dock) {
            this.dock = dock;
            return this;
        }

        public VesselDto build() {
            return new VesselDto(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VesselDto vesselDto = (VesselDto) o;
        return Objects.equals(id, vesselDto.id) && Objects.equals(name, vesselDto.name) && status == vesselDto.status && type == vesselDto.type && Objects.equals(yearBuilt, vesselDto.yearBuilt) && Objects.equals(latitude, vesselDto.latitude) && Objects.equals(longitude, vesselDto.longitude) && Objects.equals(country, vesselDto.country) && Objects.equals(currentPort, vesselDto.currentPort) && Objects.equals(homePort, vesselDto.homePort) && Objects.equals(dock, vesselDto.dock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, type, yearBuilt, latitude, longitude, country, currentPort, homePort, dock);
    }

    @Override
    public String toString() {
        return "VesselDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", yearBuilt=" + yearBuilt +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", country=" + country +
                ", currentPort=" + currentPort +
                ", homePort=" + homePort +
                ", dock=" + dock +
                '}';
    }
}
