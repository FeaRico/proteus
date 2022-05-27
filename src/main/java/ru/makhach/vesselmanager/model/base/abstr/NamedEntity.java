package ru.makhach.vesselmanager.model.base.abstr;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class NamedEntity extends IdEntity {
    @Column(name = "name", nullable = false)
    protected String name;

    public NamedEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
