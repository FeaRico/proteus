package ru.makhach.proteus.sse.event.vessel;

import ru.makhach.proteus.sse.event.vessel.base.VesselEvent;

public class VesselCreatedEvent extends VesselEvent {
    private final Long createdAt;

    public VesselCreatedEvent(Long id, Long createdAt) {
        super(id);
        this.createdAt = createdAt;
    }

    public Long getCreatedAt() {
        return createdAt;
    }
}
