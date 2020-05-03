package com.ananth.demo.dao;

import com.ananth.demo.QueryExecutor;
import com.ananth.demo.model.City;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CitySQLDao implements CityDao {

    @Override
    public List<City> getCities() {
        String getCitiesQuery = "select * from cities;";
        try {
            ResultSet resultSet = QueryExecutor.execReads(getCitiesQuery);
            List<City> res = new ArrayList<>();

            while (resultSet.next()) {
                // retrieve and print the values for the current row
                City city = new City(resultSet.getString("uuid"), resultSet.getString("name"));
                System.out.println(city.getName());
                res.add(city);
            }
           resultSet.getStatement().getConnection().close();
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public City getCityById(String uuid) {
        try {
            ResultSet resultSet = QueryExecutor.execReads("select * from cities where uuid = '" + uuid + "';");
            City city = new City(resultSet.getString("uuid"), resultSet.getString("name"));
            resultSet.getStatement().getConnection().close();
            return city;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public City getCityByName(String name) {
        String s = "select * from cities where name = '" + name + "';";

        try {
            ResultSet resultSet = QueryExecutor.execReads(s);
            City city = null;
            while (resultSet.next()) {
                // retrieve and print the values for the current row
                 city = new City(resultSet.getString("uuid"), resultSet.getString("name"));
                System.out.println(city.getName());
            }
            resultSet.getStatement().getConnection().close();
            return city;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public City addCity(City city) {
        String addCityQuery = "insert into cities (name, uuid) values ('" + city.getName() + "', '" + city.getCityId() + "');";
        try {
            QueryExecutor.execWrites(addCityQuery);
            return  city;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
