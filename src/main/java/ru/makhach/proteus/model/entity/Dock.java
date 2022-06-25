package ru.makhach.proteus.model.entity;

import ru.makhach.proteus.model.base.abstr.CoordEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Сущность причала
 */
@Entity
@Table(name = "dock")
@SequenceGenerator(name = "default_seq",
        sequenceName = "dock_id_seq", allocationSize = 1)
public class Dock extends CoordEntity {
    /**
     * Кол-во мест для пришвартовки суден
     */
    @Column(name = "capacity", nullable = false)
    private Integer vesselsCapacity;

    /**
     * Порт к которому относится порт
     */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "port_id")
    private Port port;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dock dock = (Dock) o;
        return Objects.equals(id, dock.id) && Objects.equals(vesselsCapacity, dock.vesselsCapacity) && Objects.equals(latitude, dock.latitude) && Objects.equals(longitude, dock.longitude) && Objects.equals(port, dock.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vesselsCapacity, latitude, longitude, port);
    }

    @Override
    public String toString() {
        return "Dock{" +
                "id=" + id +
                ", vesselsCapacity=" + vesselsCapacity +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", port=" + port +
                '}';
    }
}
