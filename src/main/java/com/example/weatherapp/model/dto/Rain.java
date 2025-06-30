package com.example.weatherapp.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Rain(
        @JsonProperty("3h")
        Double threeHour){
}
