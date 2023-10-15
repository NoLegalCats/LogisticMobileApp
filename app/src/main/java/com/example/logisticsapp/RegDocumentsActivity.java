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

public class RegDocumentsActivity extends AppCompatActivity {

    private static boolean isDriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_documents);

        Intent intent = getIntent();
        isDriver = intent.getBooleanExtra("isDriver", false);

        ImageButton documents_backButton = findViewById(R.id.documents_backButton);
        documents_backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegDocumentsActivity.this, RegTitleCompanyActivity.class);
                intent.putExtra("isDriver", isDriver);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
            }
        });

        Button documents_nextButton = findViewById(R.id.documents_nextButton);
        documents_nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegDocumentsActivity.this, RegPhoneActivity.class);
                intent.putExtra("isDriver", isDriver);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
            }
        });

        ConstraintLayout document_openSelImage = findViewById(R.id.document_openSelImage);
        document_openSelImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImagePicker();
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
            ImageView imageView = findViewById(R.id.document_image);
            imageView.setImageURI(selectedImageUri);
            //imageView.getLayoutParams().height = ViewGroup.LayoutParams.WRAP_CONTENT;
            //imageView.requestLayout();
        }
    }
}