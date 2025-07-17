package com.example.weatherapp.service;

import com.example.weatherapp.model.dto.WeatherApiCall;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class DtoValidationService {
    public void validateWeatherDto(@Valid WeatherApiCall weatherApiCall){}
}
