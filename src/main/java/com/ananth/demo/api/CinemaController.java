package com.ananth.demo.api;

import com.ananth.demo.model.Cinema;
import com.ananth.demo.model.User;
import com.ananth.demo.service.CinemaService;
import com.ananth.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    private UserService userService;

    @PostMapping("/api/{cinemaOwnerId}/cinema")
    public boolean createCinema(@RequestBody Cinema cinema, @PathVariable("cinemaOwnerId") UUID id) {
        Optional<User> cinemaOwner = userService.getUserById(id);
        cinemaOwner.ifPresent(cinema::setOwner);
        return cinemaService.addCinema(cinema);
    }

    @GetMapping("/api/cinema/{cinemaId}")
    public Optional<Cinema> findCinemaById(@PathVariable("cinemaId") UUID id) {
        return cinemaService.findCinemaById(id);
    }

    @GetMapping("/api/cinema")
    public List<Cinema> getAllCinemas() {
        return (List<Cinema>) cinemaService.getAllCinemas();
    }
}
