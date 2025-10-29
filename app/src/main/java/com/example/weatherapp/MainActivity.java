package com.example.weatherapp;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void irAlistCiudades(View view) {
        Intent miIntent = new Intent(this, ListActivity.class);
        startActivity(miIntent);
    }

    public void irDetalle(View view) {
        Intent myIntent = new Intent(this, DetailActivity.class);
    //    myIntent.putExtra("nombreCiudad","Amsterdam");
        myIntent.putExtra("lat", -31.73271f);
        myIntent.putExtra("lon", -60.52897f);
        startActivity(myIntent);

    }


}