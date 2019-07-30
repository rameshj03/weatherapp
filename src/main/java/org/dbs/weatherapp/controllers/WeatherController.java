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

import java.util.List;

@Controller
@RequestMapping(path = "/")
public class WeatherController {

    Logger logger = LoggerFactory.getLogger(WeatherController.class);

    @Autowired
    WeatherService weatherService;

    @GetMapping("/weather")
    public String getWeatherData(Model model) {
        List<Weather> allCitiesWeather = weatherService.getWeatherRecords();
        model.addAttribute("weathers",allCitiesWeather);
        return "report";
    }

}