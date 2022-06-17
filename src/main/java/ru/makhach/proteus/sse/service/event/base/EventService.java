package ru.makhach.proteus.sse.service.event.base;

/**
 * Интерфейс для слоя событий.
 * Предоставляет контракт для реализации базовых событий
 *
 * @param <T> объект с которым работает событие
 */
public interface EventService<T> {
    /**
     * Событие сохранения
     *
     * @param object объект события
     */
    void saveEvent(T object);

    /**
     * Событие обновления
     *
     * @param object объект события
     */
    void updateEvent(T object);

    /**
     * Событие удаления
     *
     * @param object объект события
     */
    void deleteEvent(T object);
}
