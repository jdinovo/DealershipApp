package com.example.jd.dealershipapp.JavaBean;

import java.util.ArrayList;

/**
 * @author James DiNovo
 * @date November 4th, 2018
 * @version 1.0
 *
 * Vehicle class is for vehicles which will be displayed in the recycleView
 *
 */
public class Vehicle {
    private String brand;
    private String model;
    private String price;
    private String description;
    private String year;
    private int thumbnailID;
    private ArrayList<Integer> images;

    /**
     * @author James DiNovo
     * @date November 4th, 2018
     * @version 1.0
     * @return void
     *
     * Vehicle Constructor
     *
     */
    public Vehicle() {

    }

    /**
     * @author James DiNovo
     * @date November 4th, 2018
     * @version 1.0
     * @param brand vehicle brand
     * @param model vehicle model
     * @param price vehicle price
     * @param thumbnailID imageID for thumbnail
     * @param images an arraylist of imageIDs
     *
     * Vehicle Overloaded Constructor
     *
     */
    public Vehicle(String brand, String model, String year, String price, String description, int thumbnailID, ArrayList<Integer> images) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.description = description;
        this.thumbnailID = thumbnailID;
        this.images = images;
    }

    /**
     * @author James DiNovo
     * @date November 4th, 2018
     * @version 1.0
     * @return String
     *
     * getter for brand
     *
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @author James DiNovo
     * @date November 4th, 2018
     * @version 1.0
     * @param brand vehicle brand
     * @return void
     *
     * setter for brand
     *
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @author James DiNovo
     * @date November 4th, 2018
     * @version 1.0
     * @return String
     *
     * getter for model
     *
     */
    public String getModel() {
        return model;
    }

    /**
     * @author James DiNovo
     * @date November 4th, 2018
     * @version 1.0
     * @param model vehicle model
     * @return void
     *
     * setter for model
     *
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @author James DiNovo
     * @date November 4th, 2018
     * @version 1.0
     * @return String
     *
     * getter for price
     *
     */
    public String getPrice() {
        return price;
    }

    /**
     * @author James DiNovo
     * @date November 4th, 2018
     * @version 1.0
     * @param price a string price
     * @return void
     *
     * setter for price
     *
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @author James DiNovo
     * @date November 4th, 2018
     * @version 1.0
     * @return String
     *
     * getter for thumbnailID
     *
     */
    public int getThumbnailID() {
        return thumbnailID;
    }

    /**
     * @author James DiNovo
     * @date November 4th, 2018
     * @version 1.0
     * @param thumbnailID an imageID
     * @return void
     *
     * setter for thumbnailID
     *
     */
    public void setThumbnailID(int thumbnailID) {
        this.thumbnailID = thumbnailID;
    }

    /**
     * @author James DiNovo
     * @date November 4th, 2018
     * @version 1.0
     * @return ArrayList<Integer>
     *
     * getter for images
     *
     */
    public ArrayList<Integer> getImages() {
        return images;
    }

    /**
     * @author James DiNovo
     * @date November 4th, 2018
     * @version 1.0
     * @param images an arraylist of imageIDs
     * @return void
     *
     * setter for images
     *
     */
    public void setImages(ArrayList<Integer> images) {
        this.images = images;
    }

    /**
     * @author James DiNovo
     * @date November 4th, 2018
     * @version 1.0
     * @return String
     *
     * getter for description
     *
     */
    public String getDescription() {
        return description;
    }

    /**
     * @author James DiNovo
     * @date November 4th, 2018
     * @version 1.0
     * @param description a description of the vehicle
     * @return void
     *
     * setter for description
     *
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @author James DiNovo
     * @date November 4th, 2018
     * @version 1.0
     * @return String
     *
     * getter for year
     *
     */
    public String getYear() {
        return year;
    }

    /**
     * @author James DiNovo
     * @date November 4th, 2018
     * @version 1.0
     * @param year a description of the vehicle
     * @return void
     *
     * setter for description
     *
     */
    public void setYear(String year) {
        this.year = year;
    }
}
