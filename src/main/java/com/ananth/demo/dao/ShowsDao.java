package com.ananth.demo.dao;

import com.ananth.demo.model.Seat;
import com.ananth.demo.model.Show;
import com.ananth.demo.response.ShowsByCityMovieResponse;

import java.util.List;
import java.util.Optional;

public interface ShowsDao {

    List<Show> getShows();
    Show addShow(Show show);
    List<ShowsByCityMovieResponse> getShows(String cinemaId, String showId);

    Optional<Show> getShowById(String showId);

    List<Seat> getFreeSeats(String showId);
}
