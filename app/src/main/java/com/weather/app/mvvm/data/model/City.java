package com.weather.app.mvvm.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "item_db")
public class City {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String cityName;

    public City(String cityName) {
        this.cityName = cityName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
