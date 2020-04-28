package com.ananth.demo.dao;

import com.ananth.demo.model.Cinema;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class MockCinemaDao implements CinemaDao {

    private List<Cinema> cinemaDB = new ArrayList<>();

    @Override
    public boolean addCinema(Cinema cinema) {
        cinemaDB.add(cinema);
        return true;
    }

    @Override
    public Iterable<Cinema> getAllCinemas() {
        return cinemaDB;
    }

    @Override
    public Optional<Cinema> findCinemaById(UUID cinemaID) {
        return cinemaDB.stream().filter(c -> c.getCinemaId()
                .equals(cinemaID)).findFirst();
    }

    @Override
    public void updateCinema(UUID cinemaId, Cinema updatedCinema) {

    }
}
