package com.example.weatherapp.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class ConfigWeatherApp {
    private static String API_KEY;
    @Value("${api.key}")
    private void setApiKey(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("API key must not be empty!"); //upgrade due
        }
        API_KEY = value;
    }
    public static String getApiKey(){
        return API_KEY;
    }
    public static final int API_CMT= 40;     // We ask api for the weather, about next 3 hour ahead; each 3 hourly interval is making up 8 forecast a day. (24/3=8)
    public static final int API_LIMIT = 60;  // This goes further since we ask the next 5 day instead, each 3 hourly interval 8 a day and for 5 days it makes up 40,
                                           // ...which is 5*8=40. Cmt limit is between 1-40. All cases between that numbers are 1 api call only (which is important since
                                          // ...our limit is 60 call per minute yet 40cmt is one json call anyway.)
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }
}
