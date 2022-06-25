package ru.makhach.proteus.model.dto.filter.vessel;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.makhach.proteus.model.dto.filter.base.ParamType;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Возможные параметры для сортировки суден
 * Представлены типом
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum VesselFilterParamType implements ParamType {
    STATUS("status", "Статус судна в данный момент"),
    TYPE("type", "Тип судна"),
    YEAR_BUILT("yearBuilt", "Год постройки судна");

    /**
     * Поле фильтрации
     */
    private final String filteredField;
    /**
     * Описание фильтра
     */
    private final String description;

    VesselFilterParamType(String filteredField, String description) {
        this.filteredField = filteredField;
        this.description = description;
    }

    private static final Map<String, VesselFilterParamType> paramsByNameMap;

    static {
        paramsByNameMap = Arrays.stream(values())
                .collect(Collectors.toMap(VesselFilterParamType::getFilteredField, p -> p));
    }

    public String getFilteredField() {
        return filteredField;
    }

    public String getDescription() {
        return description;
    }

    /**
     * @param filteredField имя поля
     * @return тип параметра по имени поля
     */
    public static VesselFilterParamType getByField(String filteredField) {
        VesselFilterParamType filterParam = paramsByNameMap.get(filteredField);
        if (filterParam == null)
            throw new IllegalArgumentException("Not found param with name =" + filteredField);
        return filterParam;
    }
}
