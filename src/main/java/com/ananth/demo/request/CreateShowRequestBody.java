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
    private int movieId;
    private String startTime;
    private String endTime;

    public CreateShowRequestBody(@JsonProperty("movieId") int movieId,
                @JsonProperty("startTime") String startTime,
                @JsonProperty("endTime") String endTime) {
        this.showId = UUID.randomUUID().toString();
        this.movieId = movieId;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
