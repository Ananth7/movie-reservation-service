package com.ananth.demo.dao;

import com.ananth.demo.model.City;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public interface CityDao {
    List<City> getCities();
    boolean addCity(@JsonProperty("city") City city);
}
