package com.ananth.demo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class ShowsByCinemaResponse {
    private String show_id;
    private Date show_date;
    private Date startTime;
    private Date endTime;
}
