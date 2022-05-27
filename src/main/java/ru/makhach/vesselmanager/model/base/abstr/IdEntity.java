package ru.makhach.vesselmanager.model.base.abstr;

import javax.persistence.*;

@MappedSuperclass
public abstract class IdEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "default_seq")
    @Column(name = "id", unique = true,
            nullable = false, insertable = false)
    protected Long id;

    public IdEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
