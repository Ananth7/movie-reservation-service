//package com.ananth.demo.dao;
//
//import com.ananth.demo.model.City;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MockCityDao implements CityDao {
//
//    private static List<City> citiesDB = new ArrayList<>();
//
//    static {
//        citiesDB.add(new City(1,"Bangalore"));
//        citiesDB.add(new City(2, "Chennai"));
//        citiesDB.add(new City(3, "Delhi"));
//    }
//
//    @Override
//    public List<City> getCities() {
//        return citiesDB;
//    }
//
//    @Override
//    public boolean addCity(City city) {
//        citiesDB.add(city);
//        return true;
//    }
//}
