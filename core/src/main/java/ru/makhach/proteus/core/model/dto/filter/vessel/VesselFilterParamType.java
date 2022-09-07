package ru.makhach.proteus.core.model.dto.filter.vessel;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.makhach.proteus.core.model.base.types.Status;
import ru.makhach.proteus.core.model.base.types.Type;
import ru.makhach.proteus.core.model.dto.filter.base.ParamType;
import ru.makhach.proteus.core.model.entity.Vessel;
import ru.makhach.proteus.core.service.VesselService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Возможные параметры для сортировки суден
 * Представлены типом
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum VesselFilterParamType implements ParamType {
    STATUS("status", "Статус судна в данный момент") {
        @Override
        public List<Vessel> getFilteredVessels(VesselService service, VesselFilterParam param) {
            return service.getAllVesselsByStatus(Status.valueOf(param.getValue()));
        }
    },
    TYPE("type", "Тип судна") {
        @Override
        public List<Vessel> getFilteredVessels(VesselService service, VesselFilterParam param) {
            return service.getAllVesselsByType(Type.valueOf(param.getValue()));
        }
    },
    YEAR_BUILT("yearBuilt", "Год постройки судна") {
        @Override
        public List<Vessel> getFilteredVessels(VesselService service, VesselFilterParam param) {
            return service.getAllVesselsByYearBuilt(Integer.valueOf(param.getValue()));
        }
    };

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

    public abstract List<Vessel> getFilteredVessels(VesselService service, VesselFilterParam param);
}
