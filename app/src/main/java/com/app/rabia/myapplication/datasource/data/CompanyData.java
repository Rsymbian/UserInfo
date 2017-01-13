package com.app.rabia.myapplication.datasource.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mansoor on 10/12/2016.
 */

public class CompanyData {

    @SerializedName("name")
    private String name;

    @SerializedName("catchPhrase")
    private String catchPhrase;

    @SerializedName("bs")
    private String bs;

    public String getName() {
        return name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }
}
