package com.ananth.demo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CinemaOwnershipRequestBody {

    public CinemaOwnershipRequestBody(@JsonProperty("user_id") String ownnerId)
    {
        this.ownerId = ownnerId;
    }

    private String ownerId;
}
