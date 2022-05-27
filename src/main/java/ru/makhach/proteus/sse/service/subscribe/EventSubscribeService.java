package ru.makhach.proteus.sse.service.subscribe;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * Сервис для подписки на события
 */
public interface EventSubscribeService {
    /**
     * Подписать клиента на события.
     * Если клиент уже подписан, просто возвращает
     * эммитер из хранилища
     *
     * @param clientId идентификатор клиента
     * @param time     время ожидания
     * @return настроенный эммитер
     */
    SseEmitter subscribe(String clientId, Long time);

    /**
     * Отписать клиента от событий.
     * При успешной отписке завершает эммитер
     *
     * @param clientId идентификатор клиента
     */
    void unsubscribe(String clientId);
}
