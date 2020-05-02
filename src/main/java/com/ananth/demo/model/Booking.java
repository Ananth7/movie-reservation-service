package com.ananth.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Booking {
    private String booking_id;
    private String user_id;
    private String status;
}
