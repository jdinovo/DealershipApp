package com.example.jd.dealershipapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jd.dealershipapp.JavaBean.Vehicle;

import java.util.ArrayList;

/**
 * @author James DiNovo
 * @date November 4th, 2018
 * @version 1.0
 *
 * CustomCardViewAdapter creates a recycleView which contains cardViews
 *
 */
public class CustomCardViewAdapter extends RecyclerView.Adapter {
    private ArrayList<Vehicle> vehicles;
    /**
     * @author James DiNovo
     * @date November 4th, 2018
     * @version 1.0
     * @param vehicles
     * @return void
     *
     * CustomCardViewAdapter Constructor
     *
     */
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
        final Vehicle vehicle = vehicles.get(i);
        ((CustomViewHolder) holder).brand.setText(vehicle.getBrand());
        ((CustomViewHolder) holder).model.setText(vehicle.getModel());
        ((CustomViewHolder) holder).price.setText(vehicle.getPrice());
        ((CustomViewHolder) holder).thumbnail.setImageResource(vehicle.getThumbnailID());
        ((CustomViewHolder) holder).card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VehicleFragment vehicleFrag = new VehicleFragment();
                Bundle args = new Bundle();
                args.putString("brand", vehicle.getBrand());
                args.putString("model", vehicle.getModel());
                args.putString("price", vehicle.getPrice());
                args.putString("desc", vehicle.getDescription());
                args.putIntegerArrayList("images", vehicle.getImages());

                vehicleFrag.setArguments(args);

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FragmentManager fm = activity.getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.content, vehicleFrag, "vehicle");
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        if(vehicles != null) {
            return vehicles.size();
        }
        return 0;
    }

    /**
     * @author James DiNovo
     * @date November 4th, 2018
     * @version 1.0
     *
     * CustomViewHolder for getting views from CardView
     *
     */
    class CustomViewHolder extends RecyclerView.ViewHolder {

        protected CardView card;
        protected TextView brand;
        protected TextView model;
        protected TextView price;
        protected ImageView thumbnail;

        /**
         * @author James DiNovo
         * @date November 4th, 2018
         * @version 1.0
         * @param view
         *
         * CustomViewHolder Constructor
         *
         */
        public CustomViewHolder(View view) {
            super(view);
            this.card = view.findViewById(R.id.card_view);
            this.brand = view.findViewById(R.id.brand);
            this.model = view.findViewById(R.id.model);
            this.price = view.findViewById(R.id.price);
            this.thumbnail = view.findViewById(R.id.thumbnail);
        }

        /**
         * @author James DiNovo
         * @date November 4th, 2018
         * @version 1.0
         * @param listener
         *
         * Creates a ClickListener for CustomViewHolder
         *
         */
//        public void setOnClickListener(View.OnClickListener listener) {
//            parent.setOnClickListener(listener);
//        }
    }

}
