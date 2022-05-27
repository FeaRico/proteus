package ru.makhach.proteus.validation.vessel;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = VesselValidator.class)
public @interface VesselValid {
    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
