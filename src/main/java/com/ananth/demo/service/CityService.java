package com.ananth.demo.service;

import com.ananth.demo.dao.CityDao;
import com.ananth.demo.model.City;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private CityDao cityDao;

    public CityService(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    public City addCity(City city) {
        System.out.println(city.getName() + " " + city.getCityId());
        return cityDao.addCity(city);
    }

    public List<City> getCities() {
        return cityDao.getCities();
    }
}
