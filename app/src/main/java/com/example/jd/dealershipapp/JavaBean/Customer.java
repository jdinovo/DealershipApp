package com.example.jd.dealershipapp.JavaBean;

/**
 * Customer Class for storing customer information
 *
 * @author James DiNovo
 */
public class Customer {
    private static String firstName;
    private static String lastName;
    private static String email;
    private static String phone;
    private static String brand;
    private static String model;
    private static String vin;
    private static String km;
    private static String date;
    private static String time;
    private static String issue;

    /**
     *
     * @return String
     */
    public static String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public static void setFirstName(String firstName) {
        Customer.firstName = firstName;
    }

    /**
     *
     * @return String
     */
    public static String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public static void setLastName(String lastName) {
        Customer.lastName = lastName;
    }

    /**
     *
     * @return String
     */
    public static String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public static void setEmail(String email) {
        Customer.email = email;
    }

    /**
     *
     * @return String
     */
    public static String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     */
    public static void setPhone(String phone) {
        Customer.phone = phone;
    }

    /**
     *
     * @return String
     */
    public static String getBrand() {
        return brand;
    }

    /**
     *
     * @param brand
     */
    public static void setBrand(String brand) {
        Customer.brand = brand;
    }

    /**
     *
     * @return String
     */
    public static String getModel() {
        return model;
    }

    /**
     *
     * @param model
     */
    public static void setModel(String model) {
        Customer.model = model;
    }

    /**
     *
     * @return String
     */
    public static String getVin() {
        return vin;
    }

    /**
     *
     * @param vin
     */
    public static void setVin(String vin) {
        Customer.vin = vin;
    }

    /**
     *
     * @return String
     */
    public static String getKm() {
        return km;
    }

    /**
     *
     * @param km
     */
    public static void setKm(String km) {
        Customer.km = km;
    }

    /**
     *
     * @return String
     */
    public static String getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public static void setDate(String date) {
        Customer.date = date;
    }

    /**
     *
     * @return String
     */
    public static String getTime() {
        return time;
    }

    /**
     *
     * @param time
     */
    public static void setTime(String time) {
        Customer.time = time;
    }

    /**
     *
     * @return String
     */
    public static String getIssue() {
        return issue;
    }

    /**
     *
     * @param issue
     */
    public static void setIssue(String issue) {
        Customer.issue = issue;
    }
}
