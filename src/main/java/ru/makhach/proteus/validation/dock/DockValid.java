package ru.makhach.proteus.validation.dock;

import ru.makhach.proteus.service.DockService;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DockValidator.class)
public @interface DockValid {
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<DockService> service() default DockService.class;
}
