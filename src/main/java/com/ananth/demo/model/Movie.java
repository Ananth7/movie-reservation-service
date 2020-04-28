package com.ananth.demo.model;

import lombok.Builder;
import lombok.Getter;

import java.time.Duration;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class Movie {
    private UUID movieId;
    private String name;
    private Duration duration;
    private List<String> actors;
    private Genre genre;
    private int rating;
}
