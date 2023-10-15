package com.example.logisticsapp;

import android.app.Application;

import com.yandex.mapkit.MapKitFactory;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Здесь устанавливаем API-ключ для MapKit
        MapKitFactory.setApiKey("d3b9ce34-a33b-456a-8f42-4a94534fce92");
    }
}

