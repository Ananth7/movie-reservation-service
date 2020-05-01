package com.ananth.demo.dao;

import com.ananth.demo.model.Seat;

import java.util.List;

public interface SeatsDao {
    Seat addSeat(Seat seat);
    List<Seat> getAllSeats();
    List<Seat> getBookedSeats(String showId);
    List<Seat> reserve(String showId, List<String> seats);
}
