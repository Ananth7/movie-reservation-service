package com.ananth.demo.dao;

import com.ananth.demo.model.Cinema;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MockCinemaDao implements CinemaDao {

    private List<Cinema> cinemaDB = new ArrayList<>();

    @Override
    public Optional<Cinema> findCinemaById(String cinemaId) {
        return Optional.empty();
    }

    static {
        // fill mock data here;
    }

    @Override
    public Cinema addCinema(Cinema cinema) {
        return null;
    }

    public Optional<Cinema> findCinemaById(UUID cinemaId) {
        return Optional.empty();
    }

    @Override
    public List<Cinema> getAllCinemas() {
        return null;
    }
}
