package org.dbs.weatherapp.dao;

import org.dbs.weatherapp.models.Weather;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WeatherDaoImpl extends MongoRepository<Weather, Long> {

    List<Weather> findByPlaceLabelAndDate(String place, String date);

}
