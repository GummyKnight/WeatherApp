package com.example.weatherapp.model.dto;

public record Condition(
        int id,
        String main,
        String description,
        String icon) {
}
