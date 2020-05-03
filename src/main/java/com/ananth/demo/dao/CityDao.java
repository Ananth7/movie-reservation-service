package com.ananth.demo.dao;

import com.ananth.demo.model.City;

import java.util.List;
import java.util.Optional;

public interface CityDao {
    List<City> getCities();
    City addCity(City city);
    City getCityById(String uuid);
//    Optional<City> getCityByName(String name);
}
