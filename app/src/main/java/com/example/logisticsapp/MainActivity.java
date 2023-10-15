package com.example.logisticsapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView main_textView_free;
    private TextView main_textView_Working;
    private Switch main_switch;
    private ImageButton chatButton;
    private ImageButton mapButton;
    private ImageButton ratingButton;
    private ImageButton profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_textView_free = findViewById(R.id.main_textView_free);
        main_textView_Working = findViewById(R.id.main_textView_Working);
        main_switch = findViewById(R.id.main_switch);
        main_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    main_textView_free.setTextColor(getResources().getColor(R.color.notActive));
                    main_textView_Working.setTextColor(getResources().getColor(R.color.blueApp));
                } else {
                    main_textView_free.setTextColor(getResources().getColor(R.color.blueApp));
                    main_textView_Working.setTextColor(getResources().getColor(R.color.notActive));
                }
            }
        });

        chatButton = findViewById(R.id.chatActivity);
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });

        mapButton = findViewById(R.id.mapActivity);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });

        ratingButton = findViewById(R.id.ratingActivity);
        ratingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RatingActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });

        profileButton = findViewById(R.id.profileActivity);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });


        RecyclerView recyclerView = findViewById(R.id.rcView_notification);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        List<NotificationItem> notificationList = new ArrayList<>();
        notificationList.add(new NotificationItem(R.mipmap.ic_launcher, "Важное уведомление 1", "2ч назад", "Дальнобойщик — просторечное название профессии водителей большегрузных автомобилей, перевозящих грузы на дальние расстояния. Так как водитель проводит много времени своей жизни за"));
        notificationList.add(new NotificationItem(R.mipmap.ic_launcher, "Важное уведомление 2", "3ч назад", "Дальнобойщик — просторечное название профессии водителей большегрузных автомобилей, перевозящих грузы на дальние расстояния. Так как водитель проводит много времени своей жизни за"));
        notificationList.add(new NotificationItem(R.mipmap.ic_launcher, "Важное уведомление 3", "4ч назад", "Дальнобойщик — просторечное название профессии водителей большегрузных автомобилей, перевозящих грузы на дальние расстояния. Так как водитель проводит много времени своей жизни за"));
        NotificationAdapter adapter = new NotificationAdapter(notificationList);
        recyclerView.setAdapter(adapter);

        LinearLayout changeDataTractor_go = findViewById(R.id.changeDataTractor_go);
        changeDataTractor_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChangingTractorDataActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });

        BarChart chart = findViewById(R.id.chart);

        ArrayList<BarEntry> incomeData = new ArrayList<>();
        incomeData.add(new BarEntry(1, 1000));
        incomeData.add(new BarEntry(2, 1500));
        incomeData.add(new BarEntry(3, 2000));

        ArrayList<BarEntry> expenseData = new ArrayList<>();
        expenseData.add(new BarEntry(1, 500));
        expenseData.add(new BarEntry(2, 700));
        expenseData.add(new BarEntry(3, 900));

        BarDataSet incomeDataSet = new BarDataSet(incomeData, "Доходы");
        incomeDataSet.setColor(ContextCompat.getColor(this, R.color.income));
        BarDataSet expenseDataSet = new BarDataSet(expenseData, "Расходы");
        expenseDataSet.setColor(ContextCompat.getColor(this, R.color.expense));
        BarData barData = new BarData(incomeDataSet, expenseDataSet);
        chart.setData(barData);
        chart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(new String[]{"Январь", "Февраль", "Март"}));
        chart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
        chart.getDescription().setEnabled(false);
        chart.getLegend().setEnabled(true);
        chart.invalidate();
    }
}