package com.ananth.demo.dao;

import com.ananth.demo.QueryExecutor;
import com.ananth.demo.model.Show;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ShowsSQLDao implements ShowsDao {

    @Override
    public List<Show> getShows() {
        String getCitiesQuery = "select * from shows;";
        try {
            ResultSet resultSet = QueryExecutor.execReads(getCitiesQuery);
            List<Show> res = new ArrayList<>();

            while (resultSet.next()) {
                // retrieve and print the values for the current row
                Show show = Show.builder()
                        .showId(resultSet.getString("uuid"))
                        .movieId(resultSet.getInt("movie_id"))
                        .cinemaId(resultSet.getInt("cinema_id"))
                        .startTime(resultSet.getString("start_time_epoch"))
                        .endTime(resultSet.getString("end_time_epoch")).build();

                System.out.println(show);
                res.add(show);
            }
            resultSet.getStatement().getConnection().close();
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


//`id` bigint(19) NOT NULL AUTO_INCREMENT,
//`uuid` varchar(40) NOT NULL,
//`movie_id` bigint(19) NOT NULL,
//`cinema_id` bigint(19) NOT NULL,
//`start_time` timestamp NULL DEFAULT NULL,
//`end_time` timestamp NULL DEFAULT NULL,


    @Override
    public Show addShow(Show show) {
//STR_TO_DATE('yourDateTimeValue','%d/%m/%Y %H:%i:%s')
        String addShowQuery = "insert into shows (uuid, movie_id, cinema_id, start_time_epoch, end_time_epoch" +
                ") values (' " + show.getCinemaId() + "', '" + show.getMovieId() + "', '"
                + show.getCinemaId() + "', '" + show.getStartTime() + "', '" + show.getEndTime() + "');";
        System.out.println(addShowQuery);
        try {
            QueryExecutor.execWrites(addShowQuery);
            return  show;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
