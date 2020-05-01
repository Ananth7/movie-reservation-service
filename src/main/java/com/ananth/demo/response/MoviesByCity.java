package com.ananth.demo.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class MoviesByCity {
    private String movie_id;
    private String show_id;
    private Date show_date;
    private Date start_time;
    private Date end_time;

}
