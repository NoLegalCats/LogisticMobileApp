package com.example.logisticsapp;

import androidx.appcompat.app.AppCompatActivity;

public class RouteItem extends AppCompatActivity {
    private String startLocText;
    private String endLocText;
    private String endLocDescText;
    private String massText;
    private String loadText;
    private String distantText;
    private String costText;
    private String descrText;
    private int imageResource;
    private String userNameText;
    private String userLocText;
    private String userRegText;

    public RouteItem(String startLocText, String endLocText, String endLocDescText, String massText, String loadText,
                     String distantText, int imageResource, String costText, String descrText, String userNameText, String userLocText, String userRegText) {
        this.startLocText = startLocText;
        this.endLocText = endLocText;
        this.endLocDescText = endLocDescText;
        this.massText = massText;
        this.loadText = loadText;
        this.distantText = distantText;
        this.costText = costText;
        this.descrText = descrText;
        this.imageResource = imageResource;
        this.userNameText = userNameText;
        this.userLocText = userLocText;
        this.userRegText = userRegText;
    }

    public String getStartLocText() {
        return startLocText;
    }

    public String getEndLocText() {
        return endLocText;
    }

    public String getEndLocDescText() {
        return endLocDescText;
    }

    public String getMassText() {
        return massText;
    }

    public String getLoadText() {
        return loadText;
    }

    public String getDistantText() {
        return distantText;
    }

    public String getCostText() {
        return costText;
    }

    public String getDescrText() {
        return descrText;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getUserNameText() {
        return userNameText;
    }

    public String getUserLocText() {
        return userLocText;
    }

    public String getUserRegText() {
        return userRegText;
    }
}

