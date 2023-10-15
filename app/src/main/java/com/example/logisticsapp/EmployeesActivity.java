package com.example.logisticsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EmployeesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employees);

        RecyclerView recyclerView = findViewById(R.id.rcView_employees);
        List<EmployeeItem> employeeList = new ArrayList<>();
        employeeList.add(new EmployeeItem("Константин Николаевич", "+12(345) 67-89-01", "konstnik@gmail.com"));
        employeeList.add(new EmployeeItem("Константин Николаевич", "+12(345) 67-89-01", "konstnik@gmail.com"));
        employeeList.add(new EmployeeItem("Константин Николаевич", "+12(345) 67-89-01", "konstnik@gmail.com"));
        EmployeeAdapter adapter = new EmployeeAdapter(employeeList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        ImageButton backButton = findViewById(R.id.employees_backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmployeesActivity.this, ProfileActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });

        Button addEmployees = findViewById(R.id.employees_addEmployees);
        addEmployees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EmployeesActivity.this, ProfileActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });
    }
}