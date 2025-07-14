package com.example.weatherapp.exception;

public class WeatherApiCallException extends AppBaseException{
    public WeatherApiCallException(String message, Throwable cause) {
        super(message, cause);
    }
    @Override
    public String getApiMessage(){
        return "Could not connect to the weather service at this time.";
    }
}
