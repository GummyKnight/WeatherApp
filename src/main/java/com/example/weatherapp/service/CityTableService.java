package com.example.weatherapp.service;

import com.example.weatherapp.entity.CityTable;
import com.example.weatherapp.repository.CityTableRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CityTableService {
    private final CityTableRepo cityTableRepo;

    public CityTableService(CityTableRepo cityTableRepo) {
        this.cityTableRepo
                = cityTableRepo;
    }
    public List<CityTable> cityTableList(){
        return cityTableRepo
                .findAll();
    }
}
