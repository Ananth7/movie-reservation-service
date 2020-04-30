package com.ananth.demo.api;

import com.ananth.demo.model.Cinema;
import com.ananth.demo.model.CinemaOwnership;
import com.ananth.demo.model.Show;
import com.ananth.demo.request.CinemaOwnershipRequestBody;
import com.ananth.demo.request.CreateShowRequestBody;
import com.ananth.demo.service.CinemaOwnershipService;
import com.ananth.demo.service.CinemaService;
import com.ananth.demo.service.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    CinemaOwnershipService cinemaOwnershipService;

    @Autowired
    ShowsService showsService;

    @PostMapping("/api/v1/cinema")
    @ResponseBody
    public Cinema createCinema(@RequestBody Cinema cinema) {
        return cinemaService.addCinema(cinema);
    }

    @GetMapping("/api/v1/cinema/{cinemaId}")
    public Optional<Cinema> findCinemaById(@PathVariable("cinemaId") String id) {
        return cinemaService.findCinemaById(id);
    }


    /**
     * Add ownership of user to the cinema if the user and cinema exists.
     */
    @PostMapping("/api/v1/cinema/{cinemaId}/add_owner")
    @ResponseBody
    public CinemaOwnership addCinemaOwner(
            @PathVariable String cinemaId,
            @RequestBody CinemaOwnershipRequestBody cinemaOwnership) {

        Optional<Cinema> cinemaById = cinemaService.findCinemaById(cinemaId);
        if(cinemaById.isEmpty()) throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Cinema with given ID does not exist");

        return cinemaOwnershipService.addCinemaOwnership(
                new CinemaOwnership(cinemaId, cinemaOwnership.getEmailId()));

    }


    @PostMapping("/api/v1/cinema/{cinemaId}/remove_owner")
    @ResponseBody
    public CinemaOwnership removeCinemaOwner(
            @PathVariable String cinemaId,
            @RequestBody CinemaOwnershipRequestBody cinemaOwnership) {

        Optional<Cinema> cinemaById = cinemaService.findCinemaById(cinemaId);
        if(cinemaById.isEmpty()) throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Cinema with given ID does not exist");

        return cinemaOwnershipService.removeCinemaOwnership(
                new CinemaOwnership(cinemaId, cinemaOwnership.getEmailId()));

    }


    @PostMapping("/api/v1/cinema/cinemaownership")
    @ResponseBody
    CinemaOwnership postCinemaOwnership(@RequestBody CinemaOwnership cinemaOwnership) {
        return cinemaOwnershipService.addCinemaOwnership(cinemaOwnership);
    }


    @GetMapping("/api/v1/cinema")
    @ResponseBody
    public List<Cinema> getAllCinemas() {
        return (List<Cinema>) cinemaService.getAllCinemas();
    }


    @PutMapping("/api/v1/cinema/{cinema_id}/shows")
    @ResponseBody
    public Show addShow(
            @PathVariable("cinema_id") String cinemaId,
            @RequestBody CreateShowRequestBody show) {
        System.out.println(show);
        return showsService.addShow(new Show(cinemaId, show));
    }

    @GetMapping("api/v1/cinema/{cinema_id}/shows/{show_id}/seat")
    @ResponseBody
    public List<Show> getShows(
            @PathVariable("cinema_id") String cinemaId,
            @PathVariable("show_id") String showId) {

        return showsService.getShows(cinemaId, showId);
    }
}
