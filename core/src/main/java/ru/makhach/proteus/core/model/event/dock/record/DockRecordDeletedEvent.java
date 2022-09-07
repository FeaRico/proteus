package ru.makhach.proteus.core.model.event.dock.record;

import ru.makhach.proteus.core.model.event.dock.record.base.DockRecordEvent;

public class DockRecordDeletedEvent extends DockRecordEvent {
    private final Long deletedAt;

    public DockRecordDeletedEvent(Long id, Long deletedAt) {
        super(id);
        this.deletedAt = deletedAt;
    }

    public Long getDeletedAt() {
        return deletedAt;
    }
}
