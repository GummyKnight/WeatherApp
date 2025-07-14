package com.example.weatherapp.entity;

import com.example.weatherapp.validation.annotation.ValidCityName;
import com.example.weatherapp.validation.annotation.ValidConditionID;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "cities")
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_name",nullable = false)
    @NotBlank(message = "City name cannot be blank")
    @ValidCityName//Custom Validation Enum List -> model.enums.CityName
    private String name;

    @Column(nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull(message = "Date cannot be null")
    private LocalDate date;

    @Column(nullable = false)
    @JsonFormat(pattern = "HH:mm")
    @NotNull(message = "Time cannot be null")
    private LocalTime time;

    @DecimalMin(value = "-50.0")
    @DecimalMax(value = "60.0")
    @Column(name = "temp", nullable = false)
    @NotNull(message = "Temperature cannot be null")
    private Double feelsTemp;

    @Min(0)
    @Max(100)
    @Column(name = "humidity",nullable = false)
    @NotNull(message = "Humidity cannot be null")
    private Integer humidity;

    @Column(name = "condition_id")
    @ValidConditionID//Custom Validation Enum List -> model.enums.ConditionID
    private Integer conditionId;

    @Min(0)
    @Max(100)
    @Column(name = "clouds",nullable = false)
    @NotNull(message = "Clouds cannot be null")
    private Integer clouds;

    @DecimalMin(value = "0.0")
    @DecimalMax(value = "50.0")
    @Column(name = "wind_speed", nullable = false)
    @NotNull(message = "Wind Speed cannot be null")
    private Double windSpeed;

    @Min(0)
    @Max(359)
    @Column(name = "wind_deg", nullable = false)
    @NotNull(message = "Wind Degree cannot be null")
    private Integer windDeg;

    @DecimalMin(value = "0.0")
    @DecimalMax(value = "100.0")
    @Column(name = "wind_gust",nullable = false)
    @NotNull(message = "Wind Gust cannot be null")
    private Double windGust;

    @Min(0)
    @Max(10000)
    @Column(name = "visibility", nullable = false)
    @NotNull(message = "Visibility cannot be null")
    private Integer visibility;


    @DecimalMin("0.0")
    @DecimalMax("1.0")
    @Column(name = "pop", nullable = false)
    @NotNull(message = "Probability of precipitation(pop) cannot be null")
    private Double pop;

    @DecimalMin(value = "0.0")
    @DecimalMax(value = "3000.0")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double threeHourRain;

    @DecimalMin(value = "0.0")
    @DecimalMax(value = "1500.0")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double threeHourSnow;

    @Builder
    public CityEntity(String name, LocalDate date, LocalTime time, double feelsTemp,
                      int humidity, Integer conditionId, int clouds,
                      double windSpeed, int windDeg, double windGust,
                      int visibility, double pop, Double threeHourRain, Double threeHourSnow) {
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
        this.threeHourSnow = threeHourSnow;
    }
}
