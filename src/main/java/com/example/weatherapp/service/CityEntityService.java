package com.example.weatherapp.service;

import com.example.weatherapp.entity.CityEntity;
import com.example.weatherapp.repository.CityEntityRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CityEntityService {
    private final CityEntityRepo cityEntityRepo;

    public CityEntityService(CityEntityRepo cityEntityRepo) {
        this.cityEntityRepo = cityEntityRepo;
    }
    public List<CityEntity> cityEntityList(){
     return cityEntityRepo.findAll();
    }
}
