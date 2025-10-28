package com.example.weatherapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> ciudades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        setUpListView();

    }
    void setUpListView(){
        listView = (ListView) findViewById(R.id.miListView);
        ciudades = new ArrayList<String>();

        ciudades.add("Cordoba");
        ciudades.add("Entre Rios");
        ciudades.add("Buenos Aires");
        ciudades.add("Santa Fe");
        ciudades.add("Salta");

    /*    ArrayAdapter arrayAdapter = new ArrayAdapter<String>
                (getApplicationContext(), android.R.layout.simple_list_item_1, ciudades);;

                listView.setAdapter(arrayAdapter); */

        MyAdapter adapter = new MyAdapter(this, ciudades);
        listView.setAdapter(adapter);
    };
}