package com.example.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Button btnSearch;
    private static final String[] units = {"metric", "imperial"};
    Button btnLastSearches;
    Spinner spUnits;
    AutoCompleteTextView autoTxtNameSearch;
    Type listCityType;
    List<WorldCityList> cityList;
    String[] cities;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        FragmentManager fm = getSupportFragmentManager();
        Fragment frag = fm.findFragmentById(R.id.fragHolder);
        if (frag == null) {
            frag = new SlideShowFragment();
            fm.beginTransaction().add(R.id.fragHolder, frag).commit();
        }

        // API functionality
        btnSearch = findViewById(R.id.btnSearch);
        btnLastSearches = findViewById(R.id.btnLastSearches);

//        if (bundle!= null){
//            cities = savedInstanceState.getStringArray("cities");
        if (cities == null) {
            String jsonFileString = loadCities();
            Gson gson = new Gson();
            listCityType = new TypeToken<List<WorldCityList>>() {
            }.getType();
            cityList = gson.fromJson(jsonFileString, listCityType);
            cities = new String[cityList.size()];
            for (int i = 0; i < cityList.size(); i++) {
                cities[i] = cityList.get(i).toString();
                int s = 0;
            }
        }
//        }


        ArrayAdapter<String> autoAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, cities);
        autoTxtNameSearch = (AutoCompleteTextView) findViewById(R.id.autoTxtNameSearch);
        autoTxtNameSearch.setAdapter(autoAdapter);

        spUnits = findViewById(R.id.spUnits);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, units);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spUnits.setAdapter(adapter);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiControl appC = new ApiControl();
                String[] split = autoTxtNameSearch.getText().toString().split(",");
                appC.searchWeather(getApplicationContext(), spUnits.getSelectedItem().toString(), split[0], split[1]);
            }
        });
        btnLastSearches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiControl appC = new ApiControl();
                appC.getLastSearches(getApplicationContext());
            }
        });
        //End API functionality
    }


    public String loadCities() {
        String jsonString;
        try {
            InputStream is = getAssets().open("cities.json");

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            jsonString = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return jsonString;
    }

//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        bundle.putStringArray("cities", cities);
//        super.onSaveInstanceState(outState);
//    }

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
//        mAuth.signOut();
    }
}