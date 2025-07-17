package com.example.weatherapp.validation.impl;

import com.example.weatherapp.model.enums.CityName;
import com.example.weatherapp.validation.annotation.ValidCityDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class CityDtoValidator implements ConstraintValidator<ValidCityDto, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        String cleanValue = cleanCityName(value);

        return Arrays.stream(CityName.values())
                .anyMatch(city -> city.name().equalsIgnoreCase(cleanValue));
    }
    private String cleanCityName(String cityName) {
        int spaceIndex = cityName.indexOf(" ");
        return (spaceIndex != -1) ? cityName.substring(0, spaceIndex) : cityName;
    }
}
