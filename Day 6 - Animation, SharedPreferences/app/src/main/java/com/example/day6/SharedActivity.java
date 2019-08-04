package com.example.day6;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SharedActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etName;
    private EditText etAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);


        Intent intent = getIntent();
        String myData = intent.getStringExtra("name");
        Log.e("intent data", myData);

        Button btnSaveData = findViewById(R.id.btn_save);
        Button btnGetData = findViewById(R.id.btn_get_data);
        etName = findViewById(R.id.et_name);
        etAddress = findViewById(R.id.et_address);

        btnSaveData.setOnClickListener(this);
        btnGetData.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_save:

                String name = etName.getText().toString();
                String address = etAddress.getText().toString();

                SharedPreferences sharedPreferences = getSharedPreferences("MyData", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("user_name", name);
                editor.putString("user_address", address);
                editor.commit();

                break;

            case R.id.btn_get_data:
                SharedPreferences preferences = getSharedPreferences("MyData", MODE_PRIVATE);
                String userName = preferences.getString("user_name", "no name saved");
                String userAddress = preferences.getString("user_address", "no address saved");
                Toast.makeText(this, "Name: " + userName + " " + "Address: " + userAddress, Toast.LENGTH_LONG).show();
                Log.e("Values", "Name: " + userName + " " + "Address: " + userAddress);

                break;


        }


    }
}
