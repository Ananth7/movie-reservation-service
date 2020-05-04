package com.ananth.demo.service;

import com.ananth.demo.dao.BookingDao;
import com.ananth.demo.dao.SeatsDao;
import com.ananth.demo.model.Booking;
import com.ananth.demo.model.Seat;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SeatsService {
    private SeatsDao seatsDao;
    private BookingDao bookingDao;

    public Seat addSeats(Seat seat) {
        return seatsDao.addSeat(seat);
    }

    public List<Seat> getSeatHistory() {
        return seatsDao.getAllSeats();
    }

    public List<Seat> getBookedSeats(String showId) {return seatsDao.getBookedSeats(showId);}

    public List<Seat> reserve(String showId, List<Integer> seats, String userId) throws SQLException {
        boolean areSeatsBookable = areSeatsBookable(seats, showId);
        if (!areSeatsBookable) throw new SQLException("Some seats are already booked!");
        List<Seat> reserve = seatsDao.reserve(showId, seats);
        String bookingId = reserve.get(0).getBookingId();
        bookingDao.createBooking(new Booking(bookingId, userId, "BOOKED"));
        return reserve;
    }

    public boolean areSeatsBookable(List<Integer> seatNumber, String showId) {
        long count = seatsDao.getBookedSeats(showId).stream()
                .filter(s -> seatNumber.contains(s.getSeatNumber())).count();
        return count == 0;
    }

    public List<Integer> getFreeSeats(int seatCount, String showId) {

        List<Seat> bookedSeats = seatsDao.getBookedSeats(showId);
        List<Integer> freeSeats = new ArrayList<>();
        for (int i = 0; i < seatCount; i ++) {
            final int seatNumber = i;
            Optional<Seat> optionalSeat = bookedSeats.stream().filter(s -> s.getSeatNumber() == seatNumber).findFirst();
            if (!optionalSeat.isPresent())freeSeats.add(seatNumber);
        }
        return freeSeats;
    }
}
