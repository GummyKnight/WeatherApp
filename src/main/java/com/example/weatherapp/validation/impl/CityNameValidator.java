package com.example.weatherapp.validation.impl;

import com.example.weatherapp.model.enums.CityName;
import com.example.weatherapp.validation.annotation.ValidCityName;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class CityNameValidator implements ConstraintValidator<ValidCityName,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return Arrays.stream(CityName.values())
                .anyMatch(city -> city.name().equalsIgnoreCase(value));
    }
}
