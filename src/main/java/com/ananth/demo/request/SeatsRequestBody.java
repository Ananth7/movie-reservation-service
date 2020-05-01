package com.ananth.demo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SeatsRequestBody {
    private List<String> seatIds;

    public SeatsRequestBody(
            @JsonProperty("seat_id") List<String> seatIds) {
        this.seatIds = new ArrayList<>(seatIds);
    }
}
