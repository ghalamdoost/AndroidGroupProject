package com.example.groupproject;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class LastCities extends AppCompatActivity {

    TextView txtLastCities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_cities);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtLastCities = findViewById(R.id.test);

        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.fragHolder2);
        if (frag == null) {
            frag = new SlideShowFragment();
            fm.beginTransaction().add(R.id.fragHolder2, frag).commit();
        }

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