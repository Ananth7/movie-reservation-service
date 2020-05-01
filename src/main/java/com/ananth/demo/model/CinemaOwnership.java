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
    private String owner_id;

    public CinemaOwnership(
            String cinema_id,
            String owner_id) {
        this.ownershipId = UUID.randomUUID().toString();
        this.cinema_id = cinema_id;
        this.owner_id = owner_id;
    }
}

