package com.ananth.demo.api;

import com.ananth.demo.model.CinemaOwnership;
import com.ananth.demo.service.CinemaOwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CinemaOwnershipController {

    @Autowired
    CinemaOwnershipService cinemaOwnershipService;

    @GetMapping("/api/v1/cinemaownership")
    @ResponseBody
    List<CinemaOwnership>  getCinemaOwnership() {
        return cinemaOwnershipService.getCinemaOwnershipDetails();
    }

    @PostMapping("/api/v1/cinemaownership")
    @ResponseBody
    CinemaOwnership postCinemaOwnership(@RequestBody CinemaOwnership cinemaOwnership) {
        return cinemaOwnershipService.addCinemaOwnership(cinemaOwnership);
    }
}
