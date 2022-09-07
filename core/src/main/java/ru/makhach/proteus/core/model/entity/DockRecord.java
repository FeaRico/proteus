package ru.makhach.proteus.core.model.entity;

import ru.makhach.proteus.core.model.base.abstr.CreatedAtEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "docking_record")
@SequenceGenerator(name = "default_seq",
        sequenceName = "dock_id_seq", allocationSize = 1)
public class DockRecord extends CreatedAtEntity {
    @Column(name = "docking_time", nullable = false)
    private Long dockingTime;

    @Column(name = "is_undocked", nullable = false)
    private Boolean isUndocked;

    @Column(name = "undocked_time")
    private Long undockedTime;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "dock_id")
    private Dock dock;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "vessel_id")
    private Vessel vessel;

    public DockRecord() {
    }

    public Long getDockingTime() {
        return dockingTime;
    }

    public void setDockingTime(Long dockingTime) {
        this.dockingTime = dockingTime;
    }

    public Boolean getUndocked() {
        return isUndocked;
    }

    public void setUndocked(Boolean undocked) {
        isUndocked = undocked;
    }

    public Long getUndockedTime() {
        return undockedTime;
    }

    public void setUndockedTime(Long undockedTime) {
        this.undockedTime = undockedTime;
    }

    public Dock getDock() {
        return dock;
    }

    public void setDock(Dock dock) {
        this.dock = dock;
    }

    public Vessel getVessel() {
        return vessel;
    }

    public void setVessel(Vessel vessel) {
        this.vessel = vessel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DockRecord that = (DockRecord) o;
        return Objects.equals(dockingTime, that.dockingTime) && Objects.equals(isUndocked, that.isUndocked) && Objects.equals(undockedTime, that.undockedTime) && Objects.equals(dock, that.dock) && Objects.equals(vessel, that.vessel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dockingTime, isUndocked, undockedTime, dock, vessel);
    }

    @Override
    public String toString() {
        return "DockingRecord{" +
                "createdAt=" + createdAt +
                ", id=" + id +
                ", dockingTime=" + dockingTime +
                ", isUndocked=" + isUndocked +
                ", undockedTime=" + undockedTime +
                ", dock=" + dock +
                ", vessel=" + vessel +
                '}';
    }
}
