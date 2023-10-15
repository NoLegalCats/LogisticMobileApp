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

public class HistoryOrdersActivity extends AppCompatActivity {

    String[] items = {"1 месяц", "3 месяца", "6 месяцев", "1 год", "За всё время"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_orders);

        ImageButton backButton = findViewById(R.id.historyOrders_backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HistoryOrdersActivity.this, ProfileActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });

        Spinner spinner = findViewById(R.id.historyOrders_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        RecyclerView recyclerView = findViewById(R.id.rcView_historyOrders);
        List<HistoryOrderItem> historyOrderList = new ArrayList<>();
        historyOrderList.add(new HistoryOrderItem("Kostanay, KZ", "Berlin, Germany", "11 сентября", "1500$", 5));
        historyOrderList.add(new HistoryOrderItem("Kostanay, KZ", "Berlin, Germany", "11 сентября", "1500$", 4));
        historyOrderList.add(new HistoryOrderItem("Kostanay, KZ", "Berlin, Germany", "11 сентября", "1500$", 3));
        historyOrderList.add(new HistoryOrderItem("Kostanay, KZ", "Berlin, Germany", "11 сентября", "1500$", 2));
        historyOrderList.add(new HistoryOrderItem("Kostanay, KZ", "Berlin, Germany", "11 сентября", "1500$", 1));
        historyOrderList.add(new HistoryOrderItem("Kostanay, KZ", "Berlin, Germany", "11 сентября", "1500$", 4));
        historyOrderList.add(new HistoryOrderItem("Kostanay, KZ", "Berlin, Germany", "11 сентября", "1500$", 4));
        historyOrderList.add(new HistoryOrderItem("Kostanay, KZ", "Berlin, Germany", "11 сентября", "1500$", 4));
        historyOrderList.add(new HistoryOrderItem("Kostanay, KZ", "Berlin, Germany", "11 сентября", "1500$", 4));
        historyOrderList.add(new HistoryOrderItem("Kostanay, KZ", "Berlin, Germany", "11 сентября", "1500$", 4));
        HistoryOrderAdapter adapter2 = new HistoryOrderAdapter(this, historyOrderList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter2);
    }
}