package com.example.jd.dealershipapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.jd.dealershipapp.JavaBean.Employee;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EmployeeCustomRecycleViewAdapter extends RecyclerView.Adapter {

    //Constructor and member variables
    private ArrayList<Employee> employees;

    public EmployeeCustomRecycleViewAdapter(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row_employee, null);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(layoutParams);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        final Employee employee = employees.get(position);
        final CustomViewHolder holder1 = (CustomViewHolder) holder;

        holder1.name.setText(employee.getName());
        holder1.jobTitle.setText(employee.getJobTitle());
        Picasso.with(holder1.view.getContext()).load(employee.getImageID()).into(holder1.image);
        holder1.email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SENDTO);
                i.setData(Uri.parse("mailto:"));
                i.putExtra(Intent.EXTRA_EMAIL, employee.getEmployeeEmail());

                AppCompatActivity activity = (AppCompatActivity) v.getContext();

                if (i.resolveActivity(activity.getPackageManager()) != null) {
                    activity.startActivity(i);
                } else {
                    Toast.makeText(activity.getApplicationContext(), "Please update your device", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return (employees != null ? employees.size() : 0);
    }

        /**
         * @author Chris Dias
         * @date November 16th, 2018
         * @version 1.0
         *
         * CustomViewHolder Constructor
         *
         */
        class CustomViewHolder extends RecyclerView.ViewHolder {

            protected TextView name;
            protected TextView jobTitle;
            protected ImageView image;
            protected ImageView email;
            protected View view;


            public CustomViewHolder(@NonNull View view) {
                super(view);
                this.view = view;
                this.name = view.findViewById(R.id.employeeName);
                this.jobTitle = view.findViewById(R.id.employeeJobTitle);
                this.image = view.findViewById(R.id.employeeImage);
                this.email = view.findViewById(R.id.employeeEmail);
            }
        }


}
