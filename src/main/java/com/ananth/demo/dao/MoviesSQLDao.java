package com.ananth.demo.dao;

import com.ananth.demo.QueryExecutor;
import com.ananth.demo.model.City;
import com.ananth.demo.model.Genre;
import com.ananth.demo.model.Movie;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MoviesSQLDao implements MoviesDao {

    @Override
    public Movie addMovie(Movie movie) {
        String addCityQuery = "insert into movies (uuid, name, duration, genre, rating, poster_url, trailer_url," +
                "plot) values (' " + movie.getMovieId() + "', '" + movie.getName() + "', '"
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
    public List<Movie> getMoviesByCity(String name) {
        String getCitiesQuery = "select * from movies join cities where movies.;";
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
                        .posterURL(resultSet.getString("posterURL"))
                        .trailerURL(resultSet.getString("trailerURL"))
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
    public Movie getMovieById(String movieId) {
        return null;
    }
}
