package ru.makhach.vesselmanager.model.entity;

import ru.makhach.vesselmanager.model.base.abstr.CoordEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "dock")
@SequenceGenerator(name = "default_seq", sequenceName = "dock_id_seq")
public class Dock extends CoordEntity {
    @Column(name = "capacity", nullable = false)
    private Integer vesselsCapacity;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "port_id")
    private Port port;

    @OneToMany(mappedBy = "dock", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Vessel> vessels;

    public Dock() {
    }

    public Integer getVesselsCapacity() {
        return vesselsCapacity;
    }

    public void setVesselsCapacity(Integer vesselsCapacity) {
        this.vesselsCapacity = vesselsCapacity;
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
