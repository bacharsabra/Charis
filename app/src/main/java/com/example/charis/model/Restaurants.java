
package com.example.charis.model;

public class Restaurants {

    private String name;

    private int imageUrl;

    private String rating;

    private String deliveryCharges;

    public Restaurants(String name, int imageUrl, String rating, String deliveryCharges) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.deliveryCharges = deliveryCharges;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDeliveryCharges() {
        return deliveryCharges;
    }

    public void setDeliveryCharges(String deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }
}
