package ru.makhach.vesselmanager.model.util;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Status {
    UNKNOWN("Неизвестно"),
    UNDERWAY("На ходу"),
    STOPPED("Остановился"),
    MOORED("Пришвартован"),
    AT_ANCHOR("На якоре");

    private final static Map<String, Status> descriptionMap;

    static {
        descriptionMap = Stream.of(values()).collect(Collectors.toMap(Status::getDescription, status -> status));
    }

    private final String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Status getStatusByDescription(String description) {
        Status status = descriptionMap.get(description);
        if (status == null)
            throw new IllegalArgumentException("Not found status with description =" + description);
        return status;
    }
}
