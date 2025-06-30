package com.example.weatherapp.service;

import com.example.weatherapp.entity.CityEntity;
import com.example.weatherapp.model.dto.WeatherApiCall;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

@Service
public class MapService {
    public CityEntity mapppingDtoToEntity(WeatherApiCall recordDto, int i) {
        var item = recordDto.hourlyList().get(i);

        String name = recordDto.city().name();
        LocalDate date = convertUnixToDate(item.dt());
        LocalTime time = convertUnixToTime(item.dt());
        double feelsTemp = item.details().feels_like();
        int humidity = item.details().humidity();
        Integer conditionId = (!item.condition().isEmpty()) ? item.condition().get(0).id() : null;
        int clouds = item.clouds().all();
        double windSpeed = item.wind().speed();
        int windDeg = item.wind().deg();
        double windGust = item.wind().gust();
        int visibility = item.visibility();
        double pop = item.pop();
        Double rain = (item.rain() != null) ? item.rain().threeHour() : null;

        return new CityEntity(
                name, date, time,
                feelsTemp, humidity, conditionId,
                clouds, windSpeed, windDeg, windGust,
                visibility, pop, rain
        );
    }
    private LocalDate convertUnixToDate(long unixSeconds) {
        return Instant.ofEpochSecond(unixSeconds)
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
    private LocalTime convertUnixToTime(long unixSeconds) {
        return Instant.ofEpochSecond(unixSeconds)
                .atZone(ZoneId.systemDefault())
                .toLocalTime();
    }
}
