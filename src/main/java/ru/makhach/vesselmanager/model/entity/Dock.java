package ru.makhach.vesselmanager.model.entity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "dock")
public class Dock {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "dock_id_seq")
    @SequenceGenerator(name = "dock_id_seq",
            sequenceName = "dock_id_seq")
    @Column(name = "id", nullable = false,
            unique = true, insertable = false)
    private Long id;

    @Column(name = "capacity", nullable = false)
    private Integer vesselsCapacity;

    @Column(name = "lat")
    private Double latitude;

    @Column(name = "lon")
    private Double longitude;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "port_id")
    private Port port;

    @OneToMany(mappedBy = "dock", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Vessel> vessels;

    public Dock() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVesselsCapacity() {
        return vesselsCapacity;
    }

    public void setVesselsCapacity(Integer vesselsCapacity) {
        this.vesselsCapacity = vesselsCapacity;
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

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public List<Vessel> getVessels() {
        return Collections.unmodifiableList(vessels);
    }

    public void setVessels(List<Vessel> vessels) {
        if (vessels == null)
            this.vessels = Collections.emptyList();
        else this.vessels = Collections.unmodifiableList(vessels);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dock dock = (Dock) o;
        return Objects.equals(id, dock.id) && Objects.equals(vesselsCapacity, dock.vesselsCapacity) && Objects.equals(latitude, dock.latitude) && Objects.equals(longitude, dock.longitude) && Objects.equals(port, dock.port) && Objects.equals(vessels, dock.vessels);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vesselsCapacity, latitude, longitude, port, vessels);
    }

    @Override
    public String toString() {
        return "Dock{" +
                "id=" + id +
                ", vesselsCapacity=" + vesselsCapacity +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", port=" + port +
                ", vessels=" + vessels +
                '}';
    }
}
