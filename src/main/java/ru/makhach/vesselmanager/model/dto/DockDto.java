package ru.makhach.vesselmanager.model.dto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DockDto {
    private final Long id;
    private final Integer vesselsCapacity;
    private final Double latitude;
    private final Double longitude;
    private final List<VesselDto> vessels;

    public DockDto(Builder builder) {
        this.id = builder.id;
        this.vesselsCapacity = builder.vesselsCapacity;
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
        this.vessels = builder.vessels;
    }

    public Long getId() {
        return id;
    }

    public Integer getVesselsCapacity() {
        return vesselsCapacity;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public List<VesselDto> getVessels() {
        return Collections.unmodifiableList(vessels);
    }

    public static class Builder{
        private Long id;
        private Integer vesselsCapacity;
        private Double latitude;
        private Double longitude;
        private List<VesselDto> vessels;

        public Builder setId(Long id){
            this.id = id;
            return this;
        }

        public Builder setVesselsCapacity(Integer vesselsCapacity){
            this.vesselsCapacity = vesselsCapacity;
            return this;
        }

        public Builder setLatitude(Double latitude){
            this.latitude = latitude;
            return this;
        }

        public Builder setLongitude(Double longitude){
            this.longitude = longitude;
            return this;
        }

        public Builder setVessels(List<VesselDto> vessels){
            this.vessels = vessels;
            return this;
        }

        public DockDto build(){
            return new DockDto(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DockDto dockDto = (DockDto) o;
        return Objects.equals(id, dockDto.id) && Objects.equals(vesselsCapacity, dockDto.vesselsCapacity) && Objects.equals(latitude, dockDto.latitude) && Objects.equals(longitude, dockDto.longitude) && Objects.equals(vessels, dockDto.vessels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vesselsCapacity, latitude, longitude, vessels);
    }

    @Override
    public String toString() {
        return "DockDto{" +
                "id=" + id +
                ", vesselsCapacity=" + vesselsCapacity +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", vessels=" + vessels +
                '}';
    }
}
