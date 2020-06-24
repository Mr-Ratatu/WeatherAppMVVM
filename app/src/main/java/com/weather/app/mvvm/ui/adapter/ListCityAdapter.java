package com.weather.app.mvvm.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weather.app.mvvm.R;
import com.weather.app.mvvm.data.model.City;
import com.weather.app.mvvm.databinding.CityItemBinding;
import com.weather.app.mvvm.viewmodel.CityItemViewModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class ListCityAdapter extends RecyclerView.Adapter<ListCityAdapter.ListCityViewHolder> {

    private List<City> list;

    public ListCityAdapter(List<City> list) {
        this.list = list;
    }

    public void setList(List<City> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListCityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CityItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.city_item, parent, false);

        return new ListCityViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListCityViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ListCityViewHolder extends RecyclerView.ViewHolder {

        private CityItemBinding binding;

        public ListCityViewHolder(@NonNull CityItemBinding cityItemBinding) {
            super(cityItemBinding.getRoot());

            this.binding = cityItemBinding;
        }

        public void bind(City city) {
            binding.setCity(city);
            binding.setItemViewModel(new CityItemViewModel());
            binding.executePendingBindings();
        }
    }
}
