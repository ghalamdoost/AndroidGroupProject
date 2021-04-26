package com.example.groupproject;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class DetailPage extends AppCompatActivity {

    TextView txtTemp;
    TextView txtCityName;
    TextView txtFeelsLike;
    TextView txtMinTemp;
    TextView txtMaxTemp;
    TextView txtDescription;
    TextView txtCountryName;
    ImageView imgIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtTemp = findViewById(R.id.txtTemp);
        txtCityName = findViewById(R.id.txtCityName);
        txtCountryName = findViewById(R.id.txtCountryName);
        txtFeelsLike = findViewById(R.id.txtFeelsLike);
        txtMinTemp = findViewById(R.id.txtMinTemp);
        txtMaxTemp = findViewById(R.id.txtMaxTemp);
        txtDescription = findViewById(R.id.txtDescription);
        imgIcon = findViewById(R.id.imgIcon);

        Weather wea = (Weather) getIntent().getSerializableExtra("wea");

        String formatUnit = wea.getUnits().equalsIgnoreCase("metric") ? "C" : "F";

        txtTemp.setText(formatUnit(wea.getMain_temp(), formatUnit));
        txtCityName.setText(wea.getName());
        txtCountryName.setText(wea.getCountry());
        txtDescription.setText(wea.getWeather_description());
        txtFeelsLike.setText("Feels like: " + formatUnit(wea.getMain_feels_like(), formatUnit));
        txtMinTemp.setText("Min Temp: " + formatUnit(wea.getMain_temp_min(), formatUnit));
        txtMaxTemp.setText("Max Temp: " + formatUnit(wea.getMain_temp_max(), formatUnit));

        Glide.with(this).load("http://openweathermap.org/img/wn/" + wea.getWeather_icon() + "@2x.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(imgIcon);
    }

    //format to temperatures
    public String formatUnit(Float str, String formatUnit) {
        return str.intValue() + "º" + formatUnit;
    }
}