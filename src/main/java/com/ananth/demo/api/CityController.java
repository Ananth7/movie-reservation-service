package com.ananth.demo.api;

import com.ananth.demo.model.City;
import com.ananth.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/city")
@RestController
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    @ResponseBody
    public List<City> getCities() {
        List<City> res = cityService.getCities();
        res.forEach(System.out::println);
        return res;
    }

    @ResponseBody
    @PostMapping
    public City addCity(@RequestBody City city) {
        System.out.println("Controller = " + city.getCityId() + " " + city.getName());
        return cityService.addCity(city);
    }
}
