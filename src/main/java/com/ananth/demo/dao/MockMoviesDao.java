package com.ananth.demo.dao;

import com.ananth.demo.model.CityMovies;
import com.ananth.demo.model.Movie;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class MockMoviesDao implements MoviesDao {

    private static List<Movie> moviesDB = new ArrayList<>();

    static {

        Movie terminator = Movie.builder().movieId(UUID.randomUUID())
                .name("Terminator")
                .duration(Duration.ofHours(3))
                .build();

        Movie harryPotter = Movie.builder().movieId(UUID.randomUUID())
                .name("Harry Potter")
                .duration(Duration.ofHours(3))
                .build();

        Movie baasha = Movie.builder().movieId(UUID.randomUUID())
                .name("Baasha")
                .duration(Duration.ofHours(2))
                .build();

        moviesDB.add(terminator);
        moviesDB.add(harryPotter);
        moviesDB.add(baasha);

        CityMovies.updateCache(1, baasha.getMovieId());
        CityMovies.updateCache(1, harryPotter.getMovieId());
        CityMovies.updateCache(2, baasha.getMovieId());
    }

    @Override
    public List<Movie> getMovies() {
        return moviesDB;
    }

    @Override
    public boolean addMovie(final Movie movie) {
        moviesDB.add(movie);
        return true;
    }

    @Override
    public void deleteMovie(Movie movie) {
        moviesDB = moviesDB.stream().dropWhile(m -> m.getMovieId()
                .equals(movie.getMovieId())).collect(Collectors.toList());
    }
}
