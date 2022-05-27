package ru.makhach.proteus.model.base.abstr;

import ru.makhach.proteus.model.base.interfaces.IdObj;

import javax.persistence.*;

@MappedSuperclass
public abstract class IdEntity implements IdObj {
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
