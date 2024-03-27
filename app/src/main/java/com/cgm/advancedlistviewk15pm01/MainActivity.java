package com.cgm.advancedlistviewk15pm01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.NoCopySpan;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Country> countryList = new ArrayList<>();
        Country vietnam = new Country("Vietnam", "vn", 98000000);
        Country usa = new Country("United States", "us", 320000000);
        Country russia = new Country("Russia", "ru", 142000000);

        countryList.add(vietnam);
        countryList.add(usa);
        countryList.add(russia);

        ListView countryListView = findViewById(R.id.listViewId);

        ArrayAdapter<Country> adapter = new ArrayAdapter<Country>(this,
                android.R.layout.simple_list_item_1, countryList);

        countryListView.setAdapter(adapter);
    }
}