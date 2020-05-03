package com.ananth.demo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class CreateCinemaRequest {

    private String userId;
    private String cinemaId;
    private String name;
    private String cityid;
    private int seatCount; // Seat numbers will be 1,2,3...n

    public CreateCinemaRequest(@JsonProperty("name") String name,
                  @JsonProperty("userId") String userId,
                  @JsonProperty("cityId") String location,
                  @JsonProperty("seat_count")   int seatCount) {
        cinemaId = UUID.randomUUID().toString();
        this.userId = userId;
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
