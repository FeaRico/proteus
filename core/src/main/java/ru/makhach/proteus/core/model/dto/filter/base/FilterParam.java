package ru.makhach.proteus.core.model.dto.filter.base;

/**
 * Абстрактный класс параметров для фильтра данных
 *
 * @param <T> тип параметра
 */
public abstract class FilterParam<T extends ParamType> {
    protected final T type;
    protected final String value;

    public FilterParam(T type, String value) {
        this.type = type;
        this.value = value;
    }

    public T getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
