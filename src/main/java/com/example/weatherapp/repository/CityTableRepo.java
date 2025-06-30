package com.example.weatherapp.repository;

import com.example.weatherapp.entity.CityTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityTableRepo extends JpaRepository<CityTable,Long> {
}
