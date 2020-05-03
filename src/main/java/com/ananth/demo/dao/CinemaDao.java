package com.ananth.demo.dao;

import com.ananth.demo.model.Cinema;
import com.ananth.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface CinemaDao {

    Cinema addCinema(Cinema cinema);

    Optional<Cinema> findCinemaById(String cinemaId);

    public List<Cinema> getAllCinemas();

    public List<Cinema> getCinemasInCity(String name);

}
