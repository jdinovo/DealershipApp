package com.example.jd.dealershipapp.JavaBean;

/**
 * @author Chris Dias
 * @date November 8th, 2018
 * @version 1.0
 *
 * The employee class will contain properties that
 * will be used in a recycler view which will be
 * hosted within the MeetTheTeam Fragment
 *
 */

public class Employee {

    private String name;
    private String jobTitle;
    private int imageID;
    private String[] employeeEmail;


    /**
     * @author Chris Dias
     * @date November 8th, 2018
     * @version 1.0
     *
     * Vehicle Constructors
     *
     */
    public Employee() {

    }

    public Employee(String name, String jobTitle) {
        this.name = name;
        this.jobTitle = jobTitle;
    }

    public Employee(String name, String jobTitle, int imageID) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.imageID = imageID;
    }

    public Employee(String name, String jobTitle, int imageID, String[] employeeEmail) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.imageID = imageID;
        this.employeeEmail = employeeEmail;
    }

    /**
     * @author Chris Dias
     * @date November 8th, 2018
     * @version 1.0
     *
     * Generated getters and setters for the above properties
     *
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String[] getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String[] employeeEmail) {
        this.employeeEmail = employeeEmail;
    }
}
