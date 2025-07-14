package com.example.weatherapp.exception;

public abstract class AppBaseException extends RuntimeException {
    public AppBaseException(String message) {
        super(message);
    }
    public AppBaseException(String message, Throwable cause) {
        super(message, cause);
    }
    public String getApiMessage() {
        return getMessage();
    }
}
