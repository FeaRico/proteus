package ru.makhach.proteus.core.model.dto.filter.vessel;

import ru.makhach.proteus.core.model.dto.filter.base.FilterParam;

/**
 * Параметр для фильтра суден
 */
public class VesselFilterParam extends FilterParam<VesselFilterParamType> {
    public VesselFilterParam(String paramName, String value) {
        super(VesselFilterParamType.getByField(paramName), value);
    }
}
