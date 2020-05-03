package com.ananth.demo.service;

import com.ananth.demo.dao.CinemaDao;
import com.ananth.demo.dao.CityDao;
import com.ananth.demo.dao.SeatsDao;
import com.ananth.demo.dao.ShowsDao;
import com.ananth.demo.model.Cinema;
import com.ananth.demo.model.City;
import com.ananth.demo.model.Seat;
import com.ananth.demo.model.Show;
import com.ananth.demo.response.ShowsByCityMovieResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ShowsService {

    private ShowsDao showsDao;
    private CinemaDao cinemaDao;
    private SeatsDao seatsDao;
    private CityDao cityDao;

    public Show addShow(Show show) {
        return showsDao.addShow(show);
    }

    public List<Show> getShows() {
        return showsDao.getShows();
    }

    public List<ShowsByCityMovieResponse> getShows(String city_id, String movieId) {
        cityDao.getCityById(city_id);
        return showsDao.getShows(city_id, movieId);
    }


    public Optional<Show> getShowById(String showId) {
        return showsDao.getShowById(showId);
    }

}
