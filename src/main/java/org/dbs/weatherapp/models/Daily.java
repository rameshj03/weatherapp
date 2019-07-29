package org.dbs.weatherapp.models;

import java.util.List;

public class Daily {

   private List<Data> data;

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }
}
