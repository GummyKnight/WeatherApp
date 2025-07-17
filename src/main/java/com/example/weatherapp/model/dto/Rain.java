package com.example.weatherapp.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

public record Rain(
        @DecimalMin(value = "0.0")
        @DecimalMax(value = "3000.0")
        @JsonInclude(JsonInclude.Include.NON_NULL)
        @JsonProperty("3h")
        Double threeHour){
}
