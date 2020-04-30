package com.ananth.demo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class CinemaOwnershipRequestBody {
    public CinemaOwnershipRequestBody(@JsonProperty("email_id") String emailId) {
        this.emailId = emailId;
    }

    private String emailId;
}
