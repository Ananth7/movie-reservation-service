package com.ananth.demo.model;

// show -> starttime, end time, movie, cinema

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Cinema {

    private String cinemaId;
    private String name;
    private String cityid;
    private int seatCount; // Seat numbers will be 1,2,3...n

    @Override
    public String toString() {
        return "Cinema{" +
                "cinemaId='" + cinemaId + '\'' +
                ", name='" + name + '\'' +
                ", cityid='" + cityid + '\'' +
                ", seatCount=" + seatCount +
                '}';
    }
}
