package com.example.weatherapp.validation;

import com.example.weatherapp.exception.InvalidDataException;
import com.example.weatherapp.model.dto.WeatherApiCall;

public class WeatherDataValidator {
    public static void validateWeatherDto(WeatherApiCall recordDto, int i) {
        if (recordDto == null) {
            throw new InvalidDataException("Weather data object cannot be null");
        }
        if (recordDto.city() == null || recordDto.city().name() == null) {
            throw new InvalidDataException("City or city name is missing");
        }
        if (recordDto.hourlyList() == null || recordDto.hourlyList().isEmpty()) {
            throw new InvalidDataException("Hourly forecast list is missing or empty");
        }
        if (i < 0 || i >= recordDto.hourlyList().size()) {
            throw new InvalidDataException("Index " + i + " is out of bounds for hourly list");
        }

        var item = recordDto.hourlyList().get(i);

        if (item == null) {
            throw new InvalidDataException("Hourly item at index " + i + " is null");
        }
        if (item.details() == null) {
            throw new InvalidDataException("Missing details for hourly item");
        }
        if (item.clouds() == null) {
            throw new InvalidDataException("Missing cloud data for hourly item");
        }
        if (item.wind() == null) {
            throw new InvalidDataException("Missing wind data for hourly item");
        }
    }
}
