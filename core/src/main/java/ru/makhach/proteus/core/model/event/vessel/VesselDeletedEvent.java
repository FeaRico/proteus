package ru.makhach.proteus.core.model.event.vessel;

import ru.makhach.proteus.core.model.event.vessel.base.VesselEvent;

public class VesselDeletedEvent extends VesselEvent {
    private final Long deletedAt;

    public VesselDeletedEvent(Long id, Long deletedAt) {
        super(id);
        this.deletedAt = deletedAt;
    }

    public Long getDeletedAt() {
        return deletedAt;
    }
}
