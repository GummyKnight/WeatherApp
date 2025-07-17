package com.example.weatherapp.model.dto;

import jakarta.validation.constraints.*;

public record Wind(
        @DecimalMin(value = "0.0")
        @DecimalMax(value = "50.0")
        @NotNull(message = "Wind Speed cannot be null")
        Double speed,
        @Min(0)
        @Max(359)
        @NotNull(message = "Wind Degree cannot be null")
        Integer deg,
        @DecimalMin(value = "0.0")
        @DecimalMax(value = "100.0")
        @NotNull(message = "Wind Gust cannot be null")
        Integer gust
) {
}
