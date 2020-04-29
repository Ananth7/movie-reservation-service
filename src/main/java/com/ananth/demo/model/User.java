package com.ananth.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class User {
    private String userID;
    private String name;
    private String emailId;
    private String phoneNumber;
    private int isAdmin;

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }

    public User(@NotBlank @JsonProperty("name") String name,
                @NotBlank @JsonProperty("emaildId") String emailId,
                @NotBlank @JsonProperty("phoneNumber") String phoneNumber,
                @NotBlank @JsonProperty("isAdmin") int isAdmin) {
        this.userID = UUID.randomUUID().toString();
        this.name = name;
        this.emailId = emailId;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.isAdmin = isAdmin;
    }
}
