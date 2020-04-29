package com.ananth.demo.api;

import com.ananth.demo.model.Seat;
import com.ananth.demo.service.SeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookedSeatsController {

    @Autowired
    SeatsService seatsService;

    @PostMapping("/api/v1/seat")
    public Seat addSeat(@RequestBody Seat seat) {
        return seatsService.addSeats(seat);
    }

    @GetMapping("/api/v1/seat")
    public List<Seat> getSeats() {
        return seatsService.getSeats();
    }

}
