package com.example.logisticsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RatingActivity extends AppCompatActivity {

    private ImageButton mainButton;
    private ImageButton chatButton;
    private ImageButton mapButton;
    private ImageButton profileButton;
    String[] items = {"1 месяц", "3 месяца", "6 месяцев", "1 год", "За всё время"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        mainButton = findViewById(R.id.mainActivity);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RatingActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });

        chatButton = findViewById(R.id.chatActivity);
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RatingActivity.this, ChatActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });

        mapButton = findViewById(R.id.mapActivity);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RatingActivity.this, MapActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });

        profileButton = findViewById(R.id.profileActivity);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RatingActivity.this, ProfileActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });

        Spinner spinner = findViewById(R.id.rating_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        RecyclerView recyclerView = findViewById(R.id.rcView_review);
        List<ReviewItem> reviewList = new ArrayList<>();
        reviewList.add(new ReviewItem("Даниил", "Отличный грузоперевозчик! Оставил хорошие впечатления, груз доехал в целости и сохранности.", 1, R.mipmap.ic_launcher));
        reviewList.add(new ReviewItem("Даниил", "Отличный грузоперевозчик! Оставил хорошие впечатления, груз доехал в целости и сохранности.", 2, R.mipmap.ic_launcher));
        reviewList.add(new ReviewItem("Даниил", "Отличный грузоперевозчик! Оставил хорошие впечатления, груз доехал в целости и сохранности.", 3, R.mipmap.ic_launcher));
        reviewList.add(new ReviewItem("Даниил", "Отличный грузоперевозчик! Оставил хорошие впечатления, груз доехал в целости и сохранности.", 4, R.mipmap.ic_launcher));
        reviewList.add(new ReviewItem("Даниил", "Отличный грузоперевозчик! Оставил хорошие впечатления, груз доехал в целости и сохранности.", 5, R.mipmap.ic_launcher));
        reviewList.add(new ReviewItem("Даниил", "Отличный грузоперевозчик! Оставил хорошие впечатления, груз доехал в целости и сохранности.", 4, R.mipmap.ic_launcher));
        reviewList.add(new ReviewItem("Даниил", "Отличный грузоперевозчик! Оставил хорошие впечатления, груз доехал в целости и сохранности.", 4, R.mipmap.ic_launcher));
        reviewList.add(new ReviewItem("Даниил", "Отличный грузоперевозчик! Оставил хорошие впечатления, груз доехал в целости и сохранности.", 4, R.mipmap.ic_launcher));
        reviewList.add(new ReviewItem("Даниил", "Отличный грузоперевозчик! Оставил хорошие впечатления, груз доехал в целости и сохранности.", 4, R.mipmap.ic_launcher));
        reviewList.add(new ReviewItem("Даниил", "Отличный грузоперевозчик! Оставил хорошие впечатления, груз доехал в целости и сохранности.", 4, R.mipmap.ic_launcher));
        ReviewAdapter adapter2 = new ReviewAdapter(reviewList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter2);

    }
}