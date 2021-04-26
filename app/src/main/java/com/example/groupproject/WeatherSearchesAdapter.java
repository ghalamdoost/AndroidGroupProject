package com.example.groupproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WeatherSearchesAdapter extends RecyclerView.Adapter<WeatherSearchesAdapter.MyViewHolder> {

    private WeatherSearches[] wSearch;

    public WeatherSearchesAdapter(WeatherSearches[] ws) {
        wSearch = ws;
    }

    @NonNull
    @Override
    public WeatherSearchesAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new MyViewHolder(layoutInflater, parent);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherSearchesAdapter.MyViewHolder holder, int position) {
        WeatherSearches p = wSearch[position];

        holder.txtName.setText(p.getName());
        holder.txtCountry.setText(p.getCountry());
        holder.txtUnits.setText(p.getUnits());

    }

    @Override
    public int getItemCount() {
        return wSearch.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtName;
        TextView txtCountry;
        TextView txtUnits;

        public MyViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.activity_last_cities_searched, parent, false));

            itemView.setOnClickListener(this);

            txtName = itemView.findViewById(R.id.txtWSName);
            txtCountry = itemView.findViewById(R.id.txtWSCountry);
            txtUnits = itemView.findViewById(R.id.txtWSUnits);
        }

        public void onClick(View v) {
            int position = getLayoutPosition();
            WeatherSearches selected = wSearch[position];

            Context c = itemView.getContext();

            //Call the API to show the Detail of the selection
            ApiControl apc = new ApiControl();
            apc.searchWeather(itemView.getContext(), selected.getUnits(), selected.getName(), selected.getCountry());
        }
    }
}
