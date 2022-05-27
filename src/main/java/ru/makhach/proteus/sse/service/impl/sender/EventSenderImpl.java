package ru.makhach.proteus.sse.service.impl.sender;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ru.makhach.proteus.sse.event.ProteusEvent;
import ru.makhach.proteus.sse.service.sender.EventSender;
import ru.makhach.proteus.sse.service.storage.ClientStorageService;

import java.io.IOException;

@Component
public class EventSenderImpl implements EventSender {
    private final ClientStorageService clientStorage;

    public EventSenderImpl(ClientStorageService clientStorage) {
        this.clientStorage = clientStorage;
    }

    @Override
    public void send(ProteusEvent event) {
        clientStorage.getAllClients().forEach(client -> {
            SseEmitter clientEmitter = client.getEmitter();
            try {
                clientEmitter.send(SseEmitter.event()
                        .name(event.getEventType())
                        .data(event)
                        .build());
            } catch (IOException e) {
                clientEmitter.completeWithError(e);
            }
        });
    }
}
