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
    ImageView imgIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtTemp = findViewById(R.id.txtTemp);
        txtCityName = findViewById(R.id.txtCityName);
        imgIcon = findViewById(R.id.imgIcon);

        Weather wea = (Weather) getIntent().getSerializableExtra("wea");

        String formatUnit = wea.getUnits().equalsIgnoreCase("metric") ? "C" : "F";
        txtTemp.setText(wea.getMain_temp().intValue() + "º" + formatUnit);
        txtCityName.setText(wea.getName());

        Glide.with(this).load("http://openweathermap.org/img/wn/" + wea.getWeather_icon() + "@2x.png").diskCacheStrategy(DiskCacheStrategy.ALL).into(imgIcon);
    }
}