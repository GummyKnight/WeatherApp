package com.example.weatherapp.validation.annotation;

import com.example.weatherapp.validation.impl.CityDtoValidator;
import com.example.weatherapp.validation.impl.CityNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CityDtoValidator.class)
public @interface ValidCityDto {
    String message() default "City name must be one of the predefined cities";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
