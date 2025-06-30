package com.example.weatherapp.repository;

import com.example.weatherapp.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityEntityRepo extends JpaRepository<CityEntity,Long> {
}
