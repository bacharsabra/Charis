package com.example.charis.model;

public class Charities {


    private String name;

    private int imageUrl;

    private String date;


    public Charities(String name, int imageUrl, String date) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
