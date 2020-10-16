package com.weather.app.mvvm.utils;

public class Constant {
    public static final String TAG = "data";
    public static final String UNITS_METRIC = "metric";
    public static final String LANG = "ru";
    public static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    public static final String API_KEY = "9c77026c7e309404f3f70034e652ab04";

    public static final String CITY = "city";

    public static String firstUpperCase(String word){
        if(word == null || word.isEmpty()) return ""; //или return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
