package com.test.dbapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

import static android.content.Intent.ACTION_AIRPLANE_MODE_CHANGED;

public class MainActivity extends AppCompatActivity {


    AppDatabase appDatabase;
    private static final String DB_NAME = "TeacherDB";

    BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(context, "Airplane mode changed", Toast.LENGTH_SHORT).show();
            }
        };

        appDatabase = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class, DB_NAME)
                .allowMainThreadQueries()
                .build();

        EditText id = findViewById(R.id.etId);
        EditText name = findViewById(R.id.etName);
        EditText address = findViewById(R.id.etAddress);
        EditText phone = findViewById(R.id.etPhone);
        Button btnSave = findViewById(R.id.btnSave);
        Button btnRead = findViewById(R.id.btnRead);
        Button btnUpdate = findViewById(R.id.btnUpdate);
        Button btnDelete = findViewById(R.id.btnDelete);
        Button btnPref = findViewById(R.id.btnPref);

        btnPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int teacherId = Integer.parseInt(id.getText().toString());
                String teacherName = name.getText().toString();
                String teacherAddress = address.getText().toString();
                String teacherPhone = phone.getText().toString();

                SharedPreferences pref = getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                editor.putInt("teacher_id", teacherId);
                editor.putString("teacher_name", teacherName);
                editor.commit();

            //    SharedPreferences pref = getSharedPreferences("MyPref", MODE_PRIVATE);
                String prefTeacherName = pref.getString("teacher_name", "no value");
                Log.e("from pref", prefTeacherName);


            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                int teacherId = Integer.parseInt(id.getText().toString());
                String teacherName = name.getText().toString();
                String teacherAddress = address.getText().toString();
                String teacherPhone = phone.getText().toString();

                appDatabase.teacherDao()
                        .addTeacher(
                                new Teacher(teacherId,
                                        teacherName,
                                        teacherAddress,
                                        teacherPhone)
                        );
            }
        });

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Teacher> teacherList = appDatabase.teacherDao().getAllTeachers();

                for (int i = 0; i < teacherList.size(); i++) {
                    Log.e("teacher list", teacherList.get(i).getName());

                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int teacherId = Integer.parseInt(id.getText().toString());
                String teacherName = name.getText().toString();
                String teacherAddress = address.getText().toString();
                String teacherPhone = phone.getText().toString();

                appDatabase.teacherDao().deleteTeacher(
                        new Teacher(teacherId,
                                teacherName,
                                teacherAddress,
                                teacherPhone)
                );


            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int teacherId = Integer.parseInt(id.getText().toString());
                String teacherName = name.getText().toString();
                String teacherAddress = address.getText().toString();
                String teacherPhone = phone.getText().toString();

                appDatabase.teacherDao().updateTeacher(
                        new Teacher(teacherId,
                                teacherName,
                                teacherAddress,
                                teacherPhone)
                );


            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        MainActivity.this.registerReceiver(
                broadcastReceiver,
                new IntentFilter(ACTION_AIRPLANE_MODE_CHANGED)
        );
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.this.unregisterReceiver(broadcastReceiver);
    }
}