package ru.makhach.proteus.sse.listener;

import org.springframework.context.event.EventListener;
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
    @EventListener(ProteusEvent.class)
    void handleEvent(ProteusEvent event);
}
