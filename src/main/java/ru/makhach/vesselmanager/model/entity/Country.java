package ru.makhach.vesselmanager.model.entity;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "country_id_seq")
    @SequenceGenerator(name = "country_id_seq",
            sequenceName = "country_id_seq")
    @Column(name = "id", unique = true,
            nullable = false, insertable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<City> cities;

    public Country() {
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
