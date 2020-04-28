package com.ananth.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class CityMovies  {
    private static Map<Integer, List<UUID>> cityMoviesCache = new HashMap<>();

    public static void updateCache(final int cityId, final UUID movieId) {
        List<UUID> moviesList = cityMoviesCache.getOrDefault(cityId, new ArrayList<>());
        moviesList.add(movieId);
    }

    public static List<UUID> getFromCache(final int cityId) {
        return cityMoviesCache.getOrDefault(cityId, new ArrayList<>());
    }

}
