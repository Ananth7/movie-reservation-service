package com.ananth.demo.api;

import com.ananth.demo.model.Show;
import com.ananth.demo.service.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShowsController {

    @Autowired
    private ShowsService showsService;

    @PostMapping("/api/v1/shows")
    @ResponseBody
    public Show addShow(@RequestBody Show show) {
        System.out.println(show);
        return showsService.addShow(show);
    }

    @GetMapping("/api/v1/shows")
    @ResponseBody
    public List<Show> getAllShows() {
        return showsService.getShows();
    }

    

}

