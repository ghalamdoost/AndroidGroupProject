package com.example.groupproject;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FlightInfoAdaptor extends RecyclerView.Adapter<FlightInfoAdaptor.MyViewHolder> {

    private ArrayList<FlightInfo> fInfo;

    public FlightInfoAdaptor(ArrayList<FlightInfo> flight) {
        fInfo = flight;

    }

    @NonNull
    @Override
    public FlightInfoAdaptor.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new MyViewHolder(layoutInflater, parent);

    }

    @Override
    public void onBindViewHolder(FlightInfoAdaptor.MyViewHolder holder, int position) {
        FlightInfo f = fInfo.get(position);

        //holder.imgPlane.setTex
        holder.txtPrice.setText(f.getMinPrice());
        holder.txtTimings.setText(f.getQuoteDateTime());
        holder.txtAirports.setText(f.getQuoteId());
        holder.txtAirline.setText(f.getQuoteDateTime());
        //holder.submit.setText(f.getQuoteDateTime());


    }

    @Override
    public int getItemCount() {
        return fInfo.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPlane;
        TextView txtTimings;
        TextView txtAirports;
        TextView txtPrice;
        TextView txtAirline;
        Button submit;

        public MyViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.row_layout, parent, false));

            imgPlane = itemView.findViewById(R.id.imgPlane);
            txtTimings = itemView.findViewById(R.id.txtTimings);
            txtAirports = itemView.findViewById(R.id.txtAirports);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtAirline = itemView.findViewById(R.id.textAirline);
            submit = itemView.findViewById(R.id.submit);

        }
    }
}
