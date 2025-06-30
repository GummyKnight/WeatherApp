package com.example.weatherapp.model.dto;

public record CityDetails(int id,
                          String name,
                          CityCoordination cityCoordination,
                          String country,
                          int population,
                          int timezone,
                          long sunrise,
                          long sunset) {
}
