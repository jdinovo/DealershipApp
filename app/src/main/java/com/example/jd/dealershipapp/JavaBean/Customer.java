package com.example.jd.dealershipapp.JavaBean;

/**
 * Customer Class for storing customer information
 *
 * @author James DiNovo
 */
public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String brand;
    private String model;
    private String vin;
    private String km;

    /**
     * no-args constructor
     */
    public Customer() {

    }

    /**
     * args constructor
     *
     * @param firstName
     * @param lastName
     * @param email
     * @param phone
     * @param brand
     * @param model
     * @param vin
     * @param km
     */
    public Customer(String firstName, String lastName, String email, String phone, String brand, String model, String vin, String km) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.brand = brand;
        this.model = model;
        this.vin = vin;
        this.km = km;
    }

    /**
     *
     * @return String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return String
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return String
     */
    public String getBrand() {
        return brand;
    }

    /**
     *
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     *
     * @return String
     */
    public String getModel() {
        return model;
    }

    /**
     *
     * @param model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     *
     * @return String
     */
    public String getVin() {
        return vin;
    }

    /**
     *
     * @param vin
     */
    public void setVin(String vin) {
        this.vin = vin;
    }

    /**
     *
     * @return String
     */
    public String getKm() {
        return km;
    }

    /**
     *
     * @param km
     */
    public void setKm(String km) {
        this.km = km;
    }
}
