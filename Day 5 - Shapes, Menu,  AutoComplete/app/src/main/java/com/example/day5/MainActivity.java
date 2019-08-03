package com.example.day5;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    String[] countryList = {"Australia", "Algeria", "America", "Austria",
            "Bangladesh", "Bolivia", "Bhutan", "China", "Chile", "Cambodia",
            "Canada",
            "Czech Republic", "Denmark", "Nepal"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        AutoCompleteTextView autoCompleteTv = findViewById(R.id.autoComplete);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countryList);
        autoCompleteTv.setThreshold(1);
        autoCompleteTv.setAdapter(adapter);

    }
}
