package com.ananth.demo.dao;

import com.ananth.demo.model.Movie;

import java.util.List;

public interface MoviesDao {
    List<Movie> getMovies();
    Movie addMovie(Movie movie);
    List<Movie> getMoviesByCity(String name);
    Movie getMovieById(String movieId);
}
