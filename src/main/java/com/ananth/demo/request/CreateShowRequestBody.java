package com.ananth.demo.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.UUID;

@Getter
@Builder
public class CreateShowRequestBody {
    private String userId;
    private String movieId;
    private String startTime;
    private String endTime;
    private String showDate;

    public CreateShowRequestBody(@JsonProperty("movieId") String movieId,
                @JsonProperty("start_time") String startTime,
                @JsonProperty("userId") String userId,
                @JsonProperty("end_time")   String endTime,
                @JsonProperty("show_date")  String showDate) {
        this.movieId = movieId;
        this.userId = userId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.showDate = showDate;
    }
}
