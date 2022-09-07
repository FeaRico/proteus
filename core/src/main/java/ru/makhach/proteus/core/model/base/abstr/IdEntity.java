package ru.makhach.proteus.core.model.base.abstr;

import ru.makhach.proteus.core.model.base.interfaces.IdObj;

import javax.persistence.*;

/**
 * Абстрактный класс для сущностей с идентификатором
 * В наследнике необходимо объявить свой Sequence Generator
 */
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
