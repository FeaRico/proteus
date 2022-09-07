package ru.makhach.proteus.core.validation.dock;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;
import org.springframework.context.ApplicationContext;
import ru.makhach.proteus.core.model.dto.base.DockDto;
import ru.makhach.proteus.core.service.DockService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.metadata.ConstraintDescriptor;

public class DockValidator implements ConstraintValidator<DockValid, DockDto> {
    private final ApplicationContext applicationContext;

    public DockValidator(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public boolean isValid(DockDto value, ConstraintValidatorContext context) {
        ConstraintDescriptor<?> constraintDescriptor = ((ConstraintValidatorContextImpl) context).getConstraintDescriptor();
        DockValid dockValid = (DockValid) constraintDescriptor.getAnnotation();
        DockService dockService = applicationContext.getBean(dockValid.service());
        Integer vesselsCount = dockService.countVesselsByDockId(value.getId());
        if (vesselsCount > value.getVesselsCapacity()) {
            context.buildConstraintViolationWithTemplate("it is not possible to add another vessel. not enough space")
                    .addPropertyNode("vesselCapacity")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
