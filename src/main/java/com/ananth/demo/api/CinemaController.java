package com.ananth.demo.api;

import com.ananth.demo.model.Cinema;
import com.ananth.demo.model.CinemaOwnership;
import com.ananth.demo.model.Show;
import com.ananth.demo.model.User;
import com.ananth.demo.request.CinemaOwnershipRequestBody;
import com.ananth.demo.request.CreateCinemaRequest;
import com.ananth.demo.request.CreateShowRequestBody;
import com.ananth.demo.service.CinemaOwnershipService;
import com.ananth.demo.service.CinemaService;
import com.ananth.demo.service.SeatsService;
import com.ananth.demo.service.ShowsService;
import com.ananth.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;

    @Autowired
    CinemaOwnershipService cinemaOwnershipService;

    @Autowired
    UserService userService;

    @Autowired
    ShowsService showsService;

    @Autowired
    SeatsService seatsService;

    @PostMapping("/api/v1/cinema/create_cinema")
    @ResponseBody
    public Cinema createCinema(@RequestBody CreateCinemaRequest createCinemaRequest) {
        try {
            Optional<User> userById = userService.getUserById(createCinemaRequest.getUserId());
            if (userById.isEmpty() ||  userById.get().getIsAdmin() == 0)
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "~~~Sorry~~~ Invalid user");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Cinema cinema = new Cinema(createCinemaRequest.getCinemaId(), createCinemaRequest.getName(),
                createCinemaRequest.getCityid(), createCinemaRequest.getSeatCount());
        return cinemaService.addCinema(cinema);
    }

    @GetMapping("/api/v1/cinema/")
    public Optional<Cinema> findCinemaById(@RequestParam("cinemaId") String id) {
        return cinemaService.findCinemaById(id);
    }

    /**
     * Add ownership of user to the cinema if the user and cinema exists.
     */
    @PostMapping("/api/v1/cinema/add_owner")
    @ResponseBody
    public CinemaOwnership addCinemaOwner(
            @RequestParam("cinema_id") String cinemaId,
            @RequestBody CinemaOwnershipRequestBody cinemaOwnershipRequestBody) {

        Optional<Cinema> cinemaById = cinemaService.findCinemaById(cinemaId);
        if(cinemaById.isEmpty()) throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Cinema with given ID does not exist");

        return cinemaOwnershipService.addCinemaOwnership(
                new CinemaOwnership(cinemaId,
                        cinemaOwnershipRequestBody.getOwnerId()));

    }

    @GetMapping("/api/v1/cinema")
    @ResponseBody
    public List<Cinema> getAllCinemas() {
        return (List<Cinema>) cinemaService.getAllCinemas();
    }


    @PostMapping("/api/v1/cinema/{cinema_id}/add_show")
    @ResponseBody
    public Show addShow(
            @PathVariable("cinema_id") String cinemaId,
            @RequestBody CreateShowRequestBody show) {
        System.out.println(show);
        boolean userOwnerOfCinema = cinemaOwnershipService.isUserOwnerOfCinema(show.getUserId(), cinemaId);
        if (!userOwnerOfCinema) throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "~~~Sorry~~~ User is not a owner of the given cinema");
        return showsService.addShow(new Show(cinemaId, show));
    }

    @GetMapping("api/v1/cinema/get_free_seats")
    @ResponseBody
    public List<Integer> getSeats(
            @RequestParam("cinema_id") String cinemaId,
            @RequestParam("show_id") String showId) {
        Optional<Cinema> cinemaById = cinemaService.findCinemaById(cinemaId);
        if(cinemaById.isEmpty()) throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Cinema with given ID does not exist");
        int seatCount = cinemaById.get().getSeatCount();
        return seatsService.getFreeSeats(seatCount, showId);
    }

}
