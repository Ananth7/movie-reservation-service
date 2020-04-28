package com.ananth.demo.api;


import com.ananth.demo.model.City;
import com.ananth.demo.model.Movie;
import com.ananth.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/movie")
@RestController
public class MoviesController {

    private MovieService movieService;

    @Autowired
    public MoviesController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @PostMapping
    public void addMovie(Movie movie) {
        movieService.addMovie(movie);
    }

    @DeleteMapping
    public void deleteMovie(Movie movie) {
        movieService.deleteMovie(movie);
    }
}
