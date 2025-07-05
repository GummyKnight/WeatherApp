package com.example.weatherapp.controller;

import com.example.weatherapp.entity.CityEntity;
import com.example.weatherapp.service.CityEntityService;
import com.example.weatherapp.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherControl {
    private final CityEntityService cityEntityService;
    private final WeatherService weatherService;

    public WeatherControl(CityEntityService cityEntityService, WeatherService weatherService) {
        this.cityEntityService = cityEntityService;
        this.weatherService = weatherService;
    }
    @GetMapping("/build")
    public void buildWeather(){
        weatherService.buildWeeklyForecastForEachCities();
    }
    @GetMapping("/get")
    public List<CityEntity> getEntityList(){
        return cityEntityService.cityEntityList();
    }
}
