package com.example.jd.dealershipapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jd.dealershipapp.JavaBean.Vehicle;

import java.util.ArrayList;

public class CustomCardViewAdapter extends RecyclerView.Adapter {
    private ArrayList<Vehicle> vehicles;

    public CustomCardViewAdapter(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inv_card, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int i) {
        Vehicle vehicle = vehicles.get(i);
        ((CustomViewHolder) holder).brand.setText(vehicle.getBrand());
        ((CustomViewHolder) holder).model.setText(vehicle.getModel());
        ((CustomViewHolder) holder).price.setText(vehicle.getPrice());
        ((CustomViewHolder) holder).thumbnail.setImageResource(vehicle.getImageID());
    }

    @Override
    public int getItemCount() {
        if(vehicles != null) {
            return vehicles.size();
        }
        return 0;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView brand;
        protected TextView model;
        protected TextView price;
        protected ImageView thumbnail;

        public CustomViewHolder(View view) {
            super(view);
            this.brand = view.findViewById(R.id.brand);
            this.model = view.findViewById(R.id.model);
            this.price = view.findViewById(R.id.price);
            this.thumbnail = view.findViewById(R.id.thumbnail);
        }
    }
}
