package ru.makhach.proteus.sse.listener;

import ru.makhach.proteus.sse.event.ProteusEvent;

/**
 * Слушатель событий
 */
@FunctionalInterface
public interface ProteusEventListener {
    /**
     * Метод отлавливает все события {@link ProteusEvent}
     *
     * @param event событие
     */
    void handleEvent(ProteusEvent event);
}
