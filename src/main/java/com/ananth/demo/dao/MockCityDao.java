package com.ananth.demo.dao;

import com.ananth.demo.model.City;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MockCityDao implements CityDao {

    private static List<City> citiesDB = new ArrayList<>();

    static {
        citiesDB.add(new City("Bangalore"));
        citiesDB.add(new City("Chennai"));
        citiesDB.add(new City("Delhi"));
    }

    @Override
    public List<City> getCities() {
        return citiesDB;
    }

    @Override
    public boolean addCity(City city) {
        citiesDB.add(city);
        return true;
    }
}
