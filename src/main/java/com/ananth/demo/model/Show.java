package com.ananth.demo.model;

import com.ananth.demo.request.CreateShowRequestBody;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class Show {
    private String showId;
    private String movieId;
    private String cinemaId;
    private String startTime;
    private String endTime;

    public Show(String cinemaId,
                CreateShowRequestBody showRequest) {
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
