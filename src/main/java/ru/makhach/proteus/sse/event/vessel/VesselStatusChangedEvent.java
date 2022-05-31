package ru.makhach.proteus.sse.event.vessel;

public class VesselStatusChangedEvent extends VesselChangedEvent {
    private String status;

    public VesselStatusChangedEvent(Long id, Long changedAt, String status) {
        super(id, changedAt);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
