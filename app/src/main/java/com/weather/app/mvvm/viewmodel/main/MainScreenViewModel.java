package com.weather.app.mvvm.viewmodel.main;

import android.view.View;

import com.weather.app.mvvm.R;
import com.weather.app.mvvm.data.model.WeatherBody;
import com.weather.app.mvvm.data.model.item.ThreeHourWeatherBody;

import androidx.appcompat.widget.PopupMenu;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.navigation.Navigation;

public class MainScreenViewModel extends ViewModel {
    private MutableLiveData<WeatherBody> liveData;
    private MutableLiveData<ThreeHourWeatherBody> listWeatherMutableLiveData;
    private MainScreenRepository mainScreenRepository;
    private String city;

    public MainScreenViewModel(String city) {
        this.city = city;
        mainScreenRepository = MainScreenRepository.getInstance();
        liveData = mainScreenRepository.getInfoWeather(city);
        listWeatherMutableLiveData = mainScreenRepository.getThreeHourWeather(city);
    }

    public void openListCityClick(View view) {
        Navigation.findNavController(view).navigate(R.id.action_mainScreenFragment_to_listCityFragment);
    }

    public void showPopupMenu(View view) {
        PopupMenu popup = new PopupMenu(view.getContext(), view);
        popup.inflate(R.menu.tollbar_menu);

        popup.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()) {
                case R.id.settings:

                    return true;

                case R.id.share:

                    return true;

                default:
                    return false;
            }
        });

        popup.show();
    }

    public void swipeRefreshList() {
        liveData = mainScreenRepository.getInfoWeather(city);
        listWeatherMutableLiveData = mainScreenRepository.getThreeHourWeather(city);
    }

    public MutableLiveData<WeatherBody> getLiveData() {
        return liveData;
    }

    public MutableLiveData<ThreeHourWeatherBody> getListWeatherMutableLiveData() {
        return listWeatherMutableLiveData;
    }

    public ObservableInt getLoading() {
        return mainScreenRepository.getLoading();
    }

    public ObservableInt getContent() {
        return mainScreenRepository.getContent();
    }

    public ObservableInt getError() {
        return mainScreenRepository.getError();
    }

    public ObservableBoolean getIsLoading() {
        return mainScreenRepository.isLoading();
    }

}
