package com.weather.app.mvvm.viewmodel.list;

import android.app.Application;

import com.weather.app.mvvm.ui.fragment.ListCityFragment;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ListCityFactory implements ViewModelProvider.Factory {

    private Application application;
    private ListCityFragment listCityFragment;

    public ListCityFactory(Application application, ListCityFragment listCityFragment) {
        this.application = application;
        this.listCityFragment = listCityFragment;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new ListCityViewModel(application, listCityFragment);
    }
}
