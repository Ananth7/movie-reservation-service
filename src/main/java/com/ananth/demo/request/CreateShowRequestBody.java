package com.ananth.demo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class CreateShowRequestBody {
    private String showId;
    private String movieId;
    private String startTime;
    private String endTime;
    private String showDate;

    public CreateShowRequestBody(@JsonProperty("movieId") String movieId,
                @JsonProperty("startTime") String startTime,
                @JsonProperty("endTime") String endTime,
                @JsonProperty("showDate") String showDate) {
        this.showId = UUID.randomUUID().toString();
        this.movieId = movieId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.showDate = showDate;
    }
}
