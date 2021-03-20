package com.test.db;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import static android.content.Intent.ACTION_AIRPLANE_MODE_CHANGED;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private EditText etName;
    private EditText etFaculty;
    private EditText etRollNo;
    private EditText etAddress;
    private Button btnSaveDetail;
    private Button btnRead;
    private Button btnUpdate;
    private Button btnDelete;

    private TextView tvShow;

    private static final String DB_NAME = "StudentDb";
    private MyAppDatabase myAppDatabase;

    BroadcastReceiver receiver;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        receiver = new BroadcastReceiver() {

            @Override
            public void onReceive(Context context, Intent intent) {
                Log.d(TAG, "onReceive: airplane mode changed");
            }
        };



        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, DB_NAME)
                .allowMainThreadQueries()
                .build();


        etName = findViewById(R.id.et_name);
        etFaculty = findViewById(R.id.et_faculty);
        etRollNo = findViewById(R.id.et_roll_no);
        etAddress = findViewById(R.id.et_address);
        tvShow = findViewById(R.id.tv_show);

        btnSaveDetail = findViewById(R.id.btn_save);
        btnRead = findViewById(R.id.btn_read);
        btnUpdate = findViewById(R.id.btn_update);
        btnDelete = findViewById(R.id.btn_delete);
        btnSaveDetail.setOnClickListener(this);
        btnRead.setOnClickListener(this);
        btnUpdate.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_save:
                String name = etName.getText().toString();
                String faculty = etFaculty.getText().toString();
                String address = etAddress.getText().toString();
                String rollno = etRollNo.getText().toString();

                Student student = new Student();
                student.setName(name);
                student.setFaculty(faculty);
                student.setAddress(address);
                student.setId(Integer.parseInt(rollno));

                myAppDatabase.studentDao().addStudent(student);
                Toast.makeText(this, "Student added successfully", Toast.LENGTH_SHORT).show();
                etName.setText("");
                etFaculty.setText("");
                etAddress.setText("");
                etRollNo.setText("");

                break;

            case R.id.btn_read:
                List<Student> studentList = myAppDatabase.studentDao().getAllStudent();

                String data = "";
                for (Student allStudent : studentList) {
                    String studentName = allStudent.getName();
                    String studentFaculty = allStudent.getFaculty();
                    String studentAddress = allStudent.getAddress();
                    int studentRoll = allStudent.getId();

                    data = data + studentName + "\n" + studentFaculty + "\n" + studentRoll + "\n" + studentAddress + "\n\n";
                }

                tvShow.setText(data);

                break;

            case R.id.btn_update:
                String updateName = etName.getText().toString();
                String updatedFaculty = etFaculty.getText().toString();
                String updatedAddress = etAddress.getText().toString();
                String updatedRollno = etRollNo.getText().toString();

                Student updatedStudent = new Student();
                updatedStudent.setName(updateName);
                updatedStudent.setFaculty(updatedFaculty);
                updatedStudent.setAddress(updatedAddress);
                updatedStudent.setId(Integer.parseInt(updatedRollno));

                myAppDatabase.studentDao().updateStudent(updatedStudent);
                Toast.makeText(this, "User updated success", Toast.LENGTH_SHORT).show();
                etName.setText("");
                etFaculty.setText("");
                etAddress.setText("");
                etRollNo.setText("");

                break;

            case R.id.btn_delete:
                int id = Integer.parseInt(etRollNo.getText().toString());
                Student deleteStudent = new Student();
                deleteStudent.setId(id);
                myAppDatabase.studentDao().deleteStudent(deleteStudent);
                break;

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        MainActivity.this.registerReceiver(receiver,
                new IntentFilter(ACTION_AIRPLANE_MODE_CHANGED));
    }

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.this.unregisterReceiver(receiver);
    }
}