package com.example.weatherapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "cities")
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime time;
    @Column(name = "feels_temp")
    private double feelsTemp;
    private int humidity;
    @Column(name = "condition_id")
    private Integer conditionId;
    private int clouds;
    @Column(name = "wind_speed")
    private double windSpeed;
    @Column(name = "wind_deg")
    private int windDeg;
    @Column(name = "wind_gust")
    private double windGust;
    private int visibility;
    private double pop;
    @Column(name = "three_hour_rain")
    private Double threeHourRain;

    public CityEntity(String name, LocalDate date, LocalTime time, double feelsTemp, int humidity, Integer conditionId, int clouds, double windSpeed, int windDeg, double windGust, int visibility, double pop, Double threeHourRain) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.feelsTemp = feelsTemp;
        this.humidity = humidity;
        this.conditionId = conditionId;
        this.clouds = clouds;
        this.windSpeed = windSpeed;
        this.windDeg = windDeg;
        this.windGust = windGust;
        this.visibility = visibility;
        this.pop = pop;
        this.threeHourRain = threeHourRain;
    }
}
