package com.app.rabia.myapplication.datasource.data;

import com.google.gson.annotations.SerializedName;


public class GeoData {

    @SerializedName("lat")
    private String lat;

    @SerializedName("lng")
    private String lng;

    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }
}
