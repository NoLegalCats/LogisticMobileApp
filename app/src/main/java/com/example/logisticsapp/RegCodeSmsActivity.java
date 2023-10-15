package com.example.logisticsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegCodeSmsActivity extends AppCompatActivity {

    private static boolean isDriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_code_sms);

        Intent intent = getIntent();
        isDriver = intent.getBooleanExtra("isDriver", false);
        if (!isDriver) {
            TextView phone_stepText = findViewById(R.id.smsCode_stepText2);
            phone_stepText.setText("3/3");
        }

        ImageButton smsCode_backButton = findViewById(R.id.smsCode_backButton);
        smsCode_backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegCodeSmsActivity.this, RegPhoneActivity.class);
                intent.putExtra("isDriver", isDriver);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });

        Button smsCode_nextButton = findViewById(R.id.smsCode_nextButton);
        smsCode_nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegCodeSmsActivity.this, MainActivity.class);
                intent.putExtra("isDriver", isDriver);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });
    }
}