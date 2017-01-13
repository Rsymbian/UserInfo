package com.app.rabia.myapplication.datasource.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mansoor on 10/12/2016.
 */

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
