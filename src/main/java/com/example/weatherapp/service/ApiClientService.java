package com.example.weatherapp.service;

import com.example.weatherapp.model.dto.WeatherApiCall;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
@Service
public class ApiClientService {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public ApiClientService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }
    public WeatherApiCall fetchWeatherData(String apiUrl) {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
            return objectMapper.readValue(response.getBody(), WeatherApiCall.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to parse weather data", e);
        } catch (RestClientException e) {
            throw new RuntimeException("Failed to fetch weather data from OpenWeather API", e);
        }
    }
}
