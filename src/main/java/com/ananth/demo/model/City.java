package com.ananth.demo.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class City {
    private UUID cityId;
    private String name;

    public City(String name) {
        cityId = UUID.randomUUID();
        this.name = name;
    }
}
