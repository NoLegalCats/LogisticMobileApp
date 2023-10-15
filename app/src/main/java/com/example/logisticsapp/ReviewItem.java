package com.example.logisticsapp;

public class ReviewItem {
    private String userName;
    private String userDescription;
    private float rating;
    private int userImageResId;

    public ReviewItem(String userName, String userDescription, float rating, int userImageResId) {
        this.userName = userName;
        this.userDescription = userDescription;
        this.rating = rating;
        this.userImageResId = userImageResId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public float getRating() {
        return rating;
    }

    public int getUserImageResId() {
        return userImageResId;
    }
}
