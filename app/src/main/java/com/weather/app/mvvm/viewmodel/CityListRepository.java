package com.weather.app.mvvm.viewmodel;

import android.annotation.SuppressLint;
import android.content.Context;

import com.weather.app.mvvm.data.db.ListCityDao;
import com.weather.app.mvvm.data.db.ListCityManager;
import com.weather.app.mvvm.data.model.City;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class CityListRepository {

    private CompositeDisposable compositeDisposable;
    private static CityListRepository instance;
    private ListCityDao listCityDao;

    public static CityListRepository getInstance(Context context) {
        if (instance == null) {
            instance = new CityListRepository(context);
        }

        return instance;
    }

    private CityListRepository(Context context) {
        listCityDao = ListCityManager.getInstance(context).getListDao();
        compositeDisposable = new CompositeDisposable();
    }

    public void insert(City city) {
        compositeDisposable.add(listCityDao.insert(city)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(Throwable::printStackTrace)
                .subscribe());
    }

    public void deleteItem(City city) {
        compositeDisposable.add(listCityDao.deleteItem(city)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(Throwable::printStackTrace)
                .subscribe());
    }

    @SuppressLint("CheckResult")
    public Observable<List<City>> getAllListCity() {
        return listCityDao.getAllListCity()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(Throwable::printStackTrace);
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }
}
