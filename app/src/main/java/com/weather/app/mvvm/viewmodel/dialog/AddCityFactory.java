package com.weather.app.mvvm.viewmodel.dialog;

import android.app.Application;

import com.weather.app.mvvm.databinding.FragmentAddCityListDialogBinding;
import com.weather.app.mvvm.ui.fragment.AddCityListDialog;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class AddCityFactory implements ViewModelProvider.Factory {

    private Application application;
    private AddCityListDialog addCityListDialog;
    private FragmentAddCityListDialogBinding binding;

    public AddCityFactory(Application application, AddCityListDialog addCityListDialog, FragmentAddCityListDialogBinding binding) {
        this.application = application;
        this.addCityListDialog = addCityListDialog;
        this.binding = binding;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new AddCityViewModel(application, binding, addCityListDialog);
    }
}
