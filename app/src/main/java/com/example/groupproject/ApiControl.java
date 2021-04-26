package com.example.groupproject;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class ApiControl {

    //Constructor
    public ApiControl() {
    }

    public void searchWeather(Context cont, String units, String city, String country) {
        RequestQueue queue = Volley.newRequestQueue(cont);
        String url = "http://shbnodejs.herokuapp.com/api/weathers/" + units + "/" + city + "/" + country;
        JsonObjectRequest myRequest = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
            try {
                Weather wea = new Gson().fromJson(response.toString(), Weather.class);
                //Intent to DetailPage
                Intent i = new Intent(cont, DetailPage.class);
                i.putExtra("wea", wea);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                cont.startActivity(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, error -> {
            if (error != null) {
                Log.i("There is an Error on the API call: ", error.getMessage());
                error.printStackTrace();
            }
        });
        queue.add(myRequest);
    }

    public void getLastSearches(Context cont) {
        RequestQueue queue = Volley.newRequestQueue(cont);
        String url = "http://shbnodejs.herokuapp.com/api/cities/searched";
        JsonArrayRequest myRequest = new JsonArrayRequest(Request.Method.GET, url, null, response -> {
            try {
                WeatherSearches[] ws = new Gson().fromJson(response.toString(), WeatherSearches[].class);
                //Intent to DetailPage
                Intent i = new Intent(cont, LastCities.class);
                i.putExtra("ws", ws);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                cont.startActivity(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, error -> {
            if (error != null) {
                Log.i("There is an Error on the API call: ", error.getMessage());
                error.printStackTrace();
            }
        });
        queue.add(myRequest);
    }
}
