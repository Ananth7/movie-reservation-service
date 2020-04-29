package com.ananth.demo.dao;

import com.ananth.demo.model.Cinema;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CinemaDao {

    Cinema addCinema(Cinema cinema);

    Optional<Cinema> findCinemaById(UUID cinemaId);

    public List<Cinema> getAllCinemas();

}
