package com.ananth.demo.api;

import com.ananth.demo.model.Movie;
import com.ananth.demo.response.MoviesByCity;
import com.ananth.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping(path="/city/{city}")
    @ResponseBody
    public List<MoviesByCity> getMoviesByCity(@PathVariable("city") String name) {
        return movieService.getMoviesByCity(name);
    }

    @GetMapping
    @ResponseBody
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @GetMapping("/api/v1/movie/{movie_id}")
    @ResponseBody
    public Movie getMovieById(@PathVariable("movie_id") String movieId) {
        return movieService.getMovieById(movieId);
    }

    @PostMapping
    @ResponseBody
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

}
