package com.weather.app.mvvm.viewmodel.list;

import android.app.Application;
import android.view.View;

import com.weather.app.mvvm.data.model.City;
import com.weather.app.mvvm.ui.fragment.ListCityFragment;
import com.weather.app.mvvm.viewmodel.CityListRepository;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.navigation.Navigation;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

public class ListCityViewModel extends AndroidViewModel {

    private ListCityFragment listCityFragment;
    private CityListRepository cityListRepository;
    private CompositeDisposable compositeDisposable;

    public ListCityViewModel(@NonNull Application application, ListCityFragment listCityFragment) {
        super(application);

        this.listCityFragment = listCityFragment;
        cityListRepository = CityListRepository.getInstance(application);
        compositeDisposable = cityListRepository.getCompositeDisposable();
    }

    public Observable<List<City>> getAllListCity() {
        return cityListRepository.getAllListCity();
    }

    public void onBackCLick(View view) {
        Navigation.findNavController(view).popBackStack();
    }

    public void showScreenDialogClick() {
        listCityFragment.showScreenDialog();
    }

    public void deleteItem(City city) {
        cityListRepository.deleteItem(city);
    }

    public void insertItem(City city) {
        cityListRepository.insert(city);
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }
}
