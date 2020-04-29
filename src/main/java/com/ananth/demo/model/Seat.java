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
    private String bookingId;
    private String showId;
    private String status;
    private String seatNumber;

    public Seat(
            @JsonProperty("showID") String showId,
            @JsonProperty("status") String status,
            @JsonProperty("seatNumber") String seatNumber) {
        this.bookingId = UUID.randomUUID().toString();
        this.showId = showId;
        this.status = status;
        this.seatNumber = seatNumber;
    }
}
