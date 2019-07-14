package com.myapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, DialogInterface {

    private EditText etName;
    private EditText etPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etName = findViewById(R.id.etName);
        etPass = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });



       /* btnLogin.setOnClickListener(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String password = etPass.getText().toString();


               *//* Intent intent = new Intent(LoginActivity.this, CatysActivity.class);
                intent.putExtra("k_name", name);
                intent.putExtra("a",1);
                startActivity(intent);
*//*


                Intent intent = new Intent(LoginActivity.this, CatysActivity.class);
                startActivity(intent);

            }
        });*/

    }

    //implement on click listner, preferred when there are many buttons
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnLogin:
                break;
            case R.id.img:
                break;
        }

        String name = etName.getText().toString();
        String password = etPass.getText().toString();

        Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
        intent.putExtra("k_name", name);
        startActivity(intent);
    }

    //click from xml
    public void letClick(View view) {
        String name = etName.getText().toString();
        String password = etPass.getText().toString();

        Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
        intent.putExtra("k_name", name);
        startActivity(intent);
    }

    @Override
    public void cancel() {

    }

    @Override
    public void dismiss() {

    }
}
