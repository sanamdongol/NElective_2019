package com.test.themedemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLightTheme = findViewById(R.id.btn_light_theme);
        Button btnDarkTheme = findViewById(R.id.btn_dark_theme);

        btnLightTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        MainActivity.this,
                        "Applying Light Theme",
                        Toast.LENGTH_SHORT)
                        .show();

                AppCompatDelegate
                        .setDefaultNightMode
                                (
                                AppCompatDelegate.MODE_NIGHT_NO
                        );

            }
        });
        btnDarkTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(
                        MainActivity.this,
                        "Applying Dark Theme",
                        Toast.LENGTH_SHORT)
                        .show();

                AppCompatDelegate
                        .setDefaultNightMode
                                (
                                        AppCompatDelegate.MODE_NIGHT_YES
                                );

            }
        });
    }
}