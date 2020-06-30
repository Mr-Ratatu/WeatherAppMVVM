package com.weather.app.mvvm.data.db;

import com.weather.app.mvvm.data.model.City;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Observable;

@Dao
public interface ListCityDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Completable insert(City city);

    @Delete
    Completable deleteItem(City city);

    @Query("SELECT * FROM item_db")
    Observable<List<City>> getAllListCity();

}
