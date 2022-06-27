package ru.makhach.proteus.sse.service.event;

import ru.makhach.proteus.model.dto.base.DockRecordDto;
import ru.makhach.proteus.sse.service.event.base.EventService;

public interface DockRecordEventService extends EventService<DockRecordDto> {
    void vesselMooringEvent(DockRecordDto recordDto);

    void vesselUnmooringEvent(DockRecordDto recordDto);
}
