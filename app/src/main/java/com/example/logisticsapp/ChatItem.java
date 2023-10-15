package com.example.logisticsapp;

public class ChatItem {
    private int imageResource;
    private String nameUser;
    private String time;

    public ChatItem(int imageResource, String nameUser, String time) {
        this.imageResource = imageResource;
        this.nameUser = nameUser;
        this.time = time;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getNameUser() {
        return nameUser;
    }

    public String getTime() {
        return time;
    }
}


