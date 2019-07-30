package org.dbs.weatherapp.service;

import org.dbs.weatherapp.dao.CityDaoImpl;
import org.dbs.weatherapp.dao.WeatherDaoImpl;
import org.dbs.weatherapp.models.City;
import org.dbs.weatherapp.models.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WeatherService<cities> {

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    CityDaoImpl cityDao;


    SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");

    @Autowired
    WeatherDaoImpl weatherDao;

    private List<City> cities;

    @PostConstruct
    public void setUpConfigs() {
        cities = cityDao.findAll();
    }

    public List<Weather> getWeatherRecords() {

        //check on database
        long epoch = System.currentTimeMillis()/1000;
        System.out.println("Epoch time: " + epoch);

        Date date = new Date();
        date.setHours(11);
        date.setMinutes(59);
        date.setSeconds(59);

        List<Weather> weatherReports = cities.stream().map(city -> {

            Weather weatherItem = getFromDB(city.getLabel(), df.format(date));
            
            if(weatherItem==null){
                String req = "https://api.darksky.net/forecast/2e6f774a44eeca2779413188801c6180/" + city.getLat() + "," + city.getLongt() + "," + epoch + "?exclude=minutely,flags,hourly,currently";

                System.out.println(req);

                weatherItem = restTemplate.getForObject(req, Weather.class);

                weatherItem.setPlaceLabel(city.getLabel());
                weatherItem.setDate(df.format(date));
                weatherDao.save(weatherItem);
            }

            return weatherItem;
        }).collect(Collectors.toList());

        return weatherReports;
    }


    private Weather getFromDB(String location, String date){

        List<Weather> weatherList = weatherDao.findByPlaceLabelAndDate(location, date);

        if(weatherList==null || weatherList.isEmpty()){
            return null;
        }
        else{
            return weatherList.get(0);
        }

    }
}
