package com.example.activitylifecycle;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("Activity Lifecycle", "onCreate invoked");

        //If we have an application start-up logic that needs to perform only once during the life cycle of an activity,
        // then we can write that logic in onCreate() method.
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Activity Lifecycle", "onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Activity Lifecycle", "onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Activity Lifecycle", "onPause invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Activity Lifecycle", "onStop invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Activity Lifecycle", "onRestart invoked");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Activity Lifecycle", "onDestroy invoked");
    }
}