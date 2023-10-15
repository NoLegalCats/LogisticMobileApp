package com.example.logisticsapp;

public class HistoryOrderItem {
    private String startPoint;
    private String endPoint;
    private String date;
    private String cost;
    private float rating;

    public HistoryOrderItem(String startPoint, String endPoint, String date, String cost, float rating) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.date = date;
        this.cost = cost;
        this.rating = rating;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public String getDate() {
        return date;
    }

    public String getCost() {
        return cost;
    }

    public float getRating() {
        return rating;
    }
}

