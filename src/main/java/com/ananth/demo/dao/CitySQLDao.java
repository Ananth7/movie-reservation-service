package com.ananth.demo.dao;

import com.ananth.demo.QueryExecutor;
import com.ananth.demo.model.City;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

//    @Override
//    public Optional<City> getCityByName(String cityName) {
//        String query = "select * from cinemas where name = '" + cityName + "';" ;
//        System.out.println("Query = " + query);
//        try {
//            ResultSet resultSet = QueryExecutor.execReads(query);
//            Optional<City> result;
//            City city = null;
//            while (resultSet.next()) {
//                System.out.println("Heree!");
//                // retrieve and print the values for the current row
//                city = new City(resultSet.getString("uuid"),
//                        resultSet.getString("name"));
//                System.out.println(city.getName());
//            }
//
//            resultSet.getStatement().getConnection().close();
//            return Optional.ofNullable(city);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return Optional.empty();
//        }
//    }

    @Override
    public City getCityById(String uuid) {
        try {
            ResultSet resultSet = QueryExecutor.execReads("select * from cities where uuid = " + uuid + ";");
            return new City(resultSet.getString("uuid"), resultSet.getString("name"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public City addCity(City city) {
        String addCityQuery = "insert into cities (name, uuid) values (' " + city.getName() + "', '" + city.getCityId() + "');";
        try {
            QueryExecutor.execWrites(addCityQuery);
            return  city;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
