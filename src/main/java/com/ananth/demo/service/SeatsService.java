package com.ananth.demo.service;

import com.ananth.demo.dao.SeatsDao;
import com.ananth.demo.model.Seat;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SeatsService {
    private SeatsDao seatsDao;

    public Seat addSeats(Seat seat) {
        return seatsDao.addSeat(seat);
    }

    public List<Seat> getSeatHistory() {
        return seatsDao.getAllSeats();
    }

    public List<Seat> getBookedSeats(String showId) {return seatsDao.getBookedSeats(showId);}

    public List<Seat> reserve(String showId, List<String> seats) {
        return seatsDao.reserve(showId, seats);
    }

    public List<Integer> getFreeSeats(int seatCount, String showId) {
        List<Seat> bookedSeats = seatsDao.getBookedSeats(showId);
        List<Integer> freeSeats = new ArrayList<>();
        for (int i = 0; i < seatCount; i ++) {
            final int seatNumber = i;
            Optional<Seat> optionalSeat = bookedSeats.stream().filter(s -> s.getSeatNumber() == seatNumber).findFirst();
            if (optionalSeat.isEmpty())freeSeats.add(seatNumber);
        }
        return freeSeats;
    }
}
