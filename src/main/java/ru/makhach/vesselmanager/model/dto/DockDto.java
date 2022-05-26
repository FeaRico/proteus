package ru.makhach.vesselmanager.model.dto;

import java.util.Objects;

public class DockDto {
    private final Long id;
    private final Integer vesselsCapacity;
    private final Double latitude;
    private final Double longitude;
    private final Long portId;

    protected DockDto(Builder builder) {
        this.id = builder.id;
        this.vesselsCapacity = builder.vesselsCapacity;
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
        this.portId = builder.portId;
    }

    public static DockDto.Builder builder() {
        return new DockDto.Builder();
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

    public Long getPortId() {
        return portId;
    }

    public static class Builder {
        private Long id;
        private Integer vesselsCapacity;
        private Double latitude;
        private Double longitude;
        private Long portId;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setVesselsCapacity(Integer vesselsCapacity) {
            this.vesselsCapacity = vesselsCapacity;
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

        public Builder setPortId(Long portId) {
            this.portId = portId;
            return this;
        }

        public DockDto build() {
            return new DockDto(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DockDto dockDto = (DockDto) o;
        return Objects.equals(id, dockDto.id) && Objects.equals(vesselsCapacity, dockDto.vesselsCapacity) && Objects.equals(latitude, dockDto.latitude) && Objects.equals(longitude, dockDto.longitude) && Objects.equals(portId, dockDto.portId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vesselsCapacity, latitude, longitude, portId);
    }

    @Override
    public String toString() {
        return "DockDto{" +
                "id=" + id +
                ", vesselsCapacity=" + vesselsCapacity +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", portId=" + portId +
                '}';
    }
}
