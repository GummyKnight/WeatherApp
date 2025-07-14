package com.example.weatherapp.validation.annotation;

import com.example.weatherapp.validation.impl.ConditionIDValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ConditionIDValidator.class)
public @interface ValidConditionID {
    String message() default "Invalid weather condition code";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
