package com.example.weatherapp.service;

import com.example.weatherapp.config.ConfigWeatherApp;
import com.example.weatherapp.exception.WeatherApiCallException;
import com.example.weatherapp.exception.WeatherApiParseException;
import com.example.weatherapp.model.dto.WeatherApiCall;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
@Service
public class ApiClientService {
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final DtoValidationService dtoValidationService;
    private static final Logger log = LoggerFactory.getLogger(ApiClientService.class);


    public ApiClientService(RestTemplate restTemplate, ObjectMapper objectMapper, DtoValidationService dtoValidationService) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.dtoValidationService = dtoValidationService;
    }
    private WeatherApiCall fetchWeatherData(String apiUrl, String cityTable) {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);
            return objectMapper.readValue(response.getBody(), WeatherApiCall.class);
        } catch (JsonProcessingException e) {
            log.error("JSON parsing failed for city {} with response: {}", cityTable, apiUrl, e);
            throw new WeatherApiParseException("Failed to parse weather data", e);
        } catch (RestClientException e) {
            log.error("Failed to call OpenWeather API for city {}: {}", cityTable, apiUrl, e);
            throw new WeatherApiCallException("Failed to fetch weather data from OpenWeather API", e);
        }
    }
    public WeatherApiCall fetchWeather(String cityTable){
        String apiUrl = buildingApiUrl(cityTable);
        WeatherApiCall dto = fetchWeatherData(apiUrl, cityTable);
        dtoValidationService.validateWeatherDto(dto);
        return dto;
    }
    private String buildingApiUrl(String cityTable){
        return "http://api.openweathermap.org/data/2.5/forecast?q="+
                cityTable+
                "&appid="+
                ConfigWeatherApp.getApiKey()+
                "&units=metric&cnt="+
                ConfigWeatherApp.API_CMT;
    }
}
