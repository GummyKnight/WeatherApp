package com.example.weatherapp.validation.impl;

import com.example.weatherapp.model.enums.CityName;
import com.example.weatherapp.validation.annotation.ValidCityName;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.EnumSet;

public class CityNameValidator implements ConstraintValidator<ValidCityName,CityName> {
    @Override
    public boolean isValid(CityName value, ConstraintValidatorContext context) {
        return value == null || EnumSet.allOf(CityName.class).contains(value);
    }
}
