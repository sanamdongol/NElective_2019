package com.example.mylistview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CustomListView extends AppCompatActivity implements ButtonCallBack {

    ListView list;
    String[] title = {"Aston Martin",
            "Bentley",
            "BMW",
            "Bugatti",
            "Mercedes",
            "Audi",
            "Lambo",
            "Honda",
            "Ferrari",
    };
    int[] image = {R.drawable.aston,
            R.drawable.bentley,
            R.drawable.bmw,
            R.drawable.bugatti,
            R.drawable.mercedes,
            R.drawable.audi,
            R.drawable.lambo,
            R.drawable.honda,
            R.drawable.ferrari
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        // list = findViewById(R.id.listView);

        list = findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(this, title, image);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CustomListView.this, title[i], Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public String getName() {
        return "hello ";
    }
}
