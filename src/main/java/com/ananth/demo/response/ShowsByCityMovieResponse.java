package com.ananth.demo.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Builder
@Getter
public class ShowsByCityMovieResponse {
    private String cinemaId;
    private String cinemaName;
    private String show_id;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date show_date;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date startTime;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Date endTime;

    @Override
    public String toString() {
        return "ShowsByCityMovieResponse{" +
                "cinemaId='" + cinemaId + '\'' +
                ", cinemaName='" + cinemaName + '\'' +
                ", show_id='" + show_id + '\'' +
                ", show_date=" + show_date +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
