
package com.weather.app.mvvm.data.model.item;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MainThreeHour {

    @SerializedName("temp")
    @Expose
    private double temp;
    @SerializedName("feels_like")
    @Expose
    private double feelsLike;
    @SerializedName("temp_min")
    @Expose
    private double tempMin;
    @SerializedName("temp_max")
    @Expose
    private double tempMax;
    @SerializedName("pressure")
    @Expose
    private int pressure;
    @SerializedName("humidity")
    @Expose
    private int humidity;

    public double getTemp() {
        return temp;
    }

    public String getCeilTemperature() {
        return Math.round(getTemp()) + "°C";
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public double getFeelsLikes() {
        return feelsLike;
    }

    public String getFeelsLikeInCelsius() {
        return getFeelsLikes() + " °С";
    }

    public void setFeelsLike(double feelsLike) {
        this.feelsLike = feelsLike;
    }

    public double getTempMin() {
        return tempMin;
    }

    public void setTempMin(double tempMin) {
        this.tempMin = tempMin;
    }

    public double getTempMax() {
        return tempMax;
    }

    public void setTempMax(double tempMax) {
        this.tempMax = tempMax;
    }

    public int getPressure() {
        return pressure;
    }

    public String getPressureString() {
        return pressure + " гПа";
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

}
