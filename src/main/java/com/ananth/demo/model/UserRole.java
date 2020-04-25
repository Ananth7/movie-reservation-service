package com.ananth.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.UUID;

@Getter
public class UserRole {
    private UUID userId;
    private int roleId; // 1 for theater owner, 2 for system admin
    private int theaterId;

    public UserRole(@JsonProperty("userid") UUID userId,
                    @JsonProperty("roleid") int roleId,
                    @JsonProperty("theaterid") int theaterId) {
        this.userId = userId;
        this.roleId = roleId;
        this.theaterId = theaterId;
    }
}

//
//Roles:
//
//1, 2, <>
//12, 1, a
//12, 1, b
