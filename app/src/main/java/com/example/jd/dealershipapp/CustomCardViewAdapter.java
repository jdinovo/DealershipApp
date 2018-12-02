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
import com.squareup.picasso.Picasso;

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
    private boolean mTwoPane;

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
        this.mTwoPane = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_view_inv, null).findViewById(R.id.vehicle_container) != null;

        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int i) {
        final Vehicle vehicle = vehicles.get(i);
        ((CustomViewHolder) holder).brand.setText(vehicle.getBrand());
        ((CustomViewHolder) holder).model.setText(vehicle.getModel());
        ((CustomViewHolder) holder).year.setText(vehicle.getYear());
        ((CustomViewHolder) holder).price.setText(vehicle.getPrice());
        Picasso.with(((CustomViewHolder) holder).view.getContext()).load(vehicle.getThumbnailID()).into(((CustomViewHolder) holder).thumbnail);
        //.setImageResource();
        ((CustomViewHolder) holder).card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VehicleFragment vehicleFrag = new VehicleFragment();
                Bundle args = new Bundle();
                args.putString("brand", vehicle.getBrand());
                args.putString("model", vehicle.getModel());
                args.putString("year", vehicle.getYear());
                args.putString("price", vehicle.getPrice());
                args.putString("desc", vehicle.getDescription());
                args.putIntegerArrayList("images", vehicle.getImages());

                vehicleFrag.setArguments(args);

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FragmentManager fm = activity.getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.setCustomAnimations(R.anim.fade_wipe_in, R.anim.fade_wipe_out, R.anim.fade_wipe_back_in, R.anim.fade_wipe_back_out);
                if(mTwoPane) {
                    transaction.replace(R.id.vehicle_container, vehicleFrag, "vehicle");
                } else {
                    transaction.replace(R.id.content, vehicleFrag, "vehicle");
                    transaction.addToBackStack(null);
                }


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
        protected View view;
        protected CardView card;
        protected TextView brand;
        protected TextView model;
        protected TextView year;
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
            this.view = view;
            this.card = view.findViewById(R.id.card_view);
            this.brand = view.findViewById(R.id.brand);
            this.year = view.findViewById(R.id.year);
            this.model = view.findViewById(R.id.model);
            this.price = view.findViewById(R.id.price);
            this.thumbnail = view.findViewById(R.id.thumbnail);
        }

    }

}
