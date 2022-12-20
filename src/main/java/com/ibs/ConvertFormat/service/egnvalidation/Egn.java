package com.ibs.ConvertFormat.service.egnvalidation;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Constraint(validatedBy = EgnValidator.class)
public @interface Egn {
    public String message() default "Invalid egn";
    public Class<?>[] groups() default {};
    public Class<? extends Payload>[] payload() default {};
}
