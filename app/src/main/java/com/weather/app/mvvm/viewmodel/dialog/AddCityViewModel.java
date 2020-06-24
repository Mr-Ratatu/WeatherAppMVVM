package com.weather.app.mvvm.viewmodel.dialog;

import android.app.Application;

import com.weather.app.mvvm.data.model.City;
import com.weather.app.mvvm.databinding.FragmentAddCityListDialogBinding;
import com.weather.app.mvvm.ui.fragment.AddCityListDialog;
import com.weather.app.mvvm.viewmodel.CityListRepository;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

public class AddCityViewModel extends AndroidViewModel {

    private AddCityListDialog addCityListDialog;
    private CityListRepository cityListRepository;
    private FragmentAddCityListDialogBinding binding;

    public AddCityViewModel(@NonNull Application application, FragmentAddCityListDialogBinding binding, AddCityListDialog addCityListDialog) {
        super(application);

        this.binding = binding;
        cityListRepository = CityListRepository.getInstance(application);
        this.addCityListDialog = addCityListDialog;
    }

    private boolean checkFieldIsEmpty() {
        if (binding.textInputLayout.getEditText().getText().toString().trim().isEmpty()) {
            binding.textInputLayout.setError("Поле не может быть пустым");
            return false;
        }

        return true;
    }

    public void addCityInListClick() {
        if (!checkFieldIsEmpty()) {
            return;
        }

        cityListRepository.insert(new City(binding.textInputLayout.getEditText().getText().toString()));
        addCityListDialog.dismiss();
    }
}
