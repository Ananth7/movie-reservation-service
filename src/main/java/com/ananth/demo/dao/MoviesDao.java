package com.ananth.demo.dao;

import com.ananth.demo.model.Movie;
import com.ananth.demo.response.MoviesByCity;

import java.util.List;

public interface MoviesDao {
    List<Movie> getMovies();
    Movie addMovie(Movie movie);
    List<MoviesByCity> getMoviesByCity(String name);
}
