package com.example.jd.dealershipapp.JavaBean;

public class Vehicle {
    private String brand;
    private String model;
    private String price;
    private int imageID;

    public Vehicle() {

    }

    public Vehicle(String brand, String model, String price, int imageID) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.imageID = imageID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
