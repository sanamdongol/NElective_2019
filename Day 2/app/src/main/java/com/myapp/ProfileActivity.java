package com.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView tvName = findViewById(R.id.tvName);

        Intent data = getIntent();
        String name = data.getStringExtra("k_name");

        tvName.setText(name);


    }
}
