package com.example.weatherapp.model.dto;

import jakarta.validation.constraints.*;

public record ListDetails(
        Double temp,
        @DecimalMin(value = "-50.0")
        @DecimalMax(value = "60.0")
        @NotNull(message = "Temperature cannot be null")
        Double feels_like,
        Double temp_min,
        Double temp_max,
        Integer pressure,
        Integer sea_level,
        Integer grnd_level,
        @Min(0)
        @Max(100)
        @NotNull(message = "Humidity cannot be null")
        Integer humidity,
        Double temp_kf){
}
