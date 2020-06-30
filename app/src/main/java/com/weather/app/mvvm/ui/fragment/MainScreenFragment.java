package com.weather.app.mvvm.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weather.app.mvvm.R;
import com.weather.app.mvvm.data.model.WeatherBody;
import com.weather.app.mvvm.data.model.item.ListWeather;
import com.weather.app.mvvm.data.model.item.ThreeHourWeatherBody;
import com.weather.app.mvvm.databinding.FragmentMainScreenBinding;
import com.weather.app.mvvm.ui.adapter.ListCityAdapter;
import com.weather.app.mvvm.ui.adapter.ThreeHourWeatherAdapter;
import com.weather.app.mvvm.utils.Constant;
import com.weather.app.mvvm.viewmodel.main.MainScreenFactory;
import com.weather.app.mvvm.viewmodel.main.MainScreenViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainScreenFragment extends Fragment {

    private FragmentMainScreenBinding binding;
    private MainScreenViewModel mainScreenViewModel;
    private ThreeHourWeatherAdapter listCityAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_screen, container, false);

        mainScreenViewModel = new ViewModelProvider(this, new MainScreenFactory(getNameCity())).get(MainScreenViewModel.class);
        binding.setViewModel(mainScreenViewModel);

        initializeRecyclerView(binding.recycler);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mainScreenViewModel.getLiveData().observe(getViewLifecycleOwner(),
                weatherBody -> binding.setWeatherBody(weatherBody));

        mainScreenViewModel.getListWeatherMutableLiveData().observe(getViewLifecycleOwner(),
                threeHourWeatherBody -> listCityAdapter.setListWeathers(threeHourWeatherBody.getList()));
    }

    private String getNameCity() {
        try {
            return getArguments().getString(Constant.CITY);
        } catch (Exception e) {
            return "Дагестанские Огни";
        }
    }

    private void initializeRecyclerView(RecyclerView recyclerView) {
        List<ListWeather> listWeathers = new ArrayList<>();
        listCityAdapter = new ThreeHourWeatherAdapter(listWeathers);

        recyclerView.setAdapter(listCityAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
    }

}