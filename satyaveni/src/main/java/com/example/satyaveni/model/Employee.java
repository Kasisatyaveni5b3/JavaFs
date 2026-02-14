package com.example.satyaveni;


public class Employee {
    private int id;
    private String name;
    private String email;
    private String designation;
    private String phoneNumber;

    public Employee() {

    }

    public Employee(String name, String email, String designation, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.designation = designation;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
