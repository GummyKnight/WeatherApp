package com.example.weatherapp.validation.impl;

import com.example.weatherapp.model.enums.ConditionID;
import com.example.weatherapp.validation.annotation.ValidConditionID;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ConditionIDValidator implements ConstraintValidator<ValidConditionID, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null) return true;
        return ConditionID.isValidCode(value);
    }
}
