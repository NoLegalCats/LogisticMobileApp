package com.example.logisticsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class RegTitleCompanyActivity extends AppCompatActivity {

    private static boolean isDriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_title_company);

        Intent intent = getIntent();
        isDriver = intent.getBooleanExtra("isDriver", false);

        ImageButton titleCompany_backButton = findViewById(R.id.titleCompany_backButton);
        titleCompany_backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegTitleCompanyActivity.this, RegInnActivity.class);
                intent.putExtra("isDriver", isDriver);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });

        Button titleCompany_nextButton = findViewById(R.id.titleCompany_nextButton);
        titleCompany_nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegTitleCompanyActivity.this, RegDocumentsActivity.class);
                intent.putExtra("isDriver", isDriver);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });
    }
}