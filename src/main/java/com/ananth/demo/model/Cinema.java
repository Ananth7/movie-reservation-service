package com.ananth.demo.model;

// show -> starttime, end time, movie, cinema

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class Cinema {

    private UUID cinemaId;
    private User owner;
    private String name;
    private String location;
    private int seatCount; // Seat numbers will be 1,2,3...n

    public Cinema(UUID cinemaId, String name, String location, int seatCount) {
        this.cinemaId = cinemaId;
        this.name = name;
        this.location = location;
        this.seatCount = seatCount;
    }

    // upcoming shows schedule

    // seat layout
    // total seats

}
