package com.example.weatherapp.service;

import com.example.weatherapp.config.ConfigWeatherApp;
import com.example.weatherapp.entity.CityEntity;
import com.example.weatherapp.entity.CityTable;
import com.example.weatherapp.model.dto.WeatherApiCall;
import com.example.weatherapp.repository.CityEntityRepo;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeatherService {
    private final CityEntityRepo cityEntityRepo;
    private final ApiClientService apiClientService;
    private final CityTableService cityTableService;
    private final MapService mapService;

    public WeatherService(CityEntityRepo cityEntityRepo, ApiClientService apiClientService, CityTableService cityTableService, MapService mapService) {
        this.cityEntityRepo = cityEntityRepo;
        this.apiClientService = apiClientService;
        this.cityTableService = cityTableService;
        this.mapService = mapService;
    }
    public void buildWeeklyForecastForEachCities(){
        List<CityTable> cityTableList = cityTableService.cityTableList();
        int max = Math.min(cityTableList.size(), ConfigWeatherApp.API_LIMIT);
        for (int i = 0; i<max; i++){
            WeatherApiCall recordDto = fetchWeather(buildingApiUrl(cityTableList.get(i)));
            List<CityEntity> cityEntity = buildCityList(recordDto);
            cityEntityRepo.saveAll(cityEntity);
            cityEntity.clear();
        }

    }
    private List<CityEntity> buildCityList(WeatherApiCall recordDto){
        List<CityEntity> cityEntity = new ArrayList<>();
        int max = Math.min(recordDto.hourlyList().size(),ConfigWeatherApp.API_CMT);
        for (int i = 0; i<max; i++){
            cityEntity.add(mapService.mapppingDtoToEntity(recordDto,i));
        }
        return cityEntity;
    }
    private String buildingApiUrl(CityTable cityTable){
        String city = cityTable.getName()+","+ cityTable.getCode();
        return "http://api.openweathermap.org/data/2.5/forecast?q="+
                city+
                "&appid="+
                ConfigWeatherApp.API_KEY+
                "&units=metric&cnt="+
                ConfigWeatherApp.API_CMT;
    }
    private WeatherApiCall fetchWeather(String apiUrl){
        return apiClientService
                .fetchWeatherData(apiUrl);
    }

}
