package com.example.logisticsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegPhoneActivity extends AppCompatActivity {

    private static boolean isDriver;
    String[] items = {"🇷🇺 +7", "🇺🇦 +380", "🇧🇾 +375", "🇰🇿 +7", "🇦🇲 +374", "🇦🇿 +994", "🇹🇯 +992", "🇹🇲 +993", "\uD83C\uDDFA\uD83C\uDDFF +998", "\uD83C\uDDF2\uD83C\uDDE9 +373", "\uD83C\uDDF0\uD83C\uDDEC +996"};
    String[] items2 = {"Экспедитор", "Экспедитор2", "Экспедитор3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_phone);

        Intent intent = getIntent();
        isDriver = intent.getBooleanExtra("isDriver", false);
        if (!isDriver) {
            TextView phone_stepText = findViewById(R.id.phone_stepText);
            phone_stepText.setText("Шаг 2/3");
        }

        ImageButton phone_backButton = findViewById(R.id.phone_backButton);
        phone_backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isDriver) {
                    Intent intent = new Intent(RegPhoneActivity.this, RegDocumentsActivity.class);
                    intent.putExtra("isDriver", isDriver);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                } else {
                    Intent intent = new Intent(RegPhoneActivity.this, RegInnActivity.class);
                    intent.putExtra("isDriver", isDriver);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
                }
            }
        });

        Button phone_nextButton = findViewById(R.id.phone_nextButton);
        phone_nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegPhoneActivity.this, RegCodeSmsActivity.class);
                intent.putExtra("isDriver", isDriver);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });

        Spinner phone_spinnerCode = findViewById(R.id.phone_spinnerCode);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner_item2, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        phone_spinnerCode.setAdapter(adapter);

        Spinner phone_spinner = findViewById(R.id.phone_spinner);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.custom_spinner_item2, items2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        phone_spinner.setAdapter(adapter2);
    }
}