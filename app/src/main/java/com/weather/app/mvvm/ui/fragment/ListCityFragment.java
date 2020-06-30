package com.weather.app.mvvm.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.snackbar.Snackbar;
import com.weather.app.mvvm.R;
import com.weather.app.mvvm.data.model.City;
import com.weather.app.mvvm.databinding.FragmentListCityBinding;
import com.weather.app.mvvm.ui.adapter.ListCityAdapter;
import com.weather.app.mvvm.viewmodel.list.ListCityFactory;
import com.weather.app.mvvm.viewmodel.list.ListCityViewModel;

import java.util.ArrayList;
import java.util.List;

public class ListCityFragment extends Fragment {

    private List<City> list;
    private ListCityViewModel listCityViewModel;
    private ListCityAdapter listCityAdapter;
    private FragmentListCityBinding binding;

    public static ListCityFragment newInstance() {
        return new ListCityFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_city, container, false);

        initializeRecycler(binding.recycler);

        listCityViewModel = new ViewModelProvider(this,
                new ListCityFactory(getActivity().getApplication(), this)).get(ListCityViewModel.class);

        binding.setViewModel(listCityViewModel);

        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        listCityViewModel.getCompositeDisposable().add(listCityViewModel.getAllListCity()
                .doOnNext(cities -> listCityAdapter.setCityList(cities)).subscribe());

    }

    private void initializeRecycler(RecyclerView recyclerView) {
        list = new ArrayList<>();
        listCityAdapter = new ListCityAdapter(list);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(listCityAdapter);
        recyclerView.setHasFixedSize(true);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(swipeToDelete());
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    public void showScreenDialog() {
        AddCityListDialog addCityListDialog = new AddCityListDialog();
        addCityListDialog.show(getChildFragmentManager(), "dialog");
    }

    private ItemTouchHelper.SimpleCallback swipeToDelete() {
        return new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                int position = viewHolder.getAdapterPosition();
                City city = listCityAdapter.getCityList().get(position);

                listCityViewModel.deleteItem(listCityAdapter.getCityList().get(position));
                listCityAdapter.notifyDataSetChanged();

                Snackbar.make(binding.recycler, city.getCityName(), Snackbar.LENGTH_LONG)
                        .setAction("Вернуть", view -> {
                            listCityViewModel.insertItem(city);
                            listCityAdapter.notifyDataSetChanged();
                        }).show();
            }
        };
    }
}