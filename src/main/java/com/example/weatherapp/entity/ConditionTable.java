package com.example.weatherapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "conditions")
public class ConditionTable {
    @Id
    int id;
    String main;
    String description;
    String icon;
}
