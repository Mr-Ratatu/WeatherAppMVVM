package com.weather.app.mvvm.viewmodel.main;

import android.view.View;

import com.weather.app.mvvm.R;
import com.weather.app.mvvm.data.model.WeatherBody;

import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

public class MainScreenViewModel extends ViewModel {
    private MutableLiveData<WeatherBody> liveData;
    private MainScreenRepository mainScreenRepository;

    public MainScreenViewModel(String city) {
        mainScreenRepository = MainScreenRepository.getInstance();
        liveData = mainScreenRepository.getInfoWeather(city);
    }

    public MutableLiveData<WeatherBody> getLiveData() {
        return liveData;
    }

    public ObservableInt getLoading() {
        return mainScreenRepository.getLoading();
    }

    public ObservableInt getContent() {
        return mainScreenRepository.getContent();
    }

    public void openListCityClick(View view) {
        Navigation.findNavController(view).navigate(R.id.action_mainScreenFragment_to_listCityFragment);
    }
}
