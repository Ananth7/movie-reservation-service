package com.ananth.demo.dao;

import com.ananth.demo.QueryExecutor;
import com.ananth.demo.model.Seat;
import com.ananth.demo.model.Show;
import com.ananth.demo.response.ShowsByCityMovieResponse;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
                        .movieId(resultSet.getString("movie_id"))
                        .cinemaId(resultSet.getString("cinema_id"))
                        .showDate(resultSet.getString("show_date"))
                        .startTime(resultSet.getString("start_time"))
                        .endTime(resultSet.getString("end_time")).build();

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
        String addShowQuery = "insert into shows (uuid, movie_id, cinema_id, start_time, end_time, show_date" +
                ") values ('" + show.getShowId() + "', '" + show.getMovieId() + "', '"
                + show.getCinemaId() + "', STR_TO_DATE('" + show.getStartTime() + "', '%d/%m/%Y %H:%i:%s')," +
                " STR_TO_DATE('" + show.getEndTime()  + "', '%d/%m/%Y %H:%i:%s')," +
                " STR_TO_DATE('" + show.getShowDate() + "', '%d/%m/%Y')" + ");";
        System.out.println(addShowQuery);
        try {
            QueryExecutor.execWrites(addShowQuery);
            return  show;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ShowsByCityMovieResponse> getShows(String cityId, String movieId) {
        String getShowsQuery = "select c.uuid as cinema_id, c.name as cinema_name, s.uuid as show_id," +
                " s.show_date as show_date, s.start_time as start_time," +
                " s.end_time as end_time from cinemas as c join shows as s on c.uuid = s.cinema_id" +
                " where c.city_id = '" + cityId + "'" +
                " and s.movie_id = '" + movieId +  "'; ";

        System.out.println(getShowsQuery);
        try {
            ResultSet resultSet = QueryExecutor.execReads(getShowsQuery);
            List<ShowsByCityMovieResponse> res = new ArrayList<>();

            while (resultSet.next()) {
                // retrieve and print the values for the current row
                ShowsByCityMovieResponse show = ShowsByCityMovieResponse.builder()
                        .cinemaName(resultSet.getString("cinema_name"))
                        .show_id(resultSet.getString("show_id"))
                        .show_date(resultSet.getDate("show_date"))
                        .startTime(resultSet.getDate("start_time"))
                        .endTime(resultSet.getDate("end_time")).build();

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

    @Override
    public Optional<Show> getShowById(String showId) {
        String query = "select * from shows as s where s.uuid = '" + showId +"';";
        try {
            ResultSet resultSet = QueryExecutor.execReads(query);
            Show show = null;

            while (resultSet.next()) {
                // retrieve and print the values for the current row
                show = Show.builder()
                        .showId(resultSet.getString("uuid"))
                        .movieId(resultSet.getString("movie_id"))
                        .cinemaId(resultSet.getString("cinema_id"))
                        .showDate(resultSet.getString("show_date"))
                        .startTime(resultSet.getString("start_time"))
                        .endTime(resultSet.getString("end_time")).build();

                System.out.println(show);

            }
            resultSet.getStatement().getConnection().close();
            return Optional.ofNullable(show);

        } catch (Exception e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public List<Seat> getFreeSeats(String showId) {
        return null;
    }

}
