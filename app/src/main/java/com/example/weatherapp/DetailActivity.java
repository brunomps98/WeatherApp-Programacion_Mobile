package com.example.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// --- Imports que faltaban ---
import com.example.weatherapp.Api;
import com.example.weatherapp.Results;

// --- Imports de Retrofit ---
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DetailActivity extends AppCompatActivity {

    TextView nombreCiudad, temperatura, descripcion, min, max;
    float latitud, longitud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent myIntent = getIntent();
        latitud = myIntent.getFloatExtra("lat", 0F);
        longitud = myIntent.getFloatExtra("lon", 0F);

        nombreCiudad = findViewById(R.id.tvCiudad);
        temperatura = findViewById(R.id.tvTemp);
        descripcion = findViewById(R.id.tvDesc);
        min = findViewById(R.id.tvMin);
        max = findViewById(R.id.tvMax);

        getActualWeather();
    }

    private void getActualWeather() {
        Call<Results> call = RetrofitClient.getInstance().getMyApi().getWeather(latitud, longitud, Api.Token, Api.Unidades, Api.Lenguaje);

        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                if (response.isSuccessful()) {
                    Results results = response.body();
                    if (results != null) {
                        nombreCiudad.setText(results.name);

                        // Validar que 'main' y 'weather' no sean nulos
                        if (results.main != null) {
                            temperatura.setText(results.main.temp.toString() + "°");
                            min.setText(results.main.temp_min.toString() + "°");
                            max.setText(results.main.temp_max.toString() + "°");
                        }
                        if (results.weather != null && !results.weather.isEmpty()) {
                            descripcion.setText(results.weather.get(0).description);
                        }
                    }
                } else {
                    Toast.makeText(DetailActivity.this, "Error en la respuesta de la API", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                Toast.makeText(DetailActivity.this, "Fallo la conexión: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}