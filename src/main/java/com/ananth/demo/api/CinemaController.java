package com.ananth.demo.api;

import com.ananth.demo.model.Cinema;
import com.ananth.demo.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @PostMapping("/api/v1/cinema")
    @ResponseBody
    public Cinema createCinema(@RequestBody Cinema cinema) {
        return cinemaService.addCinema(cinema);
    }

    @GetMapping("/api/v1/cinema/{cinemaId}")
    public Optional<Cinema> findCinemaById(@PathVariable("cinemaId") UUID id) {
        return cinemaService.findCinemaById(id);
    }

    @GetMapping("/api/v1/cinema")
    @ResponseBody
    public List<Cinema> getAllCinemas() {
        return (List<Cinema>) cinemaService.getAllCinemas();
    }
}
