package ru.makhach.proteus.model.entity;

import ru.makhach.proteus.model.base.abstr.NamedEntity;

import javax.persistence.*;
import java.util.Objects;

/**
 * Сущность города
 */
@Entity
@Table(name = "city")
@SequenceGenerator(name = "default_seq", sequenceName = "city_id_seq")
public class City extends NamedEntity {
    /**
     * Страна к которой принадлежит город
     */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    public City() {
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City that = (City) o;
        return id.equals(that.id) && name.equals(that.name) && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country);
    }

    @Override
    public String toString() {
        return "CityEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
