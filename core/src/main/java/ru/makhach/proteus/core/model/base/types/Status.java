package ru.makhach.proteus.core.model.base.types;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Статус судна
 */
public enum Status {
    UNKNOWN("Неизвестно"),
    UNDERWAY("На ходу"),
    STOPPED("Остановился"),
    MOORED("Пришвартован"),
    AT_ANCHOR("На якоре");

    private final static Map<String, Status> descriptionMap;

    static {
        descriptionMap = Stream.of(values()).collect(Collectors.toMap(Status::getDescription, Function.identity()));
    }

    /**
     * Описание статуса
     */
    private final String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Получение типа статуса по описанию статуса
     *
     * @param description описание
     * @return тип статуса
     */
    public static Status getStatusByDescription(String description) {
        Status status = descriptionMap.get(description);
        if (status == null)
            throw new IllegalArgumentException("Not found status with description =" + description);
        return status;
    }
}
