package com.ananth.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.UUID;

@Getter
public class City {
    private String cityId;
    private String name;

    public City(String cityId, String name) {
        this.cityId = cityId;
        this.name = name;
    }

    public City(@JsonProperty("name") String name) {
        cityId = UUID.randomUUID().toString();
        this.name = name;
    }

}
