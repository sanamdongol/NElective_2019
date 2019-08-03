package com.example.mylistview;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Array of strings...
    String[] carArray = {"Aston Martin", "Bentley Motors ", "Bugatti", "BMW",
            "Mercedes", "Audi", "Lambo", "Honda", "Ferrari", "Ford"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  TextView tv = findViewById(R.id.test);
        tv.setText();*/



        ListView listView = findViewById(R.id.listview);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                carArray);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String carName = carArray[i];
                Log.e("My car name", carName);

                Toast.makeText(MainActivity.this, carArray[i], Toast.LENGTH_SHORT).show();

            }
        });
       /* listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, carArray[i], Toast.LENGTH_SHORT).show();

            }
        });*/
    }
}
