package com.ananth.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class CinemaOwnership {
    private String ownershipId;
    private String cinema_id;
    private String user_id;

    public CinemaOwnership(
            @JsonProperty("cinema_id") String cinema_id,
            @JsonProperty("user_id") String user_id) {
        this.ownershipId = UUID.randomUUID().toString();
        this.cinema_id = cinema_id;
        this.user_id = user_id;
    }
}

