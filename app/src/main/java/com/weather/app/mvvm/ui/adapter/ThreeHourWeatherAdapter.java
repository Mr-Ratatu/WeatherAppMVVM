package com.weather.app.mvvm.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weather.app.mvvm.R;
import com.weather.app.mvvm.data.model.item.ListWeather;
import com.weather.app.mvvm.databinding.ThreeHourWeatherItemBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ThreeHourWeatherAdapter extends RecyclerView.Adapter<ThreeHourWeatherAdapter.ThreeHourWeatherViewHolder> {

    private List<ListWeather> listWeathers;

    public ThreeHourWeatherAdapter(List<ListWeather> listWeathers) {
        this.listWeathers = listWeathers;
    }

    public void setListWeathers(List<ListWeather> listWeathers) {
        this.listWeathers = listWeathers;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ThreeHourWeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ThreeHourWeatherItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.three_hour_weather_item, parent, false);

        return new ThreeHourWeatherViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ThreeHourWeatherViewHolder holder, int position) {
        holder.bind(listWeathers.get(position));
    }

    @Override
    public int getItemCount() {
        return listWeathers != null ? listWeathers.size() : 0;
    }

    static class ThreeHourWeatherViewHolder extends RecyclerView.ViewHolder {
        private ThreeHourWeatherItemBinding binding;


        public ThreeHourWeatherViewHolder(ThreeHourWeatherItemBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }

        public void bind(ListWeather listWeather) {
            binding.setItemWeather(listWeather);
            binding.executePendingBindings();
        }
    }
}
