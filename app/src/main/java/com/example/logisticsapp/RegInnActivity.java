package com.example.logisticsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegInnActivity extends AppCompatActivity {

    private static boolean isDriver;
    private Button regInn_forwarderButton;
    private Button regInn_сargoOwnerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_inn);

        Intent intent = getIntent();
        isDriver = intent.getBooleanExtra("isDriver", false);
        if (!isDriver) {
            TextView regInn_stepText = findViewById(R.id.regInn_stepText);
            regInn_stepText.setText("Шаг 1/3");
        } else {
            LinearLayout linearLayout = findViewById(R.id.regInn_linearLayout);
            linearLayout.setVisibility(View.INVISIBLE);
        }

        TextView regInn_loginClick = findViewById(R.id.regInn_loginClick);
        regInn_loginClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegInnActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });

        Button regInn_nextButton = findViewById(R.id.regInn_nextButton);
        regInn_nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isDriver) {
                    Intent intent = new Intent(RegInnActivity.this, RegTitleCompanyActivity.class);
                    intent.putExtra("isDriver", isDriver);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                } else {
                    Intent intent = new Intent(RegInnActivity.this, RegPhoneActivity.class);
                    intent.putExtra("isDriver", isDriver);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                }
            }
        });

        regInn_forwarderButton = findViewById(R.id.regInn_forwarderButton);
        regInn_forwarderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isDriver = true;
                regInn_forwarderButton.setBackgroundColor(getResources().getColor(R.color.blueApp));
                regInn_сargoOwnerButton.setBackgroundColor(getResources().getColor(R.color.subText));
            }
        });

        regInn_сargoOwnerButton = findViewById(R.id.regInn_сargoOwnerButton);
        regInn_сargoOwnerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isDriver = false;
                regInn_forwarderButton.setBackgroundColor(getResources().getColor(R.color.subText));
                regInn_сargoOwnerButton.setBackgroundColor(getResources().getColor(R.color.blueApp));
            }
        });
    }
}