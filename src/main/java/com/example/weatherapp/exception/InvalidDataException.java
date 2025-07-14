package com.example.weatherapp.exception;

public class InvalidDataException extends AppBaseException{
    public InvalidDataException(String message){
        super(message);
    }
    @Override
    public String getApiMessage(){
        return "Input data is invalid or incomplete. Please check your request and try again.";
    }
}
