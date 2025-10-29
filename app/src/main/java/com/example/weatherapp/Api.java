package com.example.weatherapp;

import retrofit2.Call;

import retrofit2.http.GET;

import retrofit2.http.Query;

public interface Api {

    String BASE_URL = "https://api.openweathermap.org/data/2.5/";

    String Token = "bc35a1d6b8f47df5cb2cf30d3d3effc7";

    String Unidades = "metric";

    String Lenguaje = "es";

    @GET("weather")
    Call<Results> getWeather(
            @Query("lat") Float latitud,
            @Query("lon") Float longitud,
            @Query("appid") String token,
            @Query("units") String unidades,
            @Query("lang") String lenguaje
    );
}
