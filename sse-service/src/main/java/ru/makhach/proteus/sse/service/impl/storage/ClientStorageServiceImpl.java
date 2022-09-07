package ru.makhach.proteus.sse.service.impl.storage;

import org.springframework.stereotype.Component;
import ru.makhach.proteus.sse.client.Client;
import ru.makhach.proteus.sse.service.storage.ClientStorageService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ClientStorageServiceImpl implements ClientStorageService {
    private final Map<String, Client> clients = new ConcurrentHashMap<>();

    @Override
    public List<Client> getAllClients() {
        return List.copyOf(clients.values());
    }

    @Override
    public Client getClientById(String clientId) {
        return clients.get(clientId);
    }

    @Override
    public Client saveClient(Client client) {
        return clients.put(client.getId(), client);
    }

    @Override
    public Client deleteClient(String clientId) {
        return clients.remove(clientId);
    }
}
