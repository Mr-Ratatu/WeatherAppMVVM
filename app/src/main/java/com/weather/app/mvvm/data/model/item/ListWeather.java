
package com.weather.app.mvvm.data.model.item;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ListWeather {

    @SerializedName("dt")
    @Expose
    private int dt;
    @SerializedName("main")
    @Expose
    private MainThreeHour main;
    @SerializedName("weather")
    @Expose
    private List<WeatherThreeHour> weather = null;
    @SerializedName("dt_txt")
    @Expose
    private String dtTxt;

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public MainThreeHour getMain() {
        return main;
    }

    public void setMain(MainThreeHour main) {
        this.main = main;
    }

    public List<WeatherThreeHour> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherThreeHour> weather) {
        this.weather = weather;
    }

    public String getDtTxt() {
        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
    }

    public String getHourWeather() {
        String[] split = dtTxt.split("\\s");
        String[] split1 = split[1].split(":00");
        Log.d("date", "getHourWeather: " + split[0]);

        return split1[0] + ":00";
    }

    /*public String getDayOfWeek() {
        String[] week = {"Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Субота", "Воскресенье"};

        String[] split = dtTxt.split("\\s");
        String[] split1 = split[0].split("-");
        Date date = new Date(split[0]);

        Calendar c = Calendar.getInstance();
        c.setTime(25);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        return week[dayOfWeek-1];
    }*/

}
