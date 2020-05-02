package com.ananth.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class Seat {
    private String uuid;
    private String showId;
    private String bookingId;
    private int seatNumber;

    public Seat(
            @JsonProperty("showID") String showId,
            @JsonProperty("status") String bookingId,
            @JsonProperty("seatNumber") int seatNumber) {
        this.uuid = UUID.randomUUID().toString();
        this.showId = showId;
        this.bookingId = bookingId;
        this.seatNumber = seatNumber;
    }
}
