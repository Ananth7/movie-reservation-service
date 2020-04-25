package com.ananth.demo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class RolesRequestBody {
    private int theaterId;
    private String role;

    public RolesRequestBody(@JsonProperty("theaterid") int theaterId,
                            @JsonProperty("role") String role) {
        this.theaterId = theaterId;
        this.role = role;
    }
}
