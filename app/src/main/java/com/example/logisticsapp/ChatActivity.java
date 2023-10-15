package com.example.logisticsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private ImageButton mainButton;
    private ImageButton mapButton;
    private ImageButton ratingButton;
    private ImageButton profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        mainButton = findViewById(R.id.mainActivity);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChatActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });

        mapButton = findViewById(R.id.mapActivity);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChatActivity.this, MapActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });

        ratingButton = findViewById(R.id.ratingActivity);
        ratingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChatActivity.this, RatingActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });

        profileButton = findViewById(R.id.profileActivity);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChatActivity.this, ProfileActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });

        ConstraintLayout chat_idOpen = findViewById(R.id.chat_idOpen);
        chat_idOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChatActivity.this, ChatIdActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.rcView_chat);
        List<ChatItem> chatList = new ArrayList<>();
        chatList.add(new ChatItem(R.mipmap.ic_launcher, "Александр", "21:50"));
        chatList.add(new ChatItem(R.mipmap.ic_launcher, "Александр", "21:50"));
        chatList.add(new ChatItem(R.mipmap.ic_launcher, "Александр", "21:50"));
        chatList.add(new ChatItem(R.mipmap.ic_launcher, "Александр", "21:50"));
        chatList.add(new ChatItem(R.mipmap.ic_launcher, "Александр", "21:50"));
        chatList.add(new ChatItem(R.mipmap.ic_launcher, "Александр", "21:50"));
        chatList.add(new ChatItem(R.mipmap.ic_launcher, "Александр", "21:50"));
        chatList.add(new ChatItem(R.mipmap.ic_launcher, "Александр", "21:50"));
        chatList.add(new ChatItem(R.mipmap.ic_launcher, "Александр", "21:50"));
        chatList.add(new ChatItem(R.mipmap.ic_launcher, "Александр", "21:50"));
        ChatAdapter adapter = new ChatAdapter(chatList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}