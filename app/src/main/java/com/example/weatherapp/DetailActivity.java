package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent myIntent = getIntent();

        String ciudadElegida = myIntent.getStringExtra("nombreCiudad");

        TextView nombreCiudad = findViewById(R.id.tvCiudad);
        nombreCiudad.setText(ciudadElegida);

    }
}