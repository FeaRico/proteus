package ru.makhach.proteus.sse.event.dock.record;

import ru.makhach.proteus.model.base.types.DockStatus;
import ru.makhach.proteus.sse.event.dock.record.base.DockRecordEvent;

public class DockVesselRecordEvent extends DockRecordEvent {
    private final Long vesselId;
    private final Long dockId;
    private final DockStatus status;

    public DockVesselRecordEvent(Long id, Long vesselId, Long dockId, DockStatus status) {
        super(id);
        this.vesselId = vesselId;
        this.dockId = dockId;
        this.status = status;
    }

    public Long getVesselId() {
        return vesselId;
    }

    public Long getDockId() {
        return dockId;
    }

    public DockStatus getStatus() {
        return status;
    }
}
