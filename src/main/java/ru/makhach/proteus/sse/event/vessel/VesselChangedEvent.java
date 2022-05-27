package ru.makhach.proteus.sse.event.vessel;

import ru.makhach.proteus.sse.event.vessel.base.VesselEvent;

public class VesselChangedEvent extends VesselEvent {
    private final Long changedAt;

    public VesselChangedEvent(Long id, Long changedAt) {
        super(id);
        this.changedAt = changedAt;
    }

    public Long getChangedAt() {
        return changedAt;
    }
}
