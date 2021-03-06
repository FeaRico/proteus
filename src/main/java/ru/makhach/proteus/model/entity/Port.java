package ru.makhach.proteus.model.entity;

import ru.makhach.proteus.model.base.abstr.CoordEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * Сущность порта
 */
@Entity
@Table(name = "port")
@SequenceGenerator(name = "default_seq", sequenceName = "port_id_seq")
public class Port extends CoordEntity {
    /**
     * Город в котором находится порт
     */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

    /**
     * Коллекция суден связанных с портом
     */
    @OneToMany(mappedBy = "port", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Dock> docks;

    public Port() {
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<Dock> getDocks() {
        return docks;
    }

    public void setDocks(List<Dock> docks) {
        this.docks = docks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Port port = (Port) o;
        return Objects.equals(id, port.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Port{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", city=" + city +
                ", docks=" + docks +
                '}';
    }
}
