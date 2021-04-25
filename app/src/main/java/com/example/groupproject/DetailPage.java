package com.example.groupproject;


import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class DetailPage extends AppCompatActivity {

    TextView txtTemp;
    TextView txtCityName;
    TextView txtFeels;
    TextView txtVisibility;
    TextView minTemp;
    TextView maxTemp;
    ImageView imgIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtTemp = findViewById(R.id.txtTemp);
        txtCityName = findViewById(R.id.txtCityName);
        txtFeels = findViewById(R.id.txtFeels);
        txtVisibility = findViewById(R.id.txtVisibility);
        minTemp = findViewById(R.id.minTemp);
        maxTemp = findViewById(R.id.maxTemp);
        imgIcon = findViewById(R.id.imgIcon);

        Weather wea = (Weather) getIntent().getSerializableExtra("wea");

        String formatUnit = wea.getUnits().equalsIgnoreCase("metric") ? "C" : "F";
        String val = wea.getMain_temp().intValue() + "º" + formatUnit;
        txtTemp.setText(val);
        txtCityName.setText(wea.getName()+", "+wea.getCountry());
        txtVisibility.setText("Visibility "+wea.getVisibility());
        txtFeels.setText("Feels Like "+wea.getMain_feels_like());
        minTemp.setText("Min Temp: "+wea.getMain_temp_min());
        maxTemp.setText("Max Temp: "+wea.getMain_temp_max());

        Glide.with(this).load("http://openweathermap.org/img/wn/" + wea.getWeather_icon() + "@2x.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(imgIcon);
    }
}