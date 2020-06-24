package com.weather.app.mvvm.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weather.app.mvvm.R;
import com.weather.app.mvvm.data.model.WeatherBody;
import com.weather.app.mvvm.databinding.FragmentMainScreenBinding;
import com.weather.app.mvvm.utils.Constant;
import com.weather.app.mvvm.viewmodel.main.MainScreenFactory;
import com.weather.app.mvvm.viewmodel.main.MainScreenViewModel;

public class MainScreenFragment extends Fragment {

    private FragmentMainScreenBinding binding;
    private MainScreenViewModel mainScreenViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_screen, container, false);

        mainScreenViewModel = new ViewModelProvider(this, new MainScreenFactory(getNameCity())).get(MainScreenViewModel.class);
        binding.setViewModel(mainScreenViewModel);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mainScreenViewModel.getLiveData().observe(getViewLifecycleOwner(),
                weatherBody -> binding.setWeatherBody(weatherBody));
    }

    private String getNameCity() {
        try {
            return getArguments().getString(Constant.CITY);
        } catch (Exception e) {
            return "Дагестанские Огни";
        }
    }

}