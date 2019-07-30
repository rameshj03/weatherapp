package org.dbs.weatherapp.controllers;


import org.dbs.weatherapp.models.Weather;
import org.dbs.weatherapp.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

//@RestController
@Controller
@RequestMapping(path = "/")
public class WeatherController {

    Logger logger = LoggerFactory.getLogger(WeatherController.class);


    @Autowired
    WeatherService weatherService;

    private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    @GetMapping(path={"/", "/weather"})
//@RequestMapping(path = "/message", method = RequestMethod.GET)
    public String getWeatherData(Model model) {
        List<Weather> allCitiesWeather = weatherService.getWeatherRecords();
        model.addAttribute("message", "Hi");
        model.addAttribute("tasks", tasks);
        model.addAttribute("weathers",allCitiesWeather);
        return "welcome";
    }

  /*  @GetMapping( "/weather")
    public String message(Model model) {
        model.addAttribute("messages", "Hi");
        return "welcome";
    } */

}