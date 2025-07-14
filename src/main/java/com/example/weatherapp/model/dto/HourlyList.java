package com.example.weatherapp.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record HourlyList(
        long dt,
        @JsonProperty("main")
        ListDetails details,
        @JsonProperty("weather")
        List<Condition> condition,
        Clouds clouds,
        Wind wind,
        int visibility,
        double pop,
        Rain rain,
        Snow snow,
        Sys sys,
        String dt_txt) {
}
