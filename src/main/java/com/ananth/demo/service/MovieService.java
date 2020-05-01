package com.ananth.demo.service;

import com.ananth.demo.dao.MoviesDao;
import com.ananth.demo.model.Movie;
import com.ananth.demo.response.MoviesByCity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {
    private MoviesDao movieDao;

    public Movie addMovie(Movie movie) {
        return movieDao.addMovie(movie);
    }

    public Movie getMovieById(String movieId) {
        return movieDao.getMovieById(movieId);
    }

    public List<Movie> getMovies() {
        return movieDao.getMovies();
    }

    public List<MoviesByCity> getMoviesByCity(String name) {
        return movieDao.getMoviesByCity(name);
    }
}
