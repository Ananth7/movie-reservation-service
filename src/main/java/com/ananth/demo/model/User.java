package com.ananth.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
public class User {
    private UUID userID;

    @NotBlank
    private String name;

    @NotBlank
    private String emailId;

    public User(UUID userID, @NotBlank String name, @NotBlank String emailId) {
        this.userID = userID;
        this.name = name;
        this.emailId = emailId;
    }
}

//
//user table
//userid
//
//
//        userroles
//        userid: theaterId: roleId
//
//        theater table
//
//userId: sysadmin
//        userId: theaterID: owner
//
//UserRole -> admin or theaterowner
//
//theaterowner -> {
//    theaters
//        }
//
//// user, theater owner, admin
////