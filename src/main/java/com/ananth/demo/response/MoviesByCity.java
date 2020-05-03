package com.ananth.demo.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MoviesByCity {
    private String movie_name;
    private String movie_id;
}
