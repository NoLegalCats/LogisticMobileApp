package com.example.logisticsapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private List<EmployeeItem> employeeList;

    public EmployeeAdapter(List<EmployeeItem> employeeList) {
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_employees, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        EmployeeItem currentItem = employeeList.get(position);

        holder.nameTextView.setText(currentItem.getName());
        holder.phoneTextView.setText(currentItem.getPhone());
        holder.emailTextView.setText(currentItem.getEmail());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public static class EmployeeViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView phoneTextView;
        public TextView emailTextView;
        public Button deleteButton;
        private Context context;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.employees_nameText);
            phoneTextView = itemView.findViewById(R.id.employees_phoneText);
            emailTextView = itemView.findViewById(R.id.employees_emailText);
            deleteButton = itemView.findViewById(R.id.employees_delButton);

            this.context = context;
            Button employees_delButton = itemView.findViewById(R.id.employees_delButton);
            employees_delButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }

        private void showConfirmationDialog() {
            // Создание диалогового окна подтверждения
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Подтверждение");
            builder.setMessage("Вы уверены, что хотите продолжить?");

            builder.setPositiveButton("Подтвердить", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Действие при подтверждении
                }
            });

            builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // Действие при отмене
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }
}

