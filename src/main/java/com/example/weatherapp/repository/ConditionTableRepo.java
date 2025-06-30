package com.example.weatherapp.repository;

import com.example.weatherapp.entity.ConditionTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionTableRepo extends JpaRepository<ConditionTable, Integer> {
}
