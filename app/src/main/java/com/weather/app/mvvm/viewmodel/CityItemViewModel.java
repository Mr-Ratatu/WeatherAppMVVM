package com.weather.app.mvvm.viewmodel;

import android.os.Bundle;
import android.view.View;

import com.weather.app.mvvm.R;
import com.weather.app.mvvm.utils.Constant;

import androidx.databinding.BaseObservable;
import androidx.navigation.Navigation;

public class CityItemViewModel extends BaseObservable {

    public void findWeatherInCity(View view, String city) {
        Bundle bundle = new Bundle();
        bundle.putString(Constant.CITY, city);

        Navigation.findNavController(view).navigate(R.id.action_listCityFragment_to_mainScreenFragment, bundle);
    }
}
