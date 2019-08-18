package com.example.activitylifecycle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MyActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnA, btnB, btnC, btnD;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);


        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);

        switchFragment(new HomeFragment());


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btnA:
/*
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                HomeFragment fragment = new HomeFragment();
                fragmentTransaction.add(R.id.frame_layout, fragment);
                fragmentTransaction.commit();*/

                switchFragment(new HomeFragment());


                break;
            case R.id.btnB:

            /*    FragmentManager fragmentManager2 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();

                ProfileFragment fragment2 = new ProfileFragment();
                fragmentTransaction2.add(R.id.frame_layout, fragment2);
                fragmentTransaction2.commit();*/
                switchFragment(new ProfileFragment());
                break;
            case R.id.btnC:
                switchFragment(new MessageFragment());
                break;
            case R.id.btnD:
                switchFragment(new FeedFragment());
                break;
        }

    }

    private void switchFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_layout, fragment);
     //   fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();

    }
}
