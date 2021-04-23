package com.example.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Button btnSearch;
    private static final String[] units = {"metric", "imperial"};
    Button btnLastSearches;
    EditText txtNameSearch;
    EditText txtCountrySearch;
    Spinner spUnits;

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
        txtNameSearch = findViewById(R.id.txtNameSearch);
        txtCountrySearch = findViewById(R.id.txtCountrySearch);
        btnSearch = findViewById(R.id.btnSearch);
        btnLastSearches = findViewById(R.id.btnLastSearches);

        spUnits = findViewById(R.id.spUnits);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, units);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spUnits.setAdapter(adapter);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiControl appC = new ApiControl();
                appC.searchWeather(getApplicationContext(), spUnits.getSelectedItem().toString(), txtNameSearch.getText().toString(), txtCountrySearch.getText().toString());
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