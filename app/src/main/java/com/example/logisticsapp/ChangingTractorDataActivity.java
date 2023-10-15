package com.example.logisticsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ChangingTractorDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changing_tractor_data);

        ImageButton backButton = findViewById(R.id.changeDataTractor_backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangingTractorDataActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });

        ConstraintLayout changeDataTractor_openSelImage = findViewById(R.id.changeDataTractor_openSelImage);
        changeDataTractor_openSelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImagePicker();
            }
        });

        Button changeDataTractor_saveData = findViewById(R.id.changeDataTractor_saveData);
        changeDataTractor_saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangingTractorDataActivity.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });
    }

    private static final int PICK_IMAGE_REQUEST = 1;
    public void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK) {
            // Получите выбранное изображение и отобразите его в ImageView
            Uri selectedImageUri = data.getData();
            ImageView imageView = findViewById(R.id.changeDataTractor_selImage);
            imageView.setImageURI(selectedImageUri);
            //imageView.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
            //imageView.requestLayout();
        }
    }
}