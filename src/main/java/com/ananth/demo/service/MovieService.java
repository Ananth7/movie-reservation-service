package com.ananth.demo.service;

import com.ananth.demo.dao.MoviesDao;
import com.ananth.demo.model.Movie;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {
    private MoviesDao movieDao;

    public void addMovie(Movie movie) {
        movieDao.addMovie(movie);
    }

    public List<Movie> getMovies() {
        return movieDao.getMovies();
    }

    public void deleteMovie(Movie movie) {
        movieDao.deleteMovie(movie);
    }
}
