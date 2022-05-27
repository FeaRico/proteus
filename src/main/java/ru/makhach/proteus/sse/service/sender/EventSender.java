package ru.makhach.proteus.sse.service.sender;

import ru.makhach.proteus.sse.event.ProteusEvent;

/**
 * Сервис для отправки событий
 */
@FunctionalInterface
public interface EventSender {
    /**
     * Отправка события всем подписчикам
     *
     * @param event событие
     */
    void send(ProteusEvent event);
}
