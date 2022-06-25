package ru.makhach.proteus.sse.listener.impl;

import org.springframework.stereotype.Component;
import ru.makhach.proteus.sse.event.ProteusEvent;
import ru.makhach.proteus.sse.listener.ProteusEventListener;
import ru.makhach.proteus.sse.service.sender.EventSender;

@Component
public class ProteusEventListenerImpl implements ProteusEventListener {
    private final EventSender eventSender;

    public ProteusEventListenerImpl(EventSender eventSender) {
        this.eventSender = eventSender;
    }

    @Override
    public void handleEvent(ProteusEvent event) {
        eventSender.send(event);
    }
}
