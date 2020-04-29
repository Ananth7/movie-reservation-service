package com.ananth.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class Show {
    private String showId;
    private int movieId;
    private int cinemaId;
    private String startTime;
    private String endTime;

    public Show(@JsonProperty("movieId") int movieId,
                @JsonProperty("cinemaId") int cinemaId,
                @JsonProperty("startTime") String startTime,
                @JsonProperty("endTime") String endTime) {
        this.showId = UUID.randomUUID().toString();
        this.movieId = movieId;
        this.cinemaId = cinemaId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Show{" +
                "showId='" + showId + '\'' +
                ", movieId='" + movieId + '\'' +
                ", cinemaId='" + cinemaId + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
