package com.example.logisticsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.Manifest;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.Map;
import com.yandex.mapkit.map.PlacemarkMapObject;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.runtime.image.ImageProvider;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MapActivity extends AppCompatActivity {

    private TextView map_textView_map;
    private TextView map_textView_list;
    private Switch map_switch;
    private MapView mapView;
    private ImageButton setMyLoc;
    private CardView grabber;
    private ImageButton mainButton;
    private ImageButton chatButton;
    private ImageButton ratingButton;
    private ImageButton profileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        MapKitFactory.initialize(this);
        mapView = findViewById(R.id.mapview);

        mainButton = findViewById(R.id.mainActivity);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });

        chatButton = findViewById(R.id.chatActivity);
        chatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapActivity.this, ChatActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });

        ratingButton = findViewById(R.id.ratingActivity);
        ratingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapActivity.this, RatingActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });

        profileButton = findViewById(R.id.profileActivity);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MapActivity.this, ProfileActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });

        map_textView_map = findViewById(R.id.map_textView_map);
        map_textView_list = findViewById(R.id.map_textView_list);
        map_switch = findViewById(R.id.map_switch);
        setMyLoc = findViewById(R.id.setMyLoc);
        grabber = findViewById(R.id.grabber);
        map_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    map_textView_map.setTextColor(getResources().getColor(R.color.notActive));
                    map_textView_list.setTextColor(getResources().getColor(R.color.blueApp));
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) mapView.getLayoutParams();
                    layoutParams.height = 0;
                    layoutParams.width = 0;
                    mapView.setLayoutParams(layoutParams);
                    layoutParams = (ConstraintLayout.LayoutParams) setMyLoc.getLayoutParams();
                    layoutParams.height = 0;
                    layoutParams.width = 0;
                    setMyLoc.setLayoutParams(layoutParams);
                    layoutParams = (ConstraintLayout.LayoutParams) grabber.getLayoutParams();
                    layoutParams.height = 0;
                    layoutParams.width = 0;
                    grabber.setLayoutParams(layoutParams);
                } else {
                    map_textView_map.setTextColor(getResources().getColor(R.color.blueApp));
                    map_textView_list.setTextColor(getResources().getColor(R.color.notActive));
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) mapView.getLayoutParams();
                    Context context = getApplicationContext();
                    float scale = context.getResources().getDisplayMetrics().density;
                    int heightInPixels = (int) (380 * scale + 0.5f);
                    int widthInPixels = (int) (0 * scale + 0.5f);
                    layoutParams.height = heightInPixels;
                    layoutParams.width = widthInPixels;
                    mapView.setLayoutParams(layoutParams);
                    layoutParams = (ConstraintLayout.LayoutParams) setMyLoc.getLayoutParams();
                    heightInPixels = (int) (64 * scale + 0.5f);
                    widthInPixels = (int) (64 * scale + 0.5f);
                    layoutParams.height = heightInPixels;
                    layoutParams.width = widthInPixels;
                    setMyLoc.setLayoutParams(layoutParams);
                    layoutParams = (ConstraintLayout.LayoutParams) grabber.getLayoutParams();
                    heightInPixels = (int) (6 * scale + 0.5f);
                    widthInPixels = (int) (80 * scale + 0.5f);
                    layoutParams.height = heightInPixels;
                    layoutParams.width = widthInPixels;
                    grabber.setLayoutParams(layoutParams);
                }
            }
        });

        RecyclerView recyclerView = findViewById(R.id.rcView_routes);
        List<RouteItem> routeList = new ArrayList<>();
        routeList.add(new RouteItem("Kostanay, KZ", "Berlin, Germany", "20/86/задн., бок., верх./ + 16", "36.000 кг", "11 сентября", "1200 км", R.mipmap.ic_launcher, "1500$", "Необходимо перевезти 36т металлических бочек для того-то, чтобы сделать то-то, это будет стоить столько-то, по цене можем договориться", "Александр", "Kostanay, KZ", "Зарегистрирован 4 года назад"));
        routeList.add(new RouteItem("Kostanay, KZ", "Berlin, Germany", "20/86/задн., бок., верх./ + 16", "36.000 кг", "11 сентября", "1200 км", R.mipmap.ic_launcher, "1500$", "Необходимо перевезти 36т металлических бочек для того-то, чтобы сделать то-то, это будет стоить столько-то, по цене можем договориться", "Александр", "Kostanay, KZ", "Зарегистрирован 4 года назад"));
        routeList.add(new RouteItem("Kostanay, KZ", "Berlin, Germany", "20/86/задн., бок., верх./ + 16", "36.000 кг", "11 сентября", "1200 км", R.mipmap.ic_launcher, "1500$", "Необходимо перевезти 36т металлических бочек для того-то, чтобы сделать то-то, это будет стоить столько-то, по цене можем договориться", "Александр", "Kostanay, KZ", "Зарегистрирован 4 года назад"));
        RouteAdapter adapter = new RouteAdapter(routeList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void getLocationAndSetOnMap() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 16384);
        } else {
            Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            if (lastKnownLocation != null) {
                double latitude = lastKnownLocation.getLatitude();
                double longitude = lastKnownLocation.getLongitude();
                Map map = mapView.getMap();
                map.move(
                        new CameraPosition(new Point(latitude, longitude), 15.0f, 0.0f, 0.0f)
                );
                ImageProvider imageProvider = ImageProvider.fromResource(this, R.drawable.my_locate);
                PlacemarkMapObject placemark = map.getMapObjects().addPlacemark(new Point(latitude, longitude), imageProvider);
                Toast.makeText(getApplicationContext(), "Местоположение установлено", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Местоположение не найдено", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        MapKitFactory.getInstance().onStart();
        mapView.onStart();
    }

    @Override
    protected void onStop() {
        mapView.onStop();
        MapKitFactory.getInstance().onStop();
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();

        ImageButton setMyLocationButton = findViewById(R.id.setMyLoc);
        setMyLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getLocationAndSetOnMap();
            }
        });
    }

}