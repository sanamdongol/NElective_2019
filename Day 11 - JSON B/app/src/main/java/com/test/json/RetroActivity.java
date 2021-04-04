package com.test.json;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RetroActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    private CustomAdapter adapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retro);

        progressDialog = new ProgressDialog(RetroActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        RetrofitGet retrofitGet = RetrofitClientInstance.getRetrofitInstance().create(RetrofitGet.class);
        Call<List<RetroPhoto>> call = retrofitGet.getAllPhotos();
        call.enqueue(new Callback<List<RetroPhoto>>() {
            @Override
            public void onResponse(Call<List<RetroPhoto>> call, Response<List<RetroPhoto>> response) {
                progressDialog.dismiss();
                 generateDataList(response.body());

            }

            @Override
            public void onFailure(Call<List<RetroPhoto>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(RetroActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();


            }
        });


    }

    /*Method to generate List of data using RecyclerView with custom adapter*/
    private void generateDataList(List<RetroPhoto> photoList) {
        recyclerView = findViewById(R.id.customRecyclerView);
        adapter = new CustomAdapter(this, photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RetroActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}