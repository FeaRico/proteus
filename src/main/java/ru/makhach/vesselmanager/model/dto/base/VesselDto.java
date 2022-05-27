package ru.makhach.vesselmanager.model.dto.base;

import ru.makhach.vesselmanager.model.base.interfaces.NamedObj;

import java.util.Objects;

//TODO: вынести координаты в отдельный класс
public class VesselDto implements NamedObj {
    private final Long id;
    private final String name;
    private final String status;
    private final String type;
    private final Integer yearBuilt;
    private final Double latitude;
    private final Double longitude;
    private final Long countryId;
    private final Long currentPortId;
    private final Long homePortId;
    private final Long dockId;

    protected VesselDto(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.status = builder.status;
        this.type = builder.type;
        this.yearBuilt = builder.yearBuilt;
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
        this.countryId = builder.countryId;
        this.currentPortId = builder.currentPortId;
        this.homePortId = builder.homePortId;
        this.dockId = builder.dockId;
    }

    public static VesselDto.Builder builder() {
        return new VesselDto.Builder();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
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

    public Long getCountryId() {
        return countryId;
    }

    public Long getCurrentPortId() {
        return currentPortId;
    }

    public Long getHomePortId() {
        return homePortId;
    }

    public Long getDockId() {
        return dockId;
    }

    public static class Builder {
        private Long id;
        private String name;
        private String status;
        private String type;
        private Integer yearBuilt;
        private Double latitude;
        private Double longitude;
        private Long countryId;
        private Long currentPortId;
        private Long homePortId;
        private Long dockId;

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setType(String type) {
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

        public Builder setCountryId(Long countryId) {
            this.countryId = countryId;
            return this;
        }

        public Builder setCurrentPortId(Long currentPortId) {
            this.currentPortId = currentPortId;
            return this;
        }

        public Builder setHomePortId(Long homePortId) {
            this.homePortId = homePortId;
            return this;
        }

        public Builder setDockId(Long dockId) {
            this.dockId = dockId;
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
        return Objects.equals(id, vesselDto.id) && Objects.equals(name, vesselDto.name) && status == vesselDto.status && type == vesselDto.type && Objects.equals(yearBuilt, vesselDto.yearBuilt) && Objects.equals(latitude, vesselDto.latitude) && Objects.equals(longitude, vesselDto.longitude) && Objects.equals(countryId, vesselDto.countryId) && Objects.equals(currentPortId, vesselDto.currentPortId) && Objects.equals(homePortId, vesselDto.homePortId) && Objects.equals(dockId, vesselDto.dockId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, type, yearBuilt, latitude, longitude, countryId, currentPortId, homePortId, dockId);
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
                ", countryId=" + countryId +
                ", currentPortId=" + currentPortId +
                ", homePortId=" + homePortId +
                ", dockId=" + dockId +
                '}';
    }
}
