package com.example.logisticsapp;

public class NotificationItem {
    private int imageResource;
    private String title;
    private String time;
    private String description;

    public NotificationItem(int imageResource, String title, String time, String description) {
        this.imageResource = imageResource;
        this.title = title;
        this.time = time;
        this.description = description;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }
}

