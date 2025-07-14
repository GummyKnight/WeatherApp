package com.example.weatherapp.service;

import com.example.weatherapp.config.ConfigWeatherApp;
import com.example.weatherapp.entity.CityEntity;
import com.example.weatherapp.exception.InvalidDataException;
import com.example.weatherapp.model.dto.WeatherApiCall;
import com.example.weatherapp.model.enums.CityName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {
    private final ApiClientService apiClientService;
    private final MapService mapService;
    private final CityEntityService cityEntityService;
    private static final Logger log = LoggerFactory.getLogger(WeatherService.class);
    public WeatherService(ApiClientService apiClientService, MapService mapService, CityEntityService cityEntityService) {
        this.apiClientService = apiClientService;
        this.mapService = mapService;
        this.cityEntityService = cityEntityService;
    }
    public void buildWeeklyForecastForEachCities(){
        CityName[] allCities = CityName.values();
        int max = Math.min(allCities.length,ConfigWeatherApp.API_LIMIT);

        log.info("Starting weekly forecast building for up to {} cities", max);
        for (int i = 0; i < max; i++){
            String cityUnwrap = allCities[i].name();
            try{
                WeatherApiCall recordDto = apiClientService.fetchWeather(cityUnwrap);
                buildCityList(recordDto);
                log.info("Successfully built forecast for {}", cityUnwrap);
            }catch (Exception e){
                log.error("Failed to build forecast for city {}: {}", cityUnwrap, e.getMessage(), e);
            }
        }
    }
    private void buildCityList(WeatherApiCall recordDto){
        int iterator = recordDto.hourlyList().size();
        if(!(iterator == ConfigWeatherApp.API_CMT)){
            log.warn("Unexpected hourly count {} from API. Expected {}", iterator, ConfigWeatherApp.API_CMT);
            throw new InvalidDataException("Unexpected number of hourly entries in weather data");
        }

        for (int i = 0; i< iterator ; i++){
            try{
                CityEntity cityEnt = mapService.mapppingDtoToEntity(recordDto,i);
                CityEntity savedEntity = cityEntityService.cityEntitySave(cityEnt);
                log.debug("Saved city entity with id: {}", savedEntity.getId());
            }catch (Exception e){
                log.error("Failed to process hourly item {}: {}", i, e.getMessage(), e);
            }
        }
    }
}
