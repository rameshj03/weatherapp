package org.dbs.weatherapp.dao;

import org.dbs.weatherapp.models.City;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityDaoImpl extends MongoRepository<City, Long> {

}
