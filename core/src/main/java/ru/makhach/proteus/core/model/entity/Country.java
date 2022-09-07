package ru.makhach.proteus.core.model.entity;

import ru.makhach.proteus.core.model.base.abstr.NamedEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Сущность страны
 */
@Entity
@Table(name = "country")
@SequenceGenerator(name = "default_seq",
        sequenceName = "country_id_seq", allocationSize = 1)
public class Country extends NamedEntity {
    /**
     * Код страны
     */
    @Column(name = "code", nullable = false, unique = true)
    private String code;

    public Country() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id) && Objects.equals(name, country.name) && Objects.equals(code, country.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
