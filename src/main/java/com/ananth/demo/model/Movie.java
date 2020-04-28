package com.ananth.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class Movie {
    private String movieId;
    private String name;
    private int duration;
    private String genre;
    private int rating;
    private String posterURL;
    private String trailerURL;
    private String plot;

    public Movie(@JsonProperty("name") String name,
                 @JsonProperty("duration") int duration,
                 @JsonProperty("genre") String genre,
                 @JsonProperty("rating") int rating,
                 @JsonProperty("posterURL") String posterURL,
                 @JsonProperty("trailerURL") String trailerURL,
                 @JsonProperty("plot") String plot) {
        this.movieId = UUID.randomUUID().toString();
        this.name = name;
        this.duration = duration;
        this.genre = genre;
        this.rating = rating;
        this.posterURL = posterURL;
        this.trailerURL = trailerURL;
        this.plot = plot;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId='" + movieId + '\'' +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                ", posterURL='" + posterURL + '\'' +
                ", trailerURL='" + trailerURL + '\'' +
                ", plot='" + plot + '\'' +
                '}';
    }
}
