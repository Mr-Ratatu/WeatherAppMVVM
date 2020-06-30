package com.weather.app.mvvm.data.network;

import com.weather.app.mvvm.data.model.WeatherBody;
import com.weather.app.mvvm.data.model.item.ListWeather;
import com.weather.app.mvvm.data.model.item.ThreeHourWeatherBody;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiWeatherService {
    @GET("weather")
    Observable<WeatherBody> getApiWeather(@Query("q") String city,
                                          @Query("units") String units,
                                          @Query("lang") String lang);

    @GET("forecast")
    Observable<ThreeHourWeatherBody> getApiWeatherThreeHour(@Query("q") String city,
                                                            @Query("units") String units,
                                                            @Query("lang") String lang);
}
