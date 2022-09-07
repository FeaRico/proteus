package ru.makhach.proteus.core.service.event;

import ru.makhach.proteus.core.model.dto.base.DockRecordDto;
import ru.makhach.proteus.sse.service.event.EventService;

public interface DockRecordEventService extends EventService<DockRecordDto> {
    void vesselMooringEvent(DockRecordDto recordDto);

    void vesselUnmooringEvent(DockRecordDto recordDto);
}
