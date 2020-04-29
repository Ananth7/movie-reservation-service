package com.ananth.demo.dao;

import com.ananth.demo.QueryExecutor;
import com.ananth.demo.model.Seat;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SeatSQLDao implements SeatsDao {

    @Override
    public Seat addSeat(Seat seat) {
        String addShowQuery = "insert into booked_seats (uuid, show_id, seat_number, status" +
                ") values (' " + seat.getBookingId() + "', '" + seat.getShowId() + "', '"
                + seat.getSeatNumber() + "', '" + seat.getStatus() + "');";
        System.out.println(addShowQuery);
        try {
            QueryExecutor.execWrites(addShowQuery);
            return  seat;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



//        `id` bigint(19) NOT NULL AUTO_INCREMENT,
//    `uuid` varchar(40) NOT NULL,
//    `show_id` bigint(19) NOT NULL,
//    `seat_number` varchar(40) NOT NULL,
//    `status` varchar(250) NULL,

    @Override
    public List<Seat> getSeats() {
        String getCitiesQuery = "select * from booked_seats;";
        try {
            ResultSet resultSet = QueryExecutor.execReads(getCitiesQuery);
            List<Seat> res = new ArrayList<>();

            while (resultSet.next()) {
                // retrieve and print the values for the current row
                Seat show = Seat.builder()
                        .bookingId(resultSet.getString("uuid"))
                        .showId(resultSet.getString("show_id"))
                        .status(resultSet.getString("status"))
                        .seatNumber(resultSet.getString("seat_number")).build();

                System.out.println(show);
                res.add(show);
            }
            resultSet.getStatement().getConnection().close();
            return res;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
