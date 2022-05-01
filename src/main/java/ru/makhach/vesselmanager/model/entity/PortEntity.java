package ru.makhach.vesselmanager.model.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "port")
public class PortEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "port_id_seq")
    @SequenceGenerator(name = "port_id_seq",
            sequenceName = "port_id_seq")
    @Column(
            name = "id",
            unique = true,
            nullable = false,
            insertable = false
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(name = "lat")
    private Double latitude;

    @Column(name = "lon")
    private Double longitude;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private CityEntity city;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private CountryEntity country;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
            mappedBy = "port")
    private List<DockEntity> docks;

    public PortEntity() {
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

    public CityEntity getCity() {
        return city;
    }

    public void setCity(CityEntity city) {
        this.city = city;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public List<DockEntity> getDocks() {
        return docks;
    }

    public void setDocks(List<DockEntity> docks) {
        this.docks = docks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PortEntity that = (PortEntity) o;
        return id.equals(that.id) && Objects.equals(name, that.name) && Objects.equals(latitude, that.latitude) && Objects.equals(longitude, that.longitude) && Objects.equals(city, that.city) && Objects.equals(country, that.country) && Objects.equals(docks, that.docks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, latitude, longitude, city, country, docks);
    }

    @Override
    public String toString() {
        return "PortEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", city=" + city +
                ", country=" + country +
                ", docks=" + docks +
                '}';
    }
}
