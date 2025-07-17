package com.example.weatherapp.model.dto;

import com.example.weatherapp.validation.annotation.ValidCityDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.util.List;

public record HourlyList(
        @NotNull
        Long dt,
        @Valid
        @JsonProperty("main")
        ListDetails details,
        @Valid
        @JsonProperty("weather")
        List<Condition> condition,
        @Valid
        Clouds clouds,
        Wind wind,
        @Min(0)
        @Max(10000)
        @NotNull(message = "Visibility cannot be null")
        Integer visibility,
        @DecimalMin("0.0")
        @DecimalMax("1.0")
        @NotNull(message = "Probability of precipitation(pop) cannot be null")
        Double pop,
        @Valid
        Rain rain,
        @Valid
        Snow snow,
        Sys sys,
        String dt_txt) {
}
