package com.ananth.demo.api;

import com.ananth.demo.model.Cinema;
import com.ananth.demo.model.CinemaOwnership;
import com.ananth.demo.model.Seat;
import com.ananth.demo.model.Show;
import com.ananth.demo.model.User;
import com.ananth.demo.request.CinemaOwnershipRequestBody;
import com.ananth.demo.request.CreateShowRequestBody;
import com.ananth.demo.service.CinemaOwnershipService;
import com.ananth.demo.service.CinemaService;
import com.ananth.demo.service.SeatsService;
import com.ananth.demo.service.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    CinemaOwnershipService cinemaOwnershipService;

    @Autowired
    ShowsService showsService;

    @Autowired
    SeatsService seatsService;

    @PostMapping("/api/v1/cinema")
    @ResponseBody
    public Cinema createCinema(@RequestBody Cinema cinema) {
        return cinemaService.addCinema(cinema);
    }

    @GetMapping("/api/v1/cinema/{cinemaId}")
    public Optional<Cinema> findCinemaById(@PathVariable("cinemaId") String id) {
        return cinemaService.findCinemaById(id);
    }

    @GetMapping("/api/v1/cinema/owners")
    @ResponseBody
    public List<User> getAllOwners() {
        return cinemaService.getAllOwners();
    }

    /**
     * Add ownership of user to the cinema if the user and cinema exists.
     */
    @PostMapping("/api/v1/cinema/{cinemaId}/add_owner")
    @ResponseBody
    public CinemaOwnership addCinemaOwner(
            @PathVariable String cinemaId,
            @RequestBody CinemaOwnershipRequestBody cinemaOwnershipRequestBody) {

        Optional<Cinema> cinemaById = cinemaService.findCinemaById(cinemaId);
        if(cinemaById.isEmpty()) throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Cinema with given ID does not exist");

        return cinemaOwnershipService.addCinemaOwnership(
                new CinemaOwnership(cinemaId,
                        cinemaOwnershipRequestBody.getOwnerId()));

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
                new CinemaOwnership(cinemaId, cinemaOwnership.getOwnerId()));

    }


    @GetMapping("/api/v1/cinema")
    @ResponseBody
    public List<Cinema> getAllCinemas() {
        return (List<Cinema>) cinemaService.getAllCinemas();
    }


    @PostMapping("/api/v1/cinema/{cinema_id}/shows")
    @ResponseBody
    public Show addShow(
            @PathVariable("cinema_id") String cinemaId,
            @RequestBody CreateShowRequestBody show) {
        System.out.println(show);
        return showsService.addShow(new Show(cinemaId, show));
    }

    @GetMapping("api/v1/cinema/{cinema_id}/shows/{show_id}/availableseats")
    @ResponseBody
    public List<Integer> getSeats(
            @PathVariable("cinema_id") String cinemaId,
            @PathVariable("show_id") String showId) {
        Optional<Cinema> cinemaById = cinemaService.findCinemaById(cinemaId);
        if(cinemaById.isEmpty()) throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Cinema with given ID does not exist");
        int seatCount = cinemaById.get().getSeatCount();
        return seatsService.getFreeSeats(seatCount, showId);
    }

}
