package ru.makhach.proteus.model.entity;

import ru.makhach.proteus.model.base.abstr.NamedEntity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Сущность страны
 */
@Entity
@Table(name = "country")
@SequenceGenerator(name = "default_seq", sequenceName = "country_id_seq")
public class Country extends NamedEntity {
    /**
     * Код страны
     */
    @Column(name = "code", nullable = false, unique = true)
    private String code;

    /**
     * Коллекция городов страны
     */
    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<City> cities;

    public Country() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<City> getCities() {
        return Collections.unmodifiableList(cities);
    }

    public void setCities(List<City> cities) {
        if (cities == null)
            this.cities = Collections.emptyList();
        else this.cities = Collections.unmodifiableList(cities);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id) && Objects.equals(name, country.name) && Objects.equals(code, country.code) && Objects.equals(cities, country.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, cities);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", cities=" + cities +
                '}';
    }
}
