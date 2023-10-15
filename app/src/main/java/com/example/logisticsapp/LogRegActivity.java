package com.example.logisticsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class LogRegActivity extends AppCompatActivity {

    private static boolean isDriver = false;
    private Button logReg_driverButton;
    private Button logReg_clientButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_reg);

        logReg_driverButton = findViewById(R.id.logReg_driverButton);
        logReg_driverButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isDriver = true;
                logReg_driverButton.setBackgroundColor(getResources().getColor(R.color.blueApp));
                logReg_clientButton.setBackgroundColor(getResources().getColor(R.color.subText));
            }
        });

        logReg_clientButton = findViewById(R.id.logReg_clientButton);
        logReg_clientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isDriver = false;
                logReg_driverButton.setBackgroundColor(getResources().getColor(R.color.subText));
                logReg_clientButton.setBackgroundColor(getResources().getColor(R.color.blueApp));
            }
        });

        Button logReg_buttonReg = findViewById(R.id.logReg_buttonReg);
        logReg_buttonReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogRegActivity.this, RegInnActivity.class);
                intent.putExtra("isDriver", isDriver);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });

        Button logReg_buttonLog = findViewById(R.id.logReg_buttonLog);
        logReg_buttonLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogRegActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });
    }
}