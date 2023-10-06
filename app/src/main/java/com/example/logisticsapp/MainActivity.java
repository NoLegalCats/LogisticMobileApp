package com.example.logisticsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private TextView textViewFree;
    private TextView textViewInWork;
    private Switch switch1;
    private ImageButton chatButton;
    private ImageButton mapButton;
    private ImageButton ratingButton;
    private ImageButton profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewFree = findViewById(R.id.textView_Free);
        textViewInWork = findViewById(R.id.textView);
        switch1 = findViewById(R.id.switch1);
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textViewFree.setTextColor(getResources().getColor(R.color.notActive));
                    textViewInWork.setTextColor(getResources().getColor(R.color.blueApp));
                } else {
                    textViewFree.setTextColor(getResources().getColor(R.color.blueApp));
                    textViewInWork.setTextColor(getResources().getColor(R.color.notActive));
                }
            }
        });

        chatButton = findViewById(R.id.chatActivity);
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });

        mapButton = findViewById(R.id.mapActivity);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });

        ratingButton = findViewById(R.id.ratingActivity);
        ratingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RatingActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });

        profileButton = findViewById(R.id.profileActivity);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });
    }
}