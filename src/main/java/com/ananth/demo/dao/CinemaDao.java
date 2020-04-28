package com.ananth.demo.dao;

import com.ananth.demo.model.Cinema;

import java.util.Optional;
import java.util.UUID;

public interface CinemaDao {

    boolean addCinema(Cinema cinema);

    Optional<Cinema> findCinemaById(UUID cinemaId);

    public Iterable<Cinema> getAllCinemas();

    void updateCinema(UUID cinemaId, Cinema updatedCinema);

}
