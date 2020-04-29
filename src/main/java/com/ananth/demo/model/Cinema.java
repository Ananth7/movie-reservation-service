package com.ananth.demo.model;

// show -> starttime, end time, movie, cinema

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class Cinema {

    private String cinemaId;
    private String name;
    private String cityid;
    private int seatCount; // Seat numbers will be 1,2,3...n

    public Cinema(@JsonProperty("name") String name,
                  @JsonProperty("cityid") String location,
                  @JsonProperty("seatcount")   int seatCount) {
        cinemaId = UUID.randomUUID().toString();
        this.name = name;
        this.cityid = location;
        this.seatCount = seatCount;
    }

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
