package com.ananth.demo.dao;

import com.ananth.demo.model.City;
import com.ananth.demo.model.CityMovies;
import com.ananth.demo.model.Movie;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class MockMoviesDao implements MoviesDao {

    private static List<Movie> moviesDB = new ArrayList<>();

    static {
        // populate mock DB here.
    }

    @Override
    public List<Movie> getMovies() {
        return null;
    }

    @Override
    public Movie addMovie(Movie movie) {
        return null;
    }

    @Override
    public List<Movie> getMoviesByCity(String name) {
        return null;
    }

    @Override
    public Movie getMovieById(String movieId) {
        return null;
    }
}
