package ru.makhach.proteus.model.dto.vessel;

import ru.makhach.proteus.model.dto.vessel.types.VesselFilterParamType;

/**
 * Параметр для фильтра суден
 */
public class VesselFilterParam {
    private final VesselFilterParamType paramType;
    private final String value;

    public VesselFilterParam(String paramName, String value) {
        this.paramType = VesselFilterParamType.getByField(paramName);
        this.value = value;
    }

    public VesselFilterParamType getType() {
        return paramType;
    }

    public String getValue() {
        return value;
    }
}
