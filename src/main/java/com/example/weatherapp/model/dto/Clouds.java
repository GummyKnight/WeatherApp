package com.example.weatherapp.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record Clouds(
        @Min(0)
        @Max(100)
        @NotNull(message = "Clouds cannot be null")
        Integer all
){
}
