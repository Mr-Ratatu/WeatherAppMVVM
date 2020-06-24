package com.weather.app.mvvm.viewmodel.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainScreenFactory implements ViewModelProvider.Factory {

    private String city;

    public MainScreenFactory(String city) {
        this.city = city;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainScreenViewModel(city);
    }
}
