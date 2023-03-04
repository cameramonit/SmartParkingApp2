package com.example.smartparkingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity3 extends AppCompatActivity {
ImageView QR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        QR=findViewById(R.id.imageView);
        QR.setImageResource(R.drawable.img);
    }
}