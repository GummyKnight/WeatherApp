package com.example.weatherapp.model.dto;

import com.example.weatherapp.validation.annotation.ValidConditionID;
import jakarta.validation.constraints.NotNull;

public record Condition(
        @NotNull(message = "Condition ID cannot be null")
        @ValidConditionID//Custom Validation Enum List -> model.enums.ConditionID
        Integer id,
        String main,
        String description,
        String icon) {
}
