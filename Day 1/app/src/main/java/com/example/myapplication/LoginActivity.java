package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etName = findViewById(R.id.etName);
        final EditText etPassword = findViewById(R.id.etPassword);
        Button btnSignIn = findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = etName.getText().toString();
                String pass = etPassword.getText().toString();
                boolean hasError = false;

                if (TextUtils.isEmpty(userName)) {
                    etName.setError("This field required");
                    hasError = true;
                }

                if (TextUtils.isEmpty(pass)) {
                    etPassword.setError("Please enter your password");
                    hasError = true;
                }

                if (!hasError) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }


                /*String userName = etName.getText().toString();
                String password = etPassword.getText().toString();

                Log.v("user input", userName +" "+password);*/
            }
        });

    }
}
