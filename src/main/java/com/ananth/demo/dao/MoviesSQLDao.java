package com.ananth.demo.dao;

import com.ananth.demo.QueryExecutor;
import com.ananth.demo.model.Movie;
import com.ananth.demo.response.MoviesByCity;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MoviesSQLDao implements MoviesDao {

    @Override
    public Movie addMovie(Movie movie) {
        String addCityQuery = "insert into movies (uuid, name, duration, genre, rating, poster_url, trailer_url," +
                "plot) values ('" + movie.getMovieId() + "', '" + movie.getName() + "', '"
                + movie.getDuration() + "', '" + movie.getGenre() + "', '" + movie.getRating() + "', '"
                + movie.getPosterURL() + "', '"+ movie.getTrailerURL() + "', '" + movie.getPlot() +  "');";
        System.out.println(addCityQuery);
        try {
            QueryExecutor.execWrites(addCityQuery);
            return  movie;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public List<Movie> getMovies() {

        String getCitiesQuery = "select * from movies;";
        try {
            ResultSet resultSet = QueryExecutor.execReads(getCitiesQuery);
            List<Movie> res = new ArrayList<>();

            while (resultSet.next()) {
                // retrieve and print the values for the current row
                Movie movie = Movie.builder()
                                .name(resultSet.getString("name"))
                                .movieId(resultSet.getString("uuid"))
                                .duration(resultSet.getInt("duration"))
                                .genre(resultSet.getString("genre"))
                                .posterURL(resultSet.getString("poster_url"))
                                .trailerURL(resultSet.getString("trailer_url"))
                                .plot(resultSet.getString("plot"))
                                .rating(resultSet.getInt("rating")).build();

                System.out.println(movie);
                res.add(movie);
            }
            resultSet.getStatement().getConnection().close();
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<MoviesByCity> getMoviesByCity(String city) {
        String createView1 = "create or replace view cinemasincity as select * from cinemas as c where c.city_id in (select uuid from cities where name = '" + city +"'); ";
        String createView2 ="create or replace view allshows as select * from shows; ";
        String createView3 = "create or replace view showsincity as select a.uuid, a.show_date, a.start_time, a.movie_id from allshows as a inner join cinemasincity on a.cinema_id = cinemasincity.uuid; ";
        String createView4  ="create or replace view allmovies as select * from movies; ";

        String getCitiesQuery =
                        "select m.name, m.uuid as movie_id from allmovies as m " +
                        "inner join showsincity " +
                        "on showsincity.movie_id = m.uuid " +
                        "group by m.name; ";

        try {
            System.out.println(createView1);QueryExecutor.execWrites(createView1);
            System.out.println(createView2);QueryExecutor.execWrites(createView2);
            System.out.println(createView3);QueryExecutor.execWrites(createView3);
            System.out.println(createView4);QueryExecutor.execWrites(createView4);
            System.out.println(getCitiesQuery);
            ResultSet resultSet = QueryExecutor.execReads(getCitiesQuery);
            List<MoviesByCity> res = new ArrayList<>();

            while (resultSet.next()) {
                // retrieve and print the values for the current row
                MoviesByCity moviesByCity =
                        MoviesByCity.builder()
                        .movie_id(resultSet.getString("movie_id"))
                        .movie_name(resultSet.getString("name"))
                        .build();

                System.out.println(moviesByCity);
                res.add(moviesByCity);
            }
            resultSet.getStatement().getConnection().close();
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
