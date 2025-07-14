package com.example.weatherapp.exception;

public class WeatherApiParseException extends AppBaseException{
    public WeatherApiParseException(String message, Throwable cause){
        super(message,cause);
    }
    @Override
    public String getApiMessage(){
        return "Unable to process weather data. Please try again later.";
    }
}
