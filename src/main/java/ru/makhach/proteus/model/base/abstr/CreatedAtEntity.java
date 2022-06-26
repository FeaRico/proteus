package ru.makhach.proteus.model.base.abstr;

import ru.makhach.proteus.model.base.interfaces.CreatedAtObj;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class CreatedAtEntity extends IdEntity implements CreatedAtObj {
    protected Long createdAt;

    public CreatedAtEntity() {
    }

    @Override
    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }
}
