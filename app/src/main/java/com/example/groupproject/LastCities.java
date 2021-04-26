package com.example.groupproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LastCities extends AppCompatActivity {

    private RecyclerView rView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_cities);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.fragHolder2);
        if (frag == null) {
            frag = new SlideShowFragment();
            fm.beginTransaction().add(R.id.fragHolder2, frag).commit();
        }

        //Getting the object from the intent
        rView = findViewById(R.id.rView);
        rView.setLayoutManager(new LinearLayoutManager(this));

        WeatherSearches[] wea = (WeatherSearches[]) getIntent().getSerializableExtra("ws");
        adapter = new WeatherSearchesAdapter(wea);
        rView.setAdapter(adapter);
    }
}