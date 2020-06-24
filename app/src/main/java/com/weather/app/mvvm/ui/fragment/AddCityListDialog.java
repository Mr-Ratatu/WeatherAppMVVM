package com.weather.app.mvvm.ui.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.weather.app.mvvm.R;
import com.weather.app.mvvm.databinding.FragmentAddCityListDialogBinding;
import com.weather.app.mvvm.viewmodel.dialog.AddCityFactory;
import com.weather.app.mvvm.viewmodel.dialog.AddCityViewModel;

public class AddCityListDialog extends BottomSheetDialogFragment {

    public static AddCityListDialog newInstance() {
        return new AddCityListDialog();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentAddCityListDialogBinding binding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_add_city_list_dialog, container, false);

        AddCityViewModel addCityViewModel = new ViewModelProvider(this,
                new AddCityFactory(getActivity().getApplication(), this, binding)).get(AddCityViewModel.class);

        binding.setViewModel(addCityViewModel);

        return binding.getRoot();
    }
}