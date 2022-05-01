package ru.makhach.vesselmanager.model.entity;

import ru.makhach.vesselmanager.model.entity.util.Status;
import ru.makhach.vesselmanager.model.entity.util.Type;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "vessel")
public class VesselEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "vessel_id_seq")
    @SequenceGenerator(name = "vessel_id_seq",
            sequenceName = "vessel_id_seq")
    @Column(name = "id", insertable = false,
            unique = true, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private Type type;

    @Column(name = "year_built")
    private Integer yearBuilt;

    @Column(name = "lat", nullable = false)
    private Double latitude;

    @Column(name = "lon", nullable = false)
    private Double longitude;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    private CountryEntity country;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "current_port_id")
    private PortEntity currentPort;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "home_port_id")
    private PortEntity homePort;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "dock_id")
    private DockEntity dock;

    public VesselEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(Integer yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public PortEntity getCurrentPort() {
        return currentPort;
    }

    public void setCurrentPort(PortEntity currentPort) {
        this.currentPort = currentPort;
    }

    public PortEntity getHomePort() {
        return homePort;
    }

    public void setHomePort(PortEntity homePort) {
        this.homePort = homePort;
    }

    public DockEntity getDock() {
        return dock;
    }

    public void setDock(DockEntity dock) {
        this.dock = dock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VesselEntity that = (VesselEntity) o;
        return id.equals(that.id) && name.equals(that.name) && status == that.status && type == that.type && Objects.equals(yearBuilt, that.yearBuilt) && Objects.equals(latitude, that.latitude) && Objects.equals(longitude, that.longitude) && Objects.equals(country, that.country) && Objects.equals(currentPort, that.currentPort) && Objects.equals(homePort, that.homePort) && Objects.equals(dock, that.dock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, status, type, yearBuilt, latitude, longitude, country, currentPort, homePort, dock);
    }

    @Override
    public String toString() {
        return "VesselEntity{" +
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
