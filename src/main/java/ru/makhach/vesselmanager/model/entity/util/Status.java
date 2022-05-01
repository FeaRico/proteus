package ru.makhach.vesselmanager.model.entity.util;

public enum Status {
    UNDERWAY("На ходу"),
    STOPPED("Остановился"),
    MOORED("Пришвартован"),
    AT_ANCHOR("На якоре");

    private final String description;

    Status(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
