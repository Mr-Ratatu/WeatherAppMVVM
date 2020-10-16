package com.weather.app.mvvm.data.db;

import android.content.Context;

import com.weather.app.mvvm.data.model.City;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {City.class}, version = 1, exportSchema = false)
public abstract class ListCityManager extends RoomDatabase {

    private static final String DB_NAME = "item_db";
    private static ListCityManager instance;

    public static ListCityManager getInstance(Context context) {
        if (instance == null) {
            synchronized (ListCityManager.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context, ListCityManager.class, DB_NAME)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }

        return instance;
    }

    public abstract ListCityDao getListDao();
}
