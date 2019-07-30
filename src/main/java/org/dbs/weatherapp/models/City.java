package org.dbs.weatherapp.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "city")
public class City {

    private String label;

    private String desc;

    private  String longt;

    private String lat;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String desc() {
        return desc;
    }

    public void desc(String desc) {
        this.desc = desc;
    }

    public String getLongt() {
        return longt;
    }

    public void setLongt(String longt) {
        this.longt = longt;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }
}
