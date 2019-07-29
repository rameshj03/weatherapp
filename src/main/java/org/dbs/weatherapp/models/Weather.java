package org.dbs.weatherapp.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "weather")
public class Weather {

    private String placeLabel;

    private String date;

//    private String country;
//    private String temperature;

    private String latitude;
    private String longitude;

    private Daily daily;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Daily getDaily() {
        return daily;
    }

    public void setDaily(Daily daily) {
        this.daily = daily;
    }

    public String getPlaceLabel() {
        return placeLabel;
    }

    public void setPlaceLabel(String placeLabel) {
        this.placeLabel = placeLabel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
