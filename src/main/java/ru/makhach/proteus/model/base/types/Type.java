package ru.makhach.proteus.model.base.types;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Type {
    UNKNOWN("Неизвестное судно"),
    TANKER("Танкер"),
    CARGO("Грузовое судно"),
    PASSENGER("Пассажирское судно"),
    FISHING("Рыбаловное судно");

    private final static Map<String, Type> nameMap;

    private final String name;

    static {
        nameMap = Stream.of(values()).collect(Collectors.toMap(Type::getName, type -> type));
    }

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Type getTypeByName(String name) {
        Type type = nameMap.get(name);
        if (type == null)
            throw new IllegalArgumentException("Not found type with name =" + name);
        return type;
    }
}
