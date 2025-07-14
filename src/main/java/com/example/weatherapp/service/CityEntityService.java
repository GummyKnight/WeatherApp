package com.example.weatherapp.service;

import com.example.weatherapp.entity.CityEntity;
import com.example.weatherapp.repository.CityEntityRepo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.List;

@Service
@Validated
public class CityEntityService {
    private final CityEntityRepo cityEntityRepo;

    public CityEntityService(CityEntityRepo cityEntityRepo) {
        this.cityEntityRepo = cityEntityRepo;
    }
    public List<CityEntity> cityEntityList(){
     return cityEntityRepo.findAll();
    }
    @Transactional
    public CityEntity cityEntitySave(@Valid CityEntity cityEntity){
        return cityEntityRepo.save(cityEntity);
    }
}
