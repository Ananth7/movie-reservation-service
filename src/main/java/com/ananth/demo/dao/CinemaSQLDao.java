package com.ananth.demo.dao;

import com.ananth.demo.QueryExecutor;
import com.ananth.demo.model.Cinema;
import com.ananth.demo.model.User;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CinemaSQLDao implements CinemaDao {
    @Override
    public Cinema addCinema(Cinema cinema) {
        String addCinemaQuery = "insert into cinemas (city_id, name, uuid, seats) values (' "
                + cinema.getCityid() + "', '"
                + cinema.getName() + "', '"
                + cinema.getCinemaId() + "', '"
                + cinema.getSeatCount() + "');";
        try {
            QueryExecutor.execWrites(addCinemaQuery);
            return  cinema;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Optional<Cinema> findCinemaById(String cinemaId) {
        String query = "select * from cinemas where uuid = '" + cinemaId + "';" ;
        System.out.println("Query = " + query);
        try {
            ResultSet resultSet = QueryExecutor.execReads(query);
            Optional<Cinema> result;
            Cinema cinema = null;
            while (resultSet.next()) {
                // retrieve and print the values for the current row
                cinema = new Cinema(resultSet.getString("uuid"),
                        resultSet.getString("name"), resultSet.getString("city_id"),
                        resultSet.getInt("seats"));
                System.out.println(cinema.getName());
            }

            resultSet.getStatement().getConnection().close();
            return Optional.ofNullable(cinema);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<Cinema> getAllCinemas() {
        String getCitiesQuery = "select * from cinemas;";
        try {
            ResultSet resultSet = QueryExecutor.execReads(getCitiesQuery);
            List<Cinema> res = new ArrayList<>();

            while (resultSet.next()) {
                // retrieve and print the values for the current row
                Cinema cinema = new Cinema(resultSet.getString("uuid"),
                        resultSet.getString("name"), resultSet.getString("city_id"),
                        resultSet.getInt("seats"));
                System.out.println(cinema.getName());
                res.add(cinema);
            }

            resultSet.getStatement().getConnection().close();
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> getAllOwners() {
        return null;
    }
}
