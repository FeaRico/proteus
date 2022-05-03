package ru.makhach.vesselmanager.model.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "dock")
public class DockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "dock_id_seq")
    @SequenceGenerator(name = "dock_id_seq",
            sequenceName = "dock_id_seq")
    @Column(name = "id", nullable = false,
            unique = true, insertable = false)
    private Long id;

    @Column(name = "capacity", nullable = false)
    private Integer vesselsCapacity;

    @Column(name = "lat")
    private Double latitude;

    @Column(name = "lon")
    private Double longitude;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "port_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private PortEntity port;

    public DockEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVesselsCapacity() {
        return vesselsCapacity;
    }

    public void setVesselsCapacity(Integer vesselsCapacity) {
        this.vesselsCapacity = vesselsCapacity;
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

    public PortEntity getPort() {
        return port;
    }

    public void setPort(PortEntity port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DockEntity that = (DockEntity) o;
        return id.equals(that.id) && Objects.equals(vesselsCapacity, that.vesselsCapacity) && Objects.equals(latitude, that.latitude) && Objects.equals(longitude, that.longitude) && Objects.equals(port, that.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vesselsCapacity, latitude, longitude, port);
    }

    @Override
    public String toString() {
        return "DockEntity{" +
                "id=" + id +
                ", vesselsCapacity=" + vesselsCapacity +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", port=" + port +
                '}';
    }
}
