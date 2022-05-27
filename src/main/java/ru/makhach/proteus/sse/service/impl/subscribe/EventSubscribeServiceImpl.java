package ru.makhach.proteus.sse.service.impl.subscribe;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ru.makhach.proteus.sse.client.Client;
import ru.makhach.proteus.sse.service.storage.ClientStorageService;
import ru.makhach.proteus.sse.service.subscribe.EventSubscribeService;

@Component
public class EventSubscribeServiceImpl implements EventSubscribeService {
    private final ClientStorageService clientStorage;

    public EventSubscribeServiceImpl(ClientStorageService clientStorage) {
        this.clientStorage = clientStorage;
    }

    @Override
    public SseEmitter subscribe(String clientId, Long time) {
        Client clientById = clientStorage.getClientById(clientId);
        if (clientById != null)
            return clientById.getEmitter();

        SseEmitter emitter = new SseEmitter(time);
        clientStorage.saveClient(new Client(clientId, emitter));
        return emitter;
    }

    @Override
    public void unsubscribe(String clientId) {
        Client deletedClient = clientStorage.deleteClient(clientId);
        if (deletedClient != null)
            deletedClient.getEmitter().complete();
    }
}
