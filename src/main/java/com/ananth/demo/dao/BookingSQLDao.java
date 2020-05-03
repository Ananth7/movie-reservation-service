package com.ananth.demo.dao;

import com.ananth.demo.QueryExecutor;
import com.ananth.demo.model.Booking;
import org.springframework.stereotype.Repository;

@Repository
public class BookingSQLDao implements BookingDao {
    @Override
    public Booking createBooking(Booking booking) {
        String addBookingQuery = "insert into booking (booking_id, user_id, status) values ('"
                + booking.getBooking_id() + "', '"
                + booking.getUser_id() + "', '"
                + booking.getStatus() + "');";
        try {
            QueryExecutor.execWrites(addBookingQuery);
            return  booking;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
