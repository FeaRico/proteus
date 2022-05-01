package ru.makhach.vesselmanager.model.entity.util;

public enum Type {
    UNKNOWN("Неизвестное судно"),
    TANKER("Танкер"),
    CARGO("Грузовое судно"),
    PASSENGER("Пассажирское судно"),
    FISHING("Рыбаловное судно");

    private final String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
