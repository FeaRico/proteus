package ru.makhach.proteus.core.validation.vessel;

import ru.makhach.proteus.core.model.base.types.Status;
import ru.makhach.proteus.core.model.dto.base.VesselDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class VesselValidator implements ConstraintValidator<VesselValid, VesselDto> {
    @Override
    public boolean isValid(VesselDto value, ConstraintValidatorContext context) {
        Status status = Status.getStatusByDescription(value.getStatus());
        switch (status) {
            case MOORED:
                return checkMoored(value, context);
            case UNDERWAY:
                return checkUnderway(value, context);
        }
        return true;
    }

    private boolean checkMoored(VesselDto value, ConstraintValidatorContext context) {
        if ((value.getDockId() != null) && (value.getCurrentPortId() != null))
            return true;
        if ((value.getDockId() == null) || (value.getCurrentPortId() == null)) {
            context.buildConstraintViolationWithTemplate("vessel cannot have a zero dock or port if it is moored")
                    .addPropertyNode("status")
                    .addPropertyNode("portId")
                    .addPropertyNode("dockId")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }

    private boolean checkUnderway(VesselDto value, ConstraintValidatorContext context) {
        if (value.getDockId() != null) {
            context.buildConstraintViolationWithTemplate("vessel cannot have a berth if it is moving")
                    .addPropertyNode("status")
                    .addPropertyNode("dockId")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
