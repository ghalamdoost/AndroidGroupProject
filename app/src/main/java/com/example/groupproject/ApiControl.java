package com.example.groupproject;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ApiControl {

    private String key = "513627f9c7msh65fc903e562a5c6p187414jsn3dc8db77788e";
    private String host = "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com";

    //Constructor
    public ApiControl() {
    }

        public void searchQuotes(Context cont, String country, String currency, String locale, String originPlace, String destinationPlace, String inboundDate, String outboundDate) {
            RequestQueue queue = Volley.newRequestQueue(cont);
            String url = "https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/browsequotes/v1.0/" + country + "/" + currency + "/" + locale + "/" + originPlace + "/" + destinationPlace + "/" + outboundDate + "?inboundpartialdate=" + inboundDate;

            JsonObjectRequest myRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONArray quotes = response.getJSONArray("Quotes");
                        System.out.println("\n\nQuotes: " + quotes);

                    JSONArray carriers = response.getJSONArray("Carriers");
                    System.out.println("\n\nQuotes: " + carriers);

                    JSONArray places = response.getJSONArray("Places");
                    System.out.println("\n\nPlaces: " + places);

                    JSONArray currencies = response.getJSONArray("Currencies");
                    System.out.println("\n\nCurrencies: " + currencies);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("There is an Error on the API call: ", error.getMessage());
                error.printStackTrace();
            }
        }) {    //HEADERS to the request
            @Override
            public Map<String, String> getHeaders() {
                Map<String, String> params = new HashMap<>();
                params.put("x-rapidapi-key", key);
                params.put("x-rapidapi-host", host);
                return params;
            }
        };
        queue.add(myRequest);
    }
}
