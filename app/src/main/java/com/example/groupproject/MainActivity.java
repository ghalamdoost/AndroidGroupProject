package com.example.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Button btnSearch;
    private RecyclerView rView;
    private RecyclerView.Adapter adapter;
    private ArrayList<FlightInfo> flightList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAuth = FirebaseAuth.getInstance();
        btnSearch = findViewById(R.id.btnSearch);


        FlightInfo f1 = new FlightInfo("1", "118", "true", "851", "81727", "60987", "2021-05-14T00:00:00", "2021-04-17T20:51:00");
        FlightInfo f2 = new FlightInfo("1", "118", "true", "851", "81727", "60987", "2021-05-14T00:00:00", "2021-04-17T20:51:00");
        FlightInfo f3 = new FlightInfo("1", "118", "true", "851", "81727", "60987", "2021-05-14T00:00:00", "2021-04-17T20:51:00");

        flightList.add(f1);
        flightList.add(f2);
        flightList.add(f3);

        rView = findViewById(R.id.rView);

        rView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new FlightInfoAdaptor(flightList);
        rView.setAdapter(adapter);


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiControl appC = new ApiControl();
                appC.searchQuotes(getApplicationContext(), "CA", "CAD", "en-US", "SFO-sky", "JFK-sky", "anytime", "anytime");
                //Do something with the data here

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() == null) {
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(), 0);
        } else {
            Toast.makeText(this, "Welcome" + mAuth.getCurrentUser().getDisplayName(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0 && resultCode == RESULT_OK) {
            Toast.makeText(this, "Welcome" + mAuth.getCurrentUser().getDisplayName(), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Login Failure! Please try again.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAuth.signOut();
    }
}