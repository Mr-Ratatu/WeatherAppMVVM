package com.weather.app.mvvm;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import androidx.databinding.BindingAdapter;

public class BindingAdapters {

    @BindingAdapter({"app:setWeatherIcon"})
    public static void setWeatherIcon(ImageView imageView, String iconPath) {
        Picasso.get().cancelRequest(imageView);
        String newPath = "a" + iconPath;
        int imageId = imageView.getContext().getResources().getIdentifier(newPath + "_svg", "drawable", imageView.getContext().getPackageName());
        imageView.setImageResource(imageId);
    }

}
