package ru.makhach.proteus.model.dto.vessel;

import ru.makhach.proteus.model.dto.base.filter.FilterParam;
import ru.makhach.proteus.model.dto.vessel.types.VesselFilterParamType;

/**
 * Параметр для фильтра суден
 */
public class VesselFilterParam extends FilterParam<VesselFilterParamType> {
    public VesselFilterParam(String paramName, String value) {
        super(VesselFilterParamType.getByField(paramName), value);
    }
}
