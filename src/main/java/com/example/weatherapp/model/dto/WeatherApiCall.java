package com.example.weatherapp.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;

import java.util.List;

public record WeatherApiCall(
        String cod,
        Integer message,
        Integer cnt,
        @Valid
        @JsonProperty("list")
        List<HourlyList> hourlyList,
        @Valid
        CityDetails city) {
}
