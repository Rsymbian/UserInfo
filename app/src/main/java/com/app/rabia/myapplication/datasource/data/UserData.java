package com.app.rabia.myapplication.datasource.data;

import com.google.gson.annotations.SerializedName;


public class UserData {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;


    @SerializedName("username")
    private String username;


    @SerializedName("email")
    private String email;


    @SerializedName("address")
    private AddressData address;


    @SerializedName("phone")
    private String phone;

    @SerializedName("website")
    private String website;


    @SerializedName("company")
    private CompanyData company;

    public UserData(int id, CompanyData company, String website, String phone, AddressData address, String email, String username, String name) {
        this.id = id;
        this.company = company;
        this.website = website;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.username = username;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public AddressData getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public CompanyData getCompany() {
        return company;
    }
}
