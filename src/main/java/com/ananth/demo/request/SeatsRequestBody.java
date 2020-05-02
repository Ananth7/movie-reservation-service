package com.ananth.demo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SeatsRequestBody {
    private List<Integer> seatIds;
    private String user_id;

    public SeatsRequestBody(
            @JsonProperty("user_id") String userId,
            @JsonProperty("seat_ids") List<Integer> seatIds) {
        this.seatIds = new ArrayList<>(seatIds);
        this.user_id = userId;
    }
}
