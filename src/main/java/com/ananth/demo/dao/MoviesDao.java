package com.ananth.demo.dao;

import com.ananth.demo.model.City;
import com.ananth.demo.model.Movie;

import java.util.List;

public interface MoviesDao {
    List<Movie> getMovies();
    boolean addMovie(Movie movie);
    void deleteMovie(Movie movie);
}
