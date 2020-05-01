package com.ananth.demo.service;

import com.ananth.demo.dao.SeatsDao;
import com.ananth.demo.model.Seat;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SeatsService {
    private SeatsDao seatsDao;

    public Seat addSeats(Seat seat) {
        return seatsDao.addSeat(seat);
    }

    public List<Seat> getSeatHistory() {
        return seatsDao.getSeats();
    }

    public List<Seat> getSeats(String cinemaId, String showId) {return seatsDao.getSeats(cinemaId, showId);}

    public List<Seat> reserve(String showId, List<String> seats) {
        return seatsDao.reserve(showId, seats);
    }
}
