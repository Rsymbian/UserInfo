package com.app.rabia.myapplication.datasource.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mansoor on 10/12/2016.
 */

public class AddressData {

    @SerializedName("street")
    private String street;

    @SerializedName("suite")
    private String suite;

    @SerializedName("city")
    private String city;

    @SerializedName("zipcode")
    private String zipcode;

    @SerializedName("geo")
    private GeoData geo;

    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public GeoData getGeo() {
        return geo;
    }
}
