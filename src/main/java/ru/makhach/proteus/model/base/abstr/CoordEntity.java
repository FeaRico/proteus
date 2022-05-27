package ru.makhach.proteus.model.base.abstr;

import ru.makhach.proteus.model.base.interfaces.CoordObj;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class CoordEntity extends NamedEntity implements CoordObj {
    @Column(name = "lat")
    protected Double latitude;

    @Column(name = "lon")
    protected Double longitude;

    public CoordEntity() {
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
