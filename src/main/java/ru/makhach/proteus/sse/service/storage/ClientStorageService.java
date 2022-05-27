package ru.makhach.proteus.sse.service.storage;

import ru.makhach.proteus.sse.client.Client;

import java.util.List;

/**
 * Сервис для хранения всех подписчиков событий.
 * Отвечает только за CR*D, без логики
 */
public interface ClientStorageService {
    /**
     * Возвращает всех подписчиков
     *
     * @return иммутабельный лист подписчиков
     */
    List<Client> getAllClients();

    /**
     * Возвращает подписчика по уникальному идентификатору.
     *
     * @param clientId идентификатор клиента
     * @return подписчик
     */
    Client getClientById(String clientId);

    /**
     * Сохранение подписчика в хранилище
     *
     * @param client подписчик
     * @return сохраненноый подписчик
     */
    Client saveClient(Client client);

    /**
     * Удаляет подписчика из хранилища
     *
     * @param clientId идентификатор подписчика
     * @return удалённый подписчик
     */
    Client deleteClient(String clientId);
}
