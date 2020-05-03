package com.ananth.demo.service;

import com.ananth.demo.dao.CinemaDao;
import com.ananth.demo.model.Cinema;
import com.ananth.demo.model.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class CinemaService {

    private final CinemaDao cinemaDao;

    @Autowired
    public CinemaService(CinemaDao cinemaDao) {
        this.cinemaDao = cinemaDao;
    }

    public Cinema addCinema(Cinema cinema) {
        return cinemaDao.addCinema(cinema);
    }

    public Iterable<Cinema> getAllCinemas() {return cinemaDao.getAllCinemas();}

    public Optional<Cinema> findCinemaById(String cinemaId) {
        return cinemaDao.findCinemaById(cinemaId);
    }

    public List<Cinema> getCinemasInCity(String name) {
        return cinemaDao.getCinemasInCity(name);
    }

    public List<User> getAllOwners() {return cinemaDao.getAllOwners();}


}
