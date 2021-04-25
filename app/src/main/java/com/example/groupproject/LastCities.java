package com.example.groupproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LastCities extends AppCompatActivity {

    TextView txtLastCities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_cities);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtLastCities = findViewById(R.id.textView);

        WeatherSearches[] wea = (WeatherSearches[]) getIntent().getSerializableExtra("ws");

        String res = "";
        for (WeatherSearches w : wea) {
            String result = w.name + " " + w.country + " " + w.units + "\n";
            System.out.println(result);
            res += result;
            //THIS PART NEEDS TO BE IMPLEMENTED IN A RECYCLER VIEW
        }
        txtLastCities.setText(res);
    }
}