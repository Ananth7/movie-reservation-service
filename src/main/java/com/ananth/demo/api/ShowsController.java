package com.ananth.demo.api;

import com.ananth.demo.model.Cinema;
import com.ananth.demo.model.Seat;
import com.ananth.demo.model.Show;
import com.ananth.demo.request.SeatsRequestBody;
import com.ananth.demo.response.ShowsByCityMovieResponse;
import com.ananth.demo.service.CinemaService;
import com.ananth.demo.service.SeatsService;
import com.ananth.demo.service.ShowsService;
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
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ShowsController {

    @Autowired
    private ShowsService showsService;

    @Autowired
    private SeatsService seatsService;

    @Autowired
    private CinemaService cinemaService;


    @GetMapping("/api/v1/shows")
    @ResponseBody
    public List<Show> getAllShows() {
        return showsService.getShows();
    }

    @GetMapping("/api/v1/shows/getshows/")
    @ResponseBody
    public Map<String, List<ShowsByCityMovieResponse>> getShowsByCityAndMovie(@RequestParam("city") String city_name,
                                                                               @RequestParam("movie_id") String movie_id) {

        List<ShowsByCityMovieResponse> shows = showsService.getShows(city_name, movie_id);
        Map<String, List<ShowsByCityMovieResponse>> result
                = shows.stream().collect(Collectors.groupingBy(ShowsByCityMovieResponse::getCinemaName));
        System.out.println(result);
        return result;
    }

    @PostMapping("/api/v1/shows/reserve")
    @ResponseBody
    public List<Seat> reserve(
            @RequestParam("show_id") String showId,
            @RequestBody SeatsRequestBody seatsRequestBody) {
        try {
            return seatsService.reserve(showId, seatsRequestBody.getSeatIds(), seatsRequestBody.getUser_id());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "~~~Sorry~~~ Not all seats are available for booking. Please try again.");
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong. Please try again.");
        }
    }

    @GetMapping("/api/v1/shows/{show_id}")
    @ResponseBody
    public Optional<Show> getShowById(@PathVariable("show_id") String showId) {
        return showsService.getShowById(showId);
    }

    @GetMapping("api/v1/shows/{show_id}/bookedseats")
    @ResponseBody
    public List<Seat> getBookedSeatsForShow(@PathVariable("show_id") String showId) {
        return seatsService.getBookedSeats(showId);
    }

    @GetMapping("api/v1/shows/get_free_seats")
    @ResponseBody
    public List<Integer> getSeats(
//            @RequestParam("cinema_id") String cinemaId,
            @RequestParam("show_id") String showId) {
        Optional<Show> showById = showsService.getShowById(showId);
        if (!showById.isPresent()) throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "Show with given ID does not exist");
        Optional<Cinema> cinemaById = cinemaService.findCinemaById(showById.get().getCinemaId());
        if (!cinemaById.isPresent()) throw new ResponseStatusException(
                HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong!");
        int seatCount = cinemaById.get().getSeatCount();
        return seatsService.getFreeSeats(seatCount, showId);
    }

}

