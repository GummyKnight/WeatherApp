package com.example.weatherapp.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Snow(
        @JsonProperty("3h")
        Double threeHour){
}
