package ru.makhach.proteus.core.model.event.dock.record.base;

import ru.makhach.proteus.sse.event.ProteusEvent;

public abstract class DockRecordEvent implements ProteusEvent {
    private final Long id;

    public DockRecordEvent(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getEventType() {
        return "dock-record";
    }
}
