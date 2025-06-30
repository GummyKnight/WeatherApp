package com.example.weatherapp.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record WeatherApiCall(
        String cod,
        int message,
        int cnt,
        @JsonProperty("list")
        List<HourlyList> hourlyList,
        CityDetails city) {
}
