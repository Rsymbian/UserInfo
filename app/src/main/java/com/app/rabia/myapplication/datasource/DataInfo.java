package com.app.rabia.myapplication.datasource;

/**
 * Created by mansoor on 12/12/2016.
 */

public class DataInfo {

    private Integer id;
    private String title;
    private String name;
    private String body;
    private int totalComments;

    public DataInfo() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getTotalCommentsCount() {
        return totalComments;
    }

    public void setTotalCommentsCount(int total) {
        this.totalComments = total;
    }
}
