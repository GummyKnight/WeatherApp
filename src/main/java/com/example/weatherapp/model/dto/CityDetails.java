package com.example.weatherapp.model.dto;

import com.example.weatherapp.validation.annotation.ValidCityDto;
import com.example.weatherapp.validation.annotation.ValidCityName;
import jakarta.validation.constraints.NotBlank;

public record CityDetails(
        Integer id,
        @ValidCityDto//CustomValidation
        @NotBlank(message = "City name cannot be blank")
        String name,
        CityCoordination cityCoordination,
        String country,
        Integer population,
        Integer timezone,
        Long sunrise,
        Long sunset
) {
}
