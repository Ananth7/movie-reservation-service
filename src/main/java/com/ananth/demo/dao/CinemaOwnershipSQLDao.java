package com.ananth.demo.dao;

import com.ananth.demo.QueryExecutor;
import com.ananth.demo.model.Cinema;
import com.ananth.demo.model.CinemaOwnership;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CinemaOwnershipSQLDao implements CinemaOwnershipDao {

    @Override
    public List<CinemaOwnership> getCinemaOwnerships() {
        String getCitiesQuery = "select * from cinema_ownership;";
        try {
            ResultSet resultSet = QueryExecutor.execReads(getCitiesQuery);
            List<CinemaOwnership> res = new ArrayList<>();

            while (resultSet.next()) {
                // retrieve and print the values for the current row
                CinemaOwnership cinemaOwnership = new CinemaOwnership(
                        resultSet.getString("uuid"),
                        resultSet.getString("cinema_id"),
                        resultSet.getString("user_id"));
                System.out.println(cinemaOwnership);
                res.add(cinemaOwnership);
            }

            resultSet.getStatement().getConnection().close();
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public CinemaOwnership addCinemaOwnershipDetail(CinemaOwnership cinemaOwnership) {
        String addCinemaQuery = "insert into cinema_ownership (cinema_id, uuid, user_id) values (' "
                + cinemaOwnership.getCinema_id() + "', '"
                + cinemaOwnership.getOwnershipId() + "', '"
                + cinemaOwnership.getOwner_id() + "');";
        System.out.println("Add cinema query = " + addCinemaQuery);
        try {
            QueryExecutor.execWrites(addCinemaQuery);
            return  cinemaOwnership;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
